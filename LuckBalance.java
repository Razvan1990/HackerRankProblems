package hackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LuckBalance {
    //wem will form a custom list for all scores in which the competition is important
    //we will then sort that list to have the correct order
    //based on k, we will see how many wins are needed = list of lucks .size - k
        //if k is <= 0, then we can lose all competitions and the result will be the sum of the points
        //else we will see what is the difference based on the neededWins. As the luck list is sorted we will add the points to a diffrence variable
        /*finally, as we need to subtract this, we will calculate the whole points and substract diffrence *2 -> to have correct substraction; if we just leave difference it means that
        we just make the substracting points equal to 0*/


    public static int luckBalance(int k, List<List<Integer>> contests) {
        // Write your code here
        int result = 0;
        List<Integer> lucks = new ArrayList<>();
        for (List<Integer> list : contests) {
            if (list.get(1) == 1) {
                lucks.add(list.get(0));
            }
        }
        Collections.sort(lucks);
        int nrNeededWins = lucks.size() - k;
        if (nrNeededWins <= 0) {
            for (List<Integer> list : contests) {
                result += list.get(0);
            }
        } else {

            int difference = 0;
            for (int i = 0; i < nrNeededWins; i++) {
                difference += lucks.get(i);
            }


            for (List<Integer> list : contests) {
                result += list.get(0);
            }
            result = result - difference * 2;
        }
        return result;

    }

    public static void main(String[] args) {
        List<List<Integer>> listTest1 = new ArrayList<>();
        List<Integer> list1A = Arrays.asList(5, 1);
        List<Integer> list1B = Arrays.asList(1, 1);
        List<Integer> list1C = Arrays.asList(4, 0);
        listTest1.add(list1A);
        listTest1.add(list1B);
        listTest1.add(list1C);
        System.out.println(luckBalance(2, listTest1));
        System.out.println("##########TEST2##########");
        List<List<Integer>> listTest2 = new ArrayList<>();
        List<Integer> list2A = Arrays.asList(5, 1);
        List<Integer> list2B = Arrays.asList(2, 1);
        List<Integer> list2C = Arrays.asList(1, 1);
        List<Integer> list2D = Arrays.asList(8, 1);
        List<Integer> list2E = Arrays.asList(10, 0);
        List<Integer> list2F = Arrays.asList(5, 0);
        listTest2.add(list2A);
        listTest2.add(list2B);
        listTest2.add(list2C);
        listTest2.add(list2D);
        listTest2.add(list2E);
        listTest2.add(list2F);
        System.out.println(luckBalance(0, listTest2));

    }

}

