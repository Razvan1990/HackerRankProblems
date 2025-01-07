package leetcode;

import java.util.HashMap;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int num:nums){
            if (freqMap.containsKey(num)){
                return true;
            }else{
                freqMap.put(num,1);
            }
        }
        return false;

    }

    public static void main(String[] args) {
        ContainsDuplicate duplicate = new ContainsDuplicate();
        int [] nums1 ={1,2,3,4};
        int [] nums2 ={1,2,3,1};
        int [] nums3 ={1,1,1,3,3,4,3,2,4,2};
        System.out.println(duplicate.containsDuplicate(nums1));
        System.out.println(duplicate.containsDuplicate(nums2));
        System.out.println(duplicate.containsDuplicate(nums3));
    }
}
