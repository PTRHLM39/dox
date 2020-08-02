package AverageAge;

import java.rmi.RemoteException;

class Person 
{
    int age;
    boolean gender;

    /**
     * Uses the person's year of birth to get the age
     * @param serial The serial entered by the user.
     * @return age 
     */
    public int getAge( String serial ) 
    throws RemoteException
    {
        int birthYear = Integer.parseInt
        (serial.substring(0,4));

        int age = 2020 - birthYear;

        if (age > 120)
            throw new RemoteException();
            
        return age;
    }

    /**
     * Uses the third digit in the last four-serial
     * to get gender
     * @param serial
     * @return gender in form of true or false
     */
    public boolean getGender( String serial ) 
    {
        int sexDigit = Character.getNumericValue
        (serial.charAt(10));
        boolean gender = sexDigit % 2 == 0;

        return gender;
    }


}