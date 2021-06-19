package com.km.nn;

import java.io.Serializable;
import java.util.Arrays;

class Net implements Serializable {
    private final static int SIZE = 64;
    private final Layer front;
    private final Layer back;
    private final Layer middle;
    private final Layer middle2;

    Net(double learningFactor) {
        front = new Layer(SIZE, SIZE, learningFactor);
        middle = new Layer(SIZE, SIZE, learningFactor);
        middle2 = new Layer(SIZE, SIZE, learningFactor);
        back = new Layer(1, SIZE, learningFactor);
    }

    public double process(double[] signal) {
        front.process(signal);
        middle.process(front.getOutputs());
        middle2.process(middle.getOutputs());
        back.process(middle2.getOutputs());
        return back.getOutputs()[0];
    }

    public void teach(double[] signal, double expected) {
        double result = process(signal);
        double[] backError = new double[]{result - expected};
        double[] middle2Error = calculateError(back.getWeights(), backError);
        double[] middleError = calculateError(middle2.getWeights(), middle2Error);
        double[] frontError = calculateError(middle.getWeights(), middleError);
        back.calculateWeightDeltas(backError);
        middle2.calculateWeightDeltas(middle2Error);
        middle.calculateWeightDeltas(middleError);
        front.calculateWeightDeltas(frontError);
        apply();
    }

    public int getSize() {
        return SIZE;
    }

    private void apply() {
        front.applyWeightDeltas();
        middle.applyWeightDeltas();
        middle2.applyWeightDeltas();
        back.applyWeightDeltas();
    }

    private double[] calculateError(double[][] weights, double[] error) {
        double[] result = new double[weights[0].length];
        Arrays.fill(result, 0);
        for (int w = 0; w < result.length; w++) {
            for (int n = 0; n < weights.length; n++)
                result[w] += weights[n][w] * error[n];
        }
        return result;
    }
}
