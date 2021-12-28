package hoon.schooldb.utils;

import java.util.regex.Pattern;

public class ZipcodeValidator {
    public static boolean isEmpty(String zipcode) {
        return zipcode.trim().length() == 0;
    }

    public static boolean isNull(String zipcode) {
        return zipcode == null;
    }

    public static boolean patternMatches(String zipcode) {
        String pattern = "^\\d{5}$";
        return Pattern.compile(pattern).matcher(zipcode).matches();
    }
}
