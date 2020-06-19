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

    @Override
    public void settings() {
        size(800, 800);
    }

    public void setup() {
        this.perceptron = new Perceptron(this);
        this.points = IntStream.rangeClosed(1, 500)
                               .mapToObj(index -> new Point(this))
                               .collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    public void draw() {
        background(255);
        this.stroke(0);
        this.line(0, height, this.width, 0);
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

