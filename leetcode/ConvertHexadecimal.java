package leetcode;
import java.util.HashMap;

public class ConvertHexadecimal {
    public String toHex(int num) {
        String hexadecimalNumbers = "0123456789abcdef";
        StringBuilder result = new StringBuilder();
        //convert num in case it is negative
        if (num < 0) {
            num = (1 << 31) + num;
        }
        while (num != 0) {
            int rest = num % 16;
            result.append(hexadecimalNumbers.charAt(rest));
            num /= 16;
        }
        return result.reverse().toString();
    }

    public int toDec(String hexaNumber) {
        HashMap<Character, Integer> hexMap = new HashMap<>();
        hexMap.put('0', 0);
        hexMap.put('1', 1);
        hexMap.put('2', 2);
        hexMap.put('3', 3);
        hexMap.put('4', 4);
        hexMap.put('5', 5);
        hexMap.put('6', 6);
        hexMap.put('7', 7);
        hexMap.put('8', 8);
        hexMap.put('9', 9);
        hexMap.put('A', 10);
        hexMap.put('B', 11);
        hexMap.put('C', 12);
        hexMap.put('D', 13);
        hexMap.put('E', 14);
        hexMap.put('F', 15);

        int sum = 0;
        int power = 1;
        for (int i = hexaNumber.length() - 1; i >= 0; i--) {
            sum += hexMap.get(hexaNumber.charAt(i)) * power;
            power *= 16;
        }
        return sum;
    }

    public String binaryToHex(String binaryNumber) throws Exception {
        //we need to split the number into 4 to have a byte
        StringBuilder builder = new StringBuilder();
        for (int i = binaryNumber.length() - 1; i >= 0; i--) {
            if (builder.length() % 4 == 0 && i != binaryNumber.length() - 1) {
                builder.append(" ");
            }
            builder.append(binaryNumber.charAt(i));
        }
        String binaryComputed = builder.reverse().toString();
        String[] byteStringArray = computeArray(binaryComputed);

        // need to create a switchcase

        builder.delete(0, builder.length());
        return computeHexaNumber(byteStringArray, builder);
    }

    private String [] computeArray(String binaryComputed){
        String[] byteStringArray = binaryComputed.split(" ");
        for (int i = 0; i < byteStringArray.length; i++) {
            if (byteStringArray[i].length() != 4) {
                int difference = 4 - byteStringArray[i].length();
                if (difference == 3) {
                    byteStringArray[i] = "000" + byteStringArray[i];
                } else if (difference == 2) {
                    byteStringArray[i] = "00" + byteStringArray[i];
                } else {
                    byteStringArray[i] = "0" + byteStringArray[i];
                }
            }
        }
        return byteStringArray;
    }

    private String computeHexaNumber(String []byteStringArray, StringBuilder builder) throws Exception{
        for (String s : byteStringArray) {
            switch (s) {
                case "0000":
                    builder.append("0");
                    break;
                case "0001":
                    builder.append("1");
                    break;
                case "0010":
                    builder.append("2");
                    break;
                case "0011":
                    builder.append("3");
                    break;
                case "0100":
                    builder.append("4");
                    break;
                case "0101":
                    builder.append("5");
                    break;
                case "0110":
                    builder.append("6");
                    break;
                case "0111":
                    builder.append("7");
                    break;
                case "1000":
                    builder.append("8");
                    break;
                case "1001":
                    builder.append("9");
                    break;
                case "1010":
                    builder.append("A");
                    break;
                case "1011":
                    builder.append("B");
                    break;
                case "1100":
                    builder.append("C");
                    break;
                case "1101":
                    builder.append("D");
                    break;
                case "1110":
                    builder.append("E");
                    break;
                case "1111":
                    builder.append("F");
                    break;
                default:
                    throw new Exception("Something went wrong");

            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        ConvertHexadecimal convertHexadecimal = new ConvertHexadecimal();
        System.out.println(convertHexadecimal.toHex(-1));
        System.out.println(convertHexadecimal.toDec("FA"));
        try {
            System.out.println(convertHexadecimal.binaryToHex("110000"));
            System.out.println(convertHexadecimal.binaryToHex("1100111"));
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

}
