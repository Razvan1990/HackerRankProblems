package hackerRank;

import java.util.ArrayList;
import java.util.List;

public class SumVsXor {

    private static String invertString(String s){
        StringBuilder builder = new StringBuilder();
        int k = s.length()-1;
       while (k>=0){
           builder.append(s.charAt(k));
           k--;
       }
       return builder.toString();
    }

    private static List<Object> getBinaryNumber(long n){
        List<Object> myList = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        boolean isPowerOfTwo = false;
        long counterOnes = 0;long counterZeroes =0;
        while(n!=0){
            long digit = n%2;
            //digit = n&1
            if(digit ==1){
                counterOnes++;
            }else{
                counterZeroes++;
            }
            builder.append(digit);
            n/=2;
        }
        String result = builder.toString();
        String resultBinary = invertString(result);
        if(counterOnes==1){
            isPowerOfTwo = true;
        }

        myList.add(resultBinary);
        myList.add(isPowerOfTwo);
        myList.add(counterZeroes);
        return myList;
    }


    public static long sumXor(long n) {
        // Write your code here
        long result;
        List<Object> myList = getBinaryNumber(n);
        Boolean isPower = (Boolean) myList.get(1);
        Long areAllZeroes = (Long) myList.get(2);
        if (isPower){
            return n;
        }

        if(areAllZeroes==0){
            return 1;//which is just number + 0 = number ^0 : 111(7)+000 = 111 ^000
        }
        result = (long)Math.pow(2,3);
        return result;




    }

    public static void main(String[] args) {
        System.out.println(sumXor(5));
        System.out.println(sumXor(10));
        System.out.println(sumXor(4));
        System.out.println(sumXor(37));
    }


}
