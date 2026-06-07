/**
 * 830. Positions of Large Groups
 * Easy
 * Topics
 * premium lock icon
 * Companies
 * In a string s of lowercase letters, these letters form consecutive groups of the same character.
 * <p>
 * For example, a string like s = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z", and "yy".
 * <p>
 * A group is identified by an interval [start, end], where start and end denote the start and end indices (inclusive) of the group. In the above example, "xxxx" has the interval [3,6].
 * <p>
 * A group is considered large if it has 3 or more characters.
 * <p>
 * Return the intervals of every large group sorted in increasing order by start index.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abbxxxxzzy"
 * Output: [[3,6]]
 * Explanation: "xxxx" is the only large group with start index 3 and end index 6.
 * Example 2:
 * <p>
 * Input: s = "abc"
 * Output: []
 * Explanation: We have groups "a", "b", and "c", none of which are large groups.
 * Example 3:
 * <p>
 * Input: s = "abcdddeeeeaabbbcd"
 * Output: [[3,5],[6,9],[12,14]]
 * Explanation: The large groups are "ddd", "eeee", and "bbb".
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 1000
 * s contains lowercase English letters only.
 */

package hackerRank.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PositionOfLargeGroups {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> ans = new ArrayList<>();
        int poz1 = 0;
        int poz2 = 1;
        int counterConsecutive = 1;

        while (poz2 < s.length()) {
            if (s.charAt(poz1) == s.charAt(poz2)) {
                counterConsecutive++;
                poz2++;
            } else {
                if (counterConsecutive >= 3) {
                    List<Integer> sequence = new ArrayList<>();
                    sequence.add(poz1);
                    sequence.add(poz2-1); //it is incremented above so it points to next one
                    ans.add(sequence);
                }
                counterConsecutive = 1;
                poz1 = poz2;
                poz2 = poz1 + 1;
            }
        }
        //case where we have same letters and not something different
        if (counterConsecutive >= 3) {
            List<Integer> sequence = new ArrayList<>();
            sequence.add(poz1);
            sequence.add(poz2-1);
            ans.add(sequence);
        }
        return ans;
    }

    static void main() {
        PositionOfLargeGroups obj = new PositionOfLargeGroups();
        String s1 = "abbxxxxzzy";
        String s2 = "abc";
        String s3 ="abcdddeeeeaabbbcd";
        System.out.println(obj.largeGroupPositions(s1));
        System.out.println(obj.largeGroupPositions(s2));
        System.out.println(obj.largeGroupPositions(s3));
    }
}
