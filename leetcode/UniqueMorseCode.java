package hackerRank.leetcode;

import java.util.*;

public class UniqueMorseCode {
    public HashMap<Character, String> morseCode = new HashMap<Character, String>();

    public int uniqueMorseRepresentations(String[] words){
        morseCode.put('a', ".-");
        morseCode.put('b', "-...");
        morseCode.put('c', "-.-.");
        morseCode.put('d', "-..");
        morseCode.put('e', ".");
        morseCode.put('f', "..-.");
        morseCode.put('g', "--.");
        morseCode.put('h', "....");
        morseCode.put('i', "..");
        morseCode.put('j', ".---");
        morseCode.put('k', "-.-");
        morseCode.put('l', ".-..");
        morseCode.put('m', "--");
        morseCode.put('n', "-.");
        morseCode.put('o', "---");
        morseCode.put('p', ".--.");
        morseCode.put('q', "--.-");
        morseCode.put('r', ".-.");
        morseCode.put('s', "...");
        morseCode.put('t', "-");
        morseCode.put('u', "..-");
        morseCode.put('v', "...-");
        morseCode.put('w', ".--");
        morseCode.put('x', "-..-");
        morseCode.put('y', "-.--");
        morseCode.put('z', "--..");

        List<String> convertedWords = new ArrayList<String>();
        for (String word : words){
            StringBuilder convertedWord = new StringBuilder();
            for (char c : word.toCharArray()){
                convertedWord.append(morseCode.get(c));
            }
            convertedWords.add(convertedWord.toString());
        }
        // check number of unique
        Set<String> result = new HashSet<String>(convertedWords);
        return result.size();
    }

    static void main() {
        UniqueMorseCode obj = new UniqueMorseCode();
        String [] words1 = {"gin","zen","gig","msg"};
        System.out.println(obj.uniqueMorseRepresentations(words1));
        String [] words2 = {"a"};
        System.out.println(obj.uniqueMorseRepresentations(words2));
    }
}
