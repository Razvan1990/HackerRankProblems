package hackerRank;

import java.util.Arrays;
import java.util.List;

public class DivisibleSumPairs {

    public static int divisibleSumPairs(int n, int k, List<Integer> ar) {
        // Write your code here
        int result =0;
        int index = 0;
        while(index<n-1){
            for (int i = index+1;i<n;i++){
                if((ar.get(index)+ar.get(i))%k==0){
                    result++;
                }
            }
            index++;
        }
        return result;

    }

    public static void main(String[] args) {
        List<Integer>test1 = Arrays.asList(1,2,3,4,5,6);
        List<Integer>test2 = Arrays.asList(1,3,2,6,1,2);
        System.out.println(divisibleSumPairs(test1.size(), 5, test1));
        System.out.println(divisibleSumPairs(test2.size(), 3, test2));

    }
}
