package hackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CountingSort1 {

    private static HashMap<Integer, Integer> getFrequencYArray(List<Integer> myList) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int element : myList) {
            if (map.containsKey(element)) {
                map.put(element, map.get(element) + 1);
            } else {
                map.put(element, 1);
            }
        }
        return map;
    }

    public static List<Integer> countingSort(List<Integer> arr) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> freqArray = getFrequencYArray(arr);
        for (int i = 0; i < 100; i++) {
            result.add(freqArray.getOrDefault(i, 0));
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(63,25,73,1,98,73,56,84,86,57,16,83,8,25,81,56,9,53,98,67,99,12,83,89,80,91,39,86,76,85,74,39,25,90,59,10,94,32,44,3,89,30,27,79,46,96,27,32,18,21,92,69,81,40,40,34,68,78,24,87,42,69,23,41,78,22,6,90,99,89,50,30,20,1,43,3,70,95,33,46,44,9,69,48,33,60,65,16,82,67,61,32,21,79,75,75,13,87,70,33);
        System.out.println(countingSort(arr));
    }

}
