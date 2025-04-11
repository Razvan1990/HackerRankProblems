package leetcode;

import java.util.*;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        /**
         * We will create 2 hashmaps for the character pattern and the words in the string
         * We compare each map with length first and then every value to check if we have a 1-1 analogy
         */
        LinkedHashMap<Character, Integer> charMap = getCharFreqMap(pattern);
        LinkedHashMap<String, Integer> strMap = getStrFreqMap(s);
        if (charMap.size() != strMap.size()) {
            return false;
        }
        List<Integer> charList = new ArrayList<>(charMap.values());
        List<Integer> stringList = new ArrayList<>(strMap.values());
        for (int i = 0; i < charList.size(); i++) {
            if (!Objects.equals(charList.get(i), stringList.get(i))) {
                return false;
            }
        }
        // abab : dog cat cat dog
        boolean isAnalog = makeAnalogyMap(pattern, s);
        if (!isAnalog){
            return false;
        }
        return true;

    }

    private LinkedHashMap<Character, Integer> getCharFreqMap(String pattern) {
        LinkedHashMap<Character, Integer> freqMap = new LinkedHashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            if (freqMap.containsKey(pattern.charAt(i))) {
                freqMap.put(pattern.charAt(i), freqMap.get(pattern.charAt(i)) + 1);
            } else {
                freqMap.put(pattern.charAt(i), 1);
            }

        }
        return freqMap;
    }

    private LinkedHashMap<String, Integer> getStrFreqMap(String sentence) {
        // first we need to ignore the spaces
        String[] words = sentence.split(" ");
        LinkedHashMap<String, Integer> freqMap = new LinkedHashMap<>();
        for (String s : words) {
            if (freqMap.containsKey(s)) {
                freqMap.put(s, freqMap.get(s) + 1);
            } else {
                freqMap.put(s, 1);
            }
        }

        return freqMap;

    }

    private boolean makeAnalogyMap(String pattern, String sentence) {
        String[] words = sentence.split(" ");
        HashMap<Character, String> analogyMap = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            if (analogyMap.containsKey(pattern.charAt(i))) {
                if (!Objects.equals(analogyMap.get(pattern.charAt(i)), words[i])) {
                    return false;
                }
            } else {
                analogyMap.put(pattern.charAt(i), words[i]);
            }
        }
        return true;
    }


    public static void main(String[] args) {
        WordPattern pattern = new WordPattern();
        System.out.println(pattern.wordPattern("abba", "dog cat cat dog"));
        System.out.println(pattern.wordPattern("abba", "dog cat cat fish"));
        System.out.println(pattern.wordPattern("aaaa", "dog cat cat dog"));
        System.out.println(pattern.wordPattern("abab", "dog cat cat dog"));
    }

}
