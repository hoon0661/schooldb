package hoon.schooldb.dto;

import hoon.schooldb.models.Major;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Column;

@Getter
@AllArgsConstructor
public class StudentRequestDto {
    private String firstname;
    private String lastname;
    private String address;
    private String city;
    private String state;
    private String zipcode;
    private Major major;
    private String email;
    private String phone;
}
