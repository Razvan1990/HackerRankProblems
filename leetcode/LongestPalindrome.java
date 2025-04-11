package leetcode;

import java.util.HashMap;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        //check if s has one character
        if (s.length() == 1) {
            return 1;
        }
        if (s.length() == 2) {
            if (s.charAt(0) == s.charAt(1)) {
                return 2;
            }
        }
        HashMap<Character, Integer> freqMap = getCharacterFreqMap(s);
        // check if we have a single letter
        if (freqMap.size() ==1){
            Object firstIndex = freqMap.keySet().toArray()[0];
            return freqMap.get(firstIndex);
        }
        if (freqMap.size() ==2){
            Object firstIndex = freqMap.keySet().toArray()[0];
            Object secondIndex = freqMap.keySet().toArray()[1];
            if ((freqMap.get(firstIndex) % 2 ==0 && freqMap.get(secondIndex) % 2 !=0) || (freqMap.get(firstIndex) % 2 !=0 && freqMap.get(secondIndex) % 2 ==0)){
                return freqMap.get(firstIndex) + freqMap.get(secondIndex);
            }
        }
        int result = 0;
        boolean traversed = false;

        //basically we check how many even occurrences we have and we add 1
        for (char c : freqMap.keySet()) {
            if (freqMap.get(c) % 2 == 0) {
                result += freqMap.get(c);
            }
            //here we also need traversed to add +1 because we have an odd number -> we also need to have an even number to get a palindroime this way, like in cond from line 25
            else if (freqMap.get(c) % 2 !=0 && freqMap.get(c)>2) {
                result += freqMap.get(c)-1;
                traversed = true;
            }
            else if (freqMap.get(c) ==1) {
                traversed = true;
            }
        }
        if (!traversed){
            return result;
        }
        return result+1;
    }

    private HashMap<Character, Integer> getCharacterFreqMap(String s) {
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (freqMap.containsKey(s.charAt(i))) {
                freqMap.put(s.charAt(i), freqMap.get(s.charAt(i)) + 1);
            } else {
                freqMap.put(s.charAt(i), 1);
            }
        }
        return freqMap;
    }

    public static void main(String[] args) {
        String s1 ="abccccdd";
        String s2 ="a";
        String s3 ="apA";
        String s4 ="bananas";
        String s5 = "tattarrattat";
        LongestPalindrome palindrome = new LongestPalindrome();
        System.out.println(palindrome.longestPalindrome(s1));
        System.out.println(palindrome.longestPalindrome(s2));
        System.out.println(palindrome.longestPalindrome(s3));
        System.out.println(palindrome.longestPalindrome(s4));
        System.out.println(palindrome.longestPalindrome(s5));
    }

}
