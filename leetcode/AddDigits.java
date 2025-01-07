package leetcode;

public class AddDigits {

    public int addDigits(int num) {
        /**
         * we need a recursive call till we have a sum less than 10
         */

        if (num < 10) {
            return num;
        }
        int sumNumbers = 0;
        while (num != 0) {
            sumNumbers += num % 10;
            num /= 10;
        }
        return addDigits(sumNumbers);
    }

    public static void main(String[] args) {
        AddDigits adder = new AddDigits();
        System.out.println(adder.addDigits(38));
        System.out.println(adder.addDigits(0));
    }
}
