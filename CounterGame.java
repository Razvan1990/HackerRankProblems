package hackerRank;


import java.util.HashMap;


public class CounterGame {

    private static String invertString(String s) {
        StringBuilder builder = new StringBuilder();
        int k = s.length() - 1;
        while (k >= 0) {
            builder.append(s.charAt(k));
            k--;
        }
        return builder.toString();
    }

    private static HashMap<Character, Integer> frequencyCharacterMap(String s) {
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (freqMap.containsKey(s.charAt(i))) {
                freqMap.put(s.charAt(i), freqMap.get(s.charAt(i)) + 1);
            } else {
                freqMap.put(s.charAt(i), 1);
            }
        }
        return freqMap;
    }


    private static String getNumberBinaryAsString(long n) {
        StringBuilder builder = new StringBuilder();
        while (n != 0) {
            long remaining = n % 2;
            builder.append(remaining);
            n /= 2;
        }
        String resultInverted = builder.toString();
        return invertString(resultInverted);

    }

    private static String createDifferenceNumberBinary(String number, String powerNumber) {
        StringBuilder builder = new StringBuilder();
        int count = 0;
        for (int i = 0; i < number.length(); i++) {
            //in order to not keep in the string the leading zeroes
            if (number.charAt(i) == '1' && powerNumber.charAt(i) == '0') {
                builder.append('1');
                break;
            } else {
                count++;
            }
        }
        for (int i = count + 1; i < number.length(); i++) {
            builder.append(number.charAt(i));
        }
        return builder.toString();
    }


    private static boolean checkIfNumberIsPowerOfTwo(long n) {
        String number = getNumberBinaryAsString(n);
        HashMap<Character, Integer> frequencyResult = frequencyCharacterMap(number);
        for (char c : frequencyResult.keySet()) {
            //if it contains just a 1(the one from the beginning) then it's a power of 2
            if (c == '1' && frequencyResult.get(c) == 1) {
                return true;
            }
        }
        return false;
    }

    //convert binary string number into decimal  long number
    private static long convertBinaryToDecimal(String s) {
        long result = 0;
        long power = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                result += Long.parseLong(String.valueOf(s.charAt(i))) * power;
            }
            power *= 2;
        }


        return result;
    }

    private static long getDifferenceOfNumbers(long n) {
        String number = getNumberBinaryAsString(n);
        int lengthString = number.length();
        StringBuilder builder = new StringBuilder();
        //create lower power as string
        builder.append("1");//needs to start with 1
        for (int i = 0; i < lengthString - 1; i++) {
            builder.append("0");
        }
        String power = builder.toString();
        //get now the difference subtracting character with character
        String differenceNumber = createDifferenceNumberBinary(number, power);
        return convertBinaryToDecimal(differenceNumber);

    }

    public static String counterGame(long n) {
        if (n == 1) {
            return "Richard";
        }
        if (checkIfNumberIsPowerOfTwo(n)) {
            int count = 0;
            while (n != 1) {
                n /= 2;
                count++;
            }
            if (count % 2 == 1) {
                return "Louise";
            } else {
                return "Richard";
            }
        } else {
            long difference = getDifferenceOfNumbers(n);//Louise
            if (difference == 1) {
                return "Louise";
            }
            int count = 0;
            //do the same till we find the number which is power of two
            while (!checkIfNumberIsPowerOfTwo(difference)) {
                difference = getDifferenceOfNumbers(difference);
                count++;
            }
            //do as in the 'if' part and continue counting
            while (difference != 1) {
                difference /= 2;
                count++;
            }
            //as the first step was making the difference, which is done by Louis', in this case the winners are different
            if (count % 2 == 1) {
                return "Richard";
            } else {
                return "Louise";
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(counterGame(156));
        System.out.println(counterGame(132));
        System.out.println(counterGame(6));
        System.out.println(counterGame(1560834904));



    }
}
