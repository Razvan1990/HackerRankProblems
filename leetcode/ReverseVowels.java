package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseVowels {
    List<Character> lowerVowels = Arrays.asList('a', 'e', 'i', 'o', 'u');
    List<Character> upperVowels = Arrays.asList('A', 'E', 'I', 'O', 'U');

    public String reverseVowels(String s) {
        if (s.length() == 1) {
            return s;
        }
        List<Character> invertedVowels = getVowelsInversedList(s);
        StringBuilder builder = new StringBuilder();
        int indexVowelCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (lowerVowels.contains(s.charAt(i)) || upperVowels.contains(s.charAt(i))) {
                builder.append(invertedVowels.get(indexVowelCount));
                indexVowelCount++;
            } else {
                builder.append(s.charAt(i));
            }
        }
        return builder.toString();
    }

    private List<Character> getVowelsInversedList(String s) {
        List<Character> resultVowels = new ArrayList<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (lowerVowels.contains(s.charAt(i)) || upperVowels.contains(s.charAt(i))) {
                resultVowels.add(s.charAt(i));
            }
        }
        return resultVowels;
    }

    public static void main(String[] args) {
        ReverseVowels reverseVowels = new ReverseVowels();
        String s1 = "salutare";
        String s2 = "IceCreAm";
        String s3 = "leetcode";
        System.out.println(reverseVowels.reverseVowels(s1));
        System.out.println(reverseVowels.reverseVowels(s2));
        System.out.println(reverseVowels.reverseVowels(s3));
    }
}
