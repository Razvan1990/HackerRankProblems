

/**Given a string s, find the length of the longest substring without duplicate characters.



        Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
package hackerRank.leetcode;


import java.util.ArrayList;
import java.util.List;

public class LongSubstingNoDuplicate {
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty() || s.length() == 1)
            return s.length();
        int result =1; //there will be at least one character
        int poz0 = 0;
        int poz1 =1;
        List<Character> charList = new ArrayList<>();
        charList.add(s.charAt(0));
        while(poz1 < s.length()){
            if (!charList.contains(s.charAt(poz1))) {
                charList.add(s.charAt(poz1));
                poz1++;
                result = Math.max(result, charList.size());
            }else{
                charList.clear();
                //we need to put back the element at that position and restart
                poz0 ++;
                charList.add(s.charAt(poz0));
                poz1 = poz0 + 1;

            }
        }
    return result;
    }

    static void main() {
        LongSubstingNoDuplicate sol = new LongSubstingNoDuplicate();
        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";
        String s4 ="aab";
        System.out.println(sol.lengthOfLongestSubstring(s1));
        System.out.println(sol.lengthOfLongestSubstring(s2));
        System.out.println(sol.lengthOfLongestSubstring(s3));
        System.out.println(sol.lengthOfLongestSubstring(s4));
    }
}
