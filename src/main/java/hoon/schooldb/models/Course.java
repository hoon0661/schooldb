package hoon.schooldb.models;

import hoon.schooldb.dto.CourseRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Course extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String courseName;

    @Column(nullable = false)
    private int capacity;

    @Column(nullable = false)
    private String description;

    @ManyToMany
    @JoinTable(name = "student_course", joinColumns = @JoinColumn(name = "course_id"), inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<Student> students = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "instructor_id", referencedColumnName = "id")
    private Instructor instructor;

    public Course(CourseRequestDto requestDto) {
        this.courseName = requestDto.getCourseName();
        this.capacity = requestDto.getCapacity();
        this.description = requestDto.getDescription();
    }

    public void update(CourseRequestDto requestDto) {
        this.courseName = requestDto.getCourseName();
        this.capacity = requestDto.getCapacity();
        this.description = requestDto.getDescription();
    }

    public void enrollStudent(Student student) {
        if (students.contains(student)) {
            throw new IllegalArgumentException("Student has been already enrolled.");
        }
        if (students.size() == this.capacity) {
            throw new IllegalArgumentException("The class is full.");
        }
        students.add(student);
    }

    public void enrollInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public void dropStudent(Student student) {
        if (!students.contains(student)) {
            throw new IllegalArgumentException("Student is not in class roster.");
        }
        students.remove(student);
    }

    public void dropInstructor(Instructor instructor) {
        if (this.instructor == null) {
            throw new IllegalArgumentException("Instructor is not in class.");
        }
        if (this.instructor != instructor) {
            throw new IllegalArgumentException("Instructor does not match.");
        }
        this.instructor = null;
    }
}
