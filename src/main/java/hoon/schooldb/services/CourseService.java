package hoon.schooldb.services;

import hoon.schooldb.dto.CourseRequestDto;
import hoon.schooldb.models.Course;
import hoon.schooldb.models.Instructor;
import hoon.schooldb.models.Student;
import hoon.schooldb.repositories.CourseRepository;
import hoon.schooldb.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final StudentService studentService;
    private final InstructorService instructorService;

    public Page<Course> getAllCourses(int page, int size, String sortBy, boolean isAsc) {
        page = page - 1;
        Sort.Direction direction = isAsc ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sort = Sort.by(direction, sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);
        return courseRepository.findAll(pageable);
    }

    public Course getCourse(Long id) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID does not exist."));
        return course;
    }

    public Course createCourse(CourseRequestDto requestDto) {
        Course course = new Course(requestDto);
        return courseRepository.save(course);
    }

    @Transactional
    public Course updateCourse(Long id, CourseRequestDto requestDto) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID does not exist."));
        course.update(requestDto);
        return course;
    }

    @Transactional
    public Course enrollStudent(Long courseId, Long studentId) {
        Course course = getCourse(courseId);
        Student student = studentService.getStudent(studentId);

        course.enrollStudent(student);
        return course;
    }

    @Transactional
    public Course enrollInstructor(Long courseId, Long instructorId) {
        Course course = getCourse(courseId);
        Instructor instructor = instructorService.getInstructor(instructorId);

        course.enrollInstructor(instructor);
        return course;
    }
}
