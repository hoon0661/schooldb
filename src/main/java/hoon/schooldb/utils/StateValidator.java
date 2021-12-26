package hoon.schooldb.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

public class StateValidator {
    private Set<String> states = new HashSet<>();

    public StateValidator() throws FileNotFoundException {
        File file1 = new File("src/main/java/hoon/schooldb/utils/states.txt");
        Scanner sc1 = new Scanner(file1);
        while (sc1.hasNextLine()) {
            String state = sc1.nextLine().toLowerCase();
            states.add(state);
        }
    }

    public boolean isNull(String state) {
        return state == null;
    }

    public boolean isEmpty(String state) {
        return state.trim().length() == 0;
    }

    public boolean isInStateList(String state) {
        return states.contains(state.toLowerCase());
    }
}
