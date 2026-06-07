package hackerRank.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an m x n matrix, return true if the matrix is Toeplitz. Otherwise, return false.
 * <p>
 * A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same elements.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
 * Output: true
 * Explanation:
 * In the above grid, the diagonals are:
 * "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]".
 * In each diagonal all elements are the same, so the answer is True.
 * Example 2:
 * <p>
 * <p>
 * Input: matrix = [[1,2],[2,2]]
 * Output: false
 * Explanation:
 * The diagonal "[1, 2]" has different elements.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 20
 * 0 <= matrix[i][j] <= 99
 */

public class ToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        /// WE JUST NEED TO TRAVERSE TRHOUGH ALL DIAGONALS
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != matrix[i + 1][j + 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}


