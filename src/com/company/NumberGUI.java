package com.company;

import java.awt.event.ActionListener;

/**
 * This is an interface used to set up base methods for all the GUIes that implement this interface.
 * @author Varun Parbhakar
 * @version 11-16-2021
 */
public interface NumberGUI extends ActionListener {
    /**
     * This method is responsible for checking the inputs, each input validation will be different depending on
     * GUI that implements this method.
     * @param theInput (String theInput)
     * @return (Boolean input is valid))
     */
    boolean isInputValid(String theInput);
    /**
     * This method sets the given solution to the solution field.
     * This method also formats the way the solution is printed.
     * @param theSolution (Solution Object)
     */
    void setSolution(Object theSolution);

}
