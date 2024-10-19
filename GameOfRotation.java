package hackerRank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*

RESULT IS CORRECT BUT DON'T UNDERSTAND HOW TO PUT INPUT IN HACKERRANK PROBLEM

 */

public class GameOfRotation {

    private static int rotateAndCalculate(int[] myArray) {
        List<Integer>sumValues = new ArrayList<>();
        int originalSum = getPMeanResult(myArray);
        sumValues.add(originalSum);
        for (int i = 0; i < myArray.length - 1; i++) {
            int temp = myArray[0];
            for (int k = 0; k < myArray.length - 1; k++) {
                myArray[k] = myArray[k + 1];
            }
            myArray[myArray.length - 1] = temp;
            int result = getPMeanResult(myArray);
            sumValues.add(result);
        }
        return getMaxValue(sumValues);
    }

    private static int getPMeanResult(int[] myArray) {
        int sum = 0;
        for (int i = 0; i < myArray.length; i++) {
            sum += (i + 1) * myArray[i];
        }
        return sum;
    }

    private static int getMaxValue(List<Integer> sumList){
        int max = sumList.get(0);
        for (int i =1;i<sumList.size();i++){
            if(sumList.get(i)>max){
                max = sumList.get(i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Size of array");
        int N = scanner.nextInt();
        int [] arrayTest = new int[N];
        for (int i =0;i<N;i++){
            System.out.print("Value at index " +i+" ");
            arrayTest[i] = scanner.nextInt();
        }
        int max = rotateAndCalculate(arrayTest);
        System.out.println(max);
    }
}

