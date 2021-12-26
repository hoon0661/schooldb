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
        try {
            int zipcodeInt = Integer.parseInt(zipcode);
        } catch (Exception e) {
            throw new IllegalArgumentException("zipcode must be numbers.");
        }
        String pattern = "^\\d{5}$";
        return Pattern.compile(pattern).matcher(zipcode).matches();
    }
}
