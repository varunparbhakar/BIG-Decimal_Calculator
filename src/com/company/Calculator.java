package com.company;

import java.math.MathContext;

public abstract class Calculator{
    static final int inputLimit = 20;

    final static MathContext PRECISION_CONSTANT = new MathContext(21);

    public static boolean inputValid(final String theNumber) {
        return (theNumber.length() <= inputLimit && theNumber.length() != 0);
    }
    public static double add(double theNumber1, double theNumber2) {
        return theNumber1 + theNumber2;
    }
    public static double subtract(double theNumber1, double theNumber2) {
        return theNumber1 - theNumber2;
    }
    public static double multiply(double theNumber1, double theNumber2) {
        return theNumber1 * theNumber2;
    }
    public static double divide(double theNumber1, double theNumber2) { return theNumber1 / theNumber2;}
    public static int remainder(int theNumber1, int theNumber2) {
        return theNumber1 % theNumber2;
    }


}
