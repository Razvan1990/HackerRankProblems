package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * TIME LIMIT EXCEEDED BUT SOLUTION IS OK
 */
public class BuySellStock {
    public int maxProfit(int[] prices) {
        if (prices.length ==1){
            return 0;
        }
        if (prices.length ==2){
            if (prices[0] < prices[1]){
                return prices[1] - prices[0];
            }
            else{
                return 0;
            }
        }
        //get difference between all elements and then get the max difference
        List<Integer> maxDifferences = new ArrayList<>();
        int counter = 0;
        //get max difference from first till last element
        while (counter < prices.length - 1) {
            List<Integer> differences = new ArrayList<>();
            for (int i = counter + 1; i < prices.length; i++) {
                differences.add(prices[i] - prices[counter]);
            }
            int max = getMaxValue(differences);
            maxDifferences.add(max);
            counter++;
        }
        int result = getMaxValue(maxDifferences);
        return Math.max(result, 0);
    }

    private int getMaxValue(List<Integer> values) {
        int max = values.get(0);
        for (int i = 1; i < values.size(); i++) {
            if (values.get(i) > max) {
                max = values.get(i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        BuySellStock buySellStock = new BuySellStock();
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        int[] prices2 = {7, 6, 4, 3, 1};
        int[] prices3 = {2, 4, 1};
        int[] prices4 = {9, 10, 4, 3, 6, 9, 2};
        int[] prices5 = {2,1,4};
        System.out.println(buySellStock.maxProfit(prices1));
        System.out.println(buySellStock.maxProfit(prices2));
        System.out.println(buySellStock.maxProfit(prices3));
        System.out.println(buySellStock.maxProfit(prices4));
        System.out.println(buySellStock.maxProfit(prices5));
    }
}
