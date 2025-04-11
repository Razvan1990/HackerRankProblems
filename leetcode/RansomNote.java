package leetcode;

import org.checkerframework.checker.units.qual.C;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Objects;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()){
            return false;
        }
        LinkedHashMap<Character,Integer> ransomeNotMap = getCharactterFreqMap(ransomNote);
        LinkedHashMap<Character, Integer> magazineMap = getCharactterFreqMap(magazine);
        for (char letter: ransomeNotMap.keySet()){
            if (!magazineMap.containsKey(letter)){
                return false;
            }else{
                //need to check instead just if magazine map has the character less present than in ransomeNote
                if (magazineMap.get(letter)<ransomeNotMap.get(letter)){
                    return false;
                }
            }

        }
        return true;

    }


    private LinkedHashMap<Character, Integer> getCharactterFreqMap(String word){
        LinkedHashMap<Character, Integer> freqMap = new LinkedHashMap<>();
        for (int i =0;i<word.length();i++){
            if (freqMap.containsKey(word.charAt(i))){
                freqMap.put(word.charAt(i), freqMap.get(word.charAt(i))+1);
            }else{
                freqMap.put(word.charAt(i),1);
            }
        }
        return freqMap;
    }

    public static void main(String[] args) {
        RansomNote ransomNote = new RansomNote();
        System.out.println(ransomNote.canConstruct("a","b"));
        System.out.println(ransomNote.canConstruct("aa", "ab"));
        System.out.println(ransomNote.canConstruct("aa", "aab"));
    }
}
