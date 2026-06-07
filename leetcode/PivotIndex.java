/**
 * If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.
 * <p>
 * Return the leftmost pivot index. If no such index exists, return -1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,7,3,6,5,6]
 * Output: 3
 * Explanation:
 * The pivot index is 3.
 * Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
 * Right sum = nums[4] + nums[5] = 5 + 6 = 11
 * Example 2:
 * <p>
 * Input: nums = [1,2,3]
 * Output: -1
 * Explanation:
 * There is no index that satisfies the conditions in the problem statement.
 * Example 3:
 * <p>
 * Input: nums = [2,1,-1]
 * Output: 0
 * Explanation:
 * The pivot index is 0.
 * Left sum = 0 (no elements to the left of index 0)
 * Right sum = nums[1] + nums[2] = 1 + -1 = 0
 */
package hackerRank.leetcode;



//not working full
public class PivotIndex {
    public int pivotIndex(int[] nums) {
        //edge case of nums.length ==1
        if (nums.length == 1) return -1;
        //edge case of nums.length ==2
        if (nums.length ==2){
            if (nums[0] == nums[1]) {
                return 0;
            } else{
                return -1;
            }
        }
        int middle = nums.length / 2;
        //we will need to keep track of original middle -> if we go back to original middle then we don't have something equal
        int origMiddle = middle;
        int start = 0;
        int end = nums.length - 1;
        while (middle >= start && middle <= end) {
            int sumLeftSide = calculateSum(0, middle - 1, nums);
            int sumRightSide = calculateSum(middle + 1, end, nums);
            //check if they are equal
            if (sumLeftSide == sumRightSide) {
                return middle;
            } else {
                if (sumLeftSide > sumRightSide && nums[middle-1] >0) {
                    middle = middle - 1;
                } else if (sumLeftSide > sumRightSide && nums[middle-1] <0) {
                    middle = middle + 1;
                } else if (sumLeftSide < sumRightSide && nums[middle+1] >0) {
                    middle = middle + 1;
                } else if (sumLeftSide < sumRightSide && nums[middle+1] <0) {
                    middle = middle - 1;
                }
            }
            if (middle == origMiddle) {
                //means we return back, so we don't have a middle
                return -1;
            }

        }
        return -1;
    }

    public int pivotIndex2(int[] nums) {
        /**another solution more simple is the following:
         * 1. Calculate the whole sum of the array
         * 2. we will have a left sum which starts with 0
         * 3. then we just compare our leftSum == fullSum - nums[i]
         * 4. IF they are not equal, we add to our leftSum a new member (from index i) and subtract the number from the fullSum
         * 5. when they are equal we just return i
         */
        int fullSum = 0;
        int leftSum =0;
        for (int number: nums) {
            fullSum += number;
        }
        for (int i =0;i<nums.length;i++){
            if (leftSum == fullSum - nums[i]){
                return i;
            }
            else{
                leftSum+=nums[i];
                fullSum-=nums[i];
            }
        }
        return -1;
    }

    private int calculateSum(int startPosition, int endPosition, int[] array) {
        int sum = 0;
        for (int i = startPosition; i <= endPosition; i++) {
            sum += array[i];
        }
        return sum;
    }



    static void main() {
        PivotIndex pivotIndex = new PivotIndex();
        int [] nums = {1,7,3,6,5,6};
        int [] nums2 = {1,2,3};
        int [] nums3 = {2,1,-1};
        int [] nums4 = {-1,-1,-1,-1,-1,-1};
        int [] nums5 = {-1,-1,-1,-1,-1,0};
        System.out.println(pivotIndex.pivotIndex(nums));
        System.out.println(pivotIndex.pivotIndex(nums2));
        System.out.println(pivotIndex.pivotIndex(nums3));
        System.out.println(pivotIndex.pivotIndex(nums4));
        System.out.println(pivotIndex.pivotIndex(nums5));

    }

}
