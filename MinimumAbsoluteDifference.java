package hackerRank;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinimumAbsoluteDifference {


    private static int getMinDifference(int a, int b) {
        return Math.abs((a - b));
    }

    public static int minimumAbsoluteDifference(List<Integer> arr) {
        // Write your code here
        //sort the list and then see every difference between neighbours
        //make as an ordinary min

        Collections.sort(arr);
        int difference = Integer.MAX_VALUE;
        for (int i = 0; i < arr.size() - 1; i++) {
            if (difference > getMinDifference(arr.get(i + 1), arr.get(i))) {
                difference = getMinDifference(arr.get(i + 1), arr.get(i));
            }

        }
    return difference;
    }

    public static void main(String[] args) {
        List<Integer>test1 = Arrays.asList(-2, 2,4);
        List<Integer>test2 = Arrays.asList(3, -7, 0);
        List<Integer>test3 = Arrays.asList(-59, -36, -13, 1, -53, -92, -2, -96, -54, 75);
        List<Integer>test4 = Arrays.asList(1, -3, 71, 68, 17);
        System.out.println(minimumAbsoluteDifference(test1));
        System.out.println(minimumAbsoluteDifference(test2));
        System.out.println(minimumAbsoluteDifference(test3));
        System.out.println(minimumAbsoluteDifference(test4));

    }
}
