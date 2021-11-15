package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.net.CacheRequest;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test{

    public static void main(String[] args) {
        JFrame ks = new JFrame();
        ks.setSize(1000,1000);
        JPanel test = new BigNumberGUI();
        test.setVisible(true);
        ks.add(test);
        ks.setVisible(true);
        ks.setSize(test.getPreferredSize());
        BigDecimal s = new BigDecimal(456556);
        MathContext aa = new MathContext(20);
        System.out.println(s.pow(13, aa));

//        var valueOne = new BigInteger("45");
//        var valueTwo = new BigInteger("0");
//        System.out.println(BigNumber.gcd(valueOne, valueTwo));
////
//          //tester();



    }

//    public static void tester() {
//JPanel sd = this;
//    JButton arm = new JButton("ARM");
//        arm.addActionListener(new ActionListener() {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            if(e.getSource() == arm) {
//                System.out.println(sd.getSize());
//            }
//        }
//    });
//        this.add(arm);
//            this.setPreferredSize(new Dimension(720,170));
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


