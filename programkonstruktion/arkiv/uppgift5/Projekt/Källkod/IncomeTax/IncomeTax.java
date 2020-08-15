package IncomeTax;

public class IncomeTax 
{
    public static final double BASIC_DEDUCTION = 13.4;   // KSEK
    public static final double LOCAL_TAX = 0.32;         // Average 32%

    public static final double STATE_LOWER = 0.2;        // 20%
    public static final double STATE_HIGHER = 0.25;      // 25%

    public static final double THRESHOLD_LOWER = 490.7;  // KSEK
    public static final double THRESHOLD_HIGHER = 689.3; // KSEK

    public static double setStateTax( Double annualIncome )
    {
        if (annualIncome >= THRESHOLD_HIGHER)
            return (annualIncome * STATE_HIGHER);
        else
            return (annualIncome * STATE_LOWER);
    }

    public static void main(String[] args)
    {
        Dialogs dialog = new Dialogs();

        int confirm;
        boolean checkInput = true;
        double annualIncome = 0;

        do
        {
            do
            {
                try
                {
                annualIncome = dialog.getIncome();
                checkInput = false;
                }catch (Exception e) {
                    dialog.errorMessage();
                }

            }while(checkInput);

            double localTax = annualIncome * LOCAL_TAX;

            double austerityTax = annualIncome - ( BASIC_DEDUCTION + localTax );
            double stateTax = 0;
            if ( austerityTax >= THRESHOLD_LOWER )
                stateTax = setStateTax( annualIncome );

            

             dialog.displayResult( annualIncome, localTax, stateTax, BASIC_DEDUCTION );

            confirm = dialog.resetIncome();

        } while ( confirm == 0 );
    }
}