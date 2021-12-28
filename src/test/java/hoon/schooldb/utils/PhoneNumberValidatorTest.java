package hoon.schooldb.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneNumberValidatorTest {
    @Test
    @DisplayName("Normal case")
    void test1() {
        String number = "1234567890";
        assertTrue(!PhoneNumberValidator.isEmpty(number) && !PhoneNumberValidator.isNull(number) && PhoneNumberValidator.patternMatches(number));
    }

    @Test
    @DisplayName("When number is null")
    void test2() {
        String number = null;
        assertFalse(!PhoneNumberValidator.isNull(number) && !PhoneNumberValidator.isEmpty(number) && PhoneNumberValidator.patternMatches(number));
    }

    @Test
    @DisplayName("When number is empty string")
    void test3() {
        String number = "";
        assertFalse(!PhoneNumberValidator.isNull(number) && !PhoneNumberValidator.isEmpty(number) && PhoneNumberValidator.patternMatches(number));
    }

    @Test
    @DisplayName("When number is less than 10 digits")
    void test4() {
        String number = "123456";
        assertFalse(!PhoneNumberValidator.isNull(number) && !PhoneNumberValidator.isEmpty(number) && PhoneNumberValidator.patternMatches(number));
    }

    @Test
    @DisplayName("When input is not number")
    void test5() {
        String number = "abcdefghij";
        assertFalse(!PhoneNumberValidator.isNull(number) && !PhoneNumberValidator.isEmpty(number) && PhoneNumberValidator.patternMatches(number));
    }

    @Test
    @DisplayName("When input is mixture of characters and numbers")
    void test6() {
        String number = "a2c4ef1hij";
        assertFalse(!PhoneNumberValidator.isNull(number) && !PhoneNumberValidator.isEmpty(number) && PhoneNumberValidator.patternMatches(number));
    }

    @Test
    @DisplayName("When number is more than 10 digits")
    void test7() {
        String number = "12345678901";
        assertFalse(!PhoneNumberValidator.isNull(number) && !PhoneNumberValidator.isEmpty(number) && PhoneNumberValidator.patternMatches(number));
    }
}