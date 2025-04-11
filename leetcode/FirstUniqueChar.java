package leetcode;

import java.util.LinkedHashMap;

public class FirstUniqueChar {

    public int firstUniqChar(String s) {
        LinkedHashMap<Character, Integer> freqMap = getFreqMap(s);
        for (char key: freqMap.keySet()){
            if (freqMap.get(key) == 1){
                return s.indexOf(key);
            }
        }
        return -1;
    }


    private LinkedHashMap<Character, Integer> getFreqMap(String s){
        LinkedHashMap<Character, Integer> myMap = new LinkedHashMap<>();
        for (int i =0;i<s.length();i++){
            if (myMap.containsKey(s.charAt(i))){
                myMap.put(s.charAt(i), myMap.get(s.charAt(i))+1);
            } else {
                myMap.put(s.charAt(i), 1);
            }
        }
        return myMap;
    }


    public static void main(String[] args) {
        FirstUniqueChar fq = new FirstUniqueChar();
        String s1 = "leetcode";
        String s2 = "loveleetcode";
        String s3 ="aabb";
        System.out.println(fq.firstUniqChar(s1));
        System.out.println(fq.firstUniqChar(s2));
        System.out.println(fq.firstUniqChar(s3));


    }

}
