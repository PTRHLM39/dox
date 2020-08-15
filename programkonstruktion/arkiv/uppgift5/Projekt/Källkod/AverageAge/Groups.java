package AverageAge;
import java.util.ArrayList;

/**
 * 
 */
class Groups 
{
    ArrayList<Integer> females = new ArrayList<Integer>();
    ArrayList<Integer> males = new ArrayList<Integer>();

    /**
     * Takes the age and stores it in
     * an arraylist intended for females.
     * @param age
     * @return females arraylist containing each age
     */
    public ArrayList<Integer> storeFemales( int age ) 
    {
        females.add( age );
        return females;
    }

    /**
     * Takes the age and stores it in
     * an arraylist intended for males.
     * @param age
     * @return males arraylist containing each age
     */
    public ArrayList<Integer> storeMales( int age ) 
    {
        males.add( age );
        return males;
    }
}