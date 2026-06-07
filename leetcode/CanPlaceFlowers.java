package hackerRank.leetcode;

/**
 * You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.
 *
 * Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: true
 * Example 2:
 *
 * Input: flowerbed = [1,0,0,0,1], n = 2
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= flowerbed.length <= 2 * 104
 * flowerbed[i] is 0 or 1.
 * There are no two adjacent flowers in flowerbed.
 * 0 <= n <= flowerbed.length
 */

public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == flowerbed.length && flowerbed.length >1){
            return false;
        }
        if (n == 0) {
            return true;
        }
        //special case flowerbed= {0}, n =1 -> return true
        if (flowerbed.length == 1 && flowerbed[0] == 0 && n == 1) {
            return true;
        }
        if (flowerbed[0] == 0 && flowerbed[1] == 0) {
            n-=1;
            flowerbed[0] = 1;
            if (n ==0) {
                return true;
            }
        }
        if (flowerbed[flowerbed.length-1] == 0 && flowerbed[flowerbed.length-2] == 0) {
            n-=1;
            flowerbed[flowerbed.length-1] = 1;
            if (n ==0) {
                return true;
            }
        }
        //check at every position now
        for (int i = 1; i< flowerbed.length-1; i++) {
            if (flowerbed[i] == 0 && flowerbed[i-1] == 0 && flowerbed[i+1] == 0) {
                n-=1;
                flowerbed[i] = 1;
                if (n ==0){
                    return true;
                }
            }
        }
        return false;
    }

    static void main() {
        CanPlaceFlowers test = new CanPlaceFlowers();
        System.out.println(test.canPlaceFlowers(new int[]{1,0,0,0,1}, 1));
        System.out.println(test.canPlaceFlowers(new int[]{1,0,0,0,1}, 2));
        System.out.println(test.canPlaceFlowers(new int[]{0}, 1));
    }
}
