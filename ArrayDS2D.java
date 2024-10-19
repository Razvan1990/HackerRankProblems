package hackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayDS2D {


    private static int getMaxOfList(List<Integer>myList){
        int max = myList.get(0);
        for(int i =1;i<myList.size();i++){
            if(myList.get(i)>max){
                max = myList.get(i);
            }
        }
        return max;
    }

    public static int hourglassSum(List<List<Integer>> arr) {
        // Write your code here
        List<Integer> sums = new ArrayList<>();
        int i = 0;
        int j = 0;
        int count = 3;
        int countColumns = 0;
        int countRows = 0;
        while (countRows < arr.size()-2) {
            j = countColumns;
            i = countRows;
            int sum = 0;
            for (int idx = 0; idx < count; idx++) {
                sum += arr.get(i).get(j);
                j++;
            }
            i++;
            j-=2;
            sum += arr.get(i).get(j);
            i++;
            j--;
            for (int idx = 0; idx < count; idx++) {
                sum += arr.get(i).get(j);
                j++;
            }
            sums.add(sum);
            countColumns++;
            if (j == arr.size()) {
                countRows++;
                countColumns = 0;
            }

        }
        return getMaxOfList(sums);


    }

    public static void main(String[] args) {
        List<List<Integer>>myList1 = new ArrayList<>();
        List<Integer>row11 = Arrays.asList(1, 1, 1, 0, 0, 0);
        List<Integer>row12 = Arrays.asList(0, 1, 0, 0, 0, 0);
        List<Integer>row13 = Arrays.asList(1, 1, 1, 0, 0, 0);
        List<Integer>row14 = Arrays.asList(0, 0, 0, 0, 0, 0);
        List<Integer>row15 = Arrays.asList(0, 0, 0, 0, 0, 0);
        List<Integer>row16 = Arrays.asList(0, 0, 0, 0, 0, 0);
        myList1.add(row11); myList1.add(row12); myList1.add(row13); myList1.add(row14); myList1.add(row15); myList1.add(row16);
//        for (List<Integer> integers : myList1) {
//            for (Integer integer : integers) {
//                System.out.print(integer + " ");
//            }
//            System.out.println();
//        }
        List<List<Integer>>myList2 = new ArrayList<>();
        List<Integer>row21 = Arrays.asList(-9, -9, -9, 1, 1, 1);
        List<Integer>row22 = Arrays.asList(0, -9, 0, 4, 3, 2);
        List<Integer>row23 = Arrays.asList(-9, -9, -9, 1, 2, 3);
        List<Integer>row24 = Arrays.asList(0, 0, 8, 6, 6, 0);
        List<Integer>row25 = Arrays.asList(0, 0, 0, -2, 0, 0);
        List<Integer>row26 = Arrays.asList(0, 0, 1, 2, 4, 0);
        myList2.add(row21); myList2.add(row22); myList2.add(row23); myList2.add(row24); myList2.add(row25); myList2.add(row26);

        List<List<Integer>>myList3 = new ArrayList<>();
        List<Integer>row31 = Arrays.asList(1, 1, 1, 0, 0, 0);
        List<Integer>row32 = Arrays.asList(0, 1, 0, 0, 0, 0);
        List<Integer>row33 = Arrays.asList(1, 1, 1, 0, 0, 0);
        List<Integer>row34 = Arrays.asList(0, 0, 2, 4, 4, 0);
        List<Integer>row35 = Arrays.asList(0, 0, 0, 2, 0, 0);
        List<Integer>row36 = Arrays.asList(0, 0, 1, 2, 4, 0);
        myList3.add(row31); myList3.add(row32); myList3.add(row33); myList3.add(row34); myList3.add(row35); myList3.add(row36);

        System.out.println(hourglassSum(myList1));
        System.out.println(hourglassSum(myList2));
        System.out.println(hourglassSum(myList3));
        
        
    }
}
