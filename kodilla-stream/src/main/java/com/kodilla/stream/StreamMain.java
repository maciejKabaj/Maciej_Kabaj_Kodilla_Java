package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;

public class StreamMain {

    public static void main(String[] args) {
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        String myPoem = "WsAd";
        poemBeautifier.beautify(myPoem, text -> "ABC" + text + "ABC");
        poemBeautifier.beautify(myPoem, String::toUpperCase);
        poemBeautifier.beautify(myPoem, String::toLowerCase);
        poemBeautifier.beautify(myPoem, text -> text.repeat(3));
        poemBeautifier.beautify(myPoem, text -> new StringBuilder(text).reverse().toString());
    }
}