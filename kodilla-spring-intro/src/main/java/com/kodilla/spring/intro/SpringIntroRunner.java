package com.kodilla.spring.intro;

import com.kodilla.spring.intro.shape.Circle;
import com.kodilla.spring.intro.shape.Figure;
import com.kodilla.spring.intro.shape.Triangle;

public class SpringIntroRunner {
    public static void main(String[] args) {
        System.out.println("Welcome to the Spring intro!");

        Figure figure = new Figure();
        Triangle triangle = new Triangle();
        Circle circle = new Circle();

        figure.draw();
        triangle.draw();
        circle.draw();
    }
}
