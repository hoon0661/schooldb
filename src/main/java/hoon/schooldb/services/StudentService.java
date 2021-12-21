package hoon.schooldb.services;

import hoon.schooldb.dto.StudentRequestDto;
import hoon.schooldb.models.Student;
import hoon.schooldb.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public Page<Student> getAllStudents(int page, int size, String sortBy, boolean isAsc) {
        page = page - 1;
        Sort.Direction direction = isAsc ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sort = Sort.by(direction, sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);
        return studentRepository.findAll(pageable);
    }

    public Student getStudent(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("ID does not exist.")
        );

        return student;
    }

    public Student createStudent(StudentRequestDto requestDto) {
        Student student = new Student(requestDto);
        return studentRepository.save(student);
    }

    @Transactional
    public Student update(Long id, StudentRequestDto requestDto) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID does not exist."));
        student.update(requestDto);
        return student;
    }
}
