package hackerRank;

public class PalindromeHard {


    /* no need for this..we can do it directly*/
    private static boolean isPalindrome(String s) {

        boolean result = true;
        int first = 0;
        int last = s.length() - 1;

        while (first < last) {
            if (s.charAt(first) == s.charAt(last)) {
                first++;
                last--;
            } else {
                result = false;
            }

        }
        return result;
    }

    private static int getDifferenceOfCharacters(char a, char b) {
        return Math.abs(a - b);
    }


    public static int theLoveLetterMystery(String s) {
        // Write your code here
        /**
         * Try to the same as in palindrome ...last with fist and increment till you come to the same condition...make them equal to have palindrome
         */
        int result = 0;
        int first = 0;
        int last = s.length() - 1;

        while (first < last) {
            if (s.charAt(first) == s.charAt(last)) {
                first++;
                last--;
            } else {
                result+=getDifferenceOfCharacters(s.charAt(first), s.charAt(last));
                first++; last--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(theLoveLetterMystery("abc"));
        System.out.println(theLoveLetterMystery("abcba"));
        System.out.println(theLoveLetterMystery("abcd"));
        System.out.println(theLoveLetterMystery("cba"));
        System.out.println(isPalindrome("abcba"));

    }

}

