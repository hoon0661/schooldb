package hoon.schooldb.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class StateValidatorTest {
    @Test
    @DisplayName("Normal case")
    void test1() throws FileNotFoundException {
        StateValidator validator = new StateValidator();
        String state = "New York";
        assertTrue(!validator.isNull(state) && !validator.isEmpty(state) && validator.isInStateList(state));
    }

    @Test
    @DisplayName("When input is null")
    void test2() throws FileNotFoundException {
        StateValidator validator = new StateValidator();
        String state = null;
        assertFalse(!validator.isNull(state) && !validator.isEmpty(state) && validator.isInStateList(state));
    }

    @Test
    @DisplayName("When input is empty string")
    void test3() throws FileNotFoundException {
        StateValidator validator = new StateValidator();
        String state = "";
        assertFalse(!validator.isNull(state) && !validator.isEmpty(state) && validator.isInStateList(state));
    }

    @Test
    @DisplayName("When input is not one of the states")
    void test4() throws FileNotFoundException {
        StateValidator validator = new StateValidator();
        String state = "Paris";
        assertFalse(!validator.isNull(state) && !validator.isEmpty(state) && validator.isInStateList(state));
    }
}
