package hackerRank;

import java.util.*;

public class LargestPermutation {

    public static void swap(List<Integer> list, int index1, int index2) {
        int temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);

    }


    private static List<Integer> getMaxIndex(List<Integer> list) {
        int max = list.get(0);
        int indexMax = 0;
        for (int i = 1; i < list.size(); i++) {
            if (max < list.get(i)) {
                max = list.get(i);
                indexMax = i;
            }
        }
        List<Integer> result = new ArrayList<>();
        result.add(max);
        result.add(indexMax);
        return result;
    }

    public static List<Integer> largestPermutation(int k, List<Integer> arr) {
        // Write your code here
        if (arr.size() <= 2) {
            if (arr.get(0) > arr.get(1)) {
                return arr;
            } else {
                swap(arr, 0, 1);
                return arr;
            }
        }

        int indexChange = 0;
        int nrSwaps = 0;
        while (nrSwaps < k && indexChange < arr.size() - 1) {
            List<Integer> tempList = new ArrayList<>();
            for (int i = indexChange + 1; i < arr.size(); i++) {
                tempList.add(arr.get(i));
            }
            int maxIndex = getMaxIndex(tempList).get(1);
            if (tempList.get(maxIndex) > arr.get(indexChange)) {
                swap(arr, indexChange, maxIndex + 1 + indexChange);
                indexChange++;
                nrSwaps++;
            } else {
                indexChange++;
            }

        }

        return new ArrayList<>(arr);
    }


    public static List<Integer> largestPermutation2(int k, List<Integer> arr) {

        if (arr.size() <= 2) {
            if (arr.get(0) > arr.get(1)) {
                return arr;
            } else {
                swap(arr, 0, 1);
                return arr;
            }
        }

        LinkedHashMap<Integer, Integer> mapIndex = new LinkedHashMap<>();
        for (int i = 0; i < arr.size(); i++) {
            mapIndex.put(arr.get(i), i);
        }
        int nrSwaps = 0;
        int index = 0;
        while (mapIndex.size() > 0) {
            List<Integer> values = new ArrayList<>(mapIndex.keySet());
            int max = getMaxIndex(values).get(0);
            if (max > (Integer) mapIndex.keySet().toArray()[index]) {
                swap(arr, index, arr.indexOf(max));
                nrSwaps++;
                if (nrSwaps == k) {
                    break;
                }
                mapIndex.remove(max);
                index++;
            } else {
                mapIndex.remove(max, arr.get(max));
                index++;
            }

        }
        return new ArrayList<>(arr);

    }

    public static List<Integer> largestPermutation3(int k, List<Integer> arr) {

        // **** initialization ****
        int n = arr.size();

        // **** sanity checks ****
        if (n == 1) return arr;
        if (k >= n) {
            Collections.sort(arr, Collections.reverseOrder());
            return arr;
        }

        // **** position of numbers in list ****
        int[] position = new int[n + 1];
        for (int i = 0; i < arr.size(); i++)
            position[arr.get(i)] = i;

        // **** loop swapping list entries (as needed) ****
        for (int i = n; k > 0 && i > 0; --i) {

            // **** actual position of `i` ****
            int actualPos = position[i];

            // **** expected position for `i` ****
            int expectedPos = n - i;


            // **** check if i'th value is in the expected place ****
            if (actualPos != expectedPos) {

                // **** swap list elements ****
                Collections.swap(arr, actualPos, expectedPos);


                // **** update positions ****
                position[arr.get(actualPos)] = actualPos;
                position[arr.get(expectedPos)] = expectedPos;


                // **** account for this swap  ****
                k--;
            }
        }

        // **** return modified list ****
        return arr;
    }


    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(4, 2, 3, 5, 1,6);
        List<Integer> list2 = Arrays.asList(2, 1, 3);
        List<Integer> list3 = Arrays.asList(2, 1);

        //System.out.println(largestPermutation(1, list1));
        //System.out.println(largestPermutation(1, list2));
        //System.out.println(largestPermutation(1, list3));

        System.out.println(largestPermutation2(3, list1));
        System.out.println(largestPermutation2(1, list2));
        System.out.println(largestPermutation2(1, list3));
    }
}
