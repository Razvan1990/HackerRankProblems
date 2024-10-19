package hackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ClosestNumbers {

    private static int getNeighbourDifference(int a, int b) {
        return Math.abs(b - a);
    }

    private static int getMinDifferenceList(List<Integer> listArray) {
        int minDifference = getNeighbourDifference(listArray.get(1), listArray.get(0));
        for (int i = 1; i < listArray.size() - 1; i++) {
            if (getNeighbourDifference(listArray.get(i + 1), listArray.get(i)) < minDifference) {
                minDifference = getNeighbourDifference(listArray.get(i + 1), listArray.get(i));
            }
        }
        return minDifference;
    }

    public static List<Integer> closestNumbers(List<Integer> arr) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        Collections.sort(arr);
        int minDiff = getMinDifferenceList(arr);
        for (int i = 0; i < arr.size() - 1; i++) {
            if (getNeighbourDifference(arr.get(i + 1), arr.get(i)) == minDiff) {
                result.add(arr.get(i));
                result.add(arr.get(i + 1));

            }

        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer>test1 = Arrays.asList(5,2,3,4,1);
        List<Integer>test2 = Arrays.asList(-20, -3916237, -357920, -3620601, 7374819, -7330761, 30, 6246457, -6461594, 266854);
        System.out.println(closestNumbers(test1));
        System.out.println(closestNumbers(test2));
    }
}
