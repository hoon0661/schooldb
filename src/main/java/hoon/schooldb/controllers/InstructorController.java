package hoon.schooldb.controllers;

import hoon.schooldb.dto.InstructorRequestDto;
import hoon.schooldb.models.Instructor;
import hoon.schooldb.services.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class InstructorController {

    private final InstructorService instructorService;

    @GetMapping("/api/instructors")
    public List<Instructor> getAllInstructors(){
        return instructorService.getAllInstructors();
    }

    @GetMapping("/api/instructors/{id}")
    public Instructor getInstructor(@PathVariable Long id){
        return instructorService.getInstructor(id);
    }

    @PostMapping("/api/instructors")
    public Instructor createInstructor(@RequestBody InstructorRequestDto requestDto){
        return instructorService.createInstructor(requestDto);
    }

    @PutMapping("/api/instructors/{id}")
    public Instructor updateInstructor(@PathVariable Long id, @RequestBody InstructorRequestDto requestDto){
        return instructorService.update(id, requestDto);
    }
}