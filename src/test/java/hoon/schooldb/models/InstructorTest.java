package hoon.schooldb.models;

import hoon.schooldb.dto.InstructorRequestDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class InstructorTest {
    @Nested
    @DisplayName("Entity creation")
    class CreateInstructor {
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
        void createInstructor_Normal() throws FileNotFoundException {
            InstructorRequestDto requestDto = new InstructorRequestDto(
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

            Instructor instructor = new Instructor(requestDto);

            assertNull(instructor.getId());
            assertEquals(firstname, instructor.getFirstname());
            assertEquals(lastname, instructor.getLastname());
            assertEquals(address, instructor.getAddress());
            assertEquals(city, instructor.getCity());
            assertEquals(state, instructor.getState());
            assertEquals(zipcode, instructor.getZipcode());
            assertEquals(major, instructor.getMajor());
            assertEquals(email, instructor.getEmail());
            assertEquals(phone, instructor.getPhone());
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
                    InstructorRequestDto requestDto = new InstructorRequestDto(
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
                        new Instructor(requestDto);
                    });
                    assertEquals("Firstname is not valid.", e.getMessage());
                }

                @Test
                @DisplayName("When firstname is empty string")
                void fail2() {
                    firstname = "";
                    InstructorRequestDto requestDto = new InstructorRequestDto(
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
                        new Instructor(requestDto);
                    });
                    assertEquals("Firstname is not valid.", e.getMessage());
                }

                @Test
                @DisplayName("When firstname contains non-letters")
                void fail3() {
                    firstname = "abc123";
                    InstructorRequestDto requestDto = new InstructorRequestDto(
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
                        new Instructor(requestDto);
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
                    InstructorRequestDto requestDto = new InstructorRequestDto(
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
                        new Instructor(requestDto);
                    });
                    assertEquals("Lastname is not valid.", e.getMessage());
                }

                @Test
                @DisplayName("When lastname is empty string")
                void fail2() {
                    lastname = "";
                    InstructorRequestDto requestDto = new InstructorRequestDto(
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
                        new Instructor(requestDto);
                    });
                    assertEquals("Lastname is not valid.", e.getMessage());
                }

                @Test
                @DisplayName("When lastname contains non-letters")
                void fail3() {
                    lastname = "abc123";
                    InstructorRequestDto requestDto = new InstructorRequestDto(
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
                        new Instructor(requestDto);
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
                    InstructorRequestDto requestDto = new InstructorRequestDto(
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
                        new Instructor(requestDto);
                    });
                    assertEquals("Major is not valid.", e.getMessage());
                }

                @Test
                @DisplayName("When major is empty string")
                void fail2() {
                    major = "";
                    InstructorRequestDto requestDto = new InstructorRequestDto(
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
                        new Instructor(requestDto);
                    });
                    assertEquals("Major is not valid.", e.getMessage());
                }

                @Test
                @DisplayName("When major string with length less than 3")
                void fail3() {
                    major = "ab";
                    InstructorRequestDto requestDto = new InstructorRequestDto(
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
                        new Instructor(requestDto);
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
                    InstructorRequestDto requestDto = new InstructorRequestDto(
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
                        new Instructor(requestDto);
                    });
                    assertEquals("Email is not valid.", e.getMessage());
                }

                @Test
                @DisplayName("When email is empty string")
                void fail2() {
                    email = "";
                    InstructorRequestDto requestDto = new InstructorRequestDto(
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
                        new Instructor(requestDto);
                    });
                    assertEquals("Email is not valid.", e.getMessage());
                }

                @Test
                @DisplayName("When email is missing @ ")
                void fail3() {
                    email = "abc123email.com";
                    InstructorRequestDto requestDto = new InstructorRequestDto(
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
                        new Instructor(requestDto);
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
                    InstructorRequestDto requestDto = new InstructorRequestDto(
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
                        new Instructor(requestDto);
                    });
                    assertEquals("Phone number is not valid.", e.getMessage());
                }

                @Test
                @DisplayName("When phone number is empty string")
                void fail2() {
                    phone = "";
                    InstructorRequestDto requestDto = new InstructorRequestDto(
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
                        new Instructor(requestDto);
                    });
                    assertEquals("Phone number is not valid.", e.getMessage());
                }

                @Test
                @DisplayName("When phone number is less than 10 digits")
                void fail3() {
                    phone = "12345678";
                    InstructorRequestDto requestDto = new InstructorRequestDto(
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
                        new Instructor(requestDto);
                    });
                    assertEquals("Phone number is not valid.", e.getMessage());
                }

                @Test
                @DisplayName("When phone number is longer than 10 digits")
                void fail4() {
                    phone = "12345678901";
                    InstructorRequestDto requestDto = new InstructorRequestDto(
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
                        new Instructor(requestDto);
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
                    InstructorRequestDto requestDto = new InstructorRequestDto(
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
                        new Instructor(requestDto);
                    });
                    assertEquals("Address is not valid.", e.getMessage());
                }

                @Test
                @DisplayName("When address is empty string")
                void fail2() {
                    address = "";
                    InstructorRequestDto requestDto = new InstructorRequestDto(
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
                        new Instructor(requestDto);
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
                    InstructorRequestDto requestDto = new InstructorRequestDto(
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
                        new Instructor(requestDto);
                    });
                    assertEquals("City is not valid.", e.getMessage());
                }

                @Test
                @DisplayName("When city is empty string")
                void fail2() {
                    city = "";
                    InstructorRequestDto requestDto = new InstructorRequestDto(
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
                        new Instructor(requestDto);
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
                    InstructorRequestDto requestDto = new InstructorRequestDto(
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
                        new Instructor(requestDto);
                    });
                    assertEquals("State is not valid.", e.getMessage());
                }

                @Test
                @DisplayName("When state is empty string")
                void fail2() {
                    state = "";
                    InstructorRequestDto requestDto = new InstructorRequestDto(
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
                        new Instructor(requestDto);
                    });
                    assertEquals("State is not valid.", e.getMessage());
                }

                @Test
                @DisplayName("When state is not one of the real states in US")
                void fail3() {
                    state = "Paris";
                    InstructorRequestDto requestDto = new InstructorRequestDto(
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
                        new Instructor(requestDto);
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
                    InstructorRequestDto requestDto = new InstructorRequestDto(
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
                        new Instructor(requestDto);
                    });
                    assertEquals("Zipcode is not valid.", e.getMessage());
                }

                @Test
                @DisplayName("When zipcode is empty string")
                void fail2() {
                    zipcode = "";
                    InstructorRequestDto requestDto = new InstructorRequestDto(
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
                        new Instructor(requestDto);
                    });
                    assertEquals("Zipcode is not valid.", e.getMessage());
                }

                @Test
                @DisplayName("When zipcode is less than 5 digits")
                void fail3() {
                    zipcode = "1234";
                    InstructorRequestDto requestDto = new InstructorRequestDto(
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
                        new Instructor(requestDto);
                    });
                    assertEquals("Zipcode is not valid.", e.getMessage());
                }

                @Test
                @DisplayName("When zipcode is longer than 5 digits")
                void fail4() {
                    zipcode = "123456";
                    InstructorRequestDto requestDto = new InstructorRequestDto(
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
                        new Instructor(requestDto);
                    });
                    assertEquals("Zipcode is not valid.", e.getMessage());
                }

                @Test
                @DisplayName("When zipcode is not digits")
                void fail5() {
                    zipcode = "abcde";
                    InstructorRequestDto requestDto = new InstructorRequestDto(
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
                        new Instructor(requestDto);
                    });
                    assertEquals("Zipcode is not valid.", e.getMessage());
                }
            }
        }
    }
}