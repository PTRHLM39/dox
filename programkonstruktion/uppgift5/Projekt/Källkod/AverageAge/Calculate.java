package AverageAge;

import java.util.ArrayList;

class Calculate 
{
    public double avrAgeFemale(ArrayList<Integer> females) {
        int population = females.size();
        int totAge = 0;

        for(Integer i : females)
            totAge += i;

          return totAge / population;
    }

    public double avrAgeMale(ArrayList<Integer> males) 
    {
        int population = males.size();
        int totAge = 0;

        for(Integer i : males)
            totAge += i;

        return totAge / population;
    }
}