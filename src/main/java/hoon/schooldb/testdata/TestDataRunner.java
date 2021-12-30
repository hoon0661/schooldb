package hoon.schooldb.testdata;

import hoon.schooldb.config.Config;
import hoon.schooldb.dto.CourseRequestDto;
import hoon.schooldb.dto.InstructorRequestDto;
import hoon.schooldb.dto.StudentRequestDto;
import hoon.schooldb.services.CourseService;
import hoon.schooldb.services.InstructorService;
import hoon.schooldb.services.StudentService;
import hoon.schooldb.utils.EmailGenerator;
import hoon.schooldb.utils.PhoneNumberGenerator;
import hoon.schooldb.utils.ZipcodeGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

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
    List<String> majorNames = new ArrayList<>();
    List<String> states = new ArrayList<>();
    Random rand = new Random();

    @Override
    public void run(ApplicationArguments args) throws Exception {
        createDataList();
        int stateSize = states.size();
        for (int i = 0; i < 20; i++) {
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

            int randomStateNumber = rand.nextInt(stateSize);
            String state = states.get(randomStateNumber);
            String zipcode = ZipcodeGenerator.generate();
            String email = EmailGenerator.generate();
            String phone = PhoneNumberGenerator.generate();

            StudentRequestDto studentRequestDto = new StudentRequestDto(firstname, lastname, address, city, state, zipcode, major, email, phone);
            studentService.createStudent(studentRequestDto);
        }

        for (int i = 0; i < 5; i++) {
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

            int randomStateNumber = rand.nextInt(stateSize);
            String state = states.get(randomStateNumber);
            String zipcode = ZipcodeGenerator.generate();
            String email = EmailGenerator.generate();
            String phone = PhoneNumberGenerator.generate();
            boolean isAdmin = false;
            String instructorToken = Config.INSTRUCTOR_KEY;
            String adminToken = "";
            if (i == 9) {
                isAdmin = true;
                adminToken = Config.ADMIN_KEY;
            }

            InstructorRequestDto requestDto = new InstructorRequestDto(firstname, lastname, address, city, state, zipcode, major, email, phone);
            instructorService.createInstructor(requestDto);
        }

        for (int i = 0; i < 5; i++) {
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
        File file4 = new File("src/main/java/hoon/schooldb/utils/states.txt");
        Scanner sc1 = new Scanner(file1);
        Scanner sc2 = new Scanner(file2);
        Scanner sc3 = new Scanner(file3);
        Scanner sc4 = new Scanner(file4);
        while (sc1.hasNextLine()) {
            firstNames.add(sc1.nextLine());
        }
        while (sc2.hasNextLine()) {
            lastNames.add(sc2.nextLine());
        }
        while (sc3.hasNextLine()) {
            majorNames.add(sc3.nextLine());
        }
        while (sc4.hasNextLine()) {
            states.add(sc4.nextLine());
        }

    }

}
