package hoon.schooldb.utils;

import java.util.Random;

public class PhoneNumberGenerator {
    public static String generate() {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        int firstThree = rand.nextInt(900) + 100;
        sb.append(firstThree);
        for (int i = 0; i < 7; i++) {
            int randomNum = rand.nextInt(10);
            sb.append(randomNum);
        }
        return sb.toString();
    }
}
