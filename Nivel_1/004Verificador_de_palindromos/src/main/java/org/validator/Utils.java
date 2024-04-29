package org.validator;

public class Utils {
    public static String removeSpaces(String input) {
        return input.replaceAll("\\s+", "");
    }

    public static String toLowerCase(String input) {
        return input.toLowerCase();
    }
}
