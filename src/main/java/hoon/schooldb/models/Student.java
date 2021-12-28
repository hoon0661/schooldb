package hoon.schooldb.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hoon.schooldb.dto.InstructorRequestDto;
import hoon.schooldb.dto.StudentRequestDto;
import hoon.schooldb.utils.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@NoArgsConstructor
@Getter
public class Student extends Timestamped {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Student(StudentRequestDto requestDto) throws FileNotFoundException {
        validateInput(requestDto);
        this.firstname = requestDto.getFirstname();
        this.lastname = requestDto.getLastname();
        this.major = requestDto.getMajor();
        this.email = requestDto.getEmail();
        this.phone = requestDto.getPhone();
        this.address = requestDto.getAddress();
        this.city = requestDto.getCity();
        this.state = requestDto.getState();
        this.zipcode = requestDto.getZipcode();
    }

    public void update(StudentRequestDto requestDto) throws FileNotFoundException {
        validateInput(requestDto);
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

    public void validateInput(StudentRequestDto requestDto) throws FileNotFoundException {
        if (requestDto.getFirstname() == null || requestDto.getFirstname().isEmpty() || requestDto.getFirstname().trim().length() < 2 || !NameValidator.isAllLetters(requestDto.getFirstname())) {
            throw new IllegalArgumentException("Firstname is not valid.");
        }
        if (requestDto.getLastname() == null || requestDto.getLastname().isEmpty() || requestDto.getLastname().trim().length() < 2 || !NameValidator.isAllLetters(requestDto.getLastname())) {
            throw new IllegalArgumentException("Lastname is not valid.");
        }
        if (requestDto.getMajor() == null || requestDto.getMajor().isEmpty() || requestDto.getMajor().trim().length() < 3) {
            throw new IllegalArgumentException("Major is not valid.");
        }
        if (EmailValidator.isNull(requestDto.getEmail()) || EmailValidator.isEmpty(requestDto.getEmail()) || !EmailValidator.patternMatches(requestDto.getEmail())) {
            throw new IllegalArgumentException("Email is not valid.");
        }
        if (PhoneNumberValidator.isNull(requestDto.getPhone()) || PhoneNumberValidator.isEmpty(requestDto.getPhone()) || !PhoneNumberValidator.patternMatches(requestDto.getPhone())) {
            throw new IllegalArgumentException("Phone number is not valid.");
        }
        if (requestDto.getAddress() == null || requestDto.getAddress().isEmpty()) {
            throw new IllegalArgumentException("Address is not valid.");
        }
        if (requestDto.getCity() == null || requestDto.getCity().isEmpty()) {
            throw new IllegalArgumentException("City is not valid.");
        }

        StateValidator stateValidator = new StateValidator();
        if (stateValidator.isNull(requestDto.getState()) || stateValidator.isEmpty(requestDto.getState()) || !stateValidator.isInStateList(requestDto.getState())) {
            throw new IllegalArgumentException("State is not valid.");
        }
        if (ZipcodeValidator.isNull(requestDto.getZipcode()) || ZipcodeValidator.isEmpty(requestDto.getZipcode()) || !ZipcodeValidator.patternMatches(requestDto.getZipcode())) {
            throw new IllegalArgumentException("Zipcode is not valid.");
        }
    }

}
