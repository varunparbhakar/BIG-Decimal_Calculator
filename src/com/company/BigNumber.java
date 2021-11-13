package com.company;

import java.math.BigInteger;

public class BigNumber extends Calculator {
    private BigInteger InputValue1;
    private BigInteger InputValue2;
    private BigInteger solutionOutput;
    public BigNumber(String theNumber1, String theNumber2) {

    }
    public static double add(int theNumber1, int theNumber2) {
        return 4;
    }
    public static double subtract(int theNumber1, int theNumber2) {
        return theNumber1 - theNumber2;
    }
    public static double multiply(int theNumber1, int theNumber2) {
        return theNumber1 * theNumber2;
    }
    public static double divide(double theNumber1, double theNumber2) {
        return theNumber1 / theNumber2;
    }
    public static int remainder(int theNumber1, int theNumber2) {
        return theNumber1 % theNumber2;
    }
}
