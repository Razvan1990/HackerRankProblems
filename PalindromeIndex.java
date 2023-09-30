package hackerRank;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public class PalindromeIndex {

    private static boolean checkIFPalindrome(String s) {
        boolean isPalindrome = true;
        int first = 0;
        int last = s.length() - 1;
        while (first < last) {
            if (s.charAt(first) == s.charAt(last)) {
                first++;
                last--;
            } else {
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }

    /**
     * @param s
     * @param index
     * @return A new string in which we did not include the character from the index which has a different character
     */

    private static String removeCharacterFromIndex(String s, int index) {

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i == index) {

            } else {
                builder.append(s.charAt(i));
            }
        }
        return builder.toString();
    }

    public static int palindromeIndex(String s) {
        // Write your code here
        int result = -1;
        if (checkIFPalindrome(s)) {
            return result;
        }
        int first = 0;
        int last = s.length() - 1;
        while (first < last) {
            if (s.charAt(first) == s.charAt(last)) {
                first++;
                last--;
            } else {
                //we are checking here to see if the character from last-1 is equal to the character at first
                if (s.charAt(first) == s.charAt(last - 1)) {
                    //we compose the new string with removing the character at index last and check if it is palindrome. If so, we return the index of last
                    String remainingString = removeCharacterFromIndex(s, last);
                    if (checkIFPalindrome(remainingString)) {
                        result = last;
                        return result;
                    }
                    //same idea here, but now we check the character from index first+1 . If this will be a palindrome, then we return the index of first
                }
                if (s.charAt(first + 1) == s.charAt(last)) {
                    String remainingString = removeCharacterFromIndex(s, first);
                    if (checkIFPalindrome(remainingString)) {
                        result = first;
                        return result;
                    }
                    //if there are more than two characters at opposite palindrom positions different, then we cannot compose a palindrom by removing just 1 character
                } else {
                    return result;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(palindromeIndex("bcbc"));
        System.out.println(palindromeIndex("aaab"));
        System.out.println(palindromeIndex("baa"));
        System.out.println(palindromeIndex("aaa"));
        System.out.println(palindromeIndex("abcd"));
        System.out.println(palindromeIndex("abbcbbda"));
        System.out.println(palindromeIndex("aaadccbbccaaa"));
        System.out.println(palindromeIndex("hgygsvlfwcwnswtuhmyaljkqlqjjqlqkjlaymhutwsnwcflvsgygh"));
        System.out.println(palindromeIndex("mmbiefhflbeckaecprwfgmqlydfroxrblulpasumubqhhbvlqpixvvxipqlvbhqbumusaplulbrxorfdylqmgfwrpceakceblfhfeibmm"));
        System.out.println(palindromeIndex("hgygsvlfcwnswtuhmyaljkqlqjjqlqkjlaymhutwsnwcwflvsgygh"));


    }
}