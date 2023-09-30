package hackerRank;

import java.util.ArrayList;
import java.util.List;

public class SmithNumbers {

    private static int getSumNumber(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }


    private static boolean checkIfNumberPrime(int n) {
        //start from 4 as it is the first nonPrime number
        for (int i = 4; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static int calculateSumNumbers(List<Integer> myList) {
        int totalSum = 0;
        for (int number : myList) {
            //if we have a prime number composed from at least 2 digits, then we need to calculate the sum of its digits
            if (number > 9) {
                totalSum += getSumNumber(number);
            } else {
                totalSum += number;
            }
        }
        return totalSum;
    }

    public static int solve(int n) {
        //need to store the original n, as we compute n in the process
        int originalNumber = n;
        List<Integer> primeNumbers = new ArrayList<>();
        //we will calculate n till we reach n==1, because we don't need 1 as a prime
        while (n != 1) {
            int i = 2;
            while (i < originalNumber / 2) { //we count till we have of the number cause we cannot have a rounded number if it's bigger than it's middle
                if (n % i == 0 && checkIfNumberPrime(i)) {
                    primeNumbers.add(i);
                    n = n / i;
                    //when we have a new n, we need to restart the process , seeing all numbers again
                    //go back to the first prime(except 1)
                    i = 2;
                    if(n==1){
                        break;
                    }
                } else if (n % i == 0 && !checkIfNumberPrime(i)) {
                    return 0;
                } else {
                    i++;
                }

            }

        }
        int sumNumberList = calculateSumNumbers(primeNumbers);
        return getSumNumber(originalNumber) == sumNumberList ? 1 : 0;


    }

    public static void main(String[] args) {
        System.out.println(solve(378));
        System.out.println(solve(85));
        System.out.println(solve(4937775));
    }
}
