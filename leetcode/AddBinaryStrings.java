package leetcode;

public class AddBinaryStrings {
    public String addBinary(String a, String b) {
        if (a.equals("0") && b.equals("0")) {
            return "0";
        }
        if (a.equals("0")) {
            return b;
        }
        if (b.equals("0")) {
            return a;
        }
        long numberDecimalOne = convertToDecimalNumber(a);
        long numberDecimalTwo = convertToDecimalNumber(b);
        long sum = numberDecimalOne + numberDecimalTwo;
        return convertNumberToBinaryString(sum);
    }


    private long convertToDecimalNumber(String number) {
        long decimalNumber = 0;
        int power = 0;
        for (int i = number.length() - 1; i >= 0; i--) {
            decimalNumber += (long) Character.getNumericValue(number.charAt(i)) * (int) Math.pow(2, power);
            power += 1;
        }
        return decimalNumber;
    }

    private String convertNumberToBinaryString(long numberCalculated) {
        StringBuilder builder = new StringBuilder();
        while (numberCalculated != 0) {
            long rest = numberCalculated % 2;
            builder.append(rest);
            numberCalculated /= 2;
        }
        return revertString(builder.toString());
    }

    private String revertString(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            result.append(s.charAt(i));
        }
        return result.toString();

    }


    public static void main(String[] args) {
        AddBinaryStrings addBinaryStrings = new AddBinaryStrings();
        String ex1 = "11";
        String ex2 = "1";
        String ex3 = "1010";
        String ex4 = "1011";
        String ex5 = "1";
        String ex6 = "1";

        System.out.println(addBinaryStrings.addBinary(ex1, ex2));
        System.out.println(addBinaryStrings.addBinary(ex3, ex4));
        System.out.println(addBinaryStrings.addBinary(ex5, ex6));
    }
}
