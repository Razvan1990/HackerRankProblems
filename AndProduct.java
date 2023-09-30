package hackerRank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AndProduct {

    private static String getInversedString(String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            builder.append(s.charAt(i));
        }
        return builder.toString();
    }

    private static long findAppeareanceOfSecondOne(long number) {
        StringBuilder builder = new StringBuilder();
        while (number != 0) {
            long rest = number % 2;
            builder.append(rest);
            number /= 2;
        }
        String myResult = builder.toString();
        String correctResult = getInversedString(myResult);
        //find now the second appearance of 1
        long index = 0;
        for (int i = 1; i < correctResult.length(); i++) {
            if (correctResult.charAt(i) == '1') {
                index = i;
                break;
            }
        }
        //it is the length of the string - the index found -> we do not add -1 to have the correct index, because then in case of 10001 for example, index = 0, so i
        //it will enter the if clause below -> there is no need of the correct index as we don't need to calculate something based on it
        return correctResult.length() - index;
    }

    private static List<Long> checkIfNumberPowerOfTwo(long number) {
        List<Long> listPowerOfTwo = new ArrayList<>();
        long countNonZeroes = 0;
        long counter = 0;
        while (number != 0) {
            if (number % 2 != 0) {
                countNonZeroes++;
            }
            number /= 2;
            counter++;
        }
        listPowerOfTwo.add(countNonZeroes);
        listPowerOfTwo.add(counter);
        return listPowerOfTwo;
    }

    public static long andProduct(long a, long b) {
        // Write your code here
        long result = 0;
        List<Long> myListB = checkIfNumberPowerOfTwo(b);
        List<Long> myListA = checkIfNumberPowerOfTwo(a);
        long nrNonZeroes = myListB.get(0);
        if (a == 0) {
            return 0;
        }
        if (nrNonZeroes == 1) {
            return 0;
        }
//        if((a==1||a==2) & b==3){
//            return a;
//        }
        long numberDigits = myListB.get(1);
        long previousPowerOfTwo = (long)Math.pow(2,(numberDigits-1));

        if (a < previousPowerOfTwo) {
            return 0;
        }
        if (myListA.get(1) == numberDigits) {
            long indexOfOneFromA = findAppeareanceOfSecondOne(a);
            long indexOfOneFromB = findAppeareanceOfSecondOne(b);
            long difference = b-a;
            long indexOfOneFromDifference = findAppeareanceOfSecondOne(difference);
            if(indexOfOneFromA==0){
                result = a;
            }
            else if (indexOfOneFromA == indexOfOneFromB) {
                result = a;
            } else {
                result = previousPowerOfTwo;
            }
            //

            /*we need to compare both of the first indices, If both numbers have the same indices, then the result will be a
            Else, result will be the previousPower of Two


            23 = 10111
            31 = 11111 -> result in this case will be 16(10000) cause we will have at next moment :
                10111
                11000
            12 = 1100
            15 =1100 -> result in this case will be  12
             */
        }


        return result;

    }

    public static void main(String[] args) {
        System.out.println(andProduct(12,15));
        System.out.println(andProduct(2,3));
        System.out.println(andProduct(8,13));
        System.out.println(andProduct(17,23));
        System.out.println(andProduct(11,15));
        System.out.println(andProduct(100799171, 102441676));
        System.out.println(andProduct(364011, 366022));
    }


}


