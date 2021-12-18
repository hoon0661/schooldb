package hoon.schooldb.testdata;

import hoon.schooldb.dto.CourseRequestDto;
import hoon.schooldb.dto.StudentRequestDto;
import hoon.schooldb.models.Major;
import hoon.schooldb.repositories.StudentRepository;
import hoon.schooldb.services.CourseService;
import hoon.schooldb.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@RequiredArgsConstructor
public class TestDataRunner implements ApplicationRunner {

    private final StudentService studentService;
    private final CourseService courseService;


    @Override
    public void run(ApplicationArguments args) throws Exception{
        for(int i = 0; i < 50; i++){
            String firstname = "firstname" + (i + 1);
            String lastname = "lastname" + (i + 1);
            Major major = Major.values()[new Random().nextInt(Major.values().length)];
            String address = "address" + (i + 1);
            String city = "city" + (i + 1);
            String state = "state" + (i + 1);
            String zipcode = "zipcode" + (i + 1);
            String email = "email" + (i + 1) + "@email.com";
            String phone = "phone" + (i + 1);

            StudentRequestDto studentRequestDto = new StudentRequestDto(firstname, lastname, address, city, state, zipcode, major, email, phone);
            studentService.createStudent(studentRequestDto);
        }

        for(int i = 0; i < 10; i++){
            String courseName = "courseName" + (i + 1);
            String instructor = "instructor" + (i + 1);
            int capacity = new Random().nextInt(40) + 11;
            String description = "description" + (i + 1);

            CourseRequestDto courseRequestDto = new CourseRequestDto(courseName, instructor, capacity, description);
            courseService.createCourse(courseRequestDto);
        }
    }

}
