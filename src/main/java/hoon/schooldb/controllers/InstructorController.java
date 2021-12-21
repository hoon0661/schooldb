package hoon.schooldb.controllers;

import hoon.schooldb.dto.InstructorRequestDto;
import hoon.schooldb.models.Instructor;
import hoon.schooldb.services.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class InstructorController {

    private final InstructorService instructorService;

    @GetMapping("/api/instructors")
    public Page<Instructor> getAllInstructors(@RequestParam int page, @RequestParam int size, @RequestParam(defaultValue = "id") String sortBy, @RequestParam(defaultValue = "true") boolean isAsc) {
        return instructorService.getAllInstructors(page, size, sortBy, isAsc);
    }

    @GetMapping("/api/instructors/{id}")
    public Instructor getInstructor(@PathVariable Long id) {
        return instructorService.getInstructor(id);
    }

    @PostMapping("/api/instructors")
    public Instructor createInstructor(@RequestBody InstructorRequestDto requestDto) {
        return instructorService.createInstructor(requestDto);
    }

    @PutMapping("/api/instructors/{id}")
    public Instructor updateInstructor(@PathVariable Long id, @RequestBody InstructorRequestDto requestDto) {
        return instructorService.update(id, requestDto);
    }
}
