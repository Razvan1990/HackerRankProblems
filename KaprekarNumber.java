package hackerRank;

import java.math.BigInteger;

public class KaprekarNumber {

    //it also can be used when you have numbers squared which are not even length -> 88209 = 297 *297
    private static boolean isKaprekar(int n) {
        if (n==1) return true;
        //check for 2 and 3 to not create exception -> these don't match
        if (n==2 || n==3){
            return false;
        }
        long squareNumber = (long) Math.pow(n, 2);
        String squareNumberBI = String.valueOf(squareNumber);
        //check the case where you have 1 -> returns true
        StringBuilder builder = new StringBuilder();
        int middle = squareNumberBI.length() / 2;
        //compute the 2 numbers into the stringbuilder
        for (int i = 0; i < middle; i++) {
            builder.append(squareNumberBI.charAt(i));
        }
        int firstMiddle = Integer.parseInt(builder.toString());
        //clear the stringbuilder now
        builder.delete(0, builder.length());
        for (int i = middle; i < squareNumberBI.length(); i++) {
            builder.append(squareNumberBI.charAt(i));
        }
        //check if it is not '000' or soemthing
        int secondMiddle = Integer.parseInt(builder.toString());

        //check now if the two numbers add
        return firstMiddle + secondMiddle == n;


    }



    public static void kaprekarNumbers(int p, int q) {
        // Write your code here
        //using a count to check if the no value from the range is kaprekar
        int counter = 0;
        for (int i = p; i <= q; i++) {
            if (isKaprekar(i)) {
                System.out.print(i + " ");
                counter++;
            }
        }
        if(counter==0){
            System.out.print("INVALID RANGE");
        }


    }

    public static void main(String[] args) {
        //test for overflow
        long x = (long) Math.pow(99999, 2);
        System.out.println(x);
        int y = Integer.parseInt("000");
        System.out.println(y);

        kaprekarNumbers(1, 100);
        kaprekarNumbers(100, 300);
    }
}
