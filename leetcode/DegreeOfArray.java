package hackerRank.leetcode;

import com.sun.jdi.PathSearchingVirtualMachine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.
 * <p>
 * Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,2,3,1]
 * Output: 2
 * Explanation:
 * The input array has a degree of 2 because both elements 1 and 2 appear twice.
 * Of the subarrays that have the same degree:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * The shortest length is 2. So return 2.
 * Example 2:
 * <p>
 * Input: nums = [1,2,2,3,1,4,2]
 * Output: 6
 * Explanation:
 * The degree is 3 because the element 2 is repeated 3 times.
 * So [2,2,3,1,4,2] is the shortest subarray, therefore returning 6.
 */
public class DegreeOfArray {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> freqMap = getFreqIndexMap(nums);
        int maxFreqValue = getMaxValue(freqMap);
        List<Integer> values = new ArrayList<>();
        for (int key : freqMap.keySet()) {
            if (freqMap.get(key) == maxFreqValue) {
                values.add(key);
            }
        }
        int currentResult = 0;
        int result = Integer.MAX_VALUE;
        //traverse through max keys and check indices
        for (int value : values) {
            List<Integer> indices = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == value) {
                    indices.add(i);
                }
            }
            //get difference
            currentResult = indices.getLast() - indices.getFirst() + 1;
            result = Math.min(currentResult, result);
        }
        return result;
    }

    private HashMap<Integer, Integer> getFreqIndexMap(int[] nums) {
        HashMap<Integer, Integer> myMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (myMap.containsKey(nums[i])) {
                myMap.put(nums[i], myMap.get(nums[i]) + 1);
            } else {
                myMap.put(nums[i], 1);
            }
        }
        return myMap;
    }

    private int getMaxValue(HashMap<Integer, Integer> myMap) {
        int max = 0;
        for (int key : myMap.keySet()) {
            if (myMap.get(key) > max) {
                max = myMap.get(key);
            }
        }
        return max;
    }

    static void main() {
        DegreeOfArray obj = new DegreeOfArray();
        int[] nums1 = {1,2,2,3,1};
        int[] nums2 = {1,2,2,3,1,4,2};
        System.out.println(obj.findShortestSubArray(nums1));
        System.out.println(obj.findShortestSubArray(nums2));

    }
}
