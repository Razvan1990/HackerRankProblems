package hackerRank;

import java.util.*;

public class Gemstones {

    /*

    DO NOT FULLY UNDERSTAND PROBLEM - this is working on tests
     */

    public static int gemstones(List<String> arr) {
        // Write your code
        Collections.sort(arr, (a, b) -> Integer.compare(a.length(), b.length()));
        int result = 0;
        char[] elementOneFirstCharArr = arr.get(0).toCharArray();
        for (int i = 0; i < elementOneFirstCharArr.length; i++) {
            boolean isOk = true;
            for (int j =1;j<arr.size();j++) {
                if (arr.get(j).indexOf(elementOneFirstCharArr[i]) == -1) {
                    isOk = false;
                    break;
                }
            }
            if (isOk) {
                result++;
            }

        }
        return result;


    }


    public static void main(String[] args) {
        List<String>test1 = Arrays.asList("abc", "abc", "bc");
        List<String>test2 = Arrays.asList("abcdde", "baccd", "eeabg");
        List<String>test3 = Arrays.asList("abcdde", "baccd", "eeabg", "afgz");
        System.out.println(gemstones(test1));
        System.out.println(gemstones(test2));
        System.out.println(gemstones(test3));


    }
}
