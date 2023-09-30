package hackerRank;

import java.util.*;

public class MakingAnagrams {

    private static HashMap<Character, Integer> frequencyStringMap(String s) {
        LinkedHashMap<Character, Integer> myMap = new LinkedHashMap<>();
        for (char c : s.toCharArray()) {
            if (myMap.containsKey(c)) {
                myMap.put(c, myMap.get(c) + 1);
            } else {
                myMap.put(c, 1);
            }
        }
        return myMap;
    }

    /**
     * @param s1 String 1
     * @param s2 String 2
     * @return result
     * 1 We first need to create 2 maps for every string to see the occurrence of each character in the string
     * 2 We will take the characters of each string as a set
     * 3 Firstly we will traverse set1 and check if the second set contains the xth character of set1
     *     a. If so, then we need to make the difference between the frequency of the characters in the map, and add this to the result. This is because we need
     *      to ensure that all character have same occurrence to make anagrams
     *     b. If not, then we will add to the result the number of occurrences of the character from set1 which is not in set2
     * 4. We do the same for set2, but now we just need to check if is does not contain the characters of set1 -> it is analog to the else block of traversing set1
     * Adding again the same characters will result in adding again the common characters of the string
     */
    public static int makingAnagrams(String s1, String s2) {
        // Write your code here
        int result = 0;
        HashMap<Character, Integer> mapFirstString = frequencyStringMap(s1);
        HashMap<Character, Integer> mapSecondString = frequencyStringMap(s2);
        Set<Character> setStringOne = new HashSet<>(mapFirstString.keySet());
        Set<Character> setStringTwo = new HashSet<>(mapSecondString.keySet());
        for (char c : setStringOne) {
            if (setStringTwo.contains(c)) {
                result += Math.abs(mapFirstString.get(c) - mapSecondString.get(c));
            } else {
                result += mapFirstString.get(c);
            }
        }
        for (char c : setStringTwo) {
            if (!setStringOne.contains(c)) {
                //no need for this part because it is already done in setStringOne => it will create duplicate values
                result += mapSecondString.get(c);

            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(makingAnagrams("cde", "abc"));
        System.out.println(makingAnagrams("abc", "amnop"));
        System.out.println(makingAnagrams("absdjkvuahdakejfnfauhdsaavasdlkj", "djfladfhiawasdkjvalskufhafablsdkashlahdfa"));

    }
}
