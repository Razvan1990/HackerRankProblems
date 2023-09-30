package hackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaximumTrianglePerimeter {
    public static List<Integer> maximumPerimeterTriangle(List<Integer> sticks) {
        // Write your code here
        // we store what are the correct values as a list of lists
        List<Integer> results = new ArrayList<>();
        Collections.sort(sticks);
        int index = sticks.size() - 1;
        while (index - 2 >= 0) {
            if (sticks.get(index - 1) + sticks.get(index - 2) > sticks.get(index)) {
                results.add(sticks.get(index - 2));
                results.add(sticks.get(index - 1));
                results.add(sticks.get(index));
                return results;
            } else {
                index--;
            }
        }
        results.add(-1);
        return results;


    }

    public static void main(String[] args) {
        List<Integer>test1 = Arrays.asList(1,2,3,4,5,10);
        List<Integer>test2 = Arrays.asList(1,1,1,3,3);
        List<Integer>test3 = Arrays.asList(1,2,3);
        List<Integer>test4 = Arrays.asList(1,1,1,2,3,5);
        System.out.println(maximumPerimeterTriangle(test1));
        System.out.println(maximumPerimeterTriangle(test2));
        System.out.println(maximumPerimeterTriangle(test3));
        System.out.println(maximumPerimeterTriangle(test4));
    }


}
