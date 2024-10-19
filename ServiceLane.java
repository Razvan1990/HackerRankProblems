package hackerRank;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ServiceLane {

    private static int getMinimum(List<Integer> myList){
        int min = myList.get(0);
        for (int i =1 ;i<myList.size();i++){
            if( myList.get(i)<min){
                min = myList.get(i);
            }
        }
        return min;
    }


    public static List<Integer> serviceLane(int n,List<Integer>width, List<List<Integer>> cases) {
        // Write your code here

        /*
        STDIN               Function
-----               --------
8 5                 n = 8, t = 5
2 3 1 2 3 2 3 3     width = [2, 3, 1, 2, 3, 2, 3, 3]
0 3                 cases = [[0, 3], [4, 6], [6, 7], [3, 5], [0, 7]]
4 6
6 7
3 5
0 7


1
2
3
2
1


   |HIGHWAY|Lane|    ->    Width

0: |       |--|            2
1: |       |---|           3
2: |       |-|             1
3: |       |--|            2
4: |       |---|           3
5: |       |--|            2
6: |       |---|           3
7: |       |---|           3

widths = indices
list2 = [[entry1 exit1] [entry2 exit2]...]




         */

        //the target is to find the minimum of that segment-> min is  the final value
        List<Integer>results = new ArrayList<>();
        for (List<Integer>testcaseList:cases){
            int startIndex = testcaseList.get(0);
            int endIndex = testcaseList.get(1);
            List<Integer>tempResult = new ArrayList<>();
            for (int i = startIndex;i<=endIndex;i++){
                tempResult.add(width.get(i));
            }
            int min = getMinimum(tempResult);
            results.add(min);
        }
        return results;

    }

    public static void main(String[] args) {
        List<Integer> width1 = Arrays.asList(2,3,2,1);
        List<Integer>case1_1 = Arrays.asList(0,1);
        List<Integer>case1_2 = Arrays.asList(1,3);
        List<List<Integer>>case1 = new ArrayList<>();
        case1.add(case1_1);
        case1.add(case1_2);

        List<Integer> width2 = Arrays.asList(2,3,1,2,3,2,3,3);
        List<Integer>case2_1 = Arrays.asList(0,3);
        List<Integer>case2_2 = Arrays.asList(4,6);
        List<Integer>case2_3 = Arrays.asList(6,7);
        List<Integer>case2_4 = Arrays.asList(3,5);
        List<Integer>case2_5 = Arrays.asList(0,7);
        List<List<Integer>>case2 = new ArrayList<>();
        case2.add(case2_1);
        case2.add(case2_2);
        case2.add(case2_3);
        case2.add(case2_4);
        case2.add(case2_5);

        System.out.println(serviceLane(4,width1,case1));
        System.out.println(serviceLane(8,width2,case2));




    }


}
