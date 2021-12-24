package hoon.schooldb.services;

import hoon.schooldb.config.Config;
import hoon.schooldb.dto.InstructorRequestDto;
import hoon.schooldb.models.Instructor;
import hoon.schooldb.repositories.InstructorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class InstructorService {
    private final InstructorRepository instructorRepository;

    public Page<Instructor> getAllInstructors(int page, int size, String sortBy, boolean isAsc) {
        page = page - 1;
        Sort.Direction direction = isAsc ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sort = Sort.by(direction, sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);
        return instructorRepository.findAll(pageable);
    }

    public Instructor getInstructor(Long id) {
        Instructor instructor = instructorRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("ID does not exist.")
        );

        return instructor;
    }

    public Instructor createInstructor(InstructorRequestDto requestDto) {
//        if (!requestDto.getInstructorToken().equals(Config.INSTRUCTOR_KEY)) {
//            throw new IllegalArgumentException("Instructor key is not correct.");
//        }
//        if (requestDto.isAdmin() && !requestDto.getAdminToken().equals(Config.ADMIN_KEY)) {
//            throw new IllegalArgumentException("Admin key is not correct.");
//        }
        Instructor instructor = new Instructor(requestDto);
//        if (requestDto.isAdmin()) {
//            instructor.setAdmin(true);
//        }
        return instructorRepository.save(instructor);
    }

    @Transactional
    public Instructor update(Long id, InstructorRequestDto requestDto) {
        Instructor instructor = instructorRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID does not exist."));
        instructor.update(requestDto);
        return instructor;
    }

    public List<Instructor> getSearchResult(String searchParam, String str) {

        switch (searchParam) {
            case "firstName":
                return instructorRepository.findByFirstnameIgnoreCaseStartingWith(str);
            case "lastName":
                return instructorRepository.findByLastnameIgnoreCaseStartingWith(str);
            case "major":
                return instructorRepository.findByMajorIgnoreCaseStartingWith(str);
            default:
                return null;
        }
    }
}
