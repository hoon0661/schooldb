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
    public List<?> search(
            @RequestParam String category,
            @RequestParam String searchParam,
            @RequestParam String str
    ) {
        if (str.trim().length() == 0) {
            return null;
        }

        if (category.equals("course")) {
            return courseService.getSearchResult(searchParam, str);
        } else if (category.equals("instructor")) {
            return instructorService.getSearchResult(searchParam, str);
        } else {
            return studentService.getSearchResult(searchParam, str);
        }
    }
}
