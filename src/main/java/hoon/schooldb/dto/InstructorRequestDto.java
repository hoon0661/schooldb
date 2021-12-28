package hoon.schooldb.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class InstructorRequestDto {
    private String firstname;
    private String lastname;
    private String address;
    private String city;
    private String state;
    private String zipcode;
    private String major;
    private String email;
    private String phone;
}
