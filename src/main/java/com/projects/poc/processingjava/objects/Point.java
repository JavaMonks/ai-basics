package com.projects.poc.processingjava.objects;

import processing.core.PApplet;

public class Point {
    private final PApplet app;
    public final float[] coordinates;
    public final int label;

    public Point(PApplet app) {
        this.app = app;
        this.coordinates = new float[2];
        this.coordinates[0] = this.app.random(this.app.width);
        this.coordinates[1] = this.app.random(this.app.height);
        this.label = this.coordinates[0] < this.coordinates[1] ? -1 : 1;
    }

    public Point(PApplet app, float x, float y) {
        this.app = app;
        this.coordinates = new float[]{x, y};
        this.label = this.coordinates[0] < this.coordinates[1] ? -1 : 1;
    }

    public void show() {
        this.app.stroke(0);
        if (label > 0) {
            this.app.fill(255);
        } else {
            this.app.fill(0);
        }
        this.app.ellipse(this.coordinates[0], this.coordinates[1], 32, 32);
    }

}
