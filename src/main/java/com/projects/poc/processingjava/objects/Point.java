package com.projects.poc.processingjava.objects;

import processing.core.PApplet;

public class Point {
    private final PApplet app;
    public final float[] coordinates;
    public final int label;

    public Point(PApplet app) {
        this.app = app;
        this.coordinates = new float[2];
        float x = this.app.random(-1, 1);
        float y = this.app.random(-1, 1);
        this.coordinates[0] = PApplet.map(x, -1, 1, 0, this.app.width);
        this.coordinates[1] = PApplet.map(y, -1, 1, this.app.height, 0);
        this.label = x > y ? -1 : 1;
    }

    public void show() {
        this.app.stroke(0);
        if (label == 1) {
            this.app.fill(255);
        } else {
            this.app.fill(0);
        }
        this.app.ellipse(this.coordinates[0], this.coordinates[1], 32, 32);
    }

}
