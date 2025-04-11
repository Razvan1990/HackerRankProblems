package leetcode;

import java.util.*;

public class CountElementMaxFrequency {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer>frequencyElements = getFreqMap(nums);
        int maxValue = getMaxNumberOfFrequencies(frequencyElements);
        if (maxValue ==1){
            return nums.length;
        }
        int counter =0;
        for (int value:frequencyElements.keySet()){
            if (frequencyElements.get(value) == maxValue){
                counter++;
            }
        }
        return counter * maxValue;
    }


    private HashMap<Integer,Integer> getFreqMap (int [] nums){
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int num:nums){
            if (freqMap.containsKey(num)){
                freqMap.put(num, freqMap.get(num)+1);
            }else {
                freqMap.put(num, 1);
            }
        }
        return freqMap;
    }

    private int getMaxNumberOfFrequencies (HashMap<Integer, Integer> myMap){
        Collection<Integer> values = myMap.values();
        List<Integer>listValues = new ArrayList<>(values);
        int max = listValues.get(0);
        for (int i =1;i<values.size();i++){
            if (listValues.get(i) >max){
                max = listValues.get(i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        CountElementMaxFrequency counterElem = new CountElementMaxFrequency();
        int [] example1 ={1,2,2,3,1,4};
        int [] example2 ={1,2,3,4,5};
        System.out.println(counterElem.maxFrequencyElements(example1));
        System.out.println(counterElem.maxFrequencyElements(example2));

    }

}
