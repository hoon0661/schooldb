package hoon.schooldb.services;

import hoon.schooldb.dto.StudentRequestDto;
import hoon.schooldb.models.Student;
import hoon.schooldb.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Student getStudent(Long id){
        Student student = studentRepository.findById(id).orElseThrow(() ->
            new IllegalArgumentException("ID does not exist.")
        );

        return student;
    }

    public Student createStudent(StudentRequestDto requestDto){
        Student student = new Student(requestDto);
        return studentRepository.save(student);
    }

    @Transactional
    public Student update(Long id, StudentRequestDto requestDto){
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID does not exist."));
        student.update(requestDto);
        return student;
    }
}
