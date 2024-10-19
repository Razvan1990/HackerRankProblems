package hackerRank;

public class ReversingInteger {
    public int reverse(int x) {
        /**
         * need to handle cases
         * 1. x is negative and has a -
         * 2. new number is out of range -> return 0
         *
         */
        int result =0;
        if (x==0){
            return result;
        }
        result = (int)getInvertedNumber(x);
    return result;
    }


    private long getInvertedNumber(int x){
        long inverted =0;
        while(x!=0){
            inverted = x%10 + inverted *10;
            if (inverted > Integer.MAX_VALUE){
                return 0;
            }
            if (inverted < Integer.MIN_VALUE){
                return 0;
            }
            x/=10;
        }
        return inverted;
    }

    public static void main(String[] args) {
        ReversingInteger reversingInteger = new ReversingInteger();
        int result = reversingInteger.reverse(1234567898);
        int result2 = reversingInteger.reverse(-2147483648);
        System.out.println(result);
        System.out.println(result2);


    }
}
