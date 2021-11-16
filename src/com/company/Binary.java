package com.company;

/**
 *  This Binary panel is backend brain for the Binary GUI
 * @author Varun Parbhakar
 * @version 11-16-2021
 */
public class Binary extends Calculator{

    /**
     * This method converts integers to binary.
     * @param theNumber (Integer)
     * @return (String Binary representation)
     */
    public static String intToBinary(int theNumber){
        return Integer.toBinaryString(theNumber);
    }

    /**
     * This method converts Binary to Integer.
     * @param theNumber (String theNumber)
     * @return (Integer Integer representation)
     */
    public static int binaryToInt(String theNumber) {
        return Integer.parseInt(theNumber, 2);
    }

}
//END
