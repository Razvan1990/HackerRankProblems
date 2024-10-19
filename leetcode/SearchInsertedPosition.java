package hackerRank;

import java.util.HashMap;
import java.util.HashSet;

public class SearchInsertedPosition {
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            } else {
                if (nums[i] > target && i == 0) {
                    return 0;
                } else if (target > nums[i] && i == nums.length-1) {
                    return i+1;
                } else if (nums[i]>target) {
                    return i;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        SearchInsertedPosition searchInsertedPosition = new SearchInsertedPosition();
        searchInsertedPosition.searchInsert(nums, 7);
    }

}
