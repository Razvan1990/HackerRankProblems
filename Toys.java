package hackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Toys {

    public static int toys(List<Integer> w) {
        // Write your code here
        Collections.sort(w);
        int threshold = 4;
        int result = 1;
        int first = 0;
        int second = 1;
        while(second<w.size()){
            int difference = w.get(second) - w.get(first);
            if (difference>threshold){
                result++;
                first = second;
                second++;
            }
            else{
                second++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer>list1 = Arrays.asList(1,2,3,4,5,10,11,12,13);
        List<Integer>list2 = Arrays.asList(1,2,3,21,7,12,14,21);
        System.out.println(toys(list1));
        System.out.println(toys(list2));

    }
}
