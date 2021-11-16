package com.company;

import java.math.MathContext;

/**
 * This is an abstract class which lays out the frameWork for the rest of the classes.
 * @author Varun Parbhakar
 * @version 11-16-2021
 */
public abstract class Calculator {
    /*
     * I have chosen to declare this the precision contains in the calculator class, such
     * that every subclass can access this constant.
     */
    final static MathContext PRECISION_CONSTANT = new MathContext(21);

    /**
     * This method adds two numbers and return the sum.
     * @param theNumber1 (double)
     * @param theNumber2 (double)
     * @return (Number1 + Number2)
     */
    public static double add(double theNumber1, double theNumber2) {
        return theNumber1 + theNumber2;
    }
    /**
     * This method subtract two numbers and return the solution.
     * @param theNumber1 (double)
     * @param theNumber2 (double)
     * @return (Number1 - Number2)
     */
    public static double subtract(double theNumber1, double theNumber2) {
        return theNumber1 - theNumber2;
    }
    /**
     * This method multiply two numbers and return the product.
     * @param theNumber1 (double)
     * @param theNumber2 (double)
     * @return (Number1 * Number2)
     */
    public static double multiply(double theNumber1, double theNumber2) {
        return theNumber1 * theNumber2;
    }
    /**
     * This method divides two numbers and return the quotient.
     * @param theNumber1 (double)
     * @param theNumber2 (double)
     * @return (Number1 / Number2)
     */
    public static double divide(double theNumber1, double theNumber2) { return theNumber1 / theNumber2;}

    /**
     * This method find the remainder two numbers and return the remainder.
     * @param theNumber1 (double)
     * @param theNumber2 (double)
     * @return (Number1 % Number2)
     */
    public static int remainder(int theNumber1, int theNumber2) {
        return theNumber1 % theNumber2;
    }


}
//END
