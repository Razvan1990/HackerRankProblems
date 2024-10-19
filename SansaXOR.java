package hackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SansaXOR {

    private static List<Integer> createElements(List<Integer> arr) {
        List<Integer> resultsList = new ArrayList<>();
        int limit = arr.size();
        int index = 0;
        int numberElements = 2;
        while (numberElements <= arr.size()) {//we do this till we reach the list size(all elements put togheter)
            List<Integer> temp = new ArrayList<>();
            int start = index;
            while (start < limit && temp.size() < numberElements) {//we control here the size of the list to have the exact number of elements and also the index
                temp.add(arr.get(start));
                start++;
            }
            int result = temp.get(0);
            for (int i = 1; i < temp.size(); i++) {
                result ^= temp.get(i);
            }
            resultsList.add(result);
            index++;
            if (start == arr.size()) {
                //if start is equal to the array size, then we have finished a cycle. Thus, the index becomes back 0, cause we need to start again
                //the number of elements in which we do the operation is also incremented
                index = 0;
                numberElements++;
            }

        }
        return resultsList;
    }

    public static int sansaXor(List<Integer> arr) {
        // Write your code here
        List<Integer>computedResults = createElements(arr);
        int result = arr.get(0);
        //first we make the results of all unique elements
        for (int i =1;i<arr.size();i++){
            result^=arr.get(i);
        }

        //now we just make the same, but iterating over the results of the combined numbers of the list
        for (int number:computedResults){
            result^=number;
        }
        return result;
    }

    public static void main(String[] args) {
        int result = 4;
        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(7);
        numbers.add(5);
        numbers.add(4 ^ 5);
        numbers.add(5 ^ 7);
        numbers.add(7 ^ 5);
        numbers.add(4 ^ 5 ^ 7);
        numbers.add(5 ^ 7 ^ 5);
        numbers.add(4 ^ 5 ^ 7 ^ 5);
        for (Integer number : numbers) {
            result = result ^ number;
        }
        System.out.println(result);

        System.out.println("-----------------");
        List<Integer>list1 = Arrays.asList(4,5,7,5);
        List<Integer>list2 = Arrays.asList(1,2,3);
        List<Integer>list3 = Arrays.asList(98,74,12);
        List<Integer>list4 = Arrays.asList(50,13,2);
        List<Integer>list5 = Arrays.asList(3,4,5);
        System.out.println(sansaXor(list1));
        System.out.println(sansaXor(list2));
        System.out.println(sansaXor(list3));
        System.out.println(sansaXor(list4));
        System.out.println(sansaXor(list5));
    }

}
