package leetcode;

import java.util.Arrays;

/**
 * NOT CORRECT SOLUTION
 */
public class PerfectSquares {

    private int getMaxNumberForSquare(int n) {
        int result = 0;
        for (int i = 1; i <= n / 2; i++) {
            result = i * i;
            if (result > n) {
                result = i - 1;
            } else if (result == n) {
                result = i;
            }


        }
        return result;
    }

    public int numSquares(int n) {
        int result = 1;
        int maxNumber = getMaxNumberForSquare(n);
        int difference = n - maxNumber * maxNumber;
        while (difference != 0) {
            if (checkIfNumberPerfectSquare(difference) && (maxNumber * maxNumber) + difference == n) {
                break;
            } else if (checkIfNumberPerfectSquare(difference)){
                result++;
            }
             else{
                maxNumber--;
                difference = n - maxNumber * maxNumber;
            }
        }
        return result;

    }

    private boolean checkIfNumberPerfectSquare(int n) {
        return (int) Math.sqrt(n) == n * 0.5;
    }

    public int numSquares2(int n) {
        /**
         * 1. First create an emptu array of value n+1
         * 2. Fill array with a value (max value)
         * 3. we will start to iterate over the perfect squares
         *  a. In this case the count will start from 1
         *  b. We will take the minimum value between the vector at position i and the square calculated
         *  c. Count will be calculated each time we will finish iterating for a perfect square
         * 4. We will return the final value at position n of the array - position of the number ??
         */
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int count = 1;
        while (count * count <= n) {
            int sq = count * count;
            for (int i = sq; i <= n; i++) {
                dp[i] = Math.min(dp[i - sq] + 1, dp[i]);
            }
            count++;
        }
        return dp[n];
    }

}
