package hackerRank.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class NumberLinesToWrite {

    private final String dictionary;

    NumberLinesToWrite() {
        this.dictionary = "abcdefghijklmnopqrstuvwxyz";
    }

    public int[] numberOfLines(int[] widths, String s) {
        int [] result = new int [2];
        HashMap<Character, Integer> widthMap = computeWidths(widths);
        int edge = 0;
        int threshold = 100;
        List<String> lines = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        //traverse through String and check when we have new line
        for (int i =0;i<s.length();i++) {
            //check before we put on line if we pass the threshold
            if (edge + widthMap.get(s.charAt(i)) > threshold) {
                lines.add(sb.toString());
                edge = 0;
                //reset StringBuilder
                sb.delete(0, sb.length());
                //add the new stringbuilder
                sb.append(s.charAt(i));
                edge += widthMap.get(s.charAt(i));
            } else{
                sb.append(s.charAt(i));
                edge += widthMap.get(s.charAt(i));
            }
        }
        //add what is last left
        lines.add(sb.toString());
        //we should be left with the final edge everytime -> so edge will be result[1]
        result[0] = lines.size();
        result[1] = edge;
        return result;
    }


    private HashMap<Character, Integer> computeWidths(int[] widths) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i =0;i<widths.length;i++){
            map.put(this.dictionary.charAt(i),widths[i]);
        }
        return map;
    }

    public static void main(String[] args) {
        NumberLinesToWrite nlt = new NumberLinesToWrite();
        int [] widths1 = {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
        String s1 = "abcdefghijklmnopqrstuvwxyz";

        int [] widths2 = {4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
        String s2 = "bbbcccdddaaa";
        System.out.println(Arrays.toString(nlt.numberOfLines(widths1, s1)));
        System.out.println(Arrays.toString(nlt.numberOfLines(widths2, s2)));
    }
}
