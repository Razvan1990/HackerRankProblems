package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        List<Integer> wordLength = new ArrayList<>();
        for (String str : strs) {
            wordLength.add(str.length());
        }
        int minLength = findLowestWord(wordLength);
        StringBuilder builder = new StringBuilder();
        String result = "";
        boolean isPrefix = true;
        int index = 0;
        while (index < minLength) {
            for (int i = 0; i < strs.length - 1; i++) {
                if (strs[i].charAt(index) != strs[i+1].charAt(index)) {
                    isPrefix = false;
                    break;
                }

            }
            if (isPrefix) {
                builder.append(strs[0].charAt(index));
            }
            else{
                break;
            }
            index++;
        }
        return builder.length() == 0 ? "" : builder.toString();
    }


    private int findLowestWord(List<Integer> sizeWords) {
        int min = sizeWords.get(0);
        for (int i = 1; i < sizeWords.size(); i++) {
            if (sizeWords.get(i) < min) {
                min = sizeWords.get(i);
            }
        }
        return min;
    }


    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String [] words = {"flower", "flow", "flight"};
        String [] words2 ={"dog", "car", "racecar"};
        String [] words3 ={"abcd", "fbcd", "zbcd"};
        String result1 = longestCommonPrefix.longestCommonPrefix(words);
        System.out.println(result1);
        String result2 = longestCommonPrefix.longestCommonPrefix(words2);
        System.out.println(result2);
        String result3 = longestCommonPrefix.longestCommonPrefix(words3);
        System.out.println(result3);
    }


}
