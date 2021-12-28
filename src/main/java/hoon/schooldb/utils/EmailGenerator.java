package hoon.schooldb.utils;

import java.util.Random;

public class EmailGenerator {
    public static String generate() {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int alphabetNum = rand.nextInt(26) + 97;
            sb.append((char) alphabetNum);
        }
        int digitNum = rand.nextInt(10000);
        sb.append(Integer.toString(digitNum));
        return sb.toString() + "@email.com";
    }
}
