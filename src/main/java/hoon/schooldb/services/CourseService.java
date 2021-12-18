package hoon.schooldb.services;

import hoon.schooldb.dto.CourseRequestDto;
import hoon.schooldb.models.Course;
import hoon.schooldb.repositories.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;

    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    public Course getCourse(Long id){
        Course course = courseRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID does not exist."));
        return course;
    }

    public Course createCourse(CourseRequestDto requestDto){
        Course course = new Course(requestDto);
        return courseRepository.save(course);
    }

    @Transactional
    public Course updateCourse(Long id, CourseRequestDto requestDto){
        Course course = courseRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID does not exist."));
        course.update(requestDto);
        return course;
    }
}
