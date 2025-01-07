package leetcode;

public class ContainsDuplicatePartTwo {

    /**
     *48 TEST CASES PASSED
     * TIME LIMIT EXCEEDED ON ONE TEST CASE
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        /**
         * Try to count with two pointers starting from 0 and 1 and check if at array[point0] == array[point1] and then check if
         * abs(point0 -point1) <=k -> return directly true
         * return false if we reach end of array for point1 and we do not have match for point0
         */
        if (nums.length ==1 && k <=1){
            return false;
        }
        int poz0 = 0;
        int poz1 = 1;
        while (poz1 < nums.length) {
            if (nums[poz0] == nums[poz1] && Math.abs(poz1 - poz0) <= k) {
                return true;
            } else {
                poz1++;
                if (poz1 >= nums.length) {
                    poz0++;
                    poz1 = poz0 + 1;
                }
                if (poz1 >=nums.length){
                    return false;
                }
                //recheck this
                if (nums[poz0] == nums[poz1] && Math.abs(poz1 - poz0) <= k) {
                    return true;
                } else if (nums[poz0] == nums[poz1] && Math.abs(poz1 - poz0) > k) {
                    // in this case we will try to increment poz0 and poz1
                    poz0++;
                    poz1 = poz0 + 1;
                }

            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicatePartTwo containsDuplicatePartTwo = new ContainsDuplicatePartTwo();
        int[] nums1 = {1, 2, 3, 1};
        int[] nums2 = {1, 0, 1, 1};
        int[] nums3 = {1, 2, 3, 1, 2, 3};
        System.out.println(containsDuplicatePartTwo.containsNearbyDuplicate(nums1,3));
        System.out.println(containsDuplicatePartTwo.containsNearbyDuplicate(nums2,1));
        System.out.println(containsDuplicatePartTwo.containsNearbyDuplicate(nums3,2));

    }


}
