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
public class Course extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public Course(CourseRequestDto requestDto){
        this.courseName = requestDto.getCourseName();
//        this.instructor = requestDto.getInstructor();
        this.capacity = requestDto.getCapacity();
        this.description = requestDto.getDescription();
    }

    public void update(CourseRequestDto requestDto){
        this.courseName = requestDto.getCourseName();
//        this.instructor = requestDto.getInstructor();
        this.capacity = requestDto.getCapacity();
        this.description = requestDto.getDescription();
    }

    public void enrollStudent(Student student) {
        if(students.contains(student)){
            throw new IllegalArgumentException("Student has been already enrolled.");
        }
        students.add(student);
    }
}
