package hoon.schooldb.services;

import hoon.schooldb.dto.InstructorRequestDto;
import hoon.schooldb.models.Course;
import hoon.schooldb.models.Instructor;
import hoon.schooldb.repositories.InstructorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.FileNotFoundException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class InstructorService {
    private final InstructorRepository instructorRepository;

    public Page<Instructor> getAllInstructorsByPages(int page, int size, String sortBy, boolean isAsc) {
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

    public Instructor createInstructor(InstructorRequestDto requestDto) throws FileNotFoundException {
        Instructor instructor = new Instructor(requestDto);
        return instructorRepository.save(instructor);
    }

    @Transactional
    public Instructor update(Long id, InstructorRequestDto requestDto) throws FileNotFoundException {
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

    public List<Instructor> getAllInstructors() {
        return instructorRepository.findAll();
    }

    @Transactional
    public Long deleteInstructor(Long id) {
        Instructor instructor = getInstructor(id);
        List<Course> teachingCourses = instructor.getCourses();
        for (Course course : teachingCourses) {
            course.dropInstructor(instructor);
        }
        instructorRepository.deleteById(id);
        return id;
    }
}
