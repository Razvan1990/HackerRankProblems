package leetcode;

public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        long numberPower = 0;
        boolean result = false;
        int power = 0;
        if (n == 0) {
            return false;
        }
        while (numberPower <= n) {
            numberPower = (long) Math.pow(2, power);
            power += 1;
            if (numberPower == n) {
                result = true;
                break;
            }
        }
        return result;
    }
}

