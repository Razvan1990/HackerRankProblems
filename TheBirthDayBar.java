package hackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TheBirthDayBar {

    private static int getListSum(List<Integer> arr) {
        int sum = 0;
        for (int number : arr) {
            sum += number;
        }
        return sum;
    }

    public static int birthday(List<Integer> s, int d, int m) {
        // Write your code here
        /**
         * We have a list in which we store the values
         * When the length of the list is equal to m(contigous) then we check to see if the sum is eqal to d
         * If so, we increment result, remove the first element and add the element at the index we are
         * Afterwards we basically check again, cause m remains the same
         * The Else block is executed just till the size of the list becomes equal to m
         * We have the case where we need to compare with the last element as well. In order to not get overflow, we break the loop to not query list.get(size)

         */

        //check if list size is 1 and m is 1(this should be logic)
        if (s.size() == 1) {
            if (s.get(0) == d && m == 1) {
                return 1;
            } else {
                return 0;
            }
        }

        int result = 0;
        List<Integer> subarrayValues = new ArrayList<>();
        int start = s.get(0);
        subarrayValues.add(start);
        for (int i = 1; i <= s.size(); i++) {
            if (subarrayValues.size() == m) {
                //check now to see if the sum of the elements are equal to day
                int sumList = getListSum(subarrayValues);
                if (sumList == d) {
                    result++;
                    //we count this because we need to check the last elements as well
                    if(i == s.size()){
                        break;
                    }
                    //clear first element from array always
                    //add next element to list
                    subarrayValues.remove(0);
                    subarrayValues.add(s.get(i));
                } else {
                    if(i ==s.size()){
                        break;
                    }
                    //need to clear the firs index and go to the next element
                    subarrayValues.remove(0);
                    subarrayValues.add(s.get(i));

                }
            } else {
                //this else block will happen till it reaches m, then it will not be executed anymore
                subarrayValues.add(s.get(i));
            }
        }

        return result;

    }

    public static void main(String[] args) {
        List<Integer> test1 = Arrays.asList(2, 2, 1, 3, 2);
        List<Integer> test2 = Arrays.asList(1, 2, 1, 3, 2);
        List<Integer> test3 = Arrays.asList(1, 1, 1, 1, 1, 1);
        List<Integer> test4 = Arrays.asList(4);

        System.out.println(birthday(test1, 4,2));
        System.out.println(birthday(test2,3,2));
        System.out.println(birthday(test3,3,2));
        System.out.println(birthday(test4,4,1));



    }
}
