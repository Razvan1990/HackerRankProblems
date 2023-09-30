package hackerRank;

import java.util.*;

public class SeparateTheNumbers {

//    private static int createTwoDigitsNumber(char a, char b) {
//        StringBuilder builder = new StringBuilder();
//        builder.append(a);
//        builder.append(b);
//        return Integer.parseInt(builder.toString());
//    }
//
//
//    public static String compressSameStringDigit(String s) {
//        String result = "";
//        StringBuilder builder = new StringBuilder();
//        for (int i = 0; i < s.length() - 1; i++) {
//            if (s.charAt(i) == s.charAt(i + 1)) {
//                builder.append(s.charAt(i));
//            } else {
//                if (builder.length() == 0) {
//                    return result;
//                } else {
//                    if (builder.charAt(0) != '9') {
//                        return builder.toString();
//                    } else {
//                        builder.append(s.charAt(i));
//                        return builder.toString();
//                    }
//                }
//            }
//        }
//        return result;
//    }
//
//    private static int getIndexToContinue(long nr) {
//        int counter = 0;
//        while (nr != 0) {
//            nr /= 10;
//            counter++;
//        }
//        return counter;
//    }
//
//    private static int getDigit(long nr) {
//        int digit = 0;
//        while (nr != 0) {
//            digit = (int) nr % 10;
//            nr /= 10;
//        }
//        return digit;
//    }
//
//    private static long findNextNumber(long number, int value, int digit, String s) {
//        long result = 0;
//        StringBuilder builder = new StringBuilder();
//        if (digit != 9) {
//            int counter = 0;
//            for (int i = value; i < s.length(); i++) {
//                if (s.length() - getIndexToContinue(number) < getIndexToContinue(number)) {
//                    return result;
//                } else {
//                    builder.append(s.charAt(i));
//                    counter++;
//                    if (counter == getIndexToContinue(number)) {
//                        String stringResult = builder.toString();
//                        return Long.parseLong(stringResult);
//                    }
//                }
//            }
//        } else {
//            int counter = 0;
//            for (int i = value; i < s.length(); i++) {
//                if (s.length() - getIndexToContinue(number) < getIndexToContinue(number) + 1) {
//                    return result;
//                } else {
//                    builder.append(s.charAt(i));
//                    counter++;
//                    if (counter == getIndexToContinue(number) + 1 && number % 10 == 9) {
//                        String stringResult = builder.toString();
//                        return Long.parseLong(stringResult);
//                    } else if (counter == getIndexToContinue(number) && number % 10 != 9) {
//                        String stringResult = builder.toString();
//                        return Long.parseLong(stringResult);
//
//                    }
//                }
//            }
//
//        }
//        return result;
//    }
//
//    public static boolean continueLoop(long number, long nextNumber) {
//        boolean result = false;
//        if (nextNumber - number == 1) {
//            return true;
//        }
//        return false;
//    }
//
//
//    private static List<Integer> makeIntegerNumbers(String s, int position) {
//        List<Integer> integers = new ArrayList<>();
//        int finalPosition = 0;
//        for (int i = position; i < s.length(); ) {
//            int number = Integer.parseInt(String.valueOf(s.charAt(position)));
//            integers.add(number);
//            while (s.length() - i >= 2) {
//                number = createTwoDigitsNumber(s.charAt(i + 1), s.charAt(i + 2));
//                integers.add(number);
//                i += 2;
//            }
//            finalPosition = i;
//            break;
//        }
//        if (s.length() - finalPosition != 1) {
//            integers.add(0);
//        }
//        Collections.sort(integers);
//        return integers;
//
//    }
//
//    private static boolean checkListDifferences(List<Integer> list) {
//        boolean result = true;
//        for (int i = 0; i < list.size() - 1; i++) {
//            if (list.get(i + 1) - list.get(i) == 1) {
//
//            } else {
//                result = false;
//            }
//        }
//        return result;
//    }
//
//    public static void separateNumbers(String s) {
//        // Write your code here
//        StringBuilder builder = new StringBuilder();
//        boolean condition = true;
//        String first = compressSameStringDigit(s);
//
//        if (s.length() == 1) {
//            System.out.println("NO");
//            return;
//        }
//        if (s.length()==2){
//            if(s.charAt(1)-s.charAt(0)==1){
//                System.out.println("YES "+s.charAt(0));
//                return;
//            }
//            else{
//                System.out.println("NO");
//                return;
//            }
//        }
//
//        if (s.charAt(0) == '0') {
//            System.out.println("NO");
//            return;
//        }
//        if (first.equals("")) {
////            if (s.charAt(0) == '9') {
////                List<Integer> myList = makeIntegerNumbers(s, 0);
////                if (myList.contains(0)) {
////                    System.out.println("NO");
////                    return;
////                }else if(myList.size()==1 && checkListDifferences(myList)){
////                    int digit = getDigit(myList.get(0));
////                    System.out.println("YES "+digit);
////                }
////                else if (checkListDifferences(myList)) {
////                    System.out.println("YES " + myList.get(0));
////                    return;
////                } else {
////                    System.out.println("NO");
////                    return;
////                }
////            } else {
//                List<Long> numbers = new ArrayList<>();
//                int poz1 = 0;
//                int poz2 = 1;int counter =0;
//                builder.append(s.charAt(poz1));
//                while (poz2 <= s.length()) {
//                    if (poz2 == s.length() - 1) {
//                        builder.append(s.charAt(poz2));
//                        long finalNumber = Long.parseLong(builder.toString());
//                        numbers.add(finalNumber);
//                        break;
//                    } else if (s.charAt(poz1) != s.charAt(poz2)) {
//                        builder.append(s.charAt(poz2));
//                        poz2++;counter++;
//
//                    } else {
//                        if (counter == 0) {
//                            builder.append(s.charAt(poz2));
//                            long number = Long.parseLong(builder.toString());
//                            numbers.add(number);
//                            builder.delete(0, s.length()-1);
//                            poz1 = poz1 + builder.length();
//                            builder.append(poz1);
//                            poz2 = poz1 + 1;
//                        } else {
//                            long number = Long.parseLong(builder.toString());
//                            numbers.add(number);
//                            builder.delete(0, s.length() - 1);
//                            poz1 = poz2;
//                            builder.append(s.charAt(poz1));
//                            poz2 = poz1 + 1;
//                            counter = 0;
//                        }
//                    }
//                }
//                for (int i = 0; i < numbers.size() - 1; i++) {
//                    if (numbers.get(i + 1) - numbers.get(i) == 1) {
//                    } else {
//                        condition = false;
//                    }
//                }
//                if (condition) {
//                    if(numbers.size()==1){
//                        int digit = getDigit(numbers.get(0));
//                        System.out.println("YES "+digit);return;
//                    }
//                    System.out.println("YES " + numbers.get(0));
//                    return;
//                } else {
//                    System.out.println("NO");
//                    return;
//                }
//
//
//            }
//
//        if (s.charAt(0) == s.charAt(1)) {
//            long number = Long.parseLong(first);
//            long initialNumber = number;
//            int indexString = getIndexToContinue(number);
//            int digit = getDigit(number);
//            long nextNumber = findNextNumber(number, indexString, digit, s);
//            while (indexString < s.length() && continueLoop(number, nextNumber)) {
//                indexString += getIndexToContinue(nextNumber);
//                digit = getDigit(nextNumber);
//                number = nextNumber;
//                nextNumber = findNextNumber(number, indexString, digit, s);
//                if (nextNumber == 0) {
//                    break;
//                }
//            }
//            if (indexString > s.length()) {
//                System.out.println("NO");
//                return;
//            } else if (indexString == s.length()) {
//                System.out.println("YES " + initialNumber);
//                return;
//            } else {
//                System.out.println("NO");
//                return;
//            }
//        }

    private static int getNumberOfDigits(Long result){
        int count =0;
        while(result!=0){
            result/=10;
            count++;
        }
        return count;
    }

    private static String composeFollowingStringNumbers(String s, String start) {
        StringBuilder builder = new StringBuilder();
        //LONG HAS MAX OF 19 CHARACTERS
        if(start.length()>18){
            return "";
        }
        long startNumber = Long.parseLong(start);
        builder.append(start);
        while (builder.length() < s.length()) {

            long nextNumber = startNumber + 1;
            String nextNumberString = String.valueOf(nextNumber);
            builder.append(nextNumberString);
            startNumber = nextNumber;
        }
        return builder.toString();
    }


    public static void separateNumbers(String s) {
        // Write your code here
        StringBuilder builder = new StringBuilder();
        if (s.length() == 1) {
            System.out.println("NO");
            return;
        }
        if (s.length() == 2) {
            if (s.charAt(1) - s.charAt(0) == 1) {
                System.out.println("YES " + s.charAt(0));
                return;
            } else {
                System.out.println("NO");
                return;
            }
        }
        if (s.charAt(0) == '0') {
            System.out.println("NO");
            return;
        }
        int index = 0;
        String starting = String.valueOf(s.charAt(index));
        builder.append(starting);
        while(starting.length()<s.length()){
            String comparingString = composeFollowingStringNumbers(s, starting);
            if (s.equals(comparingString)) {
                System.out.println("YES " + starting);
                return;
            } else {
                index++;
                builder.append(s.charAt(index));
                starting = builder.toString();
            }
    }
        System.out.println("NO");


}


    public static void main(String[] args) {
        separateNumbers("1234");
        separateNumbers("99910001001");
        separateNumbers("888990919293");
        separateNumbers("9101112131415161718");
        separateNumbers("99100");
        separateNumbers("101103");
        separateNumbers("010203");
        separateNumbers("13");
        separateNumbers("1");
        separateNumbers("76317632");
        separateNumbers("99910001001");
        separateNumbers("7891011");
        separateNumbers("9899100");
        separateNumbers("999100010001");
        separateNumbers("57585960616263646566676869707172");
        separateNumbers("858687888990919293949595979899");
        separateNumbers("90071992547409929007199254740993");

        String s = "1234";
        System.out.println(s+String.valueOf(1));



    }


}
