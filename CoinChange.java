package hackerRank;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CoinChange {

    public static long getWays(int n, List<Long> c) {
        // Write your code here


        return 0;

    }


    public static void main(String[] args) {
        List<String>test = Arrays.asList("1", "31423", "3","4", "5419");
        List<String>test2 = Arrays.asList("9","2", "4","5","7");
        List<String>test3 = Arrays.asList("1234", "1324","1243");
        List<String>test4 = Arrays.asList("12", "113","1045");
        Collections.sort(test);
        Collections.sort(test2);
        Collections.sort(test3);
        Collections.sort(test4);
        System.out.println(test);
        System.out.println(test2);
        System.out.println(test3);
        System.out.println(test4);

    }
    //1 2 4 313 413 306

}


