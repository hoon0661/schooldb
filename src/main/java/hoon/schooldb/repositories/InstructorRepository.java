package hoon.schooldb.repositories;

import hoon.schooldb.models.Instructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {
    Page<Instructor> findAll(Pageable pageable);

    Page<Instructor> findByFirstnameIgnoreCaseStartingWith(String str, Pageable pageable);

    Page<Instructor> findByLastnameIgnoreCaseStartingWith(String str, Pageable pageable);

    Page<Instructor> findByMajorIgnoreCaseStartingWith(String str, Pageable pageable);
}
