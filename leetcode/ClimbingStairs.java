package leetcode;

public class ClimbingStairs {
    /**
     You are climbing a staircase. It takes n steps to reach the top.

     Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     /* *
     *This program is a dynamic programming one and the way to go is the same like you do with fibonaci
     * n = 5
     * 1  1  2  3 5  8  = 8 ways
     * we return the last element
     */
    public int climbStairs(int n) {
        int [] resultArray = new int[45]; //it is said that n is between 1 and 45
        resultArray[0] = 1;
        resultArray[1] = 2;
        //now we just do the fibonacii series
        for (int i =2;i<=n;i++){
            resultArray[i] = resultArray[i-1] + resultArray[i-2];
        }
        return resultArray[n-1];
    }

    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs();
        int n1 = 2;
        int n2 = 3;
        int n3 = 5;
        System.out.println(climbingStairs.climbStairs(n1));
        System.out.println(climbingStairs.climbStairs(n2));
        System.out.println(climbingStairs.climbStairs(n3));
    }
}
