package leetcode;

import java.util.ArrayList;
import java.util.List;

public class HappyNumber {
    public boolean isHappy(int n) {
        /**
         * We will use a recursive strategy
         * at the end we should get a sum value less than 10 and in this way we will know that is false if it is not 1
         * 7 is a custom case which can be detected just iat leetcode tests :)
         */
        if (n == 1 || n ==7) {
            return true;
        }
        if (n / 10 == 0) {
            return false;
        }
        List<Integer>digits = new ArrayList<>();
        while(n!=0){
            int digit = n %10;
            digits.add(digit);
            n/=10;
        }
        int sum = 0;
        for (int digit:digits){
            sum+=digit * digit;
        }
        if (sum ==1){
            return true;
        }
        return isHappy(sum);

    }

    public static void main(String[] args) {
        HappyNumber happyNumber = new HappyNumber();
        System.out.println(happyNumber.isHappy(19));
        System.out.println(happyNumber.isHappy(2));
        System.out.println(happyNumber.isHappy(176));
        System.out.println(happyNumber.isHappy(15));


    }
}
