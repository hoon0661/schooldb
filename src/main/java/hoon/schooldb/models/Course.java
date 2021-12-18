package hoon.schooldb.models;

import hoon.schooldb.dto.CourseRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
    private String instructor;

    @Column(nullable = false)
    private int capacity;

    @Column(nullable = false)
    private String description;

    public Course(CourseRequestDto requestDto){
        this.courseName = requestDto.getCourseName();
        this.instructor = requestDto.getInstructor();
        this.capacity = requestDto.getCapacity();
        this.description = requestDto.getDescription();
    }

    public void update(CourseRequestDto requestDto){
        this.courseName = requestDto.getCourseName();
        this.instructor = requestDto.getInstructor();
        this.capacity = requestDto.getCapacity();
        this.description = requestDto.getDescription();
    }
}