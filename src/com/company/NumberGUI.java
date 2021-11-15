package com.company;

import java.awt.event.ActionListener;

public interface NumberGUI extends ActionListener {
    final int  TEXT_FIELD_Length = 20;
    boolean isDecimal(String theNumber);
    boolean isNegative(String theNumber);
    boolean isZero(String theNumber);
    boolean isInputValid(String theInput);

}
