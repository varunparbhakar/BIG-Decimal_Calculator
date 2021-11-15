package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DecimalCalculatorGUI extends JPanel implements NumberGUI{

    double myNumber1, myNumber2;
    char myOperation; //This stores the solution
    double solution;
    JButton buttonDigits0, buttonDigits1, buttonDigits2, buttonDigits3, buttonDigits4,
            buttonDigits5, buttonDigits6, buttonDigits7, buttonDigits8, buttonDigits9,
            buttonPlus, buttonMinus, buttonMultiply, buttonDivide, buttonEquals, buttonC;
    JButton[] buttonList;
    JTextField textDisplay;



    DecimalCalculatorGUI() {
        this.setBackground(Color.BLACK);

        textDisplay = new JTextField(20);

        this.add(textDisplay, BorderLayout.NORTH);

        var buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.LIGHT_GRAY);
        buttonPanel.setLayout(new GridLayout(4, 4));
        this.add(buttonPanel);

        // Creating the labels for the number button
        buttonList = new JButton[]{buttonDigits0, buttonDigits1, buttonDigits2, buttonDigits3, buttonDigits4,
                buttonDigits5, buttonDigits6, buttonDigits7, buttonDigits8, buttonDigits9};
        // Creating the labels for the number button
        for (int i = 0; i < buttonList.length; i++) {
            buttonList[i] = new JButton(i + "");
            buttonPanel.add(buttonList[i]);
            String number = String.valueOf(i);
            buttonList[i].addActionListener(
                    new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String s = textDisplay.getText();
                            textDisplay.setText(s + number);
                        }
                    } );
        }

        // Labeling the operations
        buttonPlus = new JButton("+");
        buttonPlus.addActionListener(this);
        buttonMinus = new JButton("-");
        buttonMinus.addActionListener(this);
        buttonMultiply = new JButton("*");
        buttonMultiply.addActionListener(this);
        buttonDivide = new JButton("/");
        buttonDivide.addActionListener(this);
        buttonEquals = new JButton("=");
        buttonEquals.addActionListener(this);
        buttonC = new JButton("C");
        buttonC.addActionListener(this);


        //Adding the buttons to the panel
        buttonPanel.add(buttonPlus);
        buttonPanel.add(buttonMinus);
        buttonPanel.add(buttonMultiply);
        buttonPanel.add(buttonDivide);
        buttonPanel.add(buttonEquals);
        buttonPanel.add(buttonC);

        this.setPreferredSize(new Dimension(250,250));
    }

    // This method scans the incoming string and extracts the 2 numbers
    // and the operator.


    public void solve() {
        String s = textDisplay.getText();
        switch (myOperation) {
            case '+' :
                setSolution(Decimal.add(myNumber1, myNumber2));
                textDisplay.setText(s + " = " + String.valueOf(solution));
                break;
            case '-':
                setSolution(Decimal.subtract(myNumber1, myNumber2));
                textDisplay.setText(s + " = " + String.valueOf(solution));
                break;
            case '*':
                setSolution(Decimal.multiply(myNumber1, myNumber2));
                textDisplay.setText(s + " = " + String.valueOf(solution));
                break;
            case '/':
                if (myNumber1 == 0.0 || myNumber2 == 0.0) {
                    textDisplay.setText("Error: Division by 0");
                    setKeyPadStatus(false);
                } else {
                    setSolution((float) Decimal.divide(myNumber1, myNumber2));
                    textDisplay.setText(s + " = " + String.valueOf(solution));
                }
                break;
            default:
                textDisplay.setText("Error: Operator not supported");
                setKeyPadStatus(false);

        }
    }
    public void setSolution(Object theSolution) {
         solution =  (double) theSolution;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonEquals) {
            if(scanner(textDisplay.getText())){
                solve();
                setKeyPadStatus(false);
            } else {
                textDisplay.setText("Please Enter Valid Numbers");
            }
        }
        if (e.getSource() == buttonC) {
            setKeyPadStatus(true);
            solution = 0;
            textDisplay.setText("");
        }
        if (e.getSource() == buttonDivide) {
            String s = textDisplay.getText();
            textDisplay.setText(s + " / ");
        }
        if (e.getSource() == buttonMultiply) {
            String s = textDisplay.getText();
            textDisplay.setText(s + " * ");
        }
        if (e.getSource() == buttonMinus) {
            String s = textDisplay.getText();
            textDisplay.setText(s + " - ");
        }
        if (e.getSource() == buttonPlus) {
            String s = textDisplay.getText();
            textDisplay.setText(s + " + ");
        }

    }
    public void setKeyPadStatus(boolean value) {
        for (JButton button : buttonList) {
            button.setEnabled(value);
        }
        buttonPlus.setEnabled(value);
        buttonMinus.setEnabled(value);

        buttonMultiply.setEnabled(value);

        buttonDivide.setEnabled(value);

        buttonEquals.setEnabled(value);


    }
    public boolean scanner(String theInput ) {
        String number1 = "";
        boolean number1Done = false;
        String number2 = "";
        boolean number2Done = false;
        char operator = 'v';

        for (int i = 0; i < theInput.length(); i++) {
            //Checking up until number 1
            if(theInput.charAt(i) == ' ' && !number1Done) {
                number1 = theInput.substring(0,i);
                operator = theInput.charAt(i+1);
                number1Done = true;
                continue;
            }
            //Checking up until number 2
            if(theInput.charAt(i) == ' ' && !number2Done) {
                number2 = theInput.substring(i+1);
                number2Done = true;
            }
        }
        //Assigning the extracted numbers and operator.
        if (isInputValid(number1) && isInputValid(number2)) {
            myNumber1 = Integer.parseInt(number1);
            myNumber2 = Integer.parseInt(number2);
        } else {
            setKeyPadStatus(false);
            textDisplay.setText("Please enter correct values");
            return false;
        }
        myOperation = operator;
        return true;

    }

    @Override
    public boolean isInputValid(String theInput) {
        if (theInput.length() == 0) {
            return false;
        }
        boolean negative = false;
        boolean decimal = false;
        for (int i = 0; i < theInput.length(); i++) {
            int s = theInput.charAt(i);
            if(s >= 48 && s<=57 || s == 45 || s == 46) {
                if (s == 45) {
                    if (!negative) {
                        negative = true;
                    } else {
                        return false;
                    }
                }
                if (s == 46) {
                    if (!decimal) {
                        decimal = true;
                    } else {
                        return false;
                    }
                }


            } else {
                return false;
            }
        }
        return true;
    }

    }



