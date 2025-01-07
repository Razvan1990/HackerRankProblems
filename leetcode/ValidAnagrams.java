package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

public class ValidAnagrams {
    private HashMap<Character, Integer> makeFreqMap(String s){
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for (int i=0;i<s.length();i++){
            if (freqMap.containsKey(s.charAt(i))){
                freqMap.put(s.charAt(i), freqMap.get(s.charAt(i))+1);
            }else{
                freqMap.put(s.charAt(i), 1);
            }
        }
        return freqMap;
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        boolean result = true;
        //transform strings into string arrays to sort them
        char [] array1 = s.toCharArray();
        char [] array2 = t.toCharArray();
        Arrays.sort(array1);
        Arrays.sort(array2);
        //create new strings
        String sortedS = new String(array1);
        String sortedT = new String(array2);
        for (int i =0;i<s.length();i++){
            if(sortedS.charAt(i) != sortedT.charAt(i)){
                return false;
            }
        }
        return result;
    }

    public boolean isAnagram2 (String s, String t){
        HashMap<Character, Integer> mapS = makeFreqMap(s);
        HashMap<Character, Integer> mapT = makeFreqMap(t);
        if (s.length() != t.length()){
            return false;
        }
        boolean result = true;
        for (char c: mapS.keySet()){
            if (!Objects.equals(mapS.get(c), mapT.get(c))){
                return false;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ValidAnagrams validAnagrams = new ValidAnagrams();
        String s = "anagram";
        String t = "nagaram";

        String s1 = "car";
        String t1 = "rat";

        System.out.println(validAnagrams.isAnagram(s, t));
        System.out.println(validAnagrams.isAnagram(s1, t1));

    }
}
