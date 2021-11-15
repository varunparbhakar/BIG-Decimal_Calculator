package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Inet4Address;

public class BinaryGUI extends JPanel implements ActionListener, NumberGUI{
    JButton oneButton, zeroButton, clearButton, confirmButton,
            oneButton2, zeroButton2, clearButton2, confirmButton2,
            solveButton;
    JTextField xValueField, yValueField, solutionField;
    String xExistingField, yExistingField, myBinaryXNumber, myBinaryYNumber;
    JLabel solutionLabel;
    JComboBox operatorSelectB;
    int myNumber1, myNumber2, remainder;
    String solution;
    char myOperator;
    BinaryGUI(){
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        solutionField = new JTextField(TEXT_FIELD_Length + 5);
        solutionField.setBorder(BorderFactory.createEmptyBorder(10,15,0,0));
        solutionField.setEditable(false);
        solutionField.setText("Select an Operation and hit Solve");
        solutionField.setSize(20,10);
        solutionLabel = new JLabel("Solution:");
        solutionLabel.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));


        xValueField = new JTextField(TEXT_FIELD_Length);
        xValueField.setEditable(false);

        oneButton = new JButton("1");
        zeroButton = new JButton("0");
        clearButton = new JButton("C");
        confirmButton = new JButton("Confirm");

        operatorSelectB = new JComboBox();
        operatorSelectB.addItem('+');
        operatorSelectB.addItem('-');
        operatorSelectB.addItem('/');
        operatorSelectB.addItem('*');



        yValueField = new JTextField(TEXT_FIELD_Length);
        yValueField.setEditable(false);
        oneButton2 = new JButton("1");
        zeroButton2 = new JButton("0");
        clearButton2 = new JButton("C");
        confirmButton2 = new JButton("Confirm");

        solveButton = new JButton("Solve");

        oneButton.addActionListener(this);
        zeroButton.addActionListener(this);
        clearButton.addActionListener(this);
        confirmButton.addActionListener(this);

        oneButton2.addActionListener(this);
        zeroButton2.addActionListener(this);
        clearButton2.addActionListener(this);
        confirmButton2.addActionListener(this);

        solveButton.addActionListener(this);

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

        oneButton.setEnabled(false);
        zeroButton.setEnabled(false);
        confirmButton.setEnabled(false);
        xValueField.setText("Value 1");

        oneButton2.setEnabled(false);
        zeroButton2.setEnabled(false);
        confirmButton2.setEnabled(false);
        yValueField.setText("Value 2");
        this.setPreferredSize(new Dimension(553,300));

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == oneButton) {
            xExistingField = xValueField.getText();
            xValueField.setText(xExistingField + "1");
        }
        if (e.getSource() == zeroButton) {
            xExistingField = xValueField.getText();
            xValueField.setText(xExistingField + "0");
        }
        if (e.getSource() == clearButton) {
            oneButton.setEnabled(true);
            zeroButton.setEnabled(true);
            confirmButton.setEnabled(true);
            xValueField.setText("");
        }


        if (e.getSource() == oneButton2) {
            yExistingField = yValueField.getText();
            yValueField.setText(yExistingField + "1");
        }
        if (e.getSource() == zeroButton2) {
            yExistingField = yValueField.getText();
            yValueField.setText(yExistingField + "0");
        }
        if (e.getSource() == clearButton2) {
            oneButton2.setEnabled(true);
            zeroButton2.setEnabled(true);
            confirmButton2.setEnabled(true);
            yValueField.setText("");
        }

        if (e.getSource() == solveButton) {
            myOperator = operatorSelectB.getSelectedItem().toString().charAt(0);
            myNumber1 = Binary.binaryToInt(xValueField.getText());
            myNumber2 = Binary.binaryToInt(yValueField.getText());
            solve();





        }

    }
    @Override
    public void setSolution(Object theSolution) {
        solutionField.setText("Integer: " + theSolution.toString() + ", Binary: " + Integer.toBinaryString((int)Double.parseDouble(solution)) );
    }

    public void solve() {
        switch (myOperator) {
            case '+' :
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
                if (myNumber1 == 0.0 || myNumber2 == 0.0) {
                    solutionField.setText("Error: Division by 0");

                } else {
                    solution = String.valueOf(Binary.divide(myNumber1, myNumber2));
                    remainder = Binary.remainder(myNumber1, myNumber2);

                    solutionField.setText("Integer: " + (int)Double.parseDouble(solution) + " Remainder: " + Binary.remainder(myNumber1, myNumber2)
                            +  ", Binary: " + Integer.toBinaryString((int)Double.parseDouble(solution)) + " Remainder: " + Binary.remainder(myNumber1, myNumber2) );
                    break;
                }
                break;
            default:
                solutionField.setText("Error: Operator not supported");

        }
    }


    @Override
    public boolean isInputValid(String theInput) {
        return false;
    }
}
