package com.company;

import javax.swing.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.CacheRequest;

public class test {
    public static void main(String[] args) {
//        JFrame ks = new JFrame();
//        ks.setSize(500,500);
//        JPanel test = new BinaryGUI();
//        test.setVisible(true);
//        ks.add(test);
//        ks.setVisible(true);
        var ff = new BigDecimal(44.445645);
        var f = new BigDecimal(5);
        var s = ff.add(f);
        System.out.println(s.divide(new BigDecimal(1)).equals(0));
        System.out.println(ff.add(f));
        System.out.println(f.remainder(BigDecimal.ONE).equals(0));




        System.out.println(BigNumber.lcm(ff, f));


    }
}
