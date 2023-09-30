package hackerRank;

public class FlippingBits {

    private static String invertString (String s){
        StringBuilder result= new StringBuilder();
        int k = s.length()-1;
        while(k>=0){
            result.append(s.charAt(k));
            k--;
        }
        return result.toString();
    }

    /**
     *
     * @param number
     * @return String of 32 bits binary
     * 1. We need to convert the number into binary, but as a String to not have overflow
     * 2. We must invert the string to have the correct value
     * 3. We then need to check every digit following:
     *  a. If it is 1 ->convert to 0
     *  b. If it is 0 -> convert to 1
     * 4. Finally, we need to add the extra zeroes in order to have the 32 bits length, by comparing the length of the string and adding 0 as difference in front
     *
     */

    private static String getInvertedBinaryNumber(long number) {
        StringBuilder builder = new StringBuilder();
        while (number != 0) {
            long rest = number % 2;
            builder.append(rest);
            number/=2;
        }

        String resultTemp = invertString(builder.toString());
        builder.delete(0, builder.length());
        StringBuilder adder = new StringBuilder();
        for (int i =0;i<resultTemp.length();i++){
            if(resultTemp.charAt(i)=='0'){
                builder.append('1');
            }else{
                builder.append('0');
            }

        }
        for (int i =0;i<32 - resultTemp.length();i++){
            adder.append('0');
        }



        String bits32TempResult = adder + resultTemp;
        builder.delete(0, builder.length());
        for (int i =0;i<bits32TempResult.length();i++){
            if(bits32TempResult.charAt(i)=='0'){
                builder.append('1');
            }
            else{
                builder.append('0');
            }
        }
        return builder.toString();

    }

    /**
     *
     * @param s
     * @return the final value as a long number
     * 1.DO NOT FORGET TO MAKE ALL PARAMETERS LONG (SUM, POWER) cause it gives overflow
     * 2. We count from backwards of the string and the result is the sum of the char value * power
     * 3. At every step power is growing by 2, as it is a binary number -> like in the binary/decimal conversion
     */

    private static long convertToLongNumber(String s){
        long sum =0;long power = 1;
        for(int i =s.length()-1;i>=0;i--){
            int charValue = Integer.parseInt(String.valueOf(s.charAt(i)));
            sum+= (long) charValue * power;
            power*=2;
        }
        return Math.abs(sum);
    }


    public static long flippingBits(long n) {
        // Write your code here
        String invertedNumber = getInvertedBinaryNumber(n);
        return convertToLongNumber(invertedNumber);



    }

    public static void main(String[] args) {
        System.out.println(flippingBits(9));
        System.out.println(flippingBits(2147483647));
        System.out.println(flippingBits(0));
        System.out.println(flippingBits(802743475));
        System.out.println(flippingBits(35601423));


    }


}
