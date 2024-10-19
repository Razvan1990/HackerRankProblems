package hackerRank;

public class PossiblePath {

    /*
    We need to find the gcd for each pair
    If the gcd are equal then we can reach that point

     */

    private static long getGreatestCommonDivisor(long a, long b){
        while(b!=0){
            long rest = a %b;
            a = b;
            b = rest;

        }
        return a;
    }

    public static String solve(long a, long b, long x, long y) {
        // Write your code here
       long divisor1 = getGreatestCommonDivisor(a, b);
       long divisor2 = getGreatestCommonDivisor(x, y);
       if (divisor1 == divisor2){
           return "YES";
       }else{
           return "NO";
       }

    }

    public static void main(String[] args) {
        System.out.println(solve(1,1,2,3));
        System.out.println(solve(1,2,2,3));
        System.out.println((solve(3,3,1,1)));
    }
}
