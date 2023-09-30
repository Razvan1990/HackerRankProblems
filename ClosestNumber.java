package hackerRank;

public class ClosestNumber {

   /* private static int findSmallestMultiplier(int a, int b){
        int original_a = a;
        int original_b = b;
        int divisor;

        while(b!=0){
            divisor = a%b;
            a = b;
            b = divisor;
        }
        return original_a *original_b/a;
    }*/

    public static int closestNumber(int a, int b, int x) {
        // Write your code here
        if (b == 0) {
            return 0;
        }

        //int smallMultiplier = findSmallestMultiplier(a,b);
        int poweredNumber = (int) Math.pow(a, b);
        if (poweredNumber % x == 0) {
            return poweredNumber;
        } else {
            int divisor = poweredNumber / x;
            return divisor * x;
        }


    }

    public static void main(String[] args) {
        System.out.println(closestNumber(349, 1, 4));
        System.out.println(closestNumber(395, 1, 7));
        System.out.println(closestNumber(4, -2, 2));
        System.out.println(closestNumber(674,2,6));
    }


}
