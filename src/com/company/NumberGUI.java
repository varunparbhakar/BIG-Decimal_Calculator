package com.company;

import java.awt.event.ActionListener;

public interface NumberGUI extends ActionListener {
    final int  TEXT_FIELD_Length = 20;
    boolean isInputValid(String theInput);
    void setSolution(Object theSolution);

}
