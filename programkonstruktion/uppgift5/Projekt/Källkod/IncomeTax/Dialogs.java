package IncomeTax;

import java.rmi.RemoteException;

import javax.swing.*;

public class Dialogs {

    public double getIncome() 
    throws RemoteException
    {
        String s = JOptionPane.showInputDialog
        (null, "Enter your gross annual income in swedish Krona (SEK): ");

        if (s == null)
            System.exit( 0 );
        else if (Double.parseDouble(s) < 0)
            throw new RemoteException();

        return Double.parseDouble( s ) / 1000;
    }

    public int resetIncome() 
    {
        int confirm = JOptionPane.showConfirmDialog
        (null, "Calculate another income?", "Question",
        JOptionPane.YES_NO_OPTION );

        return confirm;
    }

    public void displayResult
    ( Double annualIncome, Double localTax, Double stateTax, Double BASIC_DEDUCTION)
    {
        double grossIncome = annualIncome * 1000;
        double netIncome = (annualIncome - (BASIC_DEDUCTION + localTax + stateTax)) * 1000;
        double totalTaxes = (localTax + stateTax) * 1000;
        localTax = localTax * 1000;
        stateTax = stateTax * 1000;

        JOptionPane.showMessageDialog
        (null,
        "Gross Income: " + grossIncome + " SEK\n" +
        "Net Income: " + netIncome + " SEK\n" +
        "Local Taxes: " + localTax + " SEK\n" +
        "Public Taxes: " + stateTax + " SEK\n" +
        "Deduction: " + BASIC_DEDUCTION * 1000 + " SEK\n" +
        "Total Taxes: " + totalTaxes,
        "Result",
        JOptionPane.PLAIN_MESSAGE);
    }

    public void errorMessage()
    {
        JOptionPane.showMessageDialog
        (null, "Something went wrong! Try again.", "Error",
        JOptionPane.ERROR_MESSAGE);
    }
}