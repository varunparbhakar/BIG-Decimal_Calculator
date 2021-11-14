package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

class UserInterface extends JFrame implements ActionListener {
    //Menu Bars
    JMenuBar menuBar;

    //Menus
    JMenu calculatorMenu;
    JMenu helpMenu;

    //Menu Items
    JMenuItem startItem;
    JMenuItem exitItem;
    JMenuItem aboutItem;
    JMenuItem operationsItem;
    JMenuItem binaryCalcItem;

    //Frames
    JFrame aboutFrame;
    JFrame operatorFrame;

    //Panels
    JPanel aboutPanel;
    JPanel operatorPanel;
    JPanel decimalPanel, binaryPanel, hexPanel;


    UserInterface() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 400);
        this.setLocation(1200, 100);

        //Invisible calculator until user presses start
        menuBar = new JMenuBar();
        decimalPanel = new DecimalCalculatorGUI();
        decimalPanel.setVisible(false);
        binaryPanel = new BinaryGUI();
        binaryPanel.setVisible(false);

        calculatorMenu = new JMenu("Calculator");
        helpMenu = new JMenu("Help");

        startItem = new JMenuItem("Start");
        exitItem = new JMenuItem("Exit");
        aboutItem = new JMenuItem("About");
        operationsItem = new JMenuItem("Operations");
        binaryCalcItem = new JMenuItem("Binary");

        startItem.addActionListener(this);
        exitItem.addActionListener(this);
        aboutItem.addActionListener(this);
        operationsItem.addActionListener(this);
        binaryCalcItem.addActionListener(this);

        //ShortCuts for the menus and the item inside
        // "Alt + "first letter of the menu" then pressed  "first letter of the menu item"
        // Calculator -> Start -> "Alt+C" -> "S"
        calculatorMenu.setMnemonic(KeyEvent.VK_C);
        helpMenu.setMnemonic(KeyEvent.VK_H);
        aboutItem.setMnemonic(KeyEvent.VK_A);
        startItem.setMnemonic(KeyEvent.VK_S);
        exitItem.setMnemonic(KeyEvent.VK_E);

        calculatorMenu.add(startItem);
        calculatorMenu.add(binaryCalcItem);
        calculatorMenu.add(exitItem);

        helpMenu.add(aboutItem);
        helpMenu.add(operationsItem);


        menuBar.add(calculatorMenu);
        menuBar.add(helpMenu);

        this.setJMenuBar(menuBar);
        this.setVisible(true);
    }
    public void clearCanvas() {
        decimalPanel.setVisible(false);
        binaryPanel.setVisible(false);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == startItem) {
            clearCanvas();
            this.add(decimalPanel);
            decimalPanel.setVisible(true);

        }
        if (e.getSource() == binaryCalcItem) {
            clearCanvas();
            this.add(binaryPanel);
            binaryPanel.setVisible(true);
        }
        if (e.getSource() == aboutItem) {
            aboutFrame = new JFrame();
            aboutFrame.setSize(357, 97);
            aboutFrame.setLocation(1350, 100);
            aboutPanel = new JPanel();
            JTextArea aboutME =
                    new JTextArea(""" 
                            Hi, my name is Varun Parbhakar and I am the author.
                            This is my first Java Gui Project and it is a practice on how to 
                            code up GUIes for my upcoming projects.""");
            aboutME.setEditable(false);
            aboutFrame.add(aboutPanel);
            aboutPanel.add(aboutME);
            aboutFrame.add(aboutPanel);
            aboutFrame.setVisible(true);

        }
        if (e.getSource() == operationsItem) {
            operatorFrame = new JFrame();
            operatorFrame.setSize(299, 125);
            operatorFrame.setLocation(1300, 100);
            operatorPanel = new JPanel();
            JTextArea operations =
                    new JTextArea(""" 
                            '+' - This is used for Addition EX: (1 + 5 = 6).
                            '-' - This is used for Subtraction EX: (1 - 5 = -4).
                            '/' - This is used for Division EX: (1 + 2 = 0.5).
                            '*' - This is used for multiplication EX: (1 + 5 = 5).
                            """);
            operations.setEditable(false);
            operatorPanel.add(operations);
            operatorFrame.add(operatorPanel);
            operatorFrame.setVisible(true);
        }
        if (e.getSource() == exitItem) {
            System.exit(0);
        }
    }
}
