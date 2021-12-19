package hoon.schooldb.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hoon.schooldb.dto.StudentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@NoArgsConstructor
@Getter
public class Student extends Timestamped {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String zipcode;

    @Column(nullable = false)
    private String major;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phone;

    @JsonIgnore
    @ManyToMany(mappedBy = "students")
    private List<Course> courses = new ArrayList<>();

    public Student(StudentRequestDto requestDto){
        this.firstname = requestDto.getFirstname();
        this.lastname = requestDto.getLastname();
        this.major = requestDto.getMajor().toString();
        this.email = requestDto.getEmail();
        this.phone = requestDto.getPhone();
        this.address = requestDto.getAddress();
        this.city = requestDto.getCity();
        this.state = requestDto.getState();
        this.zipcode = requestDto.getZipcode();
    }

    public void update(StudentRequestDto requestDto){
        this.firstname = requestDto.getFirstname();
        this.lastname = requestDto.getLastname();
        this.major = requestDto.getMajor().toString();
        this.email = requestDto.getEmail();
        this.phone = requestDto.getPhone();
        this.address = requestDto.getAddress();
        this.city = requestDto.getCity();
        this.state = requestDto.getState();
        this.zipcode = requestDto.getZipcode();
    }

    public void addCourse(Course course){
        if(courses.contains(course)){
            throw new IllegalArgumentException("The course already exists in student's course list.");
        }
        courses.add(course);
    }

    public void deleteCourse(Course course){
        if(!courses.contains(course)){
            throw new IllegalArgumentException("The course does not exist in student's course list.");
        }
        courses.remove(course);
    }

}
