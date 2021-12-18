package hoon.schooldb.services;

import hoon.schooldb.config.Config;
import hoon.schooldb.dto.InstructorRequestDto;
import hoon.schooldb.dto.StudentRequestDto;
import hoon.schooldb.models.Instructor;
import hoon.schooldb.models.Student;
import hoon.schooldb.repositories.InstructorRepository;
import hoon.schooldb.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class InstructorService {
    private final InstructorRepository instructorRepository;

    public List<Instructor> getAllInstructors(){
        return instructorRepository.findAll();
    }

    public Instructor getInstructor(Long id){
        Instructor instructor = instructorRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("ID does not exist.")
        );

        return instructor;
    }

    public Instructor createInstructor(InstructorRequestDto requestDto){
        if(!requestDto.getInstructorToken().equals(Config.INSTRUCTOR_KEY)){
            throw new IllegalArgumentException("Instructor key is not correct.");
        }
        if(requestDto.isAdmin() && !requestDto.getAdminToken().equals(Config.ADMIN_KEY)){
            throw new IllegalArgumentException("Admin key is not correct.");
        }
        Instructor instructor = new Instructor(requestDto);
        if(requestDto.isAdmin()){
            instructor.setAdmin(true);
        }
        return instructorRepository.save(instructor);
    }

    @Transactional
    public Instructor update(Long id, InstructorRequestDto requestDto){
        Instructor instructor = instructorRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID does not exist."));
        instructor.update(requestDto);
        return instructor;
    }
}
