package hackerRank.leetcode;

public class LongContIncrSeq {
    public int findLengthOfLCIS(int[] nums) {
        int result =1;
        int currentResult = 1;
        int poz1 =0;
        int poz2 =1;

        while(poz2 < nums.length){
            if (nums[poz2] > nums[poz1]){
                currentResult++;
                result = Math.max(currentResult,result);
                poz1++;
                poz2++;
            }
            else{
                currentResult =1;
                poz1++;
                poz2++;
            }
        }
        return result;
    }


    static void main() {
        int [] nums1 ={1,3,5,4,7};
        int [] nums2 ={2,2,2,2,2};

        LongContIncrSeq obj = new LongContIncrSeq();
        System.out.println(obj.findLengthOfLCIS(nums1));
        System.out.println(obj.findLengthOfLCIS(nums2));
    }
}
