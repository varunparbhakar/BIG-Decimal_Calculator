package com.company;

import javax.swing.*;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.CacheRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {

    public static void main(String[] args) {
//        JFrame ks = new JFrame();
//        ks.setSize(500,500);
//        JPanel test = new BinaryGUI();
//        test.setVisible(true);
//        ks.add(test);
//        ks.setVisible(true);

        var valueOne = new BigInteger("45");
        var valueTwo = new BigInteger("0");
        System.out.println(BigNumber.gcd(valueOne, valueTwo));
//
          //tester();



    }

//    public static void tester() {
//        ArrayList<BigDecimal> testCase = new ArrayList<>();
//        testCase.add(new BigDecimal(-1.121321231324564542345343543));
//        testCase.add(new BigDecimal(-1));
//        testCase.add(new BigDecimal(0));
//        testCase.add(new BigDecimal(1));
//        testCase.add(new BigDecimal(0.12231564));
//        testCase.add(new BigDecimal(21));
//        testCase.add(new BigDecimal(421212.4544564564545645656465454));
//        System.out.println(testCase);
//        for (int i = 0; i < testCase.size(); i++) {
//            for (int j = 0; j < testCase.size(); j++) {
//                try {
//                    System.out.println();
//                    System.out.println( "(" + testCase.get(i) + ")" + " % " + "(" + testCase.get(j)+ ")");
//                    System.out.println("Result: " + BigNumber.gcd(testCase.get(i), testCase.get(j)));
//                    System.out.println();
//                } catch (Exception e) {
//                    System.out.println();
//                    System.out.println("-----------------------------");
//                    System.out.println("Exception was thrown with " + testCase.get(i) + ", " + testCase.get(j));
//                    System.out.println("-----------------------------");
//                    System.out.println();
//                }
//            }
//        }
//    }
}
