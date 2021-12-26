package hoon.schooldb.utils;

import java.util.regex.Pattern;

public class PhoneNumberValidator {
    public static boolean isEmpty(String phoneNumber) {
        return phoneNumber.trim().length() == 0;
    }

    public static boolean isNull(String phoneNumber) {
        return phoneNumber == null;
    }

    public static boolean patternMatches(String phoneNumber) {
        if (phoneNumber.trim().length() != 10) {
            throw new IllegalArgumentException("Phone number must be 10 digits long.");
        }
        String pattern = "^\\d{10}$";
        return Pattern.compile(pattern).matcher(phoneNumber).matches();
    }
}
