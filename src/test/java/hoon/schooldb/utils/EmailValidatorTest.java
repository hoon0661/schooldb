package hoon.schooldb.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailValidatorTest {
    @Test
    @DisplayName("Normal case")
    void test1() {
        String email = "abc123@email.com";
        assertTrue(!EmailValidator.isEmpty(email) && !EmailValidator.isNull(email) && EmailValidator.patternMatches(email));
    }

    @Test
    @DisplayName("When email is null")
    void test2() {
        String email = null;
        assertFalse(!EmailValidator.isNull(email) && !EmailValidator.isEmpty(email) && EmailValidator.patternMatches(email));
    }

    @Test
    @DisplayName("When email is empty string")
    void test3() {
        String email = "";
        assertFalse(!EmailValidator.isNull(email) && !EmailValidator.isEmpty(email) && EmailValidator.patternMatches(email));
    }

    @Test
    @DisplayName("When email does not have @ ")
    void test4() {
        String email = "abc123email.com";
        assertFalse(!EmailValidator.isNull(email) && !EmailValidator.isEmpty(email) && EmailValidator.patternMatches(email));
    }

    @Test
    @DisplayName("When email does not have . ")
    void test5() {
        String email = "abc123emailcom";
        assertFalse(!EmailValidator.isNull(email) && !EmailValidator.isEmpty(email) && EmailValidator.patternMatches(email));
    }
}