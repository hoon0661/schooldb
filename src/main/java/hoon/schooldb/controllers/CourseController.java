package hoon.schooldb.controllers;

import hoon.schooldb.dto.CourseRequestDto;
import hoon.schooldb.models.Course;
import hoon.schooldb.models.Instructor;
import hoon.schooldb.models.Student;
import hoon.schooldb.services.CourseService;
import hoon.schooldb.services.InstructorService;
import hoon.schooldb.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;
    private final StudentService studentService;
    private final InstructorService instructorService;

    @GetMapping("/api/courses")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/api/courses/pages")
    public Page<Course> getAllCoursesByPages(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "true") boolean isAsc) {
        return courseService.getCoursesByPage(page, size, sortBy, isAsc);
    }

    @GetMapping("/api/courses/{id}")
    public Course getCourse(@PathVariable Long id) {
        return courseService.getCourse(id);
    }

    @PostMapping("/api/courses")
    public Course createCourse(@RequestBody CourseRequestDto requestDto) {
        return courseService.createCourse(requestDto);
    }

    @PutMapping("/api/courses/{id}")
    public Course updateCourse(@PathVariable Long id, CourseRequestDto requestDto) {
        return courseService.updateCourse(id, requestDto);
    }

    @PutMapping("/api/courses/{courseId}/students/{studentId}")
    public Course enrollStudent(@PathVariable Long courseId, @PathVariable Long studentId) {
        Student student = studentService.getStudent(studentId);
        return courseService.enrollStudent(courseId, student);
    }

    @PutMapping("/api/courses/{courseId}/instructors/{instructorId}")
    public Course enrollInstructor(@PathVariable Long courseId, @PathVariable Long instructorId) {
        Instructor instructor = instructorService.getInstructor(instructorId);
        return courseService.enrollInstructor(courseId, instructor);
    }

    @DeleteMapping("/api/courses/{id}")
    public Long deleteCourse(@PathVariable Long id) {
        return courseService.deleteCourse(id);
    }
}
