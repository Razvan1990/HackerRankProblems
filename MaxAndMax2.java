package hackerRank;

import java.util.ArrayList;
import java.util.List;

public class MaxAndMax2 {

    public static List<Integer> getFirstTwoMaxes(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int max = nums[0];
        int max2 = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max2 = max;
                max = nums[i];
            } else if (max > max2 && nums[i] > max2) {
                max2 = nums[i];
            }
        }
        //this actually meant that the max was the first number, so we need to determine max2
        if (max == max2 && max == nums[0]) {
            max2 = nums[1];
            for (int i = 2; i < nums.length; i++) {
                if (nums[i] > max2) {
                    max2 = nums[i];
                }
            }
        }
        result.add(max);
        result.add(max2);
        return result;
    }

    static void main() {
        int[] nums = {7, 6,10, 4, 7, 9};
        int[] nums2 = {14, 6, 20, 4, 7, 15};
        int[] nums3 = {20, 6, 10, 4, 7, 19};
        System.out.println(getFirstTwoMaxes(nums));
        System.out.println(getFirstTwoMaxes(nums2));
        System.out.println(getFirstTwoMaxes(nums3));
    }
}
