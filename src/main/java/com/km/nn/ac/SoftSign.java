package com.km.nn.ac;

public class SoftSign {
    public static double f(double x) {
        return x / (1d + Math.abs(x));
    }

    public static double f1(double x) {
        return 1d / Math.pow(1d + Math.abs(x), 2);
    }
}
