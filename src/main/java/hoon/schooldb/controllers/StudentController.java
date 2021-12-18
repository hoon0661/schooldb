package hoon.schooldb.controllers;

import hoon.schooldb.dto.StudentRequestDto;
import hoon.schooldb.models.Student;
import hoon.schooldb.repositories.StudentRepository;
import hoon.schooldb.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/api/students")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/api/students/{id}")
    public Student getStudent(@PathVariable Long id){
        return studentService.getStudent(id);
    }

    @PostMapping("/api/students")
    public Student createStudent(@RequestBody StudentRequestDto requestDto){
        return studentService.createStudent(requestDto);
    }

    @PutMapping("/api/students/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody StudentRequestDto requestDto){
        return studentService.update(id, requestDto);
    }

}
