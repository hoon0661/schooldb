package hoon.schooldb.utils;

import java.util.Random;

public class ZipcodeGenerator {
    public static String generate() {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            sb.append(rand.nextInt(10));
        }

        return sb.toString();
    }
}
