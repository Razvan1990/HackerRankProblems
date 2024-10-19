package hackerRank;

import java.util.*;

public class RemoveDuplicatesSortedArray {

    public int removeDuplicates(int[] nums) {
        //easier approach here is to use a set
        HashSet<Integer> resultSet = new HashSet<>();
        for (int number : nums) {
            resultSet.add(number);
        }
        List<Integer> listSet = new ArrayList<>(resultSet);
        int [] newArray = new int[resultSet.size()];
        for (int i =0;i<listSet.size();i++){
            newArray[i] = listSet.get(i);
        }
        System.out.println(listSet);
        return newArray.length;
    }

    public static void main(String[] args) {
        RemoveDuplicatesSortedArray removeDuplicatesSortedArray = new RemoveDuplicatesSortedArray();
        int[] nums1 = {1, 1, 2};
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        //int [] nums3 ={1,1,2};
        int r1 = removeDuplicatesSortedArray.removeDuplicates(nums1);
        int r2 = removeDuplicatesSortedArray.removeDuplicates(nums2);

        System.out.println(r1);
        System.out.println(r2);
    }


}
