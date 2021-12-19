package hoon.schooldb.testdata;

import hoon.schooldb.config.Config;
import hoon.schooldb.dto.CourseRequestDto;
import hoon.schooldb.dto.InstructorRequestDto;
import hoon.schooldb.dto.StudentRequestDto;
import hoon.schooldb.models.Instructor;
import hoon.schooldb.models.Major;
import hoon.schooldb.repositories.StudentRepository;
import hoon.schooldb.services.CourseService;
import hoon.schooldb.services.InstructorService;
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
    private final InstructorService instructorService;


    @Override
    public void run(ApplicationArguments args) throws Exception{
        for(int i = 0; i < 50; i++){
            String firstname = "studentFirstname" + (i + 1);
            String lastname = "studentLastname" + (i + 1);
            Major major = Major.values()[new Random().nextInt(Major.values().length)];
            String address = "studentAddress" + (i + 1);
            String city = "studentCity" + (i + 1);
            String state = "studentState" + (i + 1);
            String zipcode = "studentZipcode" + (i + 1);
            String email = "studentEmail" + (i + 1) + "@email.com";
            String phone = "studentPhone" + (i + 1);

            StudentRequestDto studentRequestDto = new StudentRequestDto(firstname, lastname, address, city, state, zipcode, major, email, phone);
            studentService.createStudent(studentRequestDto);
        }

        for(int i = 0; i < 10; i++){
            String firstname = "instructorFirstname" + (i + 1);
            String lastname = "instructorLastname" + (i + 1);
            Major major = Major.values()[new Random().nextInt(Major.values().length)];
            String address = "instructorAddress" + (i + 1);
            String city = "instructorCity" + (i + 1);
            String state = "instructorState" + (i + 1);
            String zipcode = "instructorZipcode" + (i + 1);
            String email = "instructorEmail" + (i + 1) + "@email.com";
            String phone = "instructorPhone" + (i + 1);
            boolean isAdmin = false;
            String instructorToken = Config.INSTRUCTOR_KEY;
            String adminToken = "";
            if(i == 9){
                isAdmin = true;
                adminToken = Config.ADMIN_KEY;
            }

            InstructorRequestDto requestDto = new InstructorRequestDto(firstname, lastname, address, city, state, zipcode, major, email, phone, isAdmin, instructorToken, adminToken);
            instructorService.createInstructor(requestDto);
        }

        for(int i = 0; i < 10; i++){
            String courseName = "courseName" + (i + 1);
            int capacity = new Random().nextInt(40) + 11;
            String description = "description" + (i + 1);

            CourseRequestDto courseRequestDto = new CourseRequestDto(courseName, capacity, description);
            courseService.createCourse(courseRequestDto);
        }
    }

}
