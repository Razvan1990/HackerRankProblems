package hackerRank;

import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GameOfThronesI {

    private static HashMap<Character, Integer> frequencyMap(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        return map;
    }

    private static boolean checkIfAllElementsAreOdd(List<Integer> list) {
        boolean result = true;
        for (int number : list) {
            if (number % 2 == 1) {

            } else {
                result = false;
                break;
            }

        }
        return result;
    }

    private static boolean checkIfAllElementsAreEven(List<Integer> list) {
        boolean result = true;
        for (int number : list) {
            if (number % 2 == 0) {

            } else {
                result = false;
                break;
            }

        }
        return result;
    }

    private static boolean checkListElementsOfTwo(int a, int b) {
        boolean result = false;
        if ((a % 2 == 1 && b % 2 == 0) || (a % 2 == 0 && b % 2 == 1)) {
            result = true;
        }
        return result;
    }

    private static boolean checkIfPalindromPossible(List<Integer> list, HashMap<Character, Integer> map) {
        boolean areAllOdd = checkIfAllElementsAreOdd(list);
        boolean areAllEven = checkIfAllElementsAreEven(list);
        int counter = 0;
        if (map.size() == 2) {
            if (checkListElementsOfTwo(list.get(0), list.get(1))) {
                return true;
            }
        }
        if (areAllOdd) {
            return false;
        }
        if (areAllEven) {
            return true;
        }
        for (int number : list) {
            if (number % 2 == 1) {
                counter++;
            }
        }
        if (counter == 1) {
            return true;
        } else {
            return false;
        }


    }

    public static String gameOfThrones(String s) {
        // Write your code here
        String result ="";
        if (s.length() <= 2) {
            return "YES";
        }
        HashMap<Character, Integer> charactersMap = frequencyMap(s);
        List<Integer> valuesOfFrequency = new ArrayList<>(charactersMap.values());
        boolean resultOperator = checkIfPalindromPossible(valuesOfFrequency, charactersMap);
        if(resultOperator){
            result ="YES";
        }else {
            result ="NO";
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(gameOfThrones("aaabbbb"));//yes
        System.out.println(gameOfThrones("cdefghmnopqrstuvw"));//no
        System.out.println(gameOfThrones("cdcdcdcdeeeef"));//yes
        System.out.println(gameOfThrones("aaaabbcc"));//yes
        System.out.println(gameOfThrones("aaaabbbbccccddddeee"));//yes
        System.out.println(gameOfThrones("aaaabbbbccccddddeeef"));//no
    }

}
