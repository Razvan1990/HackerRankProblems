package hackerRank;

import java.util.ArrayList;
import java.util.List;

public class HighestValuePalindrome {

    private static int getNumberOfNeededCharactersForChange(String s) {
        int result = 0;
        int first = 0;
        int last = s.length() - 1;
        while (first < last) {
            if (s.charAt(first) != s.charAt(last)) {
                result++;
                first++;
                last--;
            } else {
                first++;
                last--;
            }
        }
        return result;
    }

    public static String highestValuePalindrome(String s, int n, int k) {
        // Write your code here
        List<Boolean> countList = new ArrayList<>();
        StringBuilder builder = new StringBuilder(s);
        //check first how many characters are needed to make the string a palindrome
        int numberOfChars = getNumberOfNeededCharactersForChange(s);
        //if number bigger than k, than we cannot have a palindrome with these conditions
        if (numberOfChars > k) {
            return "-1";
        } else if (k == 1 && numberOfChars == 0 && s.length() % 2 == 1) {
            int middle = s.length() / 2;
            builder.setCharAt(middle, '9');
            return builder.toString();
        }
//        } else if (s.length() % 2 == 0 && numberOfChars == 0) {
//            //it is already palindrome, just for safety
//            return "-1";
//        }
        //this is already in the zone where k>=number of chars
        //need to keep track at what positions there were modifications -> use a list for this

        // we first make the string palindrome, with necessary corrections
        int first = 0;
        int last = s.length() - 1;
        while (first < last) {
            if (s.charAt(first) > s.charAt(last)) {
                builder.setCharAt(last, s.charAt(first));
                first++;
                last--;
                k--;
                countList.add(true);
            } else if (s.charAt(first) < s.charAt(last)) {
                builder.setCharAt(first, s.charAt(last));
                first++;
                last--;
                k--;
                countList.add(true);
            } else {
                first++;
                last--;
                countList.add(false);
            }
        }

        if (k == 0) {
            return builder.toString();
        } else {
            first = 0;
            last = builder.length() - 1;
            int index = 0;
            while (first < last) {
                //first we check if the element is different from 9 and if there was a modification before this. If so, the k will just decrement once,
                //because one operation is done
                if (s.charAt(first) != '9' && countList.get(index)) {
                    builder.setCharAt(first, '9');
                    builder.setCharAt(last, '9');
                    k--;
                    first++;
                    last--;
                    index++;
                    if (k <= 0) {
                        break;
                    }
                    //now we check if the element is different from 9 and if there was no modification. If so, the k will decrease twice, cause there
                    //has not been any changes at that index;
                } else if (s.charAt(first) != '9' && !countList.get(index)) {
                    builder.setCharAt(first, '9');
                    k--;
                    if (k <= 0) {
                        return "-1";
                    }
                    builder.setCharAt(last, '9');
                    k--;
                    if (k <= 0) {
                        break;
                    }
                    first++;
                    last--;
                    index++;
                } else {
                    first++;
                    last--;
                    index++;
                }
            }

        }
        return builder.toString();
    }


        public static void main (String[]args){
            System.out.println(highestValuePalindrome("1231", 4, 3));
            System.out.println(highestValuePalindrome("12321", 5, 1));
            System.out.println(highestValuePalindrome("092282", 6, 3));
            System.out.println(highestValuePalindrome("0011", 4, 1));
            System.out.println(highestValuePalindrome("932239", 6, 2));
            System.out.println(highestValuePalindrome("11331", 5, 4));

        }
    }
