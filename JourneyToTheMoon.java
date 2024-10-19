package hackerRank;

import java.util.*;
/*
NOT WORKING WITH ALL TESTCASES
 */

public class JourneyToTheMoon {

    private static int calculateFactorial(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    private static Set<Integer> getOneNationAstronauts(List<List<Integer>> exampleList) {
        /*
        We will check the first value form the first list at index 0 and check in this case that we have a country
        Next we will iterate through all lists and check where we have this key, then added in a list or set in order to determine what
        are the astronauts from the same country
         */

        Set<Integer> astroSameCountry = new HashSet<>();
        if (exampleList.size() == 1) {
            astroSameCountry.add(exampleList.get(0).get(0));
            astroSameCountry.add(exampleList.get(0).get(1));
        }
        int firstValue = exampleList.get(0).get(0);
        int secondValue = exampleList.get(0).get(1);
        astroSameCountry.add(exampleList.get(0).get(1));

        for (List<Integer> pair : exampleList) {

            //first iteration will be done, but as it is set then it will not overwrite anything
            if (pair.get(0) == firstValue || pair.get(0) == secondValue || pair.get(1) == firstValue || pair.get(1) == secondValue) {
                //as here is a set it will definitely not add 4 values
                astroSameCountry.add(firstValue);
                astroSameCountry.add(secondValue);
                astroSameCountry.add(pair.get(0));
                astroSameCountry.add(pair.get(1));
            }
        }


        return astroSameCountry;

    }

    public static int journeyToMoon(int n, List<List<Integer>> astronaut) {
        int result =0;
        Set<Integer> astronautsOfSameCountry = getOneNationAstronauts(astronaut);
        int numberOfAstronautsDifferentCountry = n - astronautsOfSameCountry.size();
        Set<Integer> numberSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            numberSet.add(i);
        }
        numberSet.removeAll(astronautsOfSameCountry);
        if (numberSet.size() == 1) {
            result =  numberOfAstronautsDifferentCountry * astronautsOfSameCountry.size();
        } else if (numberSet.size() == 2) {
            List<Integer> convertedSet = new ArrayList<>(numberSet);
            if (astronaut.contains(convertedSet)) {
                result = numberOfAstronautsDifferentCountry * astronautsOfSameCountry.size();
            } else {
                result =  numberOfAstronautsDifferentCountry * astronautsOfSameCountry.size() + 1;
            }
        } else {
            int numberOfPosibilities = calculateFactorial(numberSet.size()) / calculateFactorial(numberSet.size() - 2) / calculateFactorial(2);
            result =  numberOfAstronautsDifferentCountry * astronautsOfSameCountry.size() + numberOfPosibilities;
        }


        return result;


    }

    public static void main(String[] args) {
        // Write your code here
        //------------------test1--------------------
        List<List<Integer>> test1 = new ArrayList<>();
        List<Integer> test1List1 = Arrays.asList(1, 2);
        List<Integer> test1List2 = Arrays.asList(2, 3);
        test1.add(test1List1);
        test1.add(test1List2);
        //------------------test2--------------------
        List<List<Integer>> test2 = new ArrayList<>();
        List<Integer> test2List1 = Arrays.asList(0, 1);
        List<Integer> test2List2 = Arrays.asList(2, 3);
        List<Integer> test2List3 = Arrays.asList(0, 4);
        test2.add(test2List1);
        test2.add(test2List2);
        test2.add(test2List3);
        //------------------test3--------------------
        List<List<Integer>> test3 = new ArrayList<>();
        List<Integer> test3List1 = Arrays.asList(0, 2);
        test3.add(test3List1);

        System.out.println(journeyToMoon(4, test1));
        System.out.println(journeyToMoon(5, test2));
        System.out.println(journeyToMoon(4, test3));


    }

}
