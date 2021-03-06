package hoon.schooldb.models;

import hoon.schooldb.dto.StudentRequestDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    @Nested
    @DisplayName("Entity creation")
    class CreateStudent {
        private String firstname;
        private String lastname;
        private String address;
        private String city;
        private String state;
        private String zipcode;
        private String major;
        private String email;
        private String phone;

        @BeforeEach
        void setup() {
            firstname = "MyFirstname";
            lastname = "MyLastname";
            address = "123 abc st";
            city = "abcde";
            state = "new york";
            zipcode = "12345";
            major = "computer science";
            email = "abc123@email.com";
            phone = "1234567890";
        }

        @Test
        @DisplayName("Normal case")
        void createStudent_Normal() throws FileNotFoundException {
            StudentRequestDto requestDto = new StudentRequestDto(
                    firstname,
                    lastname,
                    address,
                    city,
                    state,
                    zipcode,
                    major,
                    email,
                    phone
            );

            Student student = new Student(requestDto);

            assertNull(student.getId());
            assertEquals(firstname, student.getFirstname());
            assertEquals(lastname, student.getLastname());
            assertEquals(address, student.getAddress());
            assertEquals(city, student.getCity());
            assertEquals(state, student.getState());
            assertEquals(zipcode, student.getZipcode());
            assertEquals(major, student.getMajor());
            assertEquals(email, student.getEmail());
            assertEquals(phone, student.getPhone());
        }

        @Nested
        @DisplayName("Fail cases")
        class FailCases {
            @Nested
            @DisplayName("Firstname")
            class Firstname {
                @Test
                @DisplayName("When firstname is null")
                void fail1() {
                    firstname = null;
                    StudentRequestDto requestDto = new StudentRequestDto(
                            firstname,
                            lastname,
                            address,
                            city,
                            state,
                            zipcode,
                            major,
                            email,
                            phone
                    );

                    Exception e = assertThrows(IllegalArgumentException.class, () -> {
                        new Student(requestDto);
                    });
                    assertEquals("Firstname is not valid.", e.getMessage());
                }

                @Test
                @DisplayName("When firstname is empty string")
                void fail2() {
                    firstname = "";
                    StudentRequestDto requestDto = new StudentRequestDto(
                            firstname,
                            lastname,
                            address,
                            city,
                            state,
                            zipcode,
                            major,
                            email,
                            phone
                    );

                    Exception e = assertThrows(IllegalArgumentException.class, () -> {
                        new Student(requestDto);
                    });
                    assertEquals("Firstname is not valid.", e.getMessage());
                }

                @Test
                @DisplayName("When firstname contains non-letters")
                void fail3() {
                    firstname = "abc123";
                    StudentRequestDto requestDto = new StudentRequestDto(
                            firstname,
                            lastname,
                            address,
                            city,
                            state,
                            zipcode,
                            major,
                            email,
                            phone
                    );

                    Exception e = assertThrows(IllegalArgumentException.class, () -> {
                        new Student(requestDto);
                    });
                    assertEquals("Firstname is not valid.", e.getMessage());
                }
            }

            @Nested
            @DisplayName("Lastname")
            class Lastname {
                @Test
                @DisplayName("When lastname is null")
                void fail1() {
                    lastname = null;
                    StudentRequestDto requestDto = new StudentRequestDto(
                            firstname,
                            lastname,
                            address,
                            city,
                            state,
                            zipcode,
                            major,
                            email,
                            phone
                    );

                    Exception e = assertThrows(IllegalArgumentException.class, () -> {
                        new Student(requestDto);
                    });
                    assertEquals("Lastname is not valid.", e.getMessage());
                }

                @Test
                @DisplayName("When lastname is empty string")
                void fail2() {
                    lastname = "";
                    StudentRequestDto requestDto = new StudentRequestDto(
                            firstname,
                            lastname,
                            address,
                            city,
                            state,
                            zipcode,
                            major,
                            email,
                            phone
                    );

                    Exception e = assertThrows(IllegalArgumentException.class, () -> {
                        new Student(requestDto);
                    });
                    assertEquals("Lastname is not valid.", e.getMessage());
                }

                @Test
                @DisplayName("When lastname contains non-letters")
                void fail3() {
                    lastname = "abc123";
                    StudentRequestDto requestDto = new StudentRequestDto(
                            firstname,
                            lastname,
                            address,
                            city,
                            state,
                            zipcode,
                            major,
                            email,
                            phone
                    );

                    Exception e = assertThrows(IllegalArgumentException.class, () -> {
                        new Student(requestDto);
                    });
                    assertEquals("Lastname is not valid.", e.getMessage());
                }
            }

            @Nested
            @DisplayName("Major")
            class Major {
                @Test
                @DisplayName("When major is null")
                void fail1() {
                    major = null;
                    StudentRequestDto requestDto = new StudentRequestDto(
                            firstname,
                            lastname,
                            address,
                            city,
                            state,
                            zipcode,
                            major,
                            email,
                            phone
                    );

                    Exception e = assertThrows(IllegalArgumentException.class, () -> {
                        new Student(requestDto);
                    });
                    assertEquals("Major is not valid.", e.getMessage());
                }

                @Test
                @DisplayName("When major is empty string")
                void fail2() {
                    major = "";
                    StudentRequestDto requestDto = new StudentRequestDto(
                            firstname,
                            lastname,
                            address,
                            city,
                            state,
                            zipcode,
                            major,
                            email,
                            phone
                    );

                    Exception e = assertThrows(IllegalArgumentException.class, () -> {
                        new Student(requestDto);
                    });
                    assertEquals("Major is not valid.", e.getMessage());
                }

                @Test
                @DisplayName("When major string with length less than 3")
                void fail3() {
                    major = "ab";
                    StudentRequestDto requestDto = new StudentRequestDto(
                            firstname,
                            lastname,
                            address,
                            city,
                            state,
                            zipcode,
                            major,
                            email,
                            phone
                    );

                    Exception e = assertThrows(IllegalArgumentException.class, () -> {
                        new Student(requestDto);
                    });
                    assertEquals("Major is not valid.", e.getMessage());
                }
            }

            @Nested
            @DisplayName("Email")
            class Email {
                @Test
                @DisplayName("When email is null")
                void fail1() {
                    email = null;
                    StudentRequestDto requestDto = new StudentRequestDto(
                            firstname,
                            lastname,
                            address,
                            city,
                            state,
                            zipcode,
                            major,
                            email,
                            phone
                    );

                    Exception e = assertThrows(IllegalArgumentException.class, () -> {
                        new Student(requestDto);
                    });
                    assertEquals("Email is not valid.", e.getMessage());
                }

                @Test
                @DisplayName("When email is empty string")
                void fail2() {
                    email = "";
                    StudentRequestDto requestDto = new StudentRequestDto(
                            firstname,
                            lastname,
                            address,
                            city,
                            state,
                            zipcode,
                            major,
                            email,
                            phone
                    );

                    Exception e = assertThrows(IllegalArgumentException.class, () -> {
                        new Student(requestDto);
                    });
                    assertEquals("Email is not valid.", e.getMessage());
                }

                @Test
                @DisplayName("When email is missing @ ")
                void fail3() {
                    email = "abc123email.com";
                    StudentRequestDto requestDto = new StudentRequestDto(
                            firstname,
                            lastname,
                            address,
                            city,
                            state,
                            zipcode,
                            major,
                            email,
                            phone
                    );

                    Exception e = assertThrows(IllegalArgumentException.class, () -> {
                        new Student(requestDto);
                    });
                    assertEquals("Email is not valid.", e.getMessage());
                }
            }

            @Nested
            @DisplayName("Phone number")
            class PhoneNumber {
                @Test
                @DisplayName("When phone number is null")
                void fail1() {
                    phone = null;
                    StudentRequestDto requestDto = new StudentRequestDto(
                            firstname,
                            lastname,
                            address,
                            city,
                            state,
                            zipcode,
                            major,
                            email,
                            phone
                    );

                    Exception e = assertThrows(IllegalArgumentException.class, () -> {
                        new Student(requestDto);
                    });
                    assertEquals("Phone number is not valid.", e.getMessage());
                }

                @Test
                @DisplayName("When phone number is empty string")
                void fail2() {
                    phone = "";
                    StudentRequestDto requestDto = new StudentRequestDto(
                            firstname,
                            lastname,
                            address,
                            city,
                            state,
                            zipcode,
                            major,
                            email,
                            phone
                    );

                    Exception e = assertThrows(IllegalArgumentException.class, () -> {
                        new Student(requestDto);
                    });
                    assertEquals("Phone number is not valid.", e.getMessage());
                }

                @Test
                @DisplayName("When phone number is less than 10 digits")
                void fail3() {
                    phone = "12345678";
                    StudentRequestDto requestDto = new StudentRequestDto(
                            firstname,
                            lastname,
                            address,
                            city,
                            state,
                            zipcode,
                            major,
                            email,
                            phone
                    );

                    Exception e = assertThrows(IllegalArgumentException.class, () -> {
                        new Student(requestDto);
                    });
                    assertEquals("Phone number is not valid.", e.getMessage());
                }

                @Test
                @DisplayName("When phone number is longer than 10 digits")
                void fail4() {
                    phone = "12345678901";
                    StudentRequestDto requestDto = new StudentRequestDto(
                            firstname,
                            lastname,
                            address,
                            city,
                            state,
                            zipcode,
                            major,
                            email,
                            phone
                    );

                    Exception e = assertThrows(IllegalArgumentException.class, () -> {
                        new Student(requestDto);
                    });
                    assertEquals("Phone number is not valid.", e.getMessage());
                }
            }

            @Nested
            @DisplayName("Address")
            class Address {
                @Test
                @DisplayName("When address is null")
                void fail1() {
                    address = null;
                    StudentRequestDto requestDto = new StudentRequestDto(
                            firstname,
                            lastname,
                            address,
                            city,
                            state,
                            zipcode,
                            major,
                            email,
                            phone
                    );

                    Exception e = assertThrows(IllegalArgumentException.class, () -> {
                        new Student(requestDto);
                    });
                    assertEquals("Address is not valid.", e.getMessage());
                }

                @Test
                @DisplayName("When address is empty string")
                void fail2() {
                    address = "";
                    StudentRequestDto requestDto = new StudentRequestDto(
                            firstname,
                            lastname,
                            address,
                            city,
                            state,
                            zipcode,
                            major,
                            email,
                            phone
                    );

                    Exception e = assertThrows(IllegalArgumentException.class, () -> {
                        new Student(requestDto);
                    });
                    assertEquals("Address is not valid.", e.getMessage());
                }
            }

            @Nested
            @DisplayName("City")
            class City {
                @Test
                @DisplayName("When city is null")
                void fail1() {
                    city = null;
                    StudentRequestDto requestDto = new StudentRequestDto(
                            firstname,
                            lastname,
                            address,
                            city,
                            state,
                            zipcode,
                            major,
                            email,
                            phone
                    );

                    Exception e = assertThrows(IllegalArgumentException.class, () -> {
                        new Student(requestDto);
                    });
                    assertEquals("City is not valid.", e.getMessage());
                }

                @Test
                @DisplayName("When city is empty string")
                void fail2() {
                    city = "";
                    StudentRequestDto requestDto = new StudentRequestDto(
                            firstname,
                            lastname,
                            address,
                            city,
                            state,
                            zipcode,
                            major,
                            email,
                            phone
                    );

                    Exception e = assertThrows(IllegalArgumentException.class, () -> {
                        new Student(requestDto);
                    });
                    assertEquals("City is not valid.", e.getMessage());
                }
            }

            @Nested
            @DisplayName("State")
            class State {
                @Test
                @DisplayName("When state is null")
                void fail1() {
                    state = null;
                    StudentRequestDto requestDto = new StudentRequestDto(
                            firstname,
                            lastname,
                            address,
                            city,
                            state,
                            zipcode,
                            major,
                            email,
                            phone
                    );

                    Exception e = assertThrows(IllegalArgumentException.class, () -> {
                        new Student(requestDto);
                    });
                    assertEquals("State is not valid.", e.getMessage());
                }

                @Test
                @DisplayName("When state is empty string")
                void fail2() {
                    state = "";
                    StudentRequestDto requestDto = new StudentRequestDto(
                            firstname,
                            lastname,
                            address,
                            city,
                            state,
                            zipcode,
                            major,
                            email,
                            phone
                    );

                    Exception e = assertThrows(IllegalArgumentException.class, () -> {
                        new Student(requestDto);
                    });
                    assertEquals("State is not valid.", e.getMessage());
                }

                @Test
                @DisplayName("When state is not one of the real states in US")
                void fail3() {
                    state = "Paris";
                    StudentRequestDto requestDto = new StudentRequestDto(
                            firstname,
                            lastname,
                            address,
                            city,
                            state,
                            zipcode,
                            major,
                            email,
                            phone
                    );

                    Exception e = assertThrows(IllegalArgumentException.class, () -> {
                        new Student(requestDto);
                    });
                    assertEquals("State is not valid.", e.getMessage());
                }
            }

            @Nested
            @DisplayName("Zipcode")
            class Zipcode {
                @Test
                @DisplayName("When zipcode is null")
                void fail1() {
                    zipcode = null;
                    StudentRequestDto requestDto = new StudentRequestDto(
                            firstname,
                            lastname,
                            address,
                            city,
                            state,
                            zipcode,
                            major,
                            email,
                            phone
                    );

                    Exception e = assertThrows(IllegalArgumentException.class, () -> {
                        new Student(requestDto);
                    });
                    assertEquals("Zipcode is not valid.", e.getMessage());
                }

                @Test
                @DisplayName("When zipcode is empty string")
                void fail2() {
                    zipcode = "";
                    StudentRequestDto requestDto = new StudentRequestDto(
                            firstname,
                            lastname,
                            address,
                            city,
                            state,
                            zipcode,
                            major,
                            email,
                            phone
                    );

                    Exception e = assertThrows(IllegalArgumentException.class, () -> {
                        new Student(requestDto);
                    });
                    assertEquals("Zipcode is not valid.", e.getMessage());
                }

                @Test
                @DisplayName("When zipcode is less than 5 digits")
                void fail3() {
                    zipcode = "1234";
                    StudentRequestDto requestDto = new StudentRequestDto(
                            firstname,
                            lastname,
                            address,
                            city,
                            state,
                            zipcode,
                            major,
                            email,
                            phone
                    );

                    Exception e = assertThrows(IllegalArgumentException.class, () -> {
                        new Student(requestDto);
                    });
                    assertEquals("Zipcode is not valid.", e.getMessage());
                }

                @Test
                @DisplayName("When zipcode is longer than 5 digits")
                void fail4() {
                    zipcode = "123456";
                    StudentRequestDto requestDto = new StudentRequestDto(
                            firstname,
                            lastname,
                            address,
                            city,
                            state,
                            zipcode,
                            major,
                            email,
                            phone
                    );

                    Exception e = assertThrows(IllegalArgumentException.class, () -> {
                        new Student(requestDto);
                    });
                    assertEquals("Zipcode is not valid.", e.getMessage());
                }

                @Test
                @DisplayName("When zipcode is not digits")
                void fail5() {
                    zipcode = "abcde";
                    StudentRequestDto requestDto = new StudentRequestDto(
                            firstname,
                            lastname,
                            address,
                            city,
                            state,
                            zipcode,
                            major,
                            email,
                            phone
                    );

                    Exception e = assertThrows(IllegalArgumentException.class, () -> {
                        new Student(requestDto);
                    });
                    assertEquals("Zipcode is not valid.", e.getMessage());
                }
            }
        }
    }
}