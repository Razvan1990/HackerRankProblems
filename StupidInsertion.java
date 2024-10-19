package hackerRank;

import org.checkerframework.checker.units.qual.A;

import java.util.Arrays;
import java.util.List;

public class StupidInsertion {

    public static void insertionSort1(int n, List<Integer> arr) {
        int controlValue = arr.get(n - 1);
        int minValue = getMinValue(arr);
        for (int i = n - 2; i >= 0; i--) {
            if (arr.get(i) > controlValue) {
                //we set the array now
                arr.set(i + 1, arr.get(i));
                for (int k = 0; k < n; k++) {
                    System.out.print(arr.get(k) + " ");
                }
                System.out.println();
            } else if (arr.get(i) < controlValue && controlValue !=minValue) {
                arr.set(i + 1, controlValue);
                for (int k = 0; k < n; k++) {
                    System.out.print(arr.get(k) + " ");
                }
                System.out.println();
                break;
            }
        }
        if (controlValue == minValue) {
            //we need to do this check in case we have the min value-> this will not be in the for loop
            arr.set(0, controlValue);
            for (int k = 0; k < n; k++) {
                System.out.print(arr.get(k) + " ");
            }
            System.out.println();


        }
    }



    private static int getMinValue(List<Integer> arr) {
        int min = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) < min) {
                min = arr.get(i);
            }
        }
        return min;
    }

    public static void main(String[] args) {
        List<Integer> myList1 = Arrays.asList(2, 4, 6, 8, 3);

        List<Integer> myList2 = Arrays.asList(1, 2, 4, 5, 3);

        List<Integer> myList3 = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10, 1);
        System.out.println("First");
        insertionSort1(5, myList1);
        System.out.println("Second");
        insertionSort1(5, myList2);
        System.out.println("Third");
        insertionSort1(10, myList3);


    }
}
