/**
 * Given two strings s and goal, return true if you can swap two letters in s so the result is equal to goal, otherwise, return false.
 * <p>
 * Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j and swapping the characters at s[i] and s[j].
 * <p>
 * For example, swapping at indices 0 and 2 in "abcd" results in "cbad".
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "ab", goal = "ba"
 * Output: true
 * Explanation: You can swap s[0] = 'a' and s[1] = 'b' to get "ba", which is equal to goal.
 * Example 2:
 * <p>
 * Input: s = "ab", goal = "ab"
 * Output: false
 * Explanation: The only letters you can swap are s[0] = 'a' and s[1] = 'b', which results in "ba" != goal.
 * Example 3:
 * <p>
 * Input: s = "aa", goal = "aa"
 * Output: true
 * Explanation: You can swap s[0] = 'a' and s[1] = 'a' to get "aa", which is equal to goal.
 *
 */


package hackerRank.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BuddyStrings {
    public boolean buddyStrings(String s, String goal) {
        /**
         * 1. Check if strings are same - return true if so
         * 2. check len of strings - if not return false
         * 3. traverse string char by char and compare
         * 4. if differences use a list and store the indices which are different
         *  4.1 If list length !=2, return false
         * 5. Use a function the create a new string by reversing the chars at that position
         * 6. Check if the new string is equal to goal
         */
        HashMap<Character, Integer> freqMap = getFreqMap(s);
        /**
         * edge cases
         * 1. different lengths
         * 2. goal and s are equal but length is 1 -false
         * 3. length bigger than 1, but if goal and s are the same and contain same character - true
         * 4. if goal == s and length of s =2 -> need to swap false
         * 5. if s= goal and the length is even, with more than 2 different characters and the number of different chars is even - false
         * 6. if s = goal and the length is even we return true (knowing that the size of different chars is always more than 2
         * 7. s = goal, if the number of different chars is odd, then we can swap(knowing that freq size > 2 and s length > 2)
         * 8. If they are just equal, but not with same char or other above, we return false
         *
         */
        if (s.length() != goal.length()) return false;
        if (s.equals(goal) && s.length() ==1) return false;
        if (s.equals(goal)  && freqMap.size() ==1) return true;
        //we now that we need to swap everytime. In this case if they are equal and with different chars, it's always false
        if (s.equals(goal) && s.length() ==2) return false;
        if (s.equals(goal) && s.length() % 2 ==0 && (freqMap.size() >2 && freqMap.size() % 2 ==0)) return false;
        if (s.equals(goal) && s.length() % 2 == 0) return true;
        if (s.equals(goal) && freqMap.size() % 2 != 0) {
            return true;
        }
        if (s.equals(goal)) {
            //length is already knows as odd
            return false;
        }

        //here we have the classic part

        List<Integer> indexDiffList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                indexDiffList.add(i);
            }
        }
        if (indexDiffList.size() != 2) {
            return false;
        }
        String changedString = changeStringByIndices(s, indexDiffList);
        return changedString.equals(goal);
    }

    private String changeStringByIndices(String s, List<Integer> indices) {
        StringBuilder sb = new StringBuilder();
        //we now the hashmap is of length 2
        for (int i = 0; i < s.length(); i++) {
            if (!indices.contains(i)) {
                sb.append(s.charAt(i));
            } else {
                if (i == indices.getFirst()) {
                    sb.append(s.charAt(indices.getLast()));
                } else if (i == indices.getLast()) {
                    sb.append(s.charAt(indices.getFirst()));
                }
            }
        }
        return sb.toString();

    }

    private HashMap<Character, Integer> getFreqMap (String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        return map;
    }


    static void main() {
        BuddyStrings bs = new BuddyStrings();
        String s1 = "ab";
        String goal1 = "ba";

        String s2 = "ab";
        String goal2 = "ab";

        String s3 = "aa";
        String goal3 = "aa";

        String s4 = "abcdefg";
        String goal4 = "abfdecg";

        String s5 = "abcdefgh";
        String goal5 = "abdcefhg";

        System.out.println(bs.buddyStrings(s1, goal1));
        System.out.println(bs.buddyStrings(s2, goal2));
        System.out.println(bs.buddyStrings(s3, goal3));
        System.out.println(bs.buddyStrings(s4, goal4));
        System.out.println(bs.buddyStrings(s5, goal5));
    }
}
