package com.projects.poc.processingjava.objects;

import com.projects.poc.processingjava.App;
import processing.core.PApplet;

public class Point {
    private final PApplet app;
    public final float[] displayCoordinates;
    public final int label;
    public final float x;
    public final float y;

    public Point(PApplet app) {
        this.app = app;
        x = this.app.random(-1, 1);
        y = this.app.random(-1, 1);
        this.displayCoordinates = this.getCoordinates(x, y);
        this.label = this.getLabel(x, y);
    }

    public Point(PApplet app, float x, float y) {
        this.app = app;
        this.x = x;
        this.y = y;
        this.displayCoordinates = this.getCoordinates(x, y);
        this.label = this.getLabel(x, y);
    }

    public void show() {
        this.app.stroke(0);
        if (label == 1) {
            this.app.fill(255);
        } else {
            this.app.fill(0);
        }
        this.app.ellipse(this.displayCoordinates[0], this.displayCoordinates[1], 32, 32);
    }

    private float[] getCoordinates(float x, float y) {
        float[] coordinates = new float[2];
        coordinates[0] = PApplet.map(x, -1, 1, 0, this.app.width);
        coordinates[1] = PApplet.map(y, -1, 1, this.app.height, 0);
        return coordinates;
    }

    private int getLabel(float x, float y) {
        float yIntercept = App.f(x);
        return y > yIntercept ? 1 : -1;
    }

    public float getX() {
        return PApplet.map(x, -1, 1, 0, this.app.width);
    }

    public float getY() {
        return PApplet.map(y, -1, 1, this.app.height, 0);
    }

}
