/**
 * A self-dividing number is a number that is divisible by every digit it contains.
 * <p>
 * For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
 * A self-dividing number is not allowed to contain the digit zero.
 * <p>
 * Given two integers left and right, return a list of all the self-dividing numbers in the range [left, right] (both inclusive).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: left = 1, right = 22
 * Output: [1,2,3,4,5,6,7,8,9,11,12,15,22]
 * Example 2:
 * <p>
 * Input: left = 47, right = 85
 * Output: [48,55,66,77]
 */

package hackerRank.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SelfDividingNumbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            List<Integer> digitList = getDigitsOfNumber(i);
            if (isSelfDiving(digitList, i)) {
                ans.add(i);
            }
        }
        return ans;
    }

    private List<Integer> getDigitsOfNumber(int number) {
        List<Integer> digits = new ArrayList<>();
        while (number != 0) {
            int digit = number % 10;
            digits.add(digit);
            number /= 10;
        }

        return digits;
    }

    private boolean isSelfDiving(List<Integer> digits, int number) {
        for (int digit : digits) {
            //check that is not 0 -> false in this case and not get div by zero
            if (digit == 0){
                return false;
            }
            if (number % digit != 0) {
                return false;
            }
        }
        return true;
    }

    static void main() {
        SelfDividingNumbers sdn = new SelfDividingNumbers();
        System.out.println(sdn.selfDividingNumbers(1,22));
        System.out.println(sdn.selfDividingNumbers(47,85));
    }

}
