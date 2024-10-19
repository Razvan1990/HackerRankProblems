package hackerRank;

import java.util.*;

public class Anagram {

    /*
    1. Two lists composed of the dividing strings
    2. From the two lists get 2 maps of frequency
    3.1 Check first if mapB contains the key of mapA -> If not add the frequencyNumber for that letter to the result
    3.2 Check first if mapB contains the key of mapA -> If yes, check if frequency of char of mapA is bigger than frequncy of mapB
    3.3 If so, then add the difference to the result
     */

    private static List<List<Character>> composeStringList(String s){
        List<List<Character>> stringLists = new ArrayList<>();
        List<Character> firstHalf = new ArrayList<>();
        List<Character> secondHalf = new ArrayList<>();
        for (int i =0;i<s.length()/2;i++){
            firstHalf.add(s.charAt(i));
        }
        for (int i = s.length()/2;i<s.length();i++){
            secondHalf.add(s.charAt(i));
        }
        stringLists.add(firstHalf); stringLists.add(secondHalf);
        return stringLists;
    }

    private static LinkedHashMap<Character, Integer> createFrequencyMapList(List<Character>list){
        LinkedHashMap<Character, Integer>frequencyMap = new LinkedHashMap<>();
        for (int i=0;i<list.size();i++){
            if(frequencyMap.containsKey(list.get(i))){
                frequencyMap.put(list.get(i), frequencyMap.get(list.get(i))+1);
            }else{
                frequencyMap.put(list.get(i), 1);
            }
        }
        return frequencyMap;
    }


    public static int anagram(String s) {
        // Write your code here
        int result = 0;
        if (s.length() % 2 == 1) {
            return -1;
        }
        List<List<Character>> charactersList = composeStringList(s);
        List<Character> firstPartString = charactersList.get(0);
        List<Character> secondPartString = charactersList.get(1);
        LinkedHashMap<Character, Integer> firstMap = createFrequencyMapList(firstPartString);
        LinkedHashMap<Character, Integer> secondMap = createFrequencyMapList(secondPartString);
        for (char c : firstMap.keySet()) {
            if (!secondMap.containsKey(c)) {
                result += firstMap.get(c);
            } else if (secondMap.containsKey(c) && firstMap.get(c) > secondMap.get(c)) {
                result += firstMap.get(c) - secondMap.get(c);
            }
        }
        return result;

    }
    public static void main(String[] args) {
        System.out.println(anagram("abccde"));
        System.out.println(anagram("aaabbb"));
        System.out.println(anagram("ab"));
        System.out.println(anagram("abc"));
        System.out.println(anagram("mnop"));
        System.out.println(anagram("xyyx"));
        System.out.println(anagram("xaxbbbxx"));
        System.out.println(anagram("hhpddlnnsjfoyxpciioigvjqzfbpllssuj"));
        System.out.println(anagram("xulkowreuowzxgnhmiqekxhzistdocbnyozmnqthhpievvlj"));
        System.out.println(anagram("ubuzlt"));
        System.out.println(anagram("aujteqimwfkjoqodgqaxbrkrwykpmuimqtgulojjwtukjiqrasqejbvfbixnchzsahpnyayutsgecwvcqngzoehrmeeqlgknnb"));
        System.out.println(anagram("dnqaurlplofnrtmh"));
//        Boolean test = true;
//        System.out.println(test.getClass().getName()+" = "+test);
    }

}
