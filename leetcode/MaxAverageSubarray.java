package leetcode;

public class MaxAverageSubarray {

    public double findMaxAverage(int[] nums, int k) {
        double averageFirst;
        double averagePrec = Integer.MIN_VALUE;
        double average = Integer.MIN_VALUE;
        int sumFirst = 0;
        for (int i = 0; i < k; i++) {
            sumFirst += nums[i];
        }
        averageFirst = (double) sumFirst / k;
        int i = 1;
        while (i <= nums.length) {
            int sum = 0;
            if (i + k <= nums.length) {
                for (int cnt = i; cnt < k+i; cnt++) {
                    sum += nums[cnt];
                }
                average = (double) sum / k;
                average = Math.max(averagePrec, average);
                averagePrec = average;
            } else {
                break;
            }
            i++;
        }
        return Math.max(averageFirst, average);

    }

    public static void main(String[] args) {
        MaxAverageSubarray maxAverageSubarray = new MaxAverageSubarray();
        int []array1 = {1, 12, -5, -6, 50, 3};
        int []array2 = {5};
        int []array3 ={-1};
        System.out.println(maxAverageSubarray.findMaxAverage(array1, 4));
        System.out.println(maxAverageSubarray.findMaxAverage(array2, 1));
        System.out.println(maxAverageSubarray.findMaxAverage(array3,1));
    }

}
