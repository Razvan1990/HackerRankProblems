package leetcode;

import java.util.*;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> freqMap = getFrequencyMap(nums);
        int maxElement = getMaxValue(freqMap);
        //traverse to freq map and find element which has the value
        int result =0;
        for (int key:freqMap.keySet()){
            if (freqMap.get(key) == maxElement){
                result = key;
                break;
            }
        }
        return result;
    }

    private HashMap<Integer, Integer> getFrequencyMap (int [] array){
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num:array){
            if (frequencyMap.containsKey(num)){
                frequencyMap.put(num, frequencyMap.get(num)+1);
            }else {
                frequencyMap.put(num,1);
            }
        }
        return frequencyMap;
    }

    private int getMaxValue (HashMap<Integer, Integer> map){
        Collection<Integer> values = map.values();
        List<Integer> myList = new ArrayList<>(values);
        int max = myList.get(0);
        for (Integer integer : myList) {
            if (integer > max) {
                max = integer;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MajorityElement majorityElement = new MajorityElement();
        int [] array1= {3,2,3};
        int r1 = majorityElement.majorityElement(array1);
        int [] array2 = {2,2,1,1,2,2,3};
        int r2 = majorityElement.majorityElement(array2);
        System.out.println(r1);
        System.out.println(r2);
    }

}
