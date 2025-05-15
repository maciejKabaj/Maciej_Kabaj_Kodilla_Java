package com.kodilla.stream.beautifier;

public class PoemBeautifier {

    public void beautify(String poem, PoemDecorator decorator) {
        String result = decorator.decorate(poem);
        System.out.println("Poem after decorations is: " + result);
    }
}
