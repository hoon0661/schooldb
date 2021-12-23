package hoon.schooldb.repositories;

import hoon.schooldb.models.Instructor;
import hoon.schooldb.models.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Page<Student> findAll(Pageable pageable);

    Page<Student> findByFirstnameIgnoreCaseStartingWith(String str, Pageable pageable);

    Page<Student> findByMajorIgnoreCaseStartingWith(String str, Pageable pageable);

    Page<Student> findByLastnameIgnoreCaseStartingWith(String str, Pageable pageable);
}
