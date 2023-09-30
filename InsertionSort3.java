package hackerRank;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class InsertionSort3 {
    public static void insertionSort(int[] A){
        for(int i = 1; i < A.length; i++){
            int value = A[i];//4 7 3
            int j = i - 1;//7
            while(j >= 0 && A[j] > A[j+1]){ //7>4
                A[j + 1] = A[j];//a[1] = 7
                A[j] = value;
                j = j - 1;//0
            }
            printArray(A);
            System.out.println();
        }

        printArray(A);
    }

    /*
    COde is taken from the insertionSort and it is just adapted
     */
    public static int runningTime(List<Integer> arr) {
        // Write your code here
        int result =0;
        for (int i =1;i<arr.size();i++){
            int value = arr.get(i);
            int j = i-1;
            while(j>=0 && arr.get(j)>arr.get(j+1)){
                arr.set(j+1, arr.get(j));//means in first step at i
                arr.set(j, value);
                j = j -1;
                result++;
            }
        }
        return result;
    }


    static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
    }
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        System.out.println("Dimension");
//        int n = in.nextInt();
//        int[] ar = new int[n];
//        for(int i=0;i<n;i++){
//            System.out.print("Element "+i+": ");
//            ar[i]=in.nextInt();
//        }
//        insertionSort(ar);

        List<Integer>list = Arrays.asList(2,1,3,1,2);
        System.out.println(runningTime(list));
    }
}

