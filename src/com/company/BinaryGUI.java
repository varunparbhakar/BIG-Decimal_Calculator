package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * This panel is used for displaying the Binary Calculator.
 * @author Varun Parbhakar
 * @version 11-16-2021
 */
public class BinaryGUI extends JPanel implements ActionListener, NumberGUI{
    /*
     * I made these declarations above my constructor such that other methods can
     * have access to these variables.
     */

    //Declaring Buttons
    JButton oneButton, zeroButton, clearButton, confirmButton,
            oneButton2, zeroButton2, clearButton2, confirmButton2,
            solveButton;
    //Declaring Text fields
    JTextField xValueField, yValueField, solutionField;

    //Declaring Strings
    String xExistingField, yExistingField, solution;
    //Declaring Labels
    JLabel solutionLabel;
    //Declaring Combo Box
    JComboBox operatorSelectB;
    //Declaring Ints
    int myNumber1, myNumber2, remainder;
    //Declaring Char
    char myOperator;


    BinaryGUI(){
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        //Solution field placement and Initializing
        solutionField = new JTextField(Calculator.PRECISION_CONSTANT.getPrecision() + 10);
        solutionField.setBorder(BorderFactory.createEmptyBorder(10,15,0,0));
        solutionField.setEditable(false);
        solutionField.setText("Select an Operation and hit Solve");
        solutionField.setSize(30,10);
        solutionLabel = new JLabel("Solution:");
        solutionLabel.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));


        // X Value field
        xValueField = new JTextField(Calculator.PRECISION_CONSTANT.getPrecision());
        xValueField.setEditable(false);

        // Buttons  Initializing for X field
        oneButton = new JButton("1");
        zeroButton = new JButton("0");
        clearButton = new JButton("C");
        confirmButton = new JButton("Confirm");

        // ComboBox Initializing and adding options to the Combo Boxes
        operatorSelectB = new JComboBox();
        operatorSelectB.addItem('+');
        operatorSelectB.addItem('-');
        operatorSelectB.addItem('/');
        operatorSelectB.addItem('*');

        // Y Value field
        yValueField = new JTextField(Calculator.PRECISION_CONSTANT.getPrecision());
        yValueField.setEditable(false);

        // Buttons Initializing for Y field
        oneButton2 = new JButton("1");
        zeroButton2 = new JButton("0");
        clearButton2 = new JButton("C");
        confirmButton2 = new JButton("Confirm");

        solveButton = new JButton("Solve");

        //Adding actionlisteners to buttons
        oneButton.addActionListener(this);
        zeroButton.addActionListener(this);
        clearButton.addActionListener(this);
        confirmButton.addActionListener(this);

        oneButton2.addActionListener(this);
        zeroButton2.addActionListener(this);
        clearButton2.addActionListener(this);
        confirmButton2.addActionListener(this);

        solveButton.addActionListener(this);


        // Assigning each component to a specific location on screen
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 6;
        gbc.gridheight = 1;
        this.add(xValueField, gbc);

        gbc.gridx = 7;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        this.add(oneButton, gbc);

        gbc.gridx = 8;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        this.add(zeroButton, gbc);

        gbc.gridx = 9;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        this.add(clearButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 10;
        gbc.gridheight = 1;
        this.add(operatorSelectB, gbc);


        operatorSelectB.setBorder(BorderFactory.createEmptyBorder(15,0,15,0));


        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 4;
        gbc.gridheight = 1;
        this.add(yValueField, gbc);

        gbc.gridx = 7;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        this.add(oneButton2, gbc);

        gbc.gridx = 8;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        this.add(zeroButton2, gbc);

        gbc.gridx = 9;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        this.add(clearButton2, gbc);

        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.gridwidth = 20;
        gbc.gridheight = 10;
        this.add(solutionField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        this.add(solutionLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        this.add(solveButton, gbc);

        //Disabling the buttons until the user clears up the Text field for Value X
        oneButton.setEnabled(false);
        zeroButton.setEnabled(false);
        confirmButton.setEnabled(false);
        xValueField.setText("Value 1 EX. '0101010'");

        //Disabling the buttons until the user clears up the Text field for Value Y
        oneButton2.setEnabled(false);
        zeroButton2.setEnabled(false);
        confirmButton2.setEnabled(false);
        yValueField.setText("Value 2 EX.'10101010'");
        this.setPreferredSize(new Dimension(553,300));

    }

    /**
     * ActionListener for all the buttons.
     * @param e (Event)
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        // One Button for X Field
        if (e.getSource() == oneButton) {
            xExistingField = xValueField.getText();
            xValueField.setText(xExistingField + "1");
        }
        // Zero Button for X Field
        if (e.getSource() == zeroButton) {
            xExistingField = xValueField.getText();
            xValueField.setText(xExistingField + "0");
        }
        // Clear Button for X Field
        if (e.getSource() == clearButton) {
            oneButton.setEnabled(true);
            zeroButton.setEnabled(true);
            confirmButton.setEnabled(true);
            xValueField.setText("");
        }

        // One Button for Y Field
        if (e.getSource() == oneButton2) {
            yExistingField = yValueField.getText();
            yValueField.setText(yExistingField + "1");
        }
        // Zero Button for Y Field
        if (e.getSource() == zeroButton2) {
            yExistingField = yValueField.getText();
            yValueField.setText(yExistingField + "0");
        }
        // Clear Button for Y Field
        if (e.getSource() == clearButton2) {
            oneButton2.setEnabled(true);
            zeroButton2.setEnabled(true);
            confirmButton2.setEnabled(true);
            yValueField.setText("");
        }

        // Solve Button for solution Field
        if (e.getSource() == solveButton) {
            myOperator = operatorSelectB.getSelectedItem().toString().charAt(0);

            if(isInputValid(xValueField.getText()) && isInputValid(yValueField.getText())) {
                myOperator = operatorSelectB.getSelectedItem().toString().charAt(0);
                myNumber1 = Binary.binaryToInt(xValueField.getText());
                myNumber2 = Binary.binaryToInt(yValueField.getText());
                solve();
            } else {
                solutionField.setText("Please valid numbers");
            }
        }
    }

    /**
     * This method sets the given solution to the solution field.
     * This method also formats the way the solution is printed
     * @param theSolution (Solution Object)
     */
    @Override
    public void setSolution(Object theSolution) {
        if(isNegative(Double.parseDouble(theSolution.toString()))) {
            solutionField.setText("Integer: " + theSolution
                    + ", Binary: -" + Binary.intToBinary(((int)Double.parseDouble(solution)*-1)));
        } else {
            solutionField.setText("Integer: " + theSolution
                    + ", Binary: " + Binary.intToBinary((int)Double.parseDouble(solution)));
        }
    }

    /**
     * This method checks for the operator field and the both number field to
     * send the appropriate method calls depending on the selected operator.
     */
    public void solve() {
        //Selecting the operator
        switch (myOperator) {
            case '+':
                solution = String.valueOf(Binary.add(myNumber1, myNumber2));
                setSolution(solution);
                break;
            case '-':
                solution = String.valueOf(Binary.subtract(myNumber1, myNumber2));
                setSolution(solution);
                break;
            case '*':
                solution = String.valueOf(Binary.multiply(myNumber1, myNumber2));
                setSolution(solution);
                break;
            case '/':
                //Extra steps to properly print division operations
                if (myNumber1 == 0.0 || myNumber2 == 0.0) {
                    solutionField.setText("Error: Division by 0");

                } else {
                    solution = String.valueOf(Binary.divide(myNumber1, myNumber2));
                    remainder = Binary.remainder(myNumber1, myNumber2);
                    solutionField.setText("Integer: " + (int) Double.parseDouble(solution)
                            + " Remainder: " + Binary.remainder(myNumber1, myNumber2)
                            + ", Binary: " + Binary.intToBinary((int) Double.parseDouble(solution))
                            + " Remainder: " + Binary.intToBinary(Binary.remainder(myNumber1, myNumber2)));

                }
                break;
            default:
                solutionField.setText("Error: Operator not supported");
        }
    }

    /**
     * This method is responsible for checking the inputs, each input validation will be different depending on
     * GUI that implements this method.
     * @param theInput (String theInput)
     * @return (Boolean input is valid))
     */
    @Override
    public boolean isInputValid(String theInput) {
        return (theInput.length() != 0 && theInput.length() < Calculator.PRECISION_CONSTANT.getPrecision());
    }

    /**
     * This method is used to check of the number passes is a negative or not.
     * @param theNumber (Passed in Double)
     * @return (Boolean, if the number is negative or not)
     */
    public boolean isNegative(double theNumber) {
        return (theNumber < 0);
    }
}
