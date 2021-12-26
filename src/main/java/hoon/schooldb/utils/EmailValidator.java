package hoon.schooldb.utils;

import java.util.regex.Pattern;

public class EmailValidator {
    public static boolean isEmpty(String email) {
        return email.trim().length() == 0;
    }

    public static boolean isNull(String email) {
        return email == null;
    }

    public static boolean patternMatches(String email) {
        String pattern = "^(.+)@(\\S+)$";
        return Pattern.compile(pattern).matcher(email).matches();
    }
}
