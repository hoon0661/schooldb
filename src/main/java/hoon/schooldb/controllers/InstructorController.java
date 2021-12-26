package hoon.schooldb.controllers;

import hoon.schooldb.dto.InstructorRequestDto;
import hoon.schooldb.models.Instructor;
import hoon.schooldb.services.CourseService;
import hoon.schooldb.services.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class InstructorController {

    private final InstructorService instructorService;
    private final CourseService courseService;

    @GetMapping("/api/instructors")
    public List<Instructor> getAllInstructors() {
        return instructorService.getAllInstructors();
    }

    @GetMapping("/api/instructors/pages")
    public Page<Instructor> getAllInstructorsByPages(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "true") boolean isAsc) {
        return instructorService.getAllInstructorsByPages(page, size, sortBy, isAsc);
    }

    @GetMapping("/api/instructors/{id}")
    public Instructor getInstructor(@PathVariable Long id) {
        return instructorService.getInstructor(id);
    }

    @PostMapping("/api/instructors")
    public Instructor createInstructor(@RequestBody InstructorRequestDto requestDto) throws FileNotFoundException {
        return instructorService.createInstructor(requestDto);
    }

    @PutMapping("/api/instructors/{id}")
    public Instructor updateInstructor(@PathVariable Long id, @RequestBody InstructorRequestDto requestDto) throws FileNotFoundException {
        return instructorService.update(id, requestDto);
    }

    @DeleteMapping("/api/instructors/{id}")
    public Long deleteInstructor(@PathVariable Long id) {
        return instructorService.deleteInstructor(id);
    }
}
