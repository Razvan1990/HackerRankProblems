package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ArrayIntersection {
    private boolean checkIfNumberInList(List<Integer> myList, int target) {
        for (int num : myList) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }

    public void showArray(int[] myArray) {
        for (int j : myArray) {
            System.out.print(j + " ");
        }
        System.out.println("\n");
    }

    HashMap<Integer, Integer> getFrequencyMap(int [] array){
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int number:array){
            if(freqMap.containsKey(number)){
                freqMap.put(number, freqMap.get(number)+1);
            }else{
                freqMap.put(number, 1);
            }
        }
        return freqMap;
    }

    /**
     * we take the minimum to know in what map we have the common element which appears less
     * @param a
     * @param b
     * @return min of occurennce of common element
     */
    public int getMinValue(int a, int b){
        return Math.min(a, b);
    }


    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> resultList = new ArrayList<>();
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                if (num1 == num2 && !checkIfNumberInList(resultList, num2)) {
                    resultList.add(num2);
                }
            }
        }
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> resultList = new ArrayList<>();
        HashMap<Integer, Integer> mapArray1 = getFrequencyMap(nums1);
        HashMap<Integer, Integer> mapArray2 = getFrequencyMap(nums2);
        //traverse both maps and find common elements
        //get for both the min occurence of the common element and add in list this element exactly the number of times it appears as a min
        if (mapArray1.size() >= mapArray2.size()){
            for (int number:mapArray2.keySet()){
                for (int number2:mapArray1.keySet()){
                    if (number == number2){
                        int minValue = getMinValue(mapArray1.get(number2), mapArray2.get(number));
                        for (int i =0;i<minValue;i++){
                            resultList.add(number);
                        }
                    }
                }
            }
        }else{
            for (int number:mapArray1.keySet()){
                for (int number2:mapArray2.keySet()){
                    if (number == number2){
                        int minValue = getMinValue(mapArray1.get(number), mapArray2.get(number2));
                        for (int i =0;i<minValue;i++){
                            resultList.add(number);
                        }
                    }
                }
            }
        }
        //transform into array
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }


    public static void main(String[] args) {
        ArrayIntersection arrayIntersection = new ArrayIntersection();
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] nums3 = {4, 9, 5};
        int[] nums4 = {9, 4, 9, 8, 4};
        int[] nums5 = {1, 2};
        int[] nums6 = {1, 1};
        arrayIntersection.showArray(arrayIntersection.intersection(nums1, nums2));
        arrayIntersection.showArray(arrayIntersection.intersection(nums3, nums4));
        arrayIntersection.showArray(arrayIntersection.intersect(nums1, nums2));
        arrayIntersection.showArray(arrayIntersection.intersect(nums3, nums4));
        arrayIntersection.showArray(arrayIntersection.intersect(nums5, nums6));


    }
}
