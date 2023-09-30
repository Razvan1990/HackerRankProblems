package hackerRank;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SherlockAndArray {

    /**
     * @param arr
     * @return yes or no
     * <p>
     * 1. Get the middle of the array and count:
     * a. Till the final element and if not found
     * b. Till the first element
     * 2. Based on this
     * 2 0 0 0 - YES
     * <p>
     * It means that if it is the first element then leftSum will be 0
     * Analog for last element-> rightSum will be 0
     */

    public static String balancedSums(List<Integer> arr) {
        // Write your code here

        int middle = arr.size() / 2;
        //first counting till last element
        while (middle < arr.size()) {
            int leftSum = 0;
            int rightSum = 0;
            if (middle == arr.size() - 1) {
                for (int i = 0; i < middle; i++) {
                    leftSum += arr.get(i);
                }
                if (leftSum == rightSum) {
                    return "YES";
                }

            } else {
                for (int i = 0; i < middle; i++) {
                    leftSum += arr.get(i);
                }
                for (int i = middle + 1; i < arr.size(); i++) {
                    rightSum += arr.get(i);
                }
                if (leftSum == rightSum) {
                    return "YES";
                }
            }


            middle++;

        }

        middle = arr.size() / 2;
        //second counting till first element
        while (middle >= 0) {
            int leftSum = 0;
            int rightSum = 0;
            if (middle == 0) {
                for (int i = 1; i < arr.size(); i++) {
                    rightSum += arr.get(i);
                }
                if (leftSum == rightSum) {
                    return "YES";
                }

            } else {
                for (int i = 0; i < middle; i++) {
                    leftSum += arr.get(i);
                }
                for (int i = middle + 1; i < arr.size(); i++) {
                    rightSum += arr.get(i);
                }
                if (leftSum == rightSum) {
                    return "YES";
                }
            }


            middle--;

        }


        return "NO";

    }

    public static String balancedSums2(List<Integer> arr) {
        // Write your code here
        //try using just a single loop without using middle

        for (int middle = 0; middle < arr.size(); middle++) {
            int leftSum = 0;
            int rightSum = 0;
            //count just upwards
            if (middle > 0) {
                for (int i = 0; i < middle; i++) {
                    leftSum += arr.get(i);
                }
                for (int i = middle + 1; i < arr.size(); i++) {
                    rightSum += arr.get(i);
                }
                if (leftSum == rightSum) {
                    return "YES";
                }
            } else {
                for (int i = middle + 1; i < arr.size(); i++) {
                    rightSum += arr.get(i);
                }
                if (leftSum == rightSum) {
                    return "YES";
                }
            }
        }


        return "NO";

    }

    private static int getSum(List<Integer> arr){
        int sum =0;
        for (int number:arr){
            sum+=number;
        }
        return sum;
    }

    public static String balancedSums3(List<Integer> arr) {
        // Write your code here
        //example with calculating the sum of array and then calculating the right sum by making difference between totalSum and leftSum
        int first = 0;
        int last = arr.size();
        int leftSum = 0;
        int rightSum;
        int arraySum = getSum(arr);
        while (first < last) {
            if(first>0) {
                leftSum += arr.get(first-1);
                rightSum = arraySum - leftSum - arr.get(first);
            }else {
                rightSum = arraySum - arr.get(first);
            }
            if (leftSum == rightSum) {
                return "YES";
            }
            first++;
        }
        return "NO";
    }

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(5, 6, 8, 11);
        List<Integer> list2 = Arrays.asList(1, 2, 3);
        List<Integer> list3 = Arrays.asList(1, 2, 3, 3);
        List<Integer> list4 = Arrays.asList(1, 1, 4, 1, 1);
        List<Integer> list5 = Arrays.asList(2, 0, 0, 0);
        List<Integer> list6 = Arrays.asList(0, 0, 2, 0);
        List<Integer> list7 = Arrays.asList(0, 0, 0, 2);


        System.out.println(balancedSums(list1));
        System.out.println(balancedSums(list2));
        System.out.println(balancedSums(list3));
        System.out.println(balancedSums(list4));
        System.out.println(balancedSums(list5));
        System.out.println(balancedSums(list6));
        System.out.println("Second option");

        System.out.println(balancedSums2(list1));
        System.out.println(balancedSums2(list2));
        System.out.println(balancedSums2(list3));
        System.out.println(balancedSums2(list4));
        System.out.println(balancedSums2(list5));
        System.out.println(balancedSums2(list6));
        System.out.println(balancedSums2(list7));
        System.out.println("Third option");

        System.out.println(balancedSums3(list1));
        System.out.println(balancedSums3(list2));
        System.out.println(balancedSums3(list3));
        System.out.println(balancedSums3(list4));
        System.out.println(balancedSums3(list5));
        System.out.println(balancedSums3(list6));
        System.out.println(balancedSums3(list7));


    }
}
