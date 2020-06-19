package com.projects.poc.processingjava;

import com.projects.poc.processingjava.brain.Perceptron;
import com.projects.poc.processingjava.objects.Point;
import processing.core.PApplet;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class App extends PApplet {
    private Perceptron perceptron;
    private List<Point> points;

    public static float f(float x) {
        return 0.3f * x + 0.2f;
    }

    @Override
    public void settings() {
        size(800, 800);
    }

    public void setup() {
        this.perceptron = new Perceptron(this);
        this.points = IntStream.rangeClosed(1, 100)
                               .mapToObj(index -> new Point(this))
                               .collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    public void draw() {
        background(255);
        this.stroke(0);
        Point p1 = new Point(this, -1, App.f(-1));
        Point p2 = new Point(this, 1, App.f(1));
        this.line(p1.coordinates[0], p1.coordinates[1], p2.coordinates[0], p2.coordinates[1]);
        this.points.stream()
                   .peek(Point::show)
                   .forEach(point -> {
                       this.perceptron.train(point.coordinates, point.label);
                       int guess = this.perceptron.guess(point.coordinates);
                       if (guess == point.label) {
                           fill(0, 255, 0);
                       } else {
                           fill(255, 0, 0);
                       }
                       this.noStroke();
                       this.ellipse(point.coordinates[0], point.coordinates[1], 16, 16);
                   });

    }

}

