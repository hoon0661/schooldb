package hoon.schooldb.repositories;

import hoon.schooldb.models.Instructor;
import hoon.schooldb.models.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Page<Student> findAll(Pageable pageable);

    List<Student> findByFirstnameIgnoreCaseStartingWith(String str);

    List<Student> findByMajorIgnoreCaseStartingWith(String str);

    List<Student> findByLastnameIgnoreCaseStartingWith(String str);
}
