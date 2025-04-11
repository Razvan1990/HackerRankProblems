package leetcode;

import java.util.Arrays;

public class FindDifference {
    public char findTheDifference(String s, String t) {
        //old school -> put in order both and check character per character
        char[] arrayS = s.toCharArray();
        char[] arrayT = t.toCharArray();
        //arrange alphabetically
        Arrays.sort(arrayS);
        Arrays.sort(arrayT);
        //keep in mind to not get index out of bounds
        for (int i = 0; i < arrayS.length; i++) {
            if (arrayS[i] != arrayT[i]) {
                return arrayT[i];
            }
        }
        // in this case it is the last character
        return arrayT[arrayT.length - 1];
    }

}
