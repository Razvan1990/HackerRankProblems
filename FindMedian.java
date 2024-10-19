package hackerRank;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindMedian {

    public static int findMedian(List<Integer> arr) {
        // Write your code here
        Collections.sort(arr);
        //starts from index 0
        return arr.get(arr.size()/2);

    }

    public static void main(String[] args) {
        List<Integer> test1 = Arrays.asList(0, 1, 2, 4, 6, 5, 3);
        System.out.println(findMedian(test1));

    }

}

