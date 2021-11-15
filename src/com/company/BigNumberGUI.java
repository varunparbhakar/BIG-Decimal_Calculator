package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.BigInteger;

public class BigNumberGUI extends JPanel implements NumberGUI {


    BigDecimal myXValue, myYValue;
    BigInteger myX_BigIntValue, myY_BigIntValue;
    int myX_Integer, myY_Integer;
    JButton additionButton, subtractionButton, multiplicationButton,divisionButton, powerButton, squareRootButton,
    squareButton, xFactorialButton, modButton, gcdButton, lcmButton, clearXButton, clearYButton;
    JTextField xTextField, yTextField, solutionTextField;
    JLabel xTextLabel, yTextLabel, solutionTextLabel;


    BigNumberGUI() {
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
        clearXButton.addActionListener(this);
        clearYButton = new JButton("C");
        clearYButton.addActionListener(this);



        JButton[] buttonArray = {additionButton, subtractionButton, multiplicationButton,divisionButton, powerButton, squareRootButton,
                squareButton, xFactorialButton, modButton, gcdButton, lcmButton};



        xTextField = new JTextField(TEXT_FIELD_Length);


        yTextField = new JTextField(TEXT_FIELD_Length);

        solutionTextField = new JTextField("Enter values then choose operation", TEXT_FIELD_Length);
        solutionTextField.setEditable(false);

        xTextLabel = new JLabel("X =   ");
        xTextField.add(xTextLabel);
        yTextLabel = new JLabel("Y =   ");
        yTextField.add(yTextLabel);
        solutionTextLabel = new JLabel("Solution: ");
        solutionTextField.add(solutionTextLabel);

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

        JPanel sd = this;
        JButton arm = new JButton("ARM");
        arm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == arm) {
                    System.out.println(sd.getSize());
                }
            }
        });
        this.setPreferredSize(new Dimension(980,140));

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clearXButton) {
            xTextField.setText("");
        }
        if (e.getSource() == clearYButton) {
            yTextField.setText("");
        }
        if (e.getSource() == additionButton) {
            if(isInputValid(xTextField.getText()) && isInputValid(yTextField.getText())){
                myXValue = new BigDecimal(xTextField.getText());
                myYValue = new BigDecimal(yTextField.getText());
                solutionTextField.setText(BigNumber.add(myXValue, myYValue).toPlainString());
            } else {
                solutionTextField.setText("Please enter valid numbers");
            }
        }
        if (e.getSource() == subtractionButton) {
            if(isInputValid(xTextField.getText()) && isInputValid(yTextField.getText())){
                myXValue = new BigDecimal(xTextField.getText());
                myYValue = new BigDecimal(yTextField.getText());
                solutionTextField.setText(BigNumber.subtract(myXValue, myYValue).toPlainString());
            } else {
                solutionTextField.setText("Please enter valid numbers");
            }
        }
        if (e.getSource() == multiplicationButton) {
            if(isInputValid(xTextField.getText()) && isInputValid(yTextField.getText())){
                myXValue = new BigDecimal(xTextField.getText());
                myYValue = new BigDecimal(yTextField.getText());
                solutionTextField.setText(BigNumber.multiply(myXValue, myYValue).toPlainString());
            } else {
                solutionTextField.setText("Please enter valid numbers");
            }
        }
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
        if (e.getSource() == powerButton) {
            if(isInputValid(xTextField.getText()) && isInputValid(yTextField.getText())){
                if(!isZero(xTextField.getText()) && !isDecimal(yTextField.getText())) {
                    myXValue = new BigDecimal(xTextField.getText());
                    myY_Integer = Integer.parseInt(yTextField.getText());
                    solutionTextField.setText(BigNumber.power(myXValue, myY_Integer).toPlainString());
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
        if (e.getSource() == squareButton) {
            if(isInputValid(xTextField.getText())){
                    myXValue = new BigDecimal(xTextField.getText());
                    solutionTextField.setText(BigNumber.square(myXValue).toPlainString());
            } else {
                solutionTextField.setText("Please enter valid numbers");
            }
        }
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

    @Override
    public boolean isDecimal(String theNumber) {
        return theNumber.contains(".");
    }

    @Override
    public boolean isNegative(String theNumber) {
        double number = Double.parseDouble(theNumber);
        return number < 0;
    }


    @Override
    public boolean isZero(String theNumber) {
        double number = Double.parseDouble(theNumber);
        if (number == 0) {
            return true;
        }
        return false;
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
