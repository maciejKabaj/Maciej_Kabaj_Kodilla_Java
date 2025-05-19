package com.kodilla.stream.reverser;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TextReverser {

    public static String reverse(String textToReverse) {
        char[] chars = textToReverse.toCharArray();
        List<Character> reversedChars = new ArrayList<>();
        for (int i = chars.length - 1; i >= 0; i--) {
            reversedChars.add(chars[i]);
        }
        return reversedChars.stream()
                .map(c -> c.toString())
                .collect(Collectors.joining());
    }
}
