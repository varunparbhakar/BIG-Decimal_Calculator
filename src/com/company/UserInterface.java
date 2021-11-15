package com.company;

import javax.swing.*;
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
    JMenuItem decimalCalcItem;
    JMenuItem exitItem;
    JMenuItem aboutItem;
    JMenuItem operationsItem;
    JMenuItem binaryCalcItem;
    JMenuItem bigNumberCalcItem;

    //Frames
    JFrame aboutFrame;
    JFrame operatorFrame;

    //Panels
    JPanel aboutPanel;
    JPanel operatorPanel;
    JPanel decimalPanel, binaryPanel, bigNumberPanel,  hexPanel;


    UserInterface() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(200, 200);
        this.setLocation(1200, 100);

        //Invisible calculator until user presses start
        menuBar = new JMenuBar();
        decimalPanel = new DecimalCalculatorGUI();
        decimalPanel.setVisible(false);
        binaryPanel = new BinaryGUI();
        binaryPanel.setVisible(false);
        bigNumberPanel = new BigNumberGUI();
        bigNumberPanel.setVisible(false);

        calculatorMenu = new JMenu("Calculator");
        helpMenu = new JMenu("Help");

        decimalCalcItem = new JMenuItem("Decimal");
        binaryCalcItem = new JMenuItem("Binary");
        bigNumberCalcItem = new JMenuItem("Big Number");
        exitItem = new JMenuItem("Exit");
        aboutItem = new JMenuItem("About");
        operationsItem = new JMenuItem("Operations");

        decimalCalcItem.addActionListener(this);
        exitItem.addActionListener(this);
        aboutItem.addActionListener(this);
        operationsItem.addActionListener(this);
        binaryCalcItem.addActionListener(this);
        bigNumberCalcItem.addActionListener(this);

        //ShortCuts for the menus and the item inside
        // "Alt + "first letter of the menu" then pressed  "first letter of the menu item"
        // Calculator -> Start -> "Alt+C" -> "S"
        calculatorMenu.setMnemonic(KeyEvent.VK_C);
        helpMenu.setMnemonic(KeyEvent.VK_H);
        aboutItem.setMnemonic(KeyEvent.VK_A);
        decimalCalcItem.setMnemonic(KeyEvent.VK_S);
        exitItem.setMnemonic(KeyEvent.VK_E);

        calculatorMenu.add(decimalCalcItem);
        calculatorMenu.add(binaryCalcItem);
        calculatorMenu.add(bigNumberCalcItem);
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
        bigNumberPanel.setVisible(false);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == decimalCalcItem) {
            clearCanvas();
            this.add(decimalPanel);
            this.setSize(decimalPanel.getPreferredSize());
            decimalPanel.setVisible(true);

        }
        if (e.getSource() == binaryCalcItem) {
            clearCanvas();
            this.add(binaryPanel);
            this.setSize(binaryPanel.getPreferredSize());
            binaryPanel.setVisible(true);
        }
        if (e.getSource() == bigNumberCalcItem) {
            clearCanvas();
            this.add(bigNumberPanel);
            this.setSize(bigNumberPanel.getPreferredSize());
            bigNumberPanel.setVisible(true);
        }
        if (e.getSource() == aboutItem) {
            aboutFrame = new JFrame();
            aboutFrame.setSize(200, 200);
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
