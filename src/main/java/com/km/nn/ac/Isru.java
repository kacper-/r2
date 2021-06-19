package com.km.nn.ac;


public class Isru {
    private final static double ALPHA = 0.9d;

    public static double f(double x) {
        return x / Math.sqrt(1d + (ALPHA * x * x));
    }

    public static double f1(double x) {
        return Math.pow(1d / Math.sqrt(1d + (ALPHA * x * x)), 3);
    }
}
