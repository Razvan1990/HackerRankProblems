package leetcode;

import java.util.*;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        LinkedHashMap<Character, Integer> freqMap1 = countLettersOfWord(s);
        LinkedHashMap<Character, Integer> freqMap2 = countLettersOfWord(t);
        // if the strings are not equal, cleary they are not isomorphic
        if (s.length() != t.length()) {
            return false;
        }
        if (s.equals(t)){
            return true;
        }
        //case of one letter
        if (s.length() == 1 || (s.length() == 2 && freqMap1.size() == freqMap2.size())) {
            return true;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t.charAt(i)) {
                return false;
            }
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) != s.charAt(i + 1) && t.charAt(i) == t.charAt(i + 1) ||
                    (s.charAt(i) == s.charAt(i + 1) && t.charAt(i) != t.charAt(i + 1))) {
                return false;
            }
        }

        System.out.println(freqMap1);
        System.out.println(freqMap2);
        if (freqMap1.size() != freqMap2.size()) {
            return false;
        }
        /**
         * may be useless
         */
        List<Integer> l1 = new ArrayList<>(freqMap1.values());
        List<Integer> l2 = new ArrayList<>(freqMap2.values());
        Collections.sort(l1);
        Collections.sort(l2);
        for (int i = 0; i < l1.size(); i++) {
            if (!Objects.equals(l1.get(i), l2.get(i))) {
                return false;
            }
        }


        return true;

    }

    private LinkedHashMap<Character, Integer> countLettersOfWord(String word) {
        LinkedHashMap<Character, Integer> letterCount = new LinkedHashMap<>();
        for (int i = 0; i < word.length(); i++) {
            if (letterCount.containsKey(word.charAt(i))) {
                letterCount.put(word.charAt(i), letterCount.get(word.charAt(i)) + 1);
            } else {
                letterCount.put(word.charAt(i), 1);
            }
        }
        return letterCount;
    }
    /**
     * There is no need to get the frequency, just to have the characters and indices positions
     * If the indices are not equal then we don't have isomorphic, meaning that a character at a index is also present at another index different than in the other string


     */
    public boolean isIsomorphic2(String s, String t) {
        HashMap<Character, Integer> charIndexS = new HashMap<>();
        HashMap<Character, Integer> charIndexT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (!charIndexS.containsKey(s.charAt(i))) {
                charIndexS.put(s.charAt(i), i);
            }

            if (!charIndexT.containsKey(t.charAt(i))) {
                charIndexT.put(t.charAt(i), i);
            }

            if (!charIndexS.get(s.charAt(i)).equals(charIndexT.get(t.charAt(i)))) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        IsomorphicStrings isomorphicStrings = new IsomorphicStrings();
        System.out.println(isomorphicStrings.isIsomorphic("egg", "add"));
        System.out.println(isomorphicStrings.isIsomorphic("foo", "bar"));
        System.out.println(isomorphicStrings.isIsomorphic("paper", "title"));
    }


}
