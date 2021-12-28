package hoon.schooldb.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZipcodeValidatorTest {

    @Test
    @DisplayName("Normal case")
    void test1() {
        String zipcode = "01234";
        assertTrue(!ZipcodeValidator.isNull(zipcode) && !ZipcodeValidator.isEmpty(zipcode) && ZipcodeValidator.patternMatches(zipcode));
    }

    @Test
    @DisplayName("When input is null")
    void test2() {
        String zipcode = null;
        assertFalse(!ZipcodeValidator.isNull(zipcode) && !ZipcodeValidator.isEmpty(zipcode) && ZipcodeValidator.patternMatches(zipcode));
    }

    @Test
    @DisplayName("When input is empty")
    void test3() {
        String zipcode = "";
        assertFalse(!ZipcodeValidator.isNull(zipcode) && !ZipcodeValidator.isEmpty(zipcode) && ZipcodeValidator.patternMatches(zipcode));
    }

    @Test
    @DisplayName("When input is not number")
    void test4() {
        String zipcode = "abcde";
        assertFalse(!ZipcodeValidator.isNull(zipcode) && !ZipcodeValidator.isEmpty(zipcode) && ZipcodeValidator.patternMatches(zipcode));
    }

    @Test
    @DisplayName("When input is mixture of letter and digit")
    void test5() {
        String zipcode = "1ab23";
        assertFalse(!ZipcodeValidator.isNull(zipcode) && !ZipcodeValidator.isEmpty(zipcode) && ZipcodeValidator.patternMatches(zipcode));
    }

    @Test
    @DisplayName("When input is less than 5 digits")
    void test6() {
        String zipcode = "1234";
        assertFalse(!ZipcodeValidator.isNull(zipcode) && !ZipcodeValidator.isEmpty(zipcode) && ZipcodeValidator.patternMatches(zipcode));
    }

    @Test
    @DisplayName("When input is greater than 5 digits")
    void test7() {
        String zipcode = "123456";
        assertFalse(!ZipcodeValidator.isNull(zipcode) && !ZipcodeValidator.isEmpty(zipcode) && ZipcodeValidator.patternMatches(zipcode));
    }

}