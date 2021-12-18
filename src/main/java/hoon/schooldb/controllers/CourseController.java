package hoon.schooldb.controllers;

import hoon.schooldb.dto.CourseRequestDto;
import hoon.schooldb.models.Course;
import hoon.schooldb.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/api/courses")
    public List<Course> getAllCourses(){
        return courseService.getAllCourses();
    }

    @GetMapping("/api/courses/{id}")
    public Course getCourse(@PathVariable Long id){
        return courseService.getCourse(id);
    }

    @PostMapping("/api/courses")
    public Course createCourse(CourseRequestDto requestDto){
        return courseService.createCourse(requestDto);
    }

    @PutMapping("/api/courses/{id}")
    public Course updateCourse(@PathVariable Long id, CourseRequestDto requestDto){
        return courseService.updateCourse(id, requestDto);
    }
}