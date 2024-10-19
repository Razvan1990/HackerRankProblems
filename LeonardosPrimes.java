package hackerRank;

import java.util.ArrayList;
import java.util.List;

public class LeonardosPrimes {


    private static boolean checkIfNumberPrime(int number) {
        int counter = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                counter++;
            }
        }
        return counter == 2;

    }

    /**
     * @param n -> value given
     * @return int result number of primes
     * this is done based on the example from problem
     */

    //time limit not working
    public static int primeCount(long n) {
        // Write your code here
        int counter = 0;

        List<Integer> primes = new ArrayList<>();
        if (n == 1) {
            return 0;
        }
        for (int i = 2; i <= n; i++) {
            if (checkIfNumberPrime(i)) {
                primes.add(i);
            }
        }
        //check now how many numbers are necessary: multiply factors till n is still bigger
        long multiplication = primes.get(0);
        counter++;
        for (int i = 1; i < primes.size(); i++) {
            multiplication *= primes.get(i);
            if (multiplication > n) {
                break;
            } else {
                counter++;
            }
        }
        return counter;


    }

    public static void main(String[] args) {
        System.out.println(primeCount(100));
        System.out.println(primeCount(1));
        System.out.println(primeCount(2));
        System.out.println(primeCount(3));
        System.out.println(primeCount(500));
        System.out.println(primeCount(5000));
        //System.out.println(primeCount(10000000000));
    }
}
