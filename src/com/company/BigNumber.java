package com.company;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigNumber extends Calculator{

    /**
     * This method adds two BigDecimals and returns the results
     * @param theNumber1
     * @param theNumber2
     * @return (Number1 + Number2)
     */
    public static BigDecimal add(BigDecimal theNumber1, BigDecimal theNumber2) {
        return theNumber1.add(theNumber2, PRECISION_CONSTANT);
    }

    /**
     * This the Subtract method has a bug with same numbers, it can't display 0 properly
     */
    public static BigDecimal subtract(BigDecimal theNumber1, BigDecimal theNumber2) {
        if (theNumber1.equals(theNumber2)) {
            return BigDecimal.ZERO;
        }
        return theNumber1.subtract(theNumber2, PRECISION_CONSTANT);
    }

    /**
     * Bug where if both numbers are negative then the online calculation doesn't work
     * @param theNumber1
     * @param theNumber2
     * @return
     */
    public static BigDecimal multiply(BigDecimal theNumber1, BigDecimal theNumber2) {
        if ((!theNumber1.equals(BigDecimal.ZERO) && !theNumber2.equals(BigDecimal.ZERO) ) ) {
            return theNumber1.multiply(theNumber2, PRECISION_CONSTANT);
        } else if ((theNumber1.equals(BigDecimal.ZERO) || theNumber2.equals(BigDecimal.ZERO) )) {
            return BigDecimal.ZERO;
        } else {

            throw new IllegalArgumentException("Both Numbers cannot be 0");
        }

    }

    /**
     *
     * @param theNumber1
     * @param theNumber2
     * @return
     */
    public static BigDecimal divide(BigDecimal theNumber1, BigDecimal theNumber2) {

        if ((!theNumber1.equals(BigDecimal.ZERO) && !theNumber2.equals(BigDecimal.ZERO) ) ) {
                return theNumber1.divide(theNumber2, PRECISION_CONSTANT);
        } else {
            throw new IllegalArgumentException("There cannot be any 0 numbers");
        }
    }

    /**
     * This method will not accept any Decimals, no negatives nor any 0 as per the calculator specifications
     * @param theNumber1
     * @param theNumber2
     * @return
     */
    public static BigDecimal remainder(BigDecimal theNumber1, BigDecimal theNumber2) {
        // No Negatives and No Zero No DECIMALS
        if ((!theNumber1.equals(BigDecimal.ZERO) && !theNumber2.equals(BigDecimal.ZERO) ) ) {
            return theNumber1.remainder(theNumber2, PRECISION_CONSTANT);
        } else {
            throw new IllegalArgumentException("There cannot be any 0 numbers");
        }

    }


    /**
     * This method takes in everything but any negatives or any 0 decimal is fine
     * @param theNumber1
     * @return
     */
    public static BigDecimal squarerRoot(BigDecimal theNumber1) {
        //No negatives, No Zero
        try {
            return theNumber1.sqrt(PRECISION_CONSTANT);
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("Please enter a positive number");
        }

    }

    /**
     * This method is used for raise the given number to the second given number,
     * num1^num2. Despite the calculator not performing num^0, this method
     * will perform that calculation.
     * @param theNumber1
     * @param theNumber2
     * @return
     */
    public static BigDecimal power(BigDecimal theNumber1, int theNumber2) {
        // No negatives,
        if (theNumber1.equals(BigDecimal.ZERO)) {
            throw new IllegalArgumentException("The base cannot be zero");
        } else {
            return theNumber1.pow(theNumber2, PRECISION_CONSTANT);
        }
    }

    /**
     * This square method takes in the numbers and squares them properly
     * @param theNumber1
     * @return
     */
    public static BigDecimal square(BigDecimal theNumber1) {
        return theNumber1.pow(2, PRECISION_CONSTANT);
    }

    /**
     *
     * @param n
     * @param acc
     * @return
     * @author Lim, Teck Hooi
     */
    public static BigDecimal factorial(BigDecimal n, BigDecimal acc) {
        //No negatives, No decimals, No Zeros
        if (n.equals(BigDecimal.ONE)) {
            return acc;
        }
        BigDecimal lessOne = n.subtract(BigDecimal.ONE);
        return factorial(lessOne, acc.multiply(lessOne));
    }

    /**
     * This method finds the lowest common multiplier, this method is not suppose to take in
     * any negatives or any 0's nor any decimals point numbers.
     * @param theNumber1
     * @param theNumber2
     * @return
     */
    public static BigInteger lcm(BigDecimal theNumber1, BigDecimal theNumber2) {

        // No decimals, no 0s, no negatives

        if (!BigNumber.isDecimal(theNumber1) && !BigNumber.isDecimal(theNumber2)) {
            BigInteger temp=theNumber1.toBigInteger().gcd(theNumber2.toBigInteger());
            BigInteger temp2=theNumber2.toBigInteger().gcd(theNumber2.toBigInteger());
            // calculate multiplication of two BigDecimals
            BigInteger mul = theNumber1.multiply(theNumber2).toBigInteger();

            // calculate gcd of two BigDecimals
            BigInteger gcd = temp.gcd(temp2);

            // calculate lcm using formula: lcm * gcd = x * y
            BigInteger lcm = mul.divide(gcd);
            return lcm;

        } else {
            throw new IllegalArgumentException("Numbers entered has decimals");

        }

    }

    /**
     *
     * @param theNumber1
     * @param theNumber2
     * @return
     */
    public static BigInteger gcd(BigInteger theNumber1, BigInteger theNumber2) {
        // no zeros, no decimal, no negatives
        if (theNumber1.compareTo(BigInteger.ZERO) <= 0 || theNumber2.compareTo(BigInteger.ZERO) <= 0) {
            throw new IllegalArgumentException("The numbers has to be greater than 0");
        }
        return theNumber1.gcd(theNumber2);
    }
    public static boolean isDecimal(BigDecimal theNumber) {
        String myStringNumber = theNumber.toPlainString();
        return myStringNumber.contains(".");
    }

}
