package com.company;

public class Number {
    static final int inputLimit = 10;
    public static boolean inputValid(final String theNumber) {
        return (theNumber.length() <= inputLimit && theNumber.length() != 0);
    }
}
