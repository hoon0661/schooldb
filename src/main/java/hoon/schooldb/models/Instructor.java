package hoon.schooldb.models;

import hoon.schooldb.dto.InstructorRequestDto;
import hoon.schooldb.dto.StudentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Instructor extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @Column(nullable = false)
    private boolean isAdmin;

//    @OneToMany
//    private List<Course> courses;

    public Instructor(InstructorRequestDto requestDto){
        this.firstname = requestDto.getFirstname();
        this.lastname = requestDto.getLastname();
        this.major = requestDto.getMajor().toString();
        this.email = requestDto.getEmail();
        this.phone = requestDto.getPhone();
        this.address = requestDto.getAddress();
        this.city = requestDto.getCity();
        this.state = requestDto.getState();
        this.zipcode = requestDto.getZipcode();
        this.isAdmin = requestDto.isAdmin();
    }

    public void update(InstructorRequestDto requestDto){
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

//    public void addCourse(Course course){
//        if(courses.contains(course)){
//            throw new IllegalArgumentException("the course already exist in the course list.");
//        }
//        courses.add(course);
//    }
//
//    public void deleteCourse(Course course){
//        if(!courses.contains(course)){
//            throw new IllegalArgumentException("the course does not exist in the course list.");
//        }
//        courses.remove(course);
//    }
}
