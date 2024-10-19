package hackerRank;

public class SherlockAndDivisors {

    public static int divisors(int n) {
        // Write your code here
        /*
        1. Create a list of actual divisors
        2. Check the list and then see if it is divisible by 2

        In order to not create a list:
        1. Check if it is divisor
        2. Check in the same statement if the divisor is divisible by 2
         */
        int result = 0;
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                if (i % 2 == 0) {
                    result++;
                }
            }
        }
        return result;

    }

    public static int divisors2(int n) {
        int result = 0;
        if (n % 2 != 0) {
            return 0;
        } else {

            // no need for increment all the time as we just check divisors of 2 => +2 increment
            for (int i = 2; i <= n; i += 2) {
                if (n % i == 0) {
                    if (i % 2 == 0) {
                        result++;
                    }
                }
            }
        }
        return result;
    }



    public static void main(String[] args) {
        System.out.println(divisors(9));
        System.out.println(divisors(8));
        System.out.println(divisors2(9));
        System.out.println(divisors2(8));
    }
}
