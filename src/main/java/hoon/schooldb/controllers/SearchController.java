package hoon.schooldb.controllers;

import hoon.schooldb.services.CourseService;
import hoon.schooldb.services.InstructorService;
import hoon.schooldb.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class SearchController {

    private final CourseService courseService;
    private final InstructorService instructorService;
    private final StudentService studentService;

    @GetMapping("/api/search")
    public Page<?> search(
            @RequestParam String category,
            @RequestParam String searchParam,
            @RequestParam String str,
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "true") boolean isAsc) {
        if (str.trim().length() == 0) {
            return null;
        }

        if (category.equals("course")) {
            return courseService.getSearchResult(page, size, sortBy, isAsc, searchParam, str);
        } else if (category.equals("instructor")) {
            return instructorService.getSearchResult(page, size, sortBy, isAsc, searchParam, str);
        } else {
            return studentService.getSearchResult(page, size, sortBy, isAsc, searchParam, str);
        }
    }
}
