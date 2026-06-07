/**
 * ou are given an integer array nums where the largest integer is unique.
 *
 * Determine whether the largest element in the array is at least twice as much as every other number in the array. If it is, return the index of the largest element, or return -1 otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,6,1,0]
 * Output: 1
 * Explanation: 6 is the largest integer.
 * For every other number in the array x, 6 is at least twice as big as x.
 * The index of value 6 is 1, so we return 1.
 * Example 2:
 *
 * Input: nums = [1,2,3,4]
 * Output: -1
 * Explanation: 4 is less than twice the value of 3, so we return -1.
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 50
 * 0 <= nums[i] <= 100
 * The largest element in nums is unique.
 */
package hackerRank.leetcode;

import com.sun.jdi.PathSearchingVirtualMachine;

public class LargestAtLeastTwice {
    public int dominantIndex(int[] nums) {
        int max = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int highest_index =0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max2=max;
                max = nums[i];
                highest_index = i;
            } else if (max > max2 && nums[i] > max2 ) {
                max2 = nums[i];
            //in this case we need to specify second max
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
        if (max /2 >= max2) {
            return highest_index;
        }
        return -1;
    }

    static void main() {
        int[] array1 = {3,6,1,0};
        int [] array2 = {1,2,3,4};
        LargestAtLeastTwice sol = new LargestAtLeastTwice();
        System.out.println(sol.dominantIndex(array1));
        System.out.println(sol.dominantIndex(array2));
    }

}
