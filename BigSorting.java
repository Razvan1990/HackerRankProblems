package hackerRank;

import java.math.BigInteger;
import java.util.*;

public class BigSorting {

    String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};

    //we will check the length of elements-> if element has a bigger length then
    //it will be put in the right


    public static List<String> bigSorting(List<String> unsorted) {
        // Write your code here
        List<BigInteger> myList = new ArrayList<>();
        List<String> resultList = new ArrayList<>();
        for (String number : unsorted) {
            BigInteger numberLong = new BigInteger(number);
            myList.add(numberLong);
        }
        Collections.sort(myList);
        for (BigInteger number : myList) {
            resultList.add(String.valueOf(number));
        }
        return resultList;
    }

    public static List<String>bigSorting2(List<String>unsorted){
        Collections.sort(unsorted, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length()>o2.length()) return 1;
                else if(o2.length()>o1.length()) return -1;
                else{
                    BigInteger b1 = new BigInteger(o1);
                    BigInteger b2 = new BigInteger(o2);
                    return b1.compareTo(b2);
                }
            }
        });
        return unsorted;
    }

    public static void main(String[] args) {
        List<String> test1 = Arrays.asList("1", "200", "150", "3");
        List<String> test2 = Arrays.asList("31415926535897932384626433832795", "1", "3", "10", "3", "5");
        List<String> test3 = Arrays.asList("8", "1", "2", "100", "12303479849857341718340192371", "3084193741082937","3084193741082938","111","200");
        System.out.println(bigSorting(test1));
        System.out.println(bigSorting(test2));
        System.out.println(bigSorting(test3));

    }

}
