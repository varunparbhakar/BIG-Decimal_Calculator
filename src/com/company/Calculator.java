package com.company;

public abstract class Calculator{
    private int InputValue1;
    private int InputValue2;
    private int solutionOutput;
    static final int inputLimit = 10;

    public static boolean inputValid(final String theNumber) {
        return (theNumber.length() <= inputLimit && theNumber.length() != 0);
    }
    public static double add(int theNumber1, int theNumber2) {
        return theNumber1 + theNumber2;
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

    public int getInputValue1() {
        return InputValue1;
    }

    public void setInputValue1(int inputValue1) {
        InputValue1 = inputValue1;
    }

    public int getInputValue2() {
        return InputValue2;
    }

    public void setInputValue2(int inputValue2) {
        InputValue2 = inputValue2;
    }

    public int getSolutionOutput() {
        return solutionOutput;
    }

    public void setSolutionOutput(int solutionOutput) {
        this.solutionOutput = solutionOutput;
    }
}
