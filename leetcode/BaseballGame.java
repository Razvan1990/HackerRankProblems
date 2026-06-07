/**
 * ou are keeping the scores for a baseball game with strange rules. At the beginning of the game, you start with an empty record.
 * <p>
 * You are given a list of strings operations, where operations[i] is the ith operation you must apply to the record and is one of the following:
 * <p>
 * An integer x.
 * Record a new score of x.
 * '+'.
 * Record a new score that is the sum of the previous two scores.
 * 'D'.
 * Record a new score that is the double of the previous score.
 * 'C'.
 * Invalidate the previous score, removing it from the record.
 * Return the sum of all the scores on the record after applying all the operations.
 * <p>
 * The test cases are generated such that the answer and all intermediate calculations fit in a 32-bit integer and that all operations are valid.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: ops = ["5","2","C","D","+"]
 * Output: 30
 * Explanation:
 * "5" - Add 5 to the record, record is now [5].
 * "2" - Add 2 to the record, record is now [5, 2].
 * "C" - Invalidate and remove the previous score, record is now [5].
 * "D" - Add 2 * 5 = 10 to the record, record is now [5, 10].
 * "+" - Add 5 + 10 = 15 to the record, record is now [5, 10, 15].
 * The total sum is 5 + 10 + 15 = 30.
 * Example 2:
 * <p>
 * Input: ops = ["5","-2","4","C","D","9","+","+"]
 * Output: 27
 * Explanation:
 * "5" - Add 5 to the record, record is now [5].
 * "-2" - Add -2 to the record, record is now [5, -2].
 * "4" - Add 4 to the record, record is now [5, -2, 4].
 * "C" - Invalidate and remove the previous score, record is now [5, -2].
 * "D" - Add 2 * -2 = -4 to the record, record is now [5, -2, -4].
 * "9" - Add 9 to the record, record is now [5, -2, -4, 9].
 * "+" - Add -4 + 9 = 5 to the record, record is now [5, -2, -4, 9, 5].
 * "+" - Add 9 + 5 = 14 to the record, record is now [5, -2, -4, 9, 5, 14].
 * The total sum is 5 + -2 + -4 + 9 + 5 + 14 = 27.
 * Example 3:
 * <p>
 * Input: ops = ["1","C"]
 * Output: 0
 * Explanation:
 * "1" - Add 1 to the record, record is now [1].
 * "C" - Invalidate and remove the previous score, record is now [].
 * Since the record is empty, the total sum is 0.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= operations.length <= 1000
 * operations[i] is "C", "D", "+", or a string representing an integer in the range [-3 * 104, 3 * 104].
 * For operation "+", there will always be at least two previous scores on the record.
 * For operations "C" and "D", there will always be at least one previous score on the record.
 */

package hackerRank.leetcode;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    public int calPoints(String[] operations) {
        int result = 0;
        List<Long> resultList = new ArrayList<>();
        for (String op : operations) {
            if (isNumeric(op)) {
                result+=Integer.parseInt(op);
                resultList.add(Long.parseLong(op));
            } else if (op.equals("+")) {
                long value = resultList.getLast() + resultList.get(resultList.size() - 2);
                resultList.add(value);
                result+=(int)value;
            } else if (op.equals("C")) {
                result-=resultList.getLast();
                resultList.removeLast();
            } else if (op.equals("D")) {
                long value = resultList.getLast() * 2;
                result+=(int) value;
                resultList.add(value);
            } else {
                return result;
            }

        }
        //calculate the sum
        if (resultList.isEmpty()) {
            return result;
        }
        //for (long value : resultList) {
            //result += (int) value;
        //}
        return result;
    }

    private boolean isNumeric(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    static void main() {
        BaseballGame b = new BaseballGame();
        String [] ops1 = {"5","2","C","D","+"};
        String [] ops2 = {"5","-2","4","C","D","9","+","+"};
        String [] ops3 = {"1","C"};
        System.out.println(b.calPoints(ops1));
        System.out.println(b.calPoints(ops2));
        System.out.println(b.calPoints(ops3));
    }

}
