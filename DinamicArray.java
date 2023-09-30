package hackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DinamicArray {

//            1 0 5 -> 1 x  y
//            1 1 7
//            1 0 3
//            2 1 0 2 x y
//            2 1 1

//    Query: 1 x y
//    Let .
//    Append the integer  to .
//    Query: 2 x y
//    Let .
//    Assign the value  to .
//    Store the new value of  to an answers array.

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        // Write your code here
        List<Integer> lastAnswerList = new ArrayList<>();
        int lastAnswer = 0;
        List<List<Integer>> arrays = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> arr = new ArrayList<>();
            arrays.add(arr);


        }
        for (List<Integer> query : queries) {
            int value1 = query.get(0);
            int value2 = query.get(1);
            int value3 = query.get(2);

            if (value1 == 1) {
                int idx = (value2 ^ lastAnswer) % n;
                arrays.get(idx).add(value3);
            } else if (value1 == 2) {
                int idx = (value2 ^ lastAnswer) % n;
                int idx2 = value3 % arrays.get(idx).size();
                lastAnswer = arrays.get(idx).get(idx2);
                lastAnswerList.add(lastAnswer);
            }

        }

        return lastAnswerList;
    }

    public static void main(String[] args) {
        List<List<Integer>> queries1 = new ArrayList<>();
        List<Integer> query1 = Arrays.asList(1, 0, 5);
        List<Integer> query2 = Arrays.asList(1, 1, 7);
        List<Integer> query3 = Arrays.asList(1, 0, 3);
        List<Integer> query4 = Arrays.asList(2, 1, 0);
        List<Integer> query5 = Arrays.asList(2, 1, 1);
        queries1.add(query1); queries1.add(query2); queries1.add(query3); queries1.add(query4); queries1.add(query5);
        System.out.println(dynamicArray(2, queries1));
    }
}
