package hackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class EqualityArray {

    private static int getMaxValueOfMap(List<Integer> list) {
        int max = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > max) {
                max = list.get(i);
            }
        }
        return max;
    }


    public static int equalizeArray(List<Integer> arr) {
        // Write your code here
        HashMap<Integer, Integer> frequencyHashMap = new HashMap<>();
        for (int i = 0; i < arr.size(); i++) {
            if (frequencyHashMap.containsKey(arr.get(i))) {
                frequencyHashMap.put(arr.get(i), frequencyHashMap.get(arr.get(i)) + 1);
            } else {
                frequencyHashMap.put(arr.get(i), 1);
            }
        }
        List<Integer> valuesList = new ArrayList<>(frequencyHashMap.values());
        int max = getMaxValueOfMap(valuesList);
        return arr.size() - max;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 1, 2, 3, 3, 3);
        System.out.println(equalizeArray(list));
    }
}
