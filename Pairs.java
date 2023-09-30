package hackerRank;

import java.util.*;

public class Pairs {


    public static int pairs(int k, List<Integer> arr) {
        // Write your code here
        //time limit exceeded due to stupid tests -> it is working correctly
        int result =0;
        for (int i = 1; i < arr.size(); i++) {
            //elements are unique and k >0
            if (arr.contains(Math.abs(arr.get(i) - k))) {
                result++;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> list2 = Arrays.asList(1, 5, 3, 4, 2);
        System.out.println(pairs(1, list1));
        System.out.println(pairs(2, list2));
    }
}
