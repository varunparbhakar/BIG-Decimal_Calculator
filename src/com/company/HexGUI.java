package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


/**
 * This panel is used to display the Hex Calculator
 * @author Varun Parbhkar
 * @version 11-16-2021
 */
public class HexGUI extends JPanel implements NumberGUI{
    /*
     * I made these declarations above my constructor such that other methods can
     * have access to these variables.
     */

    //Declaring Buttons
    JButton clearButton, confirmButton,
            clearButton2, confirmButton2,
            solveButton;
    //Declaring Text fields
    JTextField xValueField, yValueField, solutionField;

    //Declaring Labels
    JLabel solutionLabel;

    //Declaring ComboBox
    JComboBox operatorSelectB;

    //Declaring Integers
    int myNumber1, myNumber2, remainder;

    //Declaring Strings
    String solution;
    //Declaring Char
    char myOperator;

    HexGUI(){
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

        // Buttons Initializing for Y field
        clearButton2 = new JButton("C");
        confirmButton2 = new JButton("Confirm");


        solveButton = new JButton("Solve");


        //Adding actionlisteners to buttons
        clearButton.addActionListener(this);
        confirmButton.addActionListener(this);
        clearButton2.addActionListener(this);
        confirmButton2.addActionListener(this);
        solveButton.addActionListener(this);

        // Assigning each component to a specific location on screen
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 6;
        gbc.gridheight = 1;
        this.add(xValueField, gbc);

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
        confirmButton.setEnabled(false);
        xValueField.setText("Value 1 Ex. 'A45'");
        xValueField.setEditable(false);

        //Disabling the buttons until the user clears up the Text field for Value Y
        confirmButton2.setEnabled(false);
        yValueField.setText("Value 2 Ex. 'AAAA'");
        yValueField.setEditable(false);
        this.setPreferredSize(new Dimension(553,300));
    }

    /**
     * ActionListener for all the buttons.
     * @param e (Event)
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        // Clear Button for X Field
        if (e.getSource() == clearButton) {
            xValueField.setEditable(true);
            confirmButton.setEnabled(true);
            xValueField.setText("");
        }

        // Clear Button for Y Field
        if (e.getSource() == clearButton2) {
            yValueField.setEditable(true);
            confirmButton2.setEnabled(true);
            yValueField.setText("");
        }

        // Solve Button for solution Field
        if (e.getSource() == solveButton) {
            if (isInputValid(xValueField.getText()) && isInputValid(yValueField.getText())) {
                    myOperator = operatorSelectB.getSelectedItem().toString().charAt(0);
                    myNumber1 = Hex.hexToInt(xValueField.getText());
                    myNumber2 = Hex.hexToInt(yValueField.getText());
                    solve();

            } else {
                solutionField.setText("Error: Invalid Value");
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
                    + ", Hex: -" + Hex.intToHex(((int)Double.parseDouble(solution)*-1)));
        } else {
            solutionField.setText("Integer: " + theSolution
                    + ", Hex: " + Hex.intToHex((int)Double.parseDouble(solution)));
        }


        solutionField.setText("Integer: " + theSolution.toString() + ", Hex: " + Hex.intToHex((int)Double.parseDouble(theSolution.toString())));
    }

    /**
     * This method checks for the operator field and the both number field to
     * send the appropriate method calls depending on the selected operator.
     */
    public void solve() {
        switch (myOperator) {
            case '+' :
                solution = String.valueOf(Hex.add(myNumber1, myNumber2));
                setSolution(solution);
                break;
            case '-':
                solution = String.valueOf(Hex.subtract(myNumber1, myNumber2));
                setSolution(solution);
                break;
            case '*':
                solution = String.valueOf(Hex.multiply(myNumber1, myNumber2));
                setSolution(solution);
                break;
            case '/':
                if (myNumber1 == 0.0 || myNumber2 == 0.0) {
                    solutionField.setText("Error: Division by 0");

                } else {
                    solution = String.valueOf(Hex.divide(myNumber1, myNumber2));
                    remainder = Binary.remainder(myNumber1, myNumber2);
                    solutionField.setText("Integer: " + (int) Double.parseDouble(solution)
                            + " Remainder: " + Hex.remainder(myNumber1, myNumber2)
                            + ", Binary: " + Hex.intToHex((int) Double.parseDouble(solution))
                            + " Remainder: " + Hex.intToHex(Binary.remainder(myNumber1, myNumber2)));
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
        theInput = theInput.toUpperCase();
        if (theInput.length() == 0) {
            return false;
        }
        for (int i = 0; i < theInput.length(); i++) {
            int s = theInput.charAt(i);
            if(s < 48 || s > 57 && s < 65 || s > 70) {
                return false;
            }
        }
        return true;
    }

    /**
     * This method is used to check of the number passes is a negative or not.
     * @param theNumber (Passed in Double)
     * @return (Boolean, if the number is negative or not)
     */
    public boolean isNegative(double theNumber) { return (theNumber < 0);}
}