package hackerRank;

import java.util.Arrays;
import java.util.List;

public class TwoStrings {


    private static boolean checkIfThereIsSubstringOfStrings(String s1, String s2) {
        boolean response = false;
        char [] array = s2.toCharArray();
        Arrays.sort(array);
        for (int i = 0; i < s1.length(); i++) {
            int res = Arrays.binarySearch(array, s1.charAt(i));
            if(res>=0){
                return true;
            }
        }
        return response;
    }

    public static String twoStrings(String s1, String s2) {
        // Write your code here
        if (checkIfThereIsSubstringOfStrings(s1, s2)){
            return "YES";
        }
        else {
            return "NO";
        }

    }

    public static void main(String[] args) {
        System.out.println(twoStrings("aardvark", "apple"));
    }

}
