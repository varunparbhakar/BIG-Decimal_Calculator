package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * This is a frame that houses all the calculator gui panels.
 * @author Varun Parbhkar
 * @version 11-16-2021
 */
class UserInterface extends JFrame implements ActionListener {
    /*
     * I made these declarations above my constructor such that other methods can
     * have access to these variables.
     */


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
    JMenuItem hexCalcItem;

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
        hexPanel = new HexGUI();
        hexPanel.setVisible(false);


        //Menus
        calculatorMenu = new JMenu("Calculator");
        helpMenu = new JMenu("Help");

        //Menu Items
        decimalCalcItem = new JMenuItem("Decimal");
        binaryCalcItem = new JMenuItem("Binary");
        bigNumberCalcItem = new JMenuItem("Big Number");
        hexCalcItem = new JMenuItem("Hex");
        exitItem = new JMenuItem("Exit");
        aboutItem = new JMenuItem("About");
        operationsItem = new JMenuItem("Operations");

        //Adding ActionListener to Menu Items
        decimalCalcItem.addActionListener(this);
        exitItem.addActionListener(this);
        aboutItem.addActionListener(this);
        operationsItem.addActionListener(this);
        binaryCalcItem.addActionListener(this);
        bigNumberCalcItem.addActionListener(this);
        hexCalcItem.addActionListener(this);

        //ShortCuts for the menus and the item inside
        // "Alt + "first letter of the menu" then pressed  "first letter of the menu item"
        // Calculator -> Start -> "Alt+C" -> "S"
        calculatorMenu.setMnemonic(KeyEvent.VK_C);
        decimalCalcItem.setMnemonic(KeyEvent.VK_S);
        binaryCalcItem.setMnemonic(KeyEvent.VK_B);
        hexCalcItem.setMnemonic(KeyEvent.VK_H);
        exitItem.setMnemonic(KeyEvent.VK_E);


        helpMenu.setMnemonic(KeyEvent.VK_H);
        aboutItem.setMnemonic(KeyEvent.VK_A);


        //Adding MenuItem to the Menu
        calculatorMenu.add(decimalCalcItem);
        calculatorMenu.add(binaryCalcItem);
        calculatorMenu.add(bigNumberCalcItem);
        calculatorMenu.add(hexCalcItem);
        calculatorMenu.add(exitItem);

        helpMenu.add(aboutItem);
        helpMenu.add(operationsItem);


        //Adding Menu to Menu Bar
        menuBar.add(calculatorMenu);
        menuBar.add(helpMenu);

        this.setJMenuBar(menuBar);
        this.setVisible(true);
    }

    /**
     * This method clear the canvas by making every panel invisible.
     */
    public void clearCanvas() {
        decimalPanel.setVisible(false);
        binaryPanel.setVisible(false);
        bigNumberPanel.setVisible(false);
        hexPanel.setVisible(false);

    }


    /**
     * ActionListener for all the buttons.
     * @param e (Event)
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        //Decimal Calculator
        if (e.getSource() == decimalCalcItem) {
            clearCanvas();
            this.add(decimalPanel);
            this.setSize(decimalPanel.getPreferredSize());
            decimalPanel.setVisible(true);

        }

        //Binary Calculator
        if (e.getSource() == binaryCalcItem) {
            clearCanvas();
            this.add(binaryPanel);
            this.setSize(binaryPanel.getPreferredSize());
            binaryPanel.setVisible(true);
        }

        //BigNumber Calculator
        if (e.getSource() == bigNumberCalcItem) {
            clearCanvas();
            this.add(bigNumberPanel);
            this.setSize(bigNumberPanel.getPreferredSize());
            bigNumberPanel.setVisible(true);
        }

        //HexDecimal Calculator
        if (e.getSource() == hexCalcItem) {
            clearCanvas();
            this.add(hexPanel);
            this.setSize(hexPanel.getPreferredSize());
            hexPanel.setVisible(true);
        }
        //About Button
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
        // Operation help menu
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
        //Exit Button
        if (e.getSource() == exitItem) {
            System.exit(0);
        }
    }
}
//END
