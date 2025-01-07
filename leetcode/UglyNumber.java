package leetcode;

import java.util.ArrayList;
import java.util.List;

public class UglyNumber {

    public boolean isUgly(int n) {
        /**
         * basically we just need to check if we have just no rest division with 2, 3, 5
         * in this case we update everytime the n
         * finally just check if n is 1
         */
        if (n == 0) {
            return false;
        }
        while (n % 2 == 0) {
            n /= 2;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        while (n % 5 == 0) {
            n/=5;
        }
        return n==1;
    }

    public static void main(String[] args) {
        UglyNumber uglyNumber = new UglyNumber();
        System.out.println(uglyNumber.isUgly(6));
        System.out.println(uglyNumber.isUgly(1));
        System.out.println(uglyNumber.isUgly(14));
        System.out.println(uglyNumber.isUgly(-2147483648));



    }

}