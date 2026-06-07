/*
Given two arrays of strings list1 and list2, find the common strings with the least index sum.

A common string is a string that appeared in both list1 and list2.

A common string with the least index sum is a common string such that if it appeared at list1[i] and list2[j] then i + j should be the minimum value among all the other common strings.

Return all the common strings with the least index sum. Return the answer in any order.



Example 1:

Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"]
Output: ["Shogun"]
Explanation: The only common string is "Shogun".
Example 2:

Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["KFC","Shogun","Burger King"]
Output: ["Shogun"]
Explanation: The common string with the least index sum is "Shogun" with index sum = (0 + 1) = 1.
Example 3:

Input: list1 = ["happy","sad","good"], list2 = ["sad","happy","good"]
Output: ["sad","happy"]
Explanation: There are three common strings:
"happy" with index sum = (0 + 1) = 1.
"sad" with index sum = (1 + 0) = 1.
"good" with index sum = (2 + 2) = 4.
The strings with the least index sum are "sad" and "happy".
 */

package hackerRank.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MinIndexSumList {
    public String[] findRestaurant(String[] list1, String[] list2) {
        //we will get the index of both lists
        List<String> results = new ArrayList<>();
        HashMap<String, Integer> indexMap1 = getIndexMap(list1);
        HashMap<String, Integer> indexMap2 = getIndexMap(list2);
        int currentResult = Integer.MAX_VALUE;
        //we need to traverse through key in map1 and check if the key is present in the other keys of the next map
        for (String key : indexMap1.keySet()) {
            if (indexMap2.containsKey(key)) {
                int indexSum = indexMap1.get(key) + indexMap2.get(key);
                //check for minimum -> if we have a value less than minimum, clear the list and add this new key
                if (indexSum < currentResult) {
                    results.clear();
                    currentResult = indexSum;
                    results.add(key);
                //else we add a new key with same sum index
                } else if (indexSum == currentResult) {
                    results.add(key);
                }
            }
        }
        return results.toArray(new String[0]);

    }

    private HashMap<String, Integer> getIndexMap(String[] myList) {
        HashMap<String, Integer> indexMap = new HashMap<>();
        int indexCounter = 0;
        for (String s : myList) {
            indexMap.put(s, indexCounter);
            indexCounter++;
        }
        return indexMap;
    }

    static void main() {
        MinIndexSumList test = new MinIndexSumList();
        String[] test1List1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] test1List2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};

        String[] test2List1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] test2List2 = {"KFC", "Shogun", "Burger King"};

        String[] test3List1 = {"happy", "sad", "good"};
        String[] test3List2 = {"sad", "happy", "good"};

        String[] result1 = test.findRestaurant(test1List1, test2List1);
        String[] result2 = test.findRestaurant(test1List2, test2List2);
        String[] result3 = test.findRestaurant(test3List1, test3List2);
        for (String s : result1) {
            System.out.println(s);
        }
        for (String s : result2) {
            System.out.println(s);
        }
        for (String s : result3) {
            System.out.println(s);
        }

    }

}
