package com.projects.poc.processingjava.brain;

import processing.core.PApplet;

public class Perceptron {
    private final float learningRate = 0.001f;
    private PApplet app;
    private float[] weights;

    public Perceptron(PApplet app, int inputs) {
        this.app = app;
        this.weights = new float[inputs];
        for (int i = 0; i < inputs; i++) {
            weights[i] = this.app.random(-1, 1);
        }
    }

    public int guess(float[] inputs) {
        float weightedSum = this.weightedSum(inputs);
        return this.activationFunction(weightedSum);
    }

    public void train(float[] inputs, int target) {
        float guess = this.guess(inputs);
        float error = target - guess;

        for (int i = 0; i < this.weights.length; i++) {
            this.weights[i] += error * inputs[i] * this.learningRate;
        }

    }

    private float weightedSum(float[] inputs) {
        float result = 0;
        for (int i = 0; i < inputs.length; i++) {
            result += (inputs[i] * weights[i]);
        }
        return result;
    }

    private int activationFunction(float weightedSum) {
        return weightedSum >= 0 ? 1 : -1;
    }

    public float guessY(float x) {
        //w0*x + w1*y + w2*bias = 0
        // y = - (w0*x + w2*bias) / w1

        return -(weights[0] * x + weights[2] * 1) / weights[1];
//        return -(weights[2] / weights[1]) - (weights[0] / weights[1]) * x;
    }


}

