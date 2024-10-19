package leetcode;

import java.util.HashMap;

public class SingleNumber {

    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = getFreqMap(nums);
        for (int key:map.keySet()){
            if (map.get(key)==1){
                return key;
            }
        }
        return 0;
    }
    private HashMap<Integer, Integer> getFreqMap(int [] array){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int number:array){
            if (map.containsKey(number)){
                map.put(number, map.get(number)+1);
            }else{
                map.put(number,1);
            }
        }
        return map;
    }
}
