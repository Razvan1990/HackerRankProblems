package hackerRank;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MarksCakewalk {

    //in order to maintain the minimum value we will sort the list
    //the sum in this way will be minimum case we will have an index which start from idx = index-1 and decreases to 0 and which will be Math.pow(2, idx) * calorie.get(0),
    // till we reach the final element of the list which will be Math.pow(2, 0) * calorie.get(calorie.size()-1)
    public static long marcsCakewalk(List<Integer> calorie) {
        // Write your code here
        long result = 0;
        Collections.sort(calorie);
        int calIndex = calorie.size() - 1;
        for (Integer cal : calorie) {
            result += Math.pow(2, calIndex) * cal;
            calIndex--;

        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> test1 = Arrays.asList(5, 10, 7);
        List<Integer> test2 = Arrays.asList(1, 3, 2);
        List<Integer> test3 = Arrays.asList(7, 4, 9, 6);
        List<Integer>test4 = Arrays.asList(1, 5);
        List<Integer>test5 = Arrays.asList(3);
        System.out.println(marcsCakewalk(test1));
        System.out.println(marcsCakewalk(test2));
        System.out.println(marcsCakewalk(test3));
        System.out.println(marcsCakewalk(test4));
        System.out.println(marcsCakewalk(test5));
    }
}
