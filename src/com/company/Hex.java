package com.company;

/**
 * This Hex panel is backend brain for the Hex GUI
 * @author Varun Parbhakar
 * @version 11-16-2021
 */
public class Hex extends Calculator {
    /**
     * This method converts hex to integer.
     * @param theNumber (String)
     * @return (Int Integer representation)
     */
    public static int hexToInt(String theNumber) {
        return Integer.parseInt(theNumber, 16);
    }

    /**
     * This method converts integer to Hex.
     * @param theNumber (Integer)
     * @return (String hex representation)
     */
    public static String intToHex(int theNumber) {
        return Integer.toHexString((theNumber)).toUpperCase();
    }

}
//END
