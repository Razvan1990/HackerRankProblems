/**
 * You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.
 *
 * You can either start from the step with index 0, or the step with index 1.
 *
 * Return the minimum cost to reach the top of the floor.
 *
 *
 *
 * Example 1:
 *
 * Input: cost = [10,15,20]
 * Output: 15
 * Explanation: You will start at index 1.
 * - Pay 15 and climb two steps to reach the top.
 * The total cost is 15.
 * Example 2:
 *
 * Input: cost = [1,100,1,1,1,100,1,1,100,1]
 * Output: 6
 * Explanation: You will start at index 0.
 * - Pay 1 and climb two steps to reach index 2.
 * - Pay 1 and climb two steps to reach index 4.
 * - Pay 1 and climb two steps to reach index 6.
 * - Pay 1 and climb one step to reach index 7.
 * - Pay 1 and climb two steps to reach index 9.
 * - Pay 1 and climb one step to reach the top.
 * The total cost is 6.
 *
 */

package hackerRank.leetcode;

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        //try to create two costs - one starting from 1 and one startring from 0
        //have two pointers to check the future positions
        //count till last index is bigger: while (pos<=len(index)-1)
        //check if we do 2 stairs the value is bigger or not than 1 stair  -> to see how much we jump with the position
        //compare the two obtained values and choose minimum
        int cost1 =0;
        int cost2 =0;


        int poz =0;


        cost1+=cost[poz];

        while(poz < cost.length){
            if (poz == cost.length-1) {
                cost1 = cost[cost.length-1];
                poz++;
            }
            else if (cost[poz+1] <= cost[poz+2]){
                poz++;
                cost1+=cost[poz];
            } else {
                poz+=2;
                cost1+=cost[poz];
            }
        }
        poz =1;


        cost1+=cost[poz];

        while(poz < cost.length){
            if (poz == cost.length-1) {
                cost1 = cost[cost.length-1];
                poz++;
            }
            else if (cost[poz+1] <= cost[poz+2]){
                poz++;
                cost1+=cost[poz];
            } else {
                poz+=2;
                cost1+=cost[poz];
            }
        }
        return Math.min(cost1,cost2);
    }

    public int minCostClimbingStairs2(int[] cost) {
        for(int i=2;i<cost.length;i++)
        {
            cost[i]+=Math.min(cost[i-1],cost[i-2]);
        }
        return Math.min(cost[cost.length-1],cost[cost.length-2]);
    }

    static void main() {
        int []arr1 = {10, 15, 20};
        int []arr2 = {1,100,1,1,1,100,1,1,100,1};
        MinCostClimbingStairs sol = new MinCostClimbingStairs();
        System.out.println(sol.minCostClimbingStairs(arr1));
        System.out.println(sol.minCostClimbingStairs(arr2));
    }
}
