package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * This panel is going to be used for displaying Big Number GUI.
 * @author Varun Parbhakar
 */
public class BigNumberGUI extends JPanel implements NumberGUI {
    /*
     * I made these declarations above my constructor such that other methods can
     * have access to these variables.
     */

    //Declaring Buttons
    JButton additionButton, subtractionButton, multiplicationButton,divisionButton, powerButton, squareRootButton,
    squareButton, xFactorialButton, modButton, gcdButton, lcmButton, clearXButton, clearYButton;

    //Declaring BigDecimals
    BigDecimal myXValue, myYValue;

    //Declaring BigIntegers
    BigInteger myX_BigIntValue, myY_BigIntValue;

    //Declaring Ints
    int myY_Integer;

    //Declaring TextFields
    JTextField xTextField, yTextField, solutionTextField;

    //Declaring Label
    JLabel xTextLabel, yTextLabel, solutionTextLabel;


    BigNumberGUI() {

        //Solution field placement and Initializing
        additionButton = new JButton("X + Y");
        subtractionButton = new JButton("X - Y");
        multiplicationButton = new JButton("X * Y");
        divisionButton = new JButton("X / Y");
        powerButton = new JButton("X ^ Y");
        squareRootButton = new JButton("√X");
        squareButton = new JButton("X ^ 2");
        xFactorialButton = new JButton("X!");
        modButton = new JButton("MOD");
        gcdButton = new JButton("GCD");
        lcmButton = new JButton("LCM");
        clearXButton = new JButton("C");
        clearYButton = new JButton("C");

        //Adding ActionListener to these buttons
        clearXButton.addActionListener(this);
        clearYButton.addActionListener(this);

        //Button array used for easy Initialization and adding ActionListener
        JButton[] buttonArray = {additionButton, subtractionButton, multiplicationButton,
                divisionButton, powerButton, squareRootButton, squareButton, xFactorialButton,
                modButton, gcdButton, lcmButton};


        xTextField = new JTextField(Calculator.PRECISION_CONSTANT.getPrecision());


        yTextField = new JTextField(Calculator.PRECISION_CONSTANT.getPrecision());

        solutionTextField = new JTextField("Enter values then choose operation", Calculator.PRECISION_CONSTANT.getPrecision());
        solutionTextField.setEditable(false);

        // X Value field
        xTextLabel = new JLabel("X =   ");
        xTextField.add(xTextLabel);

        // Y Value field
        yTextLabel = new JLabel("Y =   ");
        yTextField.add(yTextLabel);

        solutionTextLabel = new JLabel("Solution: ");
        solutionTextField.add(solutionTextLabel);


        //Adding action-listeners to buttons
        this.add(xTextLabel);
        this.add(xTextField);
        this.add(clearXButton);
        this.add(yTextLabel);
        this.add(yTextField);
        this.add(clearYButton);
        this.add(solutionTextLabel);
        this.add(solutionTextField);
        for (JButton button : buttonArray
        ) {
            this.add(button);
            button.addActionListener(this);

        }
        this.setPreferredSize(new Dimension(1000,200));

    }

    /**
     * ActionListener for all the buttons.
     * @param e (Event)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Clear X button
        if (e.getSource() == clearXButton) {
            xTextField.setText("");
        }
        // Clear Y Button
        if (e.getSource() == clearYButton) {
            yTextField.setText("");
        }
        // Add button
        if (e.getSource() == additionButton) {
            if(isInputValid(xTextField.getText()) && isInputValid(yTextField.getText())){
                myXValue = new BigDecimal(xTextField.getText());
                myYValue = new BigDecimal(yTextField.getText());
                solutionTextField.setText(BigNumber.add(myXValue, myYValue).toPlainString());
            } else {
                solutionTextField.setText("Please enter valid numbers");
            }
        }
        // Subtract button
        if (e.getSource() == subtractionButton) {
            if(isInputValid(xTextField.getText()) && isInputValid(yTextField.getText())){
                myXValue = new BigDecimal(xTextField.getText());
                myYValue = new BigDecimal(yTextField.getText());
                solutionTextField.setText(BigNumber.subtract(myXValue, myYValue).toPlainString());
            } else {
                solutionTextField.setText("Please enter valid numbers");
            }
        }
        // Multiplication button
        if (e.getSource() == multiplicationButton) {
            if(isInputValid(xTextField.getText()) && isInputValid(yTextField.getText())){
                myXValue = new BigDecimal(xTextField.getText());
                myYValue = new BigDecimal(yTextField.getText());
                solutionTextField.setText(BigNumber.multiply(myXValue, myYValue).toPlainString());
            } else {
                solutionTextField.setText("Please enter valid numbers");
            }
        }
        // Divide button
        if (e.getSource() == divisionButton) {
            if(isInputValid(xTextField.getText()) && isInputValid(yTextField.getText())){
                if(!isZero(xTextField.getText()) &&  !isZero(yTextField.getText())) {
                    myXValue = new BigDecimal(xTextField.getText());
                    myYValue = new BigDecimal(yTextField.getText());
                    solutionTextField.setText(BigNumber.divide(myXValue, myYValue).toPlainString());
                } else {
                    solutionTextField.setText("Can't divide by 0");
                }

            } else {
                solutionTextField.setText("Please enter valid numbers");
            }
        }
        // Power button
        if (e.getSource() == powerButton) {
            if(isInputValid(xTextField.getText()) && isInputValid(yTextField.getText())){
                if(!isZero(xTextField.getText()) && !isDecimal(yTextField.getText())) {
                    myXValue = new BigDecimal(xTextField.getText());
                    myY_Integer = Integer.parseInt(yTextField.getText());

                    if (myY_Integer > 200 || ((myXValue.compareTo(new BigDecimal("9999"))) > 0)) {
                        solutionTextField.setText("Solution too long to Display");
                    } else {
                        if (BigNumber.power(myXValue, myY_Integer).toPlainString().length() > Calculator.PRECISION_CONSTANT.getPrecision()) {
                            solutionTextField.setText("Solution too long to Display");
                        } else {
                            solutionTextField.setText(BigNumber.power(myXValue, myY_Integer).toPlainString());
                        }
                    }
                } else {
                    // I know that if both situations are true both messages will not be provided
                    if (isZero(xTextField.getText())) {
                        solutionTextField.setText("Base cannot be a 0");
                    }
                    if (isDecimal(yTextField.getText())) {
                        solutionTextField.setText("Power cannot be a decimal");
                    }
                }

            } else {
                solutionTextField.setText("Please enter valid numbers");
            }
        }
        // SquareRoot button
        if (e.getSource() == squareRootButton) {
            if(isInputValid(xTextField.getText())){
                if(!isZero(xTextField.getText()) && !isNegative(xTextField.getText())) {
                    myXValue = new BigDecimal(xTextField.getText());
                    solutionTextField.setText(BigNumber.squarerRoot(myXValue).toPlainString());
                } else {
                    solutionTextField.setText("Enter a positive number");
                }

            } else {
                solutionTextField.setText("Please enter valid numbers");
            }
        }
        // Square button
        if (e.getSource() == squareButton) {
            if(isInputValid(xTextField.getText())){
                    myXValue = new BigDecimal(xTextField.getText());
                    solutionTextField.setText(BigNumber.square(myXValue).toPlainString());
            } else {
                solutionTextField.setText("Please enter valid numbers");
            }
        }
        // Factorial Button
        if (e.getSource() == xFactorialButton) {
            if(isInputValid(xTextField.getText())){
                if (!isNegative(xTextField.getText()) && !isDecimal(xTextField.getText()) && !isZero(xTextField.getText())) {
                    myXValue = new BigDecimal(xTextField.getText());
                    solutionTextField.setText(BigNumber.factorial(myXValue, myXValue).toPlainString());
                } else {
                    solutionTextField.setText("Enter positive integers only");
                }
            } else {
                solutionTextField.setText("Please enter valid numbers");
            }
        }
        // Mod Button
        if (e.getSource() == modButton) {
            if(isInputValid(xTextField.getText()) && isInputValid(yTextField.getText())){
                if (!isNegative(xTextField.getText())
                        && !isDecimal(xTextField.getText())
                        && !isZero(xTextField.getText())
                        && !isNegative(yTextField.getText())
                        && !isDecimal(yTextField.getText())
                        && !isZero(yTextField.getText())
                ) {
                    myXValue = new BigDecimal(xTextField.getText());
                    myYValue = new BigDecimal(yTextField.getText());
                    solutionTextField.setText(BigNumber.remainder(myXValue, myYValue).toPlainString());
                } else {
                    solutionTextField.setText("Enter positive integers only");
                }
            } else {
                solutionTextField.setText("Please enter valid numbers");
            }
        }
        // GCD Button
        if (e.getSource() == gcdButton) {
            if(isInputValid(xTextField.getText()) && isInputValid(yTextField.getText())){
                if (!isNegative(xTextField.getText())
                        && !isDecimal(xTextField.getText())
                        && !isZero(xTextField.getText())
                        && !isNegative(yTextField.getText())
                        && !isDecimal(yTextField.getText())
                        && !isZero(yTextField.getText())
                ) {
                    myX_BigIntValue = new BigInteger(xTextField.getText());
                    myY_BigIntValue = new BigInteger(yTextField.getText());
                    solutionTextField.setText(BigNumber.gcd(myX_BigIntValue, myY_BigIntValue).toString());
                } else {
                    solutionTextField.setText("Enter positive integers only");
                }
            } else {
                solutionTextField.setText("Please enter valid numbers");
            }
        }
        // LCM Button
        if (e.getSource() == lcmButton) {
            if(isInputValid(xTextField.getText()) && isInputValid(yTextField.getText())){
                if (!isNegative(xTextField.getText())
                        && !isDecimal(xTextField.getText())
                        && !isZero(xTextField.getText())
                        && !isNegative(yTextField.getText())
                        && !isDecimal(yTextField.getText())
                        && !isZero(yTextField.getText())
                ) {
                    myXValue = new BigDecimal(xTextField.getText());
                    myYValue = new BigDecimal(yTextField.getText());
                    solutionTextField.setText(BigNumber.lcm(myXValue, myYValue).toString());
                } else {
                    solutionTextField.setText("Enter positive integers only");
                }
            } else {
                solutionTextField.setText("Please enter valid numbers");
            }
        }
    }

    public boolean isDecimal(String theNumber) {
        return theNumber.contains(".");
    }

    /**
     * This method is used to check of the number passes is a negative or not.
     * @param theNumber (Passed in String)
     * @return (Boolean, if the number is negative or not)
     */
    public boolean isNegative(String theNumber) {
        double number = Double.parseDouble(theNumber);
        return number < 0;
    }

    /**
     * This method is used to check of the number passes is a zero or not.
     * @param theNumber (Passed in String)
     * @return (Boolean, if the number is negative or not)
     */
    public boolean isZero(String theNumber) {
        double number = Double.parseDouble(theNumber);
        if (number == 0) {
            return true;
        }
        return false;
    }

    /**
     * This method is responsible for checking the inputs, each input validation will be different depending on
     * GUI that implements this method.
     * @param theInput (String theInput)
     * @return (Boolean input is valid))
     */
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


    /**
     * This method sets the given solution to the solution field.
     * This method also formats the way the solution is printed
     * @param theSolution (Solution Object)
     */
    @Override
    public void setSolution(Object theSolution) {
        solutionTextField.setText((String)theSolution);
    }

}
//END
