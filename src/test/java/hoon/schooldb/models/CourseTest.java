package hoon.schooldb.models;

import hoon.schooldb.dto.CourseRequestDto;
import hoon.schooldb.dto.InstructorRequestDto;
import hoon.schooldb.dto.StudentRequestDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {
    @Nested
    @DisplayName("Entity Creation")
    class CreateCourse {
        private String courseName;
        private int capacity;
        private String description;

        @BeforeEach
        void setup() {
            courseName = "MATH101";
            capacity = 30;
            description = "Basic Mathematics";
        }

        @Test
        @DisplayName("Normal case")
        void createCourse_Normal() {
            CourseRequestDto requestDto = new CourseRequestDto(courseName, capacity, description);
            Course course = new Course(requestDto);

            assertNull(course.getId());
            assertEquals(courseName, course.getCourseName());
            assertEquals(capacity, course.getCapacity());
            assertEquals(description, course.getDescription());
        }

        @Test
        @DisplayName("Insert a student, normal case")
        void insertStudent_Normal() throws FileNotFoundException {
            CourseRequestDto courseRequestDto = new CourseRequestDto(courseName, capacity, description);
            Course course = new Course(courseRequestDto);

            StudentRequestDto studentRequestDto = new StudentRequestDto(
                    "MyFirstname",
                    "MyLastname",
                    "123 abc st",
                    "abcde",
                    "new york",
                    "12345",
                    "computer science",
                    "abc123@email.com",
                    "1234567890"
            );

            Student student = new Student(studentRequestDto);
            course.enrollStudent(student);

            assertTrue(course.getStudents().size() == 1);
            assertTrue(student.getEmail() == course.getStudents().get(0).getEmail());
        }

        @Test
        @DisplayName("Insert an instructor, normal case")
        void insertInstructor_Normal() throws FileNotFoundException {
            CourseRequestDto courseRequestDto = new CourseRequestDto(courseName, capacity, description);
            Course course = new Course(courseRequestDto);

            InstructorRequestDto instructorRequestDto = new InstructorRequestDto(
                    "MyFirstname",
                    "MyLastname",
                    "123 abc st",
                    "abcde",
                    "new york",
                    "12345",
                    "computer science",
                    "abc123@email.com",
                    "1234567890"
            );

            Instructor instructor = new Instructor(instructorRequestDto);
            course.enrollInstructor(instructor);

            assertNotNull(course.getInstructor());
            assertTrue(instructor.getEmail() == course.getInstructor().getEmail());
        }

        @Test
        @DisplayName("drop a student, normal case")
        void dropStudent_Normal() throws FileNotFoundException {
            CourseRequestDto courseRequestDto = new CourseRequestDto(courseName, capacity, description);
            Course course = new Course(courseRequestDto);

            StudentRequestDto studentRequestDto = new StudentRequestDto(
                    "MyFirstname",
                    "MyLastname",
                    "123 abc st",
                    "abcde",
                    "new york",
                    "12345",
                    "computer science",
                    "abc123@email.com",
                    "1234567890"
            );

            Student student = new Student(studentRequestDto);
            course.enrollStudent(student);

            assertTrue(course.getStudents().size() == 1);
            assertTrue(student.getEmail().equals(course.getStudents().get(0).getEmail()));

            course.dropStudent(student);
            assertEquals(0, course.getStudents().size());
        }

        @Test
        @DisplayName("drop an instructor, normal case")
        void dropInstructor_Normal() throws FileNotFoundException {
            CourseRequestDto courseRequestDto = new CourseRequestDto(courseName, capacity, description);
            Course course = new Course(courseRequestDto);

            InstructorRequestDto instructorRequestDto = new InstructorRequestDto(
                    "MyFirstname",
                    "MyLastname",
                    "123 abc st",
                    "abcde",
                    "new york",
                    "12345",
                    "computer science",
                    "abc123@email.com",
                    "1234567890"
            );

            Instructor instructor = new Instructor(instructorRequestDto);
            course.enrollInstructor(instructor);

            assertNotNull(course.getInstructor());
            assertTrue(instructor.getEmail() == course.getInstructor().getEmail());

            course.dropInstructor(instructor);
            assertNull(course.getInstructor());
        }

        @Nested
        @DisplayName("Fail cases")
        class FailCases {
            @Nested
            @DisplayName("Course name")
            class CourseName {
                @Test
                @DisplayName("When course name is null")
                void fail1() {
                    courseName = null;
                    CourseRequestDto requestDto = new CourseRequestDto(courseName, capacity, description);
                    Exception e = assertThrows(IllegalArgumentException.class, () -> {
                        new Course(requestDto);
                    });
                    assertEquals("Course name is not valid.", e.getMessage());
                }

                @Test
                @DisplayName("When course name is empty string")
                void fail2() {
                    courseName = "";
                    CourseRequestDto requestDto = new CourseRequestDto(courseName, capacity, description);
                    Exception e = assertThrows(IllegalArgumentException.class, () -> {
                        new Course(requestDto);
                    });
                    assertEquals("Course name is not valid.", e.getMessage());
                }

                @Test
                @DisplayName("When course name is less than length of 2 letters")
                void fail3() {
                    courseName = "a";
                    CourseRequestDto requestDto = new CourseRequestDto(courseName, capacity, description);
                    Exception e = assertThrows(IllegalArgumentException.class, () -> {
                        new Course(requestDto);
                    });
                    assertEquals("Course name is not valid.", e.getMessage());
                }
            }

            @Nested
            @DisplayName("Capacity")
            class Capacity {
                @Test
                @DisplayName("When capacity is less than 1")
                void fail1() {
                    capacity = 0;
                    CourseRequestDto requestDto = new CourseRequestDto(courseName, capacity, description);
                    Exception e = assertThrows(IllegalArgumentException.class, () -> {
                        new Course(requestDto);
                    });
                    assertEquals("Capacity must be greater than 0.", e.getMessage());
                }
            }

            @Nested
            @DisplayName("Description")
            class Description {
                @Test
                @DisplayName("When description is null")
                void fail1() {
                    description = null;
                    CourseRequestDto requestDto = new CourseRequestDto(courseName, capacity, description);
                    Exception e = assertThrows(IllegalArgumentException.class, () -> {
                        new Course(requestDto);
                    });
                    assertEquals("Description is not valid.", e.getMessage());
                }

                @Test
                @DisplayName("When description is empty string")
                void fail2() {
                    description = "";
                    CourseRequestDto requestDto = new CourseRequestDto(courseName, capacity, description);
                    Exception e = assertThrows(IllegalArgumentException.class, () -> {
                        new Course(requestDto);
                    });
                    assertEquals("Description is not valid.", e.getMessage());
                }
            }

            @Nested
            @DisplayName("Enroll")
            class Enroll {
                @Nested
                @DisplayName("Student Enroll")
                class StudentEnroll {
                    @Test
                    @DisplayName("When student list is full")
                    void fail1() throws FileNotFoundException {
                        capacity = 1;
                        CourseRequestDto requestDto = new CourseRequestDto(courseName, capacity, description);
                        Course course = new Course(requestDto);

                        assertNull(course.getId());
                        assertEquals(courseName, course.getCourseName());
                        assertEquals(capacity, course.getCapacity());
                        assertEquals(description, course.getDescription());

                        StudentRequestDto studentRequestDto1 = new StudentRequestDto(
                                "MyFirstnameOne",
                                "MyLastnameOne",
                                "123 abc st",
                                "abcde",
                                "new york",
                                "12345",
                                "computer science",
                                "abc123@email.com",
                                "1234567890"
                        );

                        Student student1 = new Student(studentRequestDto1);
                        course.enrollStudent(student1);


                        StudentRequestDto studentRequestDto2 = new StudentRequestDto(
                                "MyFirstnameTwo",
                                "MyLastnameTwo",
                                "123 def st",
                                "edcba",
                                "new york",
                                "54321",
                                "computer engineering",
                                "def123@email.com",
                                "9876543210"
                        );

                        Student student2 = new Student(studentRequestDto2);
                        Exception e = assertThrows(IllegalArgumentException.class, () -> {
                            course.enrollStudent(student2);
                        });
                        assertEquals("The class is full.", e.getMessage());


                    }

                    @Test
                    @DisplayName("When a student has already been enrolled")
                    void fail2() throws FileNotFoundException {
                        CourseRequestDto requestDto = new CourseRequestDto(courseName, capacity, description);
                        Course course = new Course(requestDto);

                        assertNull(course.getId());
                        assertEquals(courseName, course.getCourseName());
                        assertEquals(capacity, course.getCapacity());
                        assertEquals(description, course.getDescription());

                        StudentRequestDto studentRequestDto = new StudentRequestDto(
                                "MyFirstnameOne",
                                "MyLastnameOne",
                                "123 abc st",
                                "abcde",
                                "new york",
                                "12345",
                                "computer science",
                                "abc123@email.com",
                                "1234567890"
                        );

                        Student student = new Student(studentRequestDto);
                        course.enrollStudent(student);

                        Exception e = assertThrows(IllegalArgumentException.class, () -> {
                            course.enrollStudent(student);
                        });
                        assertEquals("Student has been already enrolled.", e.getMessage());
                    }
                }

                @Nested
                @DisplayName("Instructor enroll")
                class InstructorEnroll {
                    @Test
                    @DisplayName("When instructor spot is occupied")
                    void fail1() throws FileNotFoundException {
                        CourseRequestDto requestDto = new CourseRequestDto(courseName, capacity, description);
                        Course course = new Course(requestDto);

                        assertNull(course.getId());
                        assertEquals(courseName, course.getCourseName());
                        assertEquals(capacity, course.getCapacity());
                        assertEquals(description, course.getDescription());

                        InstructorRequestDto instructorRequestDto1 = new InstructorRequestDto(
                                "MyFirstnameOne",
                                "MyLastnameOne",
                                "123 abc st",
                                "abcde",
                                "new york",
                                "12345",
                                "computer science",
                                "abc123@email.com",
                                "1234567890"
                        );

                        Instructor instructor1 = new Instructor(instructorRequestDto1);
                        course.enrollInstructor(instructor1);


                        InstructorRequestDto instructorRequestDto2 = new InstructorRequestDto(
                                "MyFirstnameTwo",
                                "MyLastnameTwo",
                                "123 def st",
                                "edcba",
                                "new york",
                                "54321",
                                "computer engineering",
                                "def123@email.com",
                                "9876543210"
                        );

                        Instructor instructor2 = new Instructor(instructorRequestDto2);
                        Exception e = assertThrows(IllegalArgumentException.class, () -> {
                            course.enrollInstructor(instructor2);
                        });
                        assertEquals("Instructor has been already enrolled.", e.getMessage());
                    }
                }

                @Nested
                @DisplayName("Drop")
                class Drop {
                    @Nested
                    @DisplayName("Student drop")
                    class StudentDrop {
                        @Test
                        @DisplayName("When student is not in list")
                        void fail1() throws FileNotFoundException {
                            CourseRequestDto requestDto = new CourseRequestDto(courseName, capacity, description);
                            Course course = new Course(requestDto);

                            assertNull(course.getId());
                            assertEquals(courseName, course.getCourseName());
                            assertEquals(capacity, course.getCapacity());
                            assertEquals(description, course.getDescription());

                            StudentRequestDto studentRequestDto = new StudentRequestDto(
                                    "MyFirstnameOne",
                                    "MyLastnameOne",
                                    "123 abc st",
                                    "abcde",
                                    "new york",
                                    "12345",
                                    "computer science",
                                    "abc123@email.com",
                                    "1234567890"
                            );

                            Student student = new Student(studentRequestDto);

                            Exception e = assertThrows(IllegalArgumentException.class, () -> {
                                course.dropStudent(student);
                            });
                            assertEquals("Student is not in class roster.", e.getMessage());
                        }
                    }

                    @Nested
                    @DisplayName("Instructor drop")
                    class InstructorDrop {
                        @Test
                        @DisplayName("When Instructor is not in class")
                        void fail1() throws FileNotFoundException {
                            CourseRequestDto requestDto = new CourseRequestDto(courseName, capacity, description);
                            Course course = new Course(requestDto);

                            assertNull(course.getId());
                            assertEquals(courseName, course.getCourseName());
                            assertEquals(capacity, course.getCapacity());
                            assertEquals(description, course.getDescription());

                            InstructorRequestDto instructorRequestDto = new InstructorRequestDto(
                                    "MyFirstnameOne",
                                    "MyLastnameOne",
                                    "123 abc st",
                                    "abcde",
                                    "new york",
                                    "12345",
                                    "computer science",
                                    "abc123@email.com",
                                    "1234567890"
                            );

                            Instructor instructor = new Instructor(instructorRequestDto);

                            Exception e = assertThrows(IllegalArgumentException.class, () -> {
                                course.dropInstructor(instructor);
                            });
                            assertEquals("Instructor is not in class.", e.getMessage());
                        }

                        @Test
                        @DisplayName("When Instructor to drop is different")
                        void fail2() throws FileNotFoundException {
                            CourseRequestDto requestDto = new CourseRequestDto(courseName, capacity, description);
                            Course course = new Course(requestDto);

                            assertNull(course.getId());
                            assertEquals(courseName, course.getCourseName());
                            assertEquals(capacity, course.getCapacity());
                            assertEquals(description, course.getDescription());

                            InstructorRequestDto instructorRequestDto1 = new InstructorRequestDto(
                                    "MyFirstnameOne",
                                    "MyLastnameOne",
                                    "123 abc st",
                                    "abcde",
                                    "new york",
                                    "12345",
                                    "computer science",
                                    "abc123@email.com",
                                    "1234567890"
                            );

                            Instructor instructor1 = new Instructor(instructorRequestDto1);
                            course.enrollInstructor(instructor1);


                            InstructorRequestDto instructorRequestDto2 = new InstructorRequestDto(
                                    "MyFirstnameTwo",
                                    "MyLastnameTwo",
                                    "123 def st",
                                    "edcba",
                                    "new york",
                                    "54321",
                                    "computer engineering",
                                    "def123@email.com",
                                    "9876543210"
                            );

                            Instructor instructor2 = new Instructor(instructorRequestDto2);

                            Exception e = assertThrows(IllegalArgumentException.class, () -> {
                                course.dropInstructor(instructor2);
                            });
                            assertEquals("Instructor does not match.", e.getMessage());
                        }
                    }
                }
            }
        }
    }
}