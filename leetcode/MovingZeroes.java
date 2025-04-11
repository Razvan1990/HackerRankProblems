package leetcode;

import java.util.Arrays;

public class MovingZeroes {
    public void moveZeroes(int[] nums) {
        /**
         * first we need to make all elements which are different to 0 in a list
         * then we need to make the first elements with the elements different
         */
        int[] numsNonZero = new int[nums.length];
        int index =0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                numsNonZero[index] = nums[i];
                index++;
            }
        }
        Arrays.fill(nums, 0);
        for (int i = 0; i < numsNonZero.length; i++) {
            nums[i] = numsNonZero[i];
        }
        System.out.println(Arrays.toString(numsNonZero));
    }

    public static void main(String[] args) {
        MovingZeroes movingZeroes = new MovingZeroes();
        int[] nums = {0, 1, 0, 3, 12};
        movingZeroes.moveZeroes(nums);
    }
}
