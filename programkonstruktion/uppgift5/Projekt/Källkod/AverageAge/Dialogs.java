package AverageAge;

import java.rmi.RemoteException;

import javax.swing.*;

class Dialogs 
{
    /**
     * Prompt user, and ask for a persons serial code
     * @return serial code
     */
    public String enterSerial() 
    throws RemoteException
    {
        String serial = JOptionPane.showInputDialog
        (null, "Enter personal serial code: " +
        "(YYYYMMDDNNNN)");

        if (serial == null)
            System.exit(0);
        else if (serial.length() > 12)
            throw new RemoteException();

        return serial;
    }

    /**
     * Prompt user and ask if he/she wants to add another person
     * to the population.
     * @return confirm  Yes or no in form of '1' or '0'.
     */
    public int enterAnotherSerial() 
    {
        int confirm = JOptionPane.showConfirmDialog
        (null, "Add another person?", "Question",
        JOptionPane.YES_NO_OPTION );

        return confirm;
    }

    public void errorMessage()
    {
        JOptionPane.showMessageDialog
        (null, "Something went wrong! Try again.", "Error",
        JOptionPane.ERROR_MESSAGE);
    }

    public void displayResult(Double males, Double females)
    {
        JOptionPane.showMessageDialog
        (null,
        "Average female age: " + females + " years\n" +
        "Average male age: " + males + " years\n",
        "Result", JOptionPane.PLAIN_MESSAGE);
    }

}