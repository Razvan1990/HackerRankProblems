package hackerRank;

import java.util.ArrayList;
import java.util.List;

public class DigitsArray {
    public int[] plusOne(int[] digits) {
        //we need to transform the digits into a number
        long number =0;
        for (int digit:digits){
            number = number*10 + digit;
        }
        long finalNumber = number +1;
        List<Integer> digitList = numberTransformation(finalNumber);
        int [] result = new int[digitList.size()];
        for (int i =0;i<digitList.size();i++){
            result[i] = digitList.get(i);
        }
        return result;
    }

    private List<Integer> numberTransformation (long number){
        List<Integer> resultArray = new ArrayList<>();
        while(number!=0){
            int digit = (int) (number %10);
            resultArray.add(0, digit);
            number/=10;
        }
        return resultArray;
    }

    private void showArray(int [] myArray){
        for (int n:myArray){
            System.out.print(n+" ");
        }
    }

    public static void main(String[] args) {
        DigitsArray digitsArray = new DigitsArray();
        int [] exArray1 = {1,2,3};
        int [] exArray2 = {4,3,2,1};
        int [] exArray3 = {9};
        int [] result1 = digitsArray.plusOne(exArray1);
        int [] result2 = digitsArray.plusOne(exArray2);
        int [] result3 = digitsArray.plusOne(exArray3);
        digitsArray.showArray(result1);
        System.out.println();
        digitsArray.showArray(result2);
        System.out.println();
        digitsArray.showArray(result3);
    }

}
