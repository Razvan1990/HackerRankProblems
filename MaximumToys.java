package hackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaximumToys {

    private static int getSumList(List<Integer>list){
        int sum = 0;
        for(int number:list){
            sum+=number;
        }
        return sum;
    }

    public static int maximumToys(List<Integer> prices, int k) {
        // Write your code here
        //sort the list prices first. Basically as it is sorted we can count and put in a new list, the prices till the sum of the list is less than k
        Collections.sort(prices);
        List<Integer>resultList = new ArrayList<>();
        for (Integer price : prices) {
            int sumList = getSumList(resultList);
            if (sumList+price > k) {
                break;
            } else {
                resultList.add(price);
            }

        }
        return resultList.size();

    }

    public static void main(String[] args) {
        List<Integer>prices1 = Arrays.asList(1,12,5,111,200,1000,10);
        System.out.println(maximumToys(prices1, 50));
    }
}
