package com.company;

import javax.swing.*;

public class test {
    public static void main(String[] args) {
        JFrame ks = new JFrame();
        ks.setSize(500,500);
        JPanel test = new BinaryGUI();
        test.setVisible(true);
        ks.add(test);
        ks.setVisible(true);

    }
}
