package hackerRank;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SherlockAndAnagrams2 {

    private static HashMap<Character, Integer> getFrequencyMapOfCharacters(String s) {
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (frequencyMap.containsKey(s.charAt(i))) {
                frequencyMap.put(s.charAt(i), frequencyMap.get(s.charAt(i)) + 1);
            } else {
                frequencyMap.put(s.charAt(i), 1);
            }
        }
        return frequencyMap;
    }

    private static HashMap<String, Integer> getFrequencyMapOfSubstrings(List<String> list) {
        HashMap<String, Integer> frequencyMap = new HashMap<>();
        for (String substring : list) {
            if (frequencyMap.containsKey(substring)) {
                frequencyMap.put(substring, frequencyMap.get(substring) + 1);
            } else {
                frequencyMap.put(substring, 1);
            }
        }
        return frequencyMap;
    }


    private static List<String> createSubstrings(String s, int numberCharacters) {
        List<String> substrings = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        int start = 0;
        for (int i = start; i < s.length() - 1; ) {
            for (int j = 0; j <= numberCharacters; j++) {
                builder.append(s.charAt(i));
                i++;

            }
            String s1 = builder.toString();
            char[] chars = s1.toCharArray();
            Arrays.sort(chars);
            substrings.add(new String(chars));
            builder.delete(0, builder.length());
            if(i>s.length()-1){
                return substrings;
            }
            i = ++start;

        }
        return substrings;
    }


    public static int sherlockAndAnagrams(String s) {
        /*
        1. We need to take all possible substrings from the string, starting from length=1 to length = s.length()-1
        2. We then need to see if they are anagrams, by sorting them and comparing if the lengths are even and the frequencies are the same
        3. We will keep all the substrings as map keys, and if we encounter the same substring we just increment the value of the key
        4. After we do this, the formula to calculate the result is the following: n(n-1)/2 for every key and we sum the result
         */

        //start with len1
        int result = 0;
        HashMap<String, Integer> substringMap = new HashMap<>();
        HashMap<Character, Integer> mapStringsLengthOne = getFrequencyMapOfCharacters(s);
        for (char c : mapStringsLengthOne.keySet()) {
            if (mapStringsLengthOne.get(c) > 1) {
                substringMap.put(String.valueOf(c), mapStringsLengthOne.get(c));
            }
        }

        //need way to create substrings of different lengths
        //Basically we will just create substrings and see if they appear or not..If it will be just 1, then it does not matter, cause it
        //will not count because of the formula

        int idxSubstring = 1;
        while (idxSubstring < s.length()) {
            List<String> substrings = createSubstrings(s, idxSubstring);
            HashMap<String, Integer> frequencySubstrings = getFrequencyMapOfSubstrings(substrings);
            for (String key:frequencySubstrings.keySet()){
                if(frequencySubstrings.get(key)>1){
                    substringMap.put(key, frequencySubstrings.get(key));
                }
            }
            idxSubstring++;
        }
        for (String key:substringMap.keySet()){
            result+=substringMap.get(key)*(substringMap.get(key)-1)/2;
        }
        return result;

    }

    public static void main(String[] args) {
        System.out.println(sherlockAndAnagrams("mom"));
        System.out.println(sherlockAndAnagrams("abba"));
        System.out.println(sherlockAndAnagrams("abcd"));
        System.out.println(sherlockAndAnagrams("kkkk"));
        System.out.println(sherlockAndAnagrams("aaaaa"));
        System.out.println(sherlockAndAnagrams("cccccc"));
        System.out.println(sherlockAndAnagrams("ifailuhkqq"));
        System.out.println(sherlockAndAnagrams("cdcd"));
        System.out.println(sherlockAndAnagrams("ifailuhkqqhucpoltgtyovarjsnrbfpvmupwjjjfiwwhrlkpekxxnebfrwibylcvkfealgonjkzwlyfhhkefuvgndgdnbelgruel"));

    }
}
