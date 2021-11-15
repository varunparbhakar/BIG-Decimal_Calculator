package com.company;

public class Binary extends Calculator{
    public static String intToBinary(int theNumber){
        return Integer.toBinaryString(theNumber);
    }
    public static int binaryToInt(String theNumber) {
        return Integer.parseInt(theNumber, 2);
    }

}
