/*
Given a string s, return true if the s can be palindrome after deleting at most one character from it.



Example 1:

Input: s = "aba"
Output: true
Example 2:

Input: s = "abca"
Output: true
Explanation: You could delete the character 'c'.
Example 3:

Input: s = "abc"
Output: false


Constraints:

1 <= s.length <= 105
s consists of lowercase English letters.
 */



package hackerRank.leetcode;

public class ValidPalindrome2 {

    public boolean validPalindrome(String s) {
        int start =0;
        int end = s.length()-1;

        while (start <end){
            //we will do the same thing, but we will appeal is palindrome for the neighbour characters
            if (s.charAt(start)!=s.charAt(end)){
                boolean result = isPalindrome(s, start+1,end) || isPalindrome(s,start,end-1);
                if(!result){
                    return false;
                }
            }
            start++;
            end--;
        }
        return true;
    }

    private boolean isPalindrome(String s, int left, int right){
        while (left < right){
            //check if we have palindrome
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }







    static void main() {
        ValidPalindrome2 p = new ValidPalindrome2();
        System.out.println(p.validPalindrome("aba"));
        System.out.println(p.validPalindrome("abca"));
        System.out.println(p.validPalindrome("abc"));
    }
}
