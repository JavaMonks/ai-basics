package com.projects.poc.processingjava.brain;

import processing.core.PApplet;

public class Perceptron {
    private float[] weights = new float[2];
    private PApplet app;
    private final float learningRate = 0.1f;

    public Perceptron(PApplet app) {
        this.app = app;
        for (int i = 0; i < weights.length; i++) {
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


}

