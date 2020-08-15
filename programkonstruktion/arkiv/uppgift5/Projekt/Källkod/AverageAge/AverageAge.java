package AverageAge;

public class AverageAge 
{
    public static void main( String[] args ) 
    {
        Person person = new Person();
        Groups groups = new Groups();
        Calculate calc = new Calculate();
        Dialogs dialog = new Dialogs();

        int confirm;
        boolean checkInput = true;
        do 
        { 
            do
            {
                try
                {
                    String serial = dialog.enterSerial();
                    person.age = person.getAge( serial );
                    person.gender = person.getGender( serial );

                    if  ( person.gender )
                        groups.storeFemales( person.age );
                    else
                        groups.storeMales( person.age );

                    checkInput = false;

                } catch ( Exception e ) 
                {
                   dialog.errorMessage();
                }
            } while ( checkInput );

            confirm = dialog.enterAnotherSerial();

        } while ( confirm == 0 );
        
        double males = 0, females = 0;
        if ( groups.females.size() > 0 )
            females = calc.avrAgeFemale( groups.females );

        if ( groups.males.size() > 0 )
            males = calc.avrAgeMale(groups.males);

        dialog.displayResult(males, females);
    }
}