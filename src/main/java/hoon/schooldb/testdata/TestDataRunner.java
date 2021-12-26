package hoon.schooldb.testdata;

import hoon.schooldb.config.Config;
import hoon.schooldb.dto.CourseRequestDto;
import hoon.schooldb.dto.InstructorRequestDto;
import hoon.schooldb.dto.StudentRequestDto;
import hoon.schooldb.services.CourseService;
import hoon.schooldb.services.InstructorService;
import hoon.schooldb.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

//@Component
@RequiredArgsConstructor
public class TestDataRunner implements ApplicationRunner {

    private final StudentService studentService;
    private final CourseService courseService;
    private final InstructorService instructorService;
    List<String> firstNames = new ArrayList<>();
    List<String> lastNames = new ArrayList<>();
    List<String> courseNames = new ArrayList<>();
    List<String> majorNames = new ArrayList<>();

    @Override
    public void run(ApplicationArguments args) throws Exception {
        createDataList();
        for (int i = 0; i < 200; i++) {

            int firstnameLength = firstNames.size();
            int lastnameLength = lastNames.size();
            int majorLength = majorNames.size();
            int firstnameIdx = new Random().nextInt(firstnameLength);
            int lastnameIdx = new Random().nextInt(lastnameLength);
            int majorIdx = new Random().nextInt(majorLength);
            String firstname = firstNames.get(firstnameIdx);
            firstNames.remove(firstnameIdx);
            String lastname = lastNames.get(lastnameIdx);
            lastNames.remove(lastnameIdx);

            String major = majorNames.get(majorIdx);
            String address = "studentAddress" + (i + 1);
            String city = "studentCity" + (i + 1);
            String state = "studentState" + (i + 1);
            String zipcode = "studentZipcode" + (i + 1);
            String email = "studentEmail" + (i + 1) + "@email.com";
            String phone = "studentPhone" + (i + 1);

            StudentRequestDto studentRequestDto = new StudentRequestDto(firstname, lastname, address, city, state, zipcode, major, email, phone);
            studentService.createStudent(studentRequestDto);
        }

        for (int i = 0; i < 50; i++) {
            int firstnameLength = firstNames.size();
            int lastnameLength = lastNames.size();
            int majorLength = majorNames.size();
            int firstnameIdx = new Random().nextInt(firstnameLength);
            int lastnameIdx = new Random().nextInt(lastnameLength);
            int majorIdx = new Random().nextInt(majorLength);
            String firstname = firstNames.get(firstnameIdx);
            firstNames.remove(firstnameIdx);
            String lastname = lastNames.get(lastnameIdx);
            lastNames.remove(lastnameIdx);

            String major = majorNames.get(majorIdx);
            String address = "instructorAddress" + (i + 1);
            String city = "instructorCity" + (i + 1);
            String state = "instructorState" + (i + 1);
            String zipcode = "instructorZipcode" + (i + 1);
            String email = "instructorEmail" + (i + 1) + "@email.com";
            String phone = "instructorPhone" + (i + 1);
            boolean isAdmin = false;
            String instructorToken = Config.INSTRUCTOR_KEY;
            String adminToken = "";
            if (i == 9) {
                isAdmin = true;
                adminToken = Config.ADMIN_KEY;
            }

            InstructorRequestDto requestDto = new InstructorRequestDto(firstname, lastname, address, city, state, zipcode, major, email, phone, isAdmin, instructorToken, adminToken);
            instructorService.createInstructor(requestDto);
        }

        for (int i = 0; i < 100; i++) {
            String courseName = "courseName" + (i + 1);
            int capacity = new Random().nextInt(40) + 11;
            String description = "description" + (i + 1);

            CourseRequestDto courseRequestDto = new CourseRequestDto(courseName, capacity, description);
            courseService.createCourse(courseRequestDto);
        }
    }

    private void createDataList() throws FileNotFoundException {
        File file1 = new File("src/main/java/hoon/schooldb/testdata/firstnameList.txt");
        File file2 = new File("src/main/java/hoon/schooldb/testdata/lastnameList.txt");
        File file3 = new File("src/main/java/hoon/schooldb/testdata/majorList.txt");
        Scanner sc1 = new Scanner(file1);
        Scanner sc2 = new Scanner(file2);
        Scanner sc3 = new Scanner(file3);
        while (sc1.hasNextLine()) {
            firstNames.add(sc1.nextLine());
        }
        while (sc2.hasNextLine()) {
            lastNames.add(sc2.nextLine());
        }
        while (sc3.hasNextLine()) {
            majorNames.add(sc3.nextLine());
        }

    }

}
