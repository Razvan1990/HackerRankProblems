package hackerRank;

import java.util.HashMap;

public class RepeatedString {

    private static HashMap<Character, Long> getCharacterFrequencyMap(String s) {
        HashMap<Character, Long> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1L);
            }
        }
        return map;
    }

    public static long repeatedString(String s, long n) {
        // Write your code here

        //check first if we have 'a' in string
        if(!s.contains("a")){
            return 0;
        }
        //find the number of as
        HashMap<Character, Long> freqMap = getCharacterFrequencyMap(s);
        int lengthString = s.length();
        if (n == lengthString) {
            return freqMap.get('a');
        }
        long numberRepetitions = n / lengthString;
        long restLetters = n % lengthString;
        //create a temp variable that holds the number of 'a' of the repetition
        long tempResult = freqMap.get('a')*numberRepetitions;
        //check first to see if the restLetters is different than 0 and add them in a string
        //if so, make a map from the remaining letters and check to see if it has 'a'
        //if so, add the value to the tempResult
        long tempResultLetters =0;
        if (restLetters>0){
            StringBuilder builder = new StringBuilder();
            for (int i =0;i<restLetters;i++){
                builder.append(s.charAt(i));
            }
            HashMap<Character, Long> freqMapLetter = getCharacterFrequencyMap(builder.toString());
            if (freqMap.containsKey('a')){
                tempResultLetters = freqMapLetter.get('a');
            }
        }
        return tempResult+tempResultLetters;
    }

    public static void main(String[] args) {
        System.out.println(repeatedString("abcac", 10));
        System.out.println(repeatedString("aba", 10));
        //System.out.println(repeatedString("a", 1000000000000);
    }
}