package hoon.schooldb.controllers;

import hoon.schooldb.dto.StudentRequestDto;
import hoon.schooldb.models.Student;
import hoon.schooldb.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/api/students")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/api/students/pages")
    public Page<Student> getAllStudentsByPages(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "true") boolean isAsc) {
        return studentService.getAllStudentsByPages(page, size, sortBy, isAsc);
    }

    @GetMapping("/api/students/{id}")
    public Student getStudent(@PathVariable Long id) {
        return studentService.getStudent(id);
    }

    @PostMapping("/api/students")
    public Student createStudent(@RequestBody StudentRequestDto requestDto) throws FileNotFoundException {
        return studentService.createStudent(requestDto);
    }

    @PutMapping("/api/students/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody StudentRequestDto requestDto) throws FileNotFoundException {
        return studentService.update(id, requestDto);
    }

    @DeleteMapping("/api/students/{id}")
    public Long deleteStudent(@PathVariable Long id) {
        return studentService.deleteStudent(id);
    }

}
