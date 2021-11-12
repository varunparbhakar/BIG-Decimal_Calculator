package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DecimalCalculatorGUI extends JPanel{

    int number1; //This stores the first number
    int number2; //This stores the second number
    char operation; //This stores the solution
    double solution;

    public void setSolution(double solution) {
        this.solution = solution;
    }


    DecimalCalculatorGUI() {
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.BLACK);
        this.add(mainPanel);

        var textDisplay = new TextField(20);
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(textDisplay, BorderLayout.NORTH);

        var buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.LIGHT_GRAY);
        buttonPanel.setLayout(new GridLayout(4, 4));
        mainPanel.add(buttonPanel);

        // Creating the labels for the number button
        JButton[] buttonDigits = new JButton[10];
        for (int i = 0; i < 10; i++)
            buttonDigits[i] = new JButton(i + "");

        // Labeling the operations
        var buttonPlus = new JButton("+");
        var buttonMinus = new JButton("-");
        var buttonMultiply = new JButton("*");
        var buttonDivide = new JButton("/");
        var buttonEquals = new JButton("=");
        var buttonC = new JButton("C");

        // add all buttons onto the buttonPanel
        for (int i=0; i<10; i++)
            buttonPanel.add(buttonDigits[i]);

        //Adding the buttons to the panel
        buttonPanel.add(buttonPlus);
        buttonPanel.add(buttonMinus);
        buttonPanel.add(buttonMultiply);
        buttonPanel.add(buttonDivide);
        buttonPanel.add(buttonEquals);
        buttonPanel.add(buttonC);

        //Adding the operator symbols
        buttonPlus.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String s = textDisplay.getText();
                        textDisplay.setText(s + " + ");
                    }
                } );
        buttonMinus.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String s = textDisplay.getText();
                        textDisplay.setText(s + " - ");
                    }
                } );
        buttonMultiply.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String s = textDisplay.getText();
                        textDisplay.setText(s + " * ");
                    }
                } );
        buttonDivide.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String s = textDisplay.getText();
                        textDisplay.setText(s + " / ");
                    }
                } );
        buttonC.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        textDisplay.setText("");
                    }
                } );


        //Assigning String to Int
        for (int i = 0; i < 10; i++) {
            String number = String.valueOf(i);
            buttonDigits[i].addActionListener(
                    new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String s = textDisplay.getText();
                            textDisplay.setText(s + number);
                        }
                    } );

        }
        buttonEquals.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String s = textDisplay.getText();
                        scanner(textDisplay.getText());
                        textDisplay.setText(s + " = " + String.valueOf(solution));

                    }
                } );
    }

    // This method scans the incoming string and extracts the 2 numbers
    // and the operator.
    public void scanner(String questionString ) {
        String number1 = "";
        boolean number1Done = false;
        String number2 = "";
        boolean number2Done = false;
        char operator = 'v';

        for (int i = 0; i < questionString.length(); i++) {
            //Checking up until number 1
            if(questionString.charAt(i) == ' ' && !number1Done) {
                number1 = questionString.substring(0,i);
                operator = questionString.charAt(i+1);
                number1Done = true;
                continue;
            }
            //Checking up until number 2
            if(questionString.charAt(i) == ' ' && !number2Done) {
                number2 = questionString.substring(i+1);
                number2Done = true;
            }
        }
        //Assigning the extracted numbers and operator.
        this.number1 = Integer.parseInt(number1);
        this.number2 = Integer.parseInt(number2);
        this.operation = operator;

        //Solves the expression with the extracted numbers
        solve(this.number1, this.number2, operator);


    }
    //Solves the expression
    public void solve(int number1, int number2, char operator) {
        //Takes in the solution and perform the solution
        // and setting the solution to the field
        switch (operator) {
            case '+' -> setSolution(number1 + number2);
            case '-' -> setSolution(number1 - number2);
            case '*' -> setSolution(number1 * number2);
            case '/' -> setSolution((float)(number1 / number2));
        };
    }

}


