package hackerRank;

import java.util.*;

public class EqualStacks {





    private static int getMin(List<Integer> list) {
        int min = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (min < list.get(i)) {
                min = list.get(i);
            }
        }
        return min;
    }


    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        // Write your code here
        //need a map to store the sequence and values

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        Stack<Integer> s3 = new Stack<>();
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;

        for (int i = h1.size() - 1; i >= 0; i--) {
            s1.push(h1.get(i));
            sum1 += h1.get(i);

        }
        for (int i = h2.size() - 1; i >= 0; i--) {
            s2.push(h2.get(i));
            sum2 += h2.get(i);

        }
        for (int i = h3.size() - 1; i >= 0; i--) {
            s3.push(h3.get(i));
            sum3 += h3.get(i);
        }
        int min = Integer.MIN_VALUE;
        while (sum1 != sum2 || sum2 != sum3) {
            min = Math.min(sum1, Math.min(sum2, sum3));
            if (sum1 > min) {
                sum1 = sum1 - s1.pop();

            }
            if (sum2 > min) {
                sum2 = sum2 - s2.pop();

            }
            if (sum3 > min) {
                sum3 = sum3 - s3.pop();

            }
        }
        return sum1;


    }

    private static int getListSum(List<Integer>list){
        int sum =0;
        for (int number:list){
            sum+=number;
        }
        return sum;

    }

    public static int equalStacks2(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        List<Integer>sums = new ArrayList<>();
        int sumH1 = getListSum(h1);
        int sumH2 = getListSum(h2);
        int sumH3 = getListSum(h3);

        sums.add(sumH1); sums.add(sumH2); sums.add(sumH3);



        while(sumH2 != sumH3 || sumH1 != sumH3){
            int min = getMin(sums);
            if(sumH1>min){
                h1.remove(0);
                sumH1 = getListSum(h1);
            }
            if(sumH2>min){
                h2.remove(0);
                sumH2 = getListSum(h2);
            }
            if (sumH3>min){
                h3.remove(0);
                sumH3 = getListSum(h3);
            }
        }
        return sumH1;
    }



}

