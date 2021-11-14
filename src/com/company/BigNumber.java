package com.company;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigNumber extends Calculator {
    private BigDecimal InputValue1;
    private BigDecimal InputValue2;
    private BigInteger solutionOutput;

    public static BigDecimal add(BigDecimal theNumber1, BigDecimal theNumber2) {
        return theNumber1.add(theNumber2, PERCISION_CONSTANT);
    }
    public static BigDecimal subtract(BigDecimal theNumber1, BigDecimal theNumber2) {
        return theNumber1.subtract(theNumber2, PERCISION_CONSTANT);
    }
    public static BigDecimal multiply(BigDecimal theNumber1, BigDecimal theNumber2) {
        return theNumber1.multiply(theNumber2, PERCISION_CONSTANT);
    }
    public static BigDecimal divide(BigDecimal theNumber1, BigDecimal theNumber2) {
        //DIVIDE BY 0
        //CATch ARITHMETIC ERROR
        return theNumber1.divide(theNumber2, PERCISION_CONSTANT);
    }
    public static BigDecimal remainder(BigDecimal theNumber1, BigDecimal theNumber2) {
        //DIVIDE BY 0
        //CATch ARITHMETIC ERROR
        //Integer too large
        return theNumber1.remainder(theNumber2, PERCISION_CONSTANT);
    }
    public static BigDecimal squarerRoot(BigDecimal theNumber1) {
        return theNumber1.sqrt(PERCISION_CONSTANT);
    }
    public static BigDecimal square(BigDecimal theNumber1) {
        return theNumber1.pow(2,PERCISION_CONSTANT);
    }

    /**
     *
     * @param n
     * @param acc
     * @return
     * @author Lim, Teck Hooi
     */
    public static BigDecimal factorial(BigDecimal n, BigDecimal acc) {
        if (n.equals(BigDecimal.ONE)) {
            return acc;
        }
        BigDecimal lessOne = n.subtract(BigDecimal.ONE);
        return factorial(lessOne, acc.multiply(lessOne));
    }
    public static BigInteger lcm(BigDecimal theNumber1, BigDecimal theNumber2) {

        // NEED TO DEAL WITH EXECPTION AT GUI

        if (theNumber1.remainder(new BigDecimal(1)).equals(0) && theNumber2.remainder(new BigDecimal(1)).equals(0)) {
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

}
