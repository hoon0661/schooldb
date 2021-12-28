package hoon.schooldb.utils;

public class NameValidator {
    public static boolean isAllLetters(String str) {
        return str.matches("[a-zA-Z]+");
    }
}
