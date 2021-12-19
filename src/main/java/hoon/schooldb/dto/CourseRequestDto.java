package hoon.schooldb.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CourseRequestDto {

    private String courseName;
    private int capacity;
    private String description;

}
