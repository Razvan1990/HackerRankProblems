/**
 * We have two special characters:
 *
 * The first character can be represented by one bit 0.
 * The second character can be represented by two bits (10 or 11).
 * Given a binary array bits that ends with 0, return true if the last character must be a one-bit character.
 *
 *
 *
 * Example 1:
 *
 * Input: bits = [1,0,0]
 * Output: true
 * Explanation: The only way to decode it is two-bit character and one-bit character.
 * So the last character is one-bit character.
 * Example 2:
 *
 * Input: bits = [1,1,1,0]
 * Output: false
 * Explanation: The only way to decode it is two-bit character and two-bit character.
 * So the last character is not one-bit character.
 */

//not all tests passing
package hackerRank.leetcode;

public class Bits {
    public boolean isOneBitCharacter(int[] bits) {
        if (bits.length ==1){
            return true; //it is basically just a 0
        }
        if (bits.length == 2) {
            if (bits[0] == 1){
                return false;
            } else return bits[0] == 0;
        }
        //check if we have just zero
        if (checkIfAllZero(bits) && bits.length % 2 !=0){
            return true;
        }
        //check if we have the last to one character value
        if  (bits.length % 2 !=0){
            if (!checkBitsTillLast(bits)){
                return true;
            }
            else if (bits[bits.length-2] == 0){
                return true;
            }
        }
        if (bits.length % 2 ==0 && bits[bits.length-2] ==0){
            return true;
        }
        if (bits.length % 2 ==0 && bits[bits.length-2] ==1 && bits[bits.length-3] ==1){
            return true;
        }
        return false;
    }

    private boolean checkBitsTillLast(int[] bits){
        for (int i =0;i<bits.length -1;i++){
            if (bits[i] != 1){
                return true;
            }
        }
        return false;
    }

    private boolean checkIfAllZero(int [] bits){
        for (int i =0;i<bits.length;i++){
            if (bits[i]!=0){
                return false;
            }
        }
        return true;
    }

    /**
     * Correctsolution
     *
     * Basically we need to check if a bit is 1 or 0
     * In case it is 0, we just move ahead to the next character
     * In case it is 1, we decode it like 10 or 11, thus moving forward 2 chars
     * The maine idea is to see that we actually reach with the index the exact length of the array
     * if our index is length of array, then we can return true, otherwise, it is not valid and we have to many ones for example
     * @param bits
     * @return
     */

    public boolean isOneBitCharacter2(int[] bits) {
        int n = bits.length;
        int i = 0;
        while(i < n - 1)
            i += bits[i] + 1;
        return i == n - 1;
    }
}
