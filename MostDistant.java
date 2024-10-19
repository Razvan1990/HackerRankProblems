package hackerRank;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MostDistant {
    /*
    create 2 lists from the original matrix
    - first list contains row values and get minimum
    - second list contains column values and get maximum

     */

    private static int getMinValue(List<Integer>myList){
        int min = myList.get(0);
        for (int i =1;i<myList.size();i++){
            if (min >myList.get(i)){
                min = myList.get(i);
            }
        }
        return min;
    }

    private static int getMaxValue(List<Integer>myList){
        int max = myList.get(0);
        for (int i =1;i<myList.size();i++){
            if (max < myList.get(i)){
                max = myList.get(i);
            }
        }
        return max;
    }

    private static double putDecimals(double num) {
        DecimalFormat df = new DecimalFormat("0.000000");
        return Double.parseDouble(df.format(num));
    }



    public static double solve(List<List<Integer>> coordinates) {
        // Write your code here
        List<Integer> rowValues = new ArrayList<>();
        List<Integer> columnValues = new ArrayList<>();

        for(List<Integer>l:coordinates){
            rowValues.add(l.get(0));
            columnValues.add(l.get(1));
        }

        int minValue = getMinValue(rowValues);
        int maxValue = getMaxValue(columnValues);
        double result = Math.abs(maxValue - minValue);
        double resultConverted = putDecimals(result);
        return resultConverted;


    }

    public static void main(String[] args) {
        List<Integer> coord1 = Arrays.asList(-1, 0);
        List<Integer> coord2 = Arrays.asList(1, 0);
        List<Integer> coord3 = Arrays.asList(0, 1);
        List<Integer> coord4 = Arrays.asList(0, -1);
        List<List<Integer>>test1 = new ArrayList<>();
        test1.add(coord1);
        test1.add(coord2);
        test1.add(coord3);
        test1.add(coord4);
        System.out.println(solve(test1));
    }




}
