package hoon.schooldb.controllers;

import hoon.schooldb.dto.CourseRequestDto;
import hoon.schooldb.models.Course;
import hoon.schooldb.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/api/courses")
    public Page<Course> getAllCourses(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "true") boolean isAsc) {
        return courseService.getAllCourses(page, size, sortBy, isAsc);
    }

    @GetMapping("/api/courses/{id}")
    public Course getCourse(@PathVariable Long id) {
        return courseService.getCourse(id);
    }

    @PostMapping("/api/courses")
    public Course createCourse(CourseRequestDto requestDto) {
        return courseService.createCourse(requestDto);
    }

    @PutMapping("/api/courses/{id}")
    public Course updateCourse(@PathVariable Long id, CourseRequestDto requestDto) {
        return courseService.updateCourse(id, requestDto);
    }

    @PutMapping("/api/courses/{courseId}/students/{studentId}")
    public Course enrollStudent(@PathVariable Long courseId, @PathVariable Long studentId) {
        return courseService.enrollStudent(courseId, studentId);
    }

    @PutMapping("/api/courses/{courseId}/instructors/{instructorId}")
    public Course enrollInstructor(@PathVariable Long courseId, @PathVariable Long instructorId) {
        return courseService.enrollInstructor(courseId, instructorId);
    }
}
