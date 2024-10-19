package hackerRank;

public class TheGreaterXor {

    public static long theGreatXor(long x) {
        // Write your code here
        /**
         * basically if we see the results, we can spot the following pattern. The number of values that satisfy the condition is exactly the sum of Math.pow(2, indexOf 0) in the number
         * We just need to keep track of the power, divide by 2 and see if the remainder is 0. If so, the sum will be sum+=power
         */
        long sum = 0;
        long pow = 1;
        while(x!=0){
            if (x%2==0){
                sum+=pow;
            }
            pow*=2;
            x/=2;
        }
        return sum;

    }

    public static void main(String[] args) {
        System.out.println(theGreatXor(2));
        System.out.println(theGreatXor(5));
        System.out.println(theGreatXor(100));
        System.out.println(theGreatXor(10));
        System.out.println(theGreatXor(100000));


    }
}
