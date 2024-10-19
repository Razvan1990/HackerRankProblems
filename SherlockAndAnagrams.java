package hackerRank;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SherlockAndAnagrams {
    //POSSIBLE NOT TO WORK all test cases
    private static boolean checkIfJustOneLetter(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
            } else {
                return false;
            }

        }
        return true;
    }

    private static int calculateResultForSameLetter(String test) {
        int x = test.length();
        int result = 0;
        while (x > 1) {
            for (int i = 0; i < x; i++) {
                for (int j = i + 1; j < x; j++) {
                    result += 1;
                }
            }
            x--;
        }
        return result;
    }

    private static int getNumberOfOccurences(String s, String substring) {
        int result = 0;
        for (int i = 0; i < s.length(); i += substring.length()) {
            StringBuilder builder = new StringBuilder();
            builder.append(s.charAt(i));
            if (builder.toString().contains(substring)) {
                result++;
            }
        }
        return result;
    }


//not needed

    private static String invertString(String s) {
        StringBuilder builder = new StringBuilder();
        int k = s.length() - 1;
        while (k >= 0) {
            builder.append(s.charAt(k));
            k--;
        }
        return builder.toString();
    }

    private static List<String> createSubstrings(String s, int size) {
        List<String> neededStrings = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i <= size; i++) {
            builder.append(s.charAt(i));
        }
        String neededSubstring = builder.toString();
        neededStrings.add(neededSubstring);
        builder.delete(0, builder.length());
        for (int i = size + 1; i < s.length(); i++) {
            builder.append(s.charAt(i));
        }
        String remainingString = builder.toString();
        neededStrings.add(remainingString);
        return neededStrings;
    }

    private static String sortString(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }


    public static int sherlockAndAnagrams(String s) {
        // Write your code here

        //check if it is just one letter
        if (checkIfJustOneLetter(s)) {
            return calculateResultForSameLetter(s);
        }


        int result = 0;
        int first = 0;
        int last = 1;
        int lastIndex = s.length() - 1;

        while (first < last) {
            if (first == lastIndex) {
                break;
            }
            if (s.charAt(first) == s.charAt(last)) {
                if (last - first > 1) {
                    result += 2;
                } else {
                    result += 1;
                }
                first++;
                last = first + 1;
            } else {
                last++;
                if (last >= s.length()) {
                    first++;
                    last = first + 1;
                }
            }

        }
        for (int i = 1; i < s.length(); i++) {
            List<String> substrings = createSubstrings(s, i);
            String s1 = sortString(substrings.get(0));
            String s2 = sortString(substrings.get(1));
            if (s2.contains(s1)) {//this part is not correct -> no other solution
                result += 1;
            }

        }


        return result;
    }

    public static void main(String[] args) {

        System.out.println(sherlockAndAnagrams("mom"));
        System.out.println(sherlockAndAnagrams("abba"));
        System.out.println(sherlockAndAnagrams("abcd"));
        System.out.println(sherlockAndAnagrams("kkkk"));
        System.out.println(sherlockAndAnagrams("aaaaa"));
        System.out.println(sherlockAndAnagrams("ifailuhkqq"));
        System.out.println(sherlockAndAnagrams("cdcd"));
        System.out.println(sherlockAndAnagrams("ifailuhkqqhucpoltgtyovarjsnrbfpvmupwjjjfiwwhrlkpekxxnebfrwibylcvkfealgonjkzwlyfhhkefuvgndgdnbelgruel"));

        String s = "sadcecsafcsadesall";
        String substring = "sa";
        String comparing = "";
        int result = 0;
        for (int i = 0; i < s.length(); i += substring.length()) {
            StringBuilder builder = new StringBuilder();
            int j = i;
            int counter = 0;
            while (counter < substring.length()) {
                builder.append(s.charAt(j));
                counter++;
                j++;
            }
            comparing = builder.toString();

            if (comparing.equals(substring)) {
                result += 1;
            }


        }
        System.out.println(result);


    }
}

