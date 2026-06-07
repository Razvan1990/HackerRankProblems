package hackerRank.leetcode;

import java.util.Arrays;


/**
 * Given an integer array nums, find three numbers whose product is maximum and return the maximum product.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3]
 * Output: 6
 * Example 2:
 * <p>
 * Input: nums = [1,2,3,4]
 * Output: 24
 * Example 3:
 * <p>
 * Input: nums = [-1,-2,-3]
 * Output: -6
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 3 <= nums.length <= 104
 * -1000 <= nums[i] <= 1000
 */
public class MaximumProduct {
    public int maximumProduct(int[] nums) {
        if (nums.length == 3) {
            return nums[0] * nums[1] * nums[2];
        }
        //sort array
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        //all elements are negative -> we will have a negative result, and we need to return the least negative
        if (nums[nums.length - 1] < 0){
            return nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
        }
        //special case when we have just 2 elements which are positive -> this implies that we need to use the first negative numbers(nums[0] and nums[1])
        if (nums[nums.length - 3] <= 0) {
            return nums[0] * nums[1] * nums[nums.length - 1];
        }
        //we need to check if we have at least 2 elements with negative sign and are bigger than the positive elements
        if (nums[0] < 0 && nums[1] < 0) {
            //start computing and check product of the 2 versus product of the last 2 and the nums-2 * nums-3
            int productMinus = nums[0] * nums[1];
            int productPlus1 = nums[nums.length - 1] * nums[nums.length - 2];
            int proudctPlus2 = nums[nums.length - 2] * nums[nums.length - 3];
            if (productMinus >= productPlus1 || productMinus >= proudctPlus2) {
                return productMinus * nums[nums.length - 1];
            }
        }
        return nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];

    }

    static void main() {
        MaximumProduct test = new MaximumProduct();
        int [] arrayTest = {722,634,-504,-379,163,-613,-842,-578,750,951,-158,30,-238,-392,-487,-797,-157,-374,999,-5,-521,-879,-858,382,626,803,-347,903,-205,57,-342,186,-736,17,83,726,-960,343,-984,937,-758,-122,577,-595,-544,-559,903,-183,192,825,368,-674,57,-959,884,29,-681,-339,582,969,-95,-455,-275,205,-548,79,258,35,233,203,20,-936,878,-868,-458,-882,867,-664,-892,-687,322,844,-745,447,-909,-586,69,-88,88,445,-553,-666,130,-640,-918,-7,-420,-368,250,-786};
        System.out.println(test.maximumProduct(arrayTest));
    }
}
