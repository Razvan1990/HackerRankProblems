package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissingNumbers {
    public int missingNumber(int[] nums) {
        int result = 0;
        List<Integer> numsList = new ArrayList<>();
        for (int i:nums){
            numsList.add(i);
        }
        for (int i =0;i<=nums.length;i++){
            if (!numsList.contains(i)){
                result =i;
                break;
            }
        }
        return result;
    }
    //better time complexity
    public int missingNumbers2 (int [] nums){
        Arrays.sort(nums);
        int result = 0;
        int max = nums.length;//because it starts from 0 - [0,n]
        if (max > nums[nums.length-1]){
            return max;
        }
        for (int i=0;i<=max;i++){
            if (nums[i] !=i){
                result = i;
                break;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        MissingNumbers numbers = new MissingNumbers();
        int [] nums1 ={3, 0, 1};
        int [] nums2 = {0, 1};
        int [] nums3 = {9,6,4,2,3,5,7,0,1};
        System.out.println(numbers.missingNumber(nums1));
        System.out.println(numbers.missingNumber(nums2));
        System.out.println(numbers.missingNumber(nums3));
        System.out.println(numbers.missingNumbers2(nums1));
        System.out.println(numbers.missingNumbers2(nums2));
        System.out.println(numbers.missingNumbers2(nums3));
    }

}
