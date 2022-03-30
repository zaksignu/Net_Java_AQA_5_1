package ru.netology;

import java.util.ArrayList;
import java.util.Arrays;

public class TrueCity {
    //ArrayList <String> listOfCities = (ArrayList<String>) Arrays.asList(new String[] {"a", "b", "c"});
    public boolean testIt(String City){
        ArrayList<String> listOfCities;
        listOfCities = Arrays.asList(new String[] {"a", "b", "c"});
     return listOfCities.contains(City);
    }
//    ArrayList<String> list;
//    list = Arrays.asList(new String[] {"a", "b", "c"});
}

