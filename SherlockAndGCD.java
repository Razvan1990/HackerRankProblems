package hackerRank;

import java.util.*;

public class SherlockAndGCD {

    private static boolean checkForDifferentNumbers(List<Integer> list) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int element : list) {
            if (freqMap.containsKey(element)) {
                freqMap.put(element, freqMap.get(element) + 1);
            } else {
                freqMap.put(element, 1);
            }

        }
        Set<Integer> keys = new HashSet<>(freqMap.keySet());
        return keys.size() == 1;
    }


    private static boolean checkForDivisors(int a, int b) {
        boolean answer = false;
        //check till the lowest number
        if (a < b) {
            for (int i = 2; i <= a; i++) {
                if (!(a % i == 0 && b % i == 0)) {
                    answer = true;
                    break;
                }
            }
        } else if (a > b) {
            for (int i = 2; i <= b; i++) {
                if (!(b % i == 0 && a % i == 0)) {
                    answer = true;
                    break;
                }
            }
        }
        return answer;

    }

    public static String solve(List<Integer> a) {
        // Write your code here
        //stating condtions to make it true
        if (a.contains(1)) {
            return "YES";
        }
        if (checkForDifferentNumbers(a)) {
            return "NO";
        }
        //make all possible combinations of 2 elements
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.size(); j++) {
                if (checkForDivisors(a.get(i), a.get(j))) {
                    return "YES";

                }
            }
        }
        return "NO";


    }

    public static void main(String[] args) {
        List<Integer>test1 = Arrays.asList(1,2,3);
        List<Integer>test2 = Arrays.asList(2,4);
        List<Integer>test3 = Arrays.asList(5,5,5);
        System.out.println(solve(test1));
        System.out.println(solve(test2));
        System.out.println(solve(test3));
    }
}
