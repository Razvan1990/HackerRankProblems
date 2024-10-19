package hackerRank;

import javax.security.auth.callback.CallbackHandler;
import java.util.*;

public class WeightedUniformString {

    private static HashMap<Character, Integer> getWeightCharacterMap() {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('a', 1);
        map.put('c', 3);
        map.put('e', 5);
        map.put('g', 7);
        map.put('i', 9);
        map.put('k', 11);
        map.put('b', 2);
        map.put('d', 4);
        map.put('f', 6);
        map.put('h', 8);
        map.put('j', 10);
        map.put('l', 12);
        map.put('m', 13);

        map.put('n', 14);
        map.put('p', 16);
        map.put('r', 18);
        map.put('t', 20);
        map.put('v', 22);
        map.put('x', 24);
        map.put('z', 26);
        map.put('o', 15);
        map.put('q', 17);
        map.put('s', 19);
        map.put('u', 21);
        map.put('w', 23);
        map.put('y', 25);
        return map;
    }
    //aaabbbbcccddd
    private static List<Integer>computeListOfValues(String s){
        HashMap<Character, Integer> map = getWeightCharacterMap();
        List<Integer>values = new ArrayList<>();
        if (s.length()==1){
            values.add(map.get(s.charAt(0)));
            return values;
        }
        int sum =0;
        for (int i =0;i<s.length()-1;i++){
            if (i == s.length()-2){
                if (s.charAt(i)==s.charAt(i+1)){
                    sum+=map.get(s.charAt(i));
                    values.add(sum);
                    sum+=map.get(s.charAt(i+1));
                    values.add(sum);
                }
                else{
                    sum+=map.get(s.charAt(i));
                    values.add(sum);
                    values.add(map.get(s.charAt(i+1)));
                }
            }
            else if(s.charAt(i)==s.charAt(i+1)){
                sum+=map.get(s.charAt(i));
                values.add(sum);
            }
            else{
                sum+=map.get(s.charAt(i));
                values.add(sum);
                sum =0;
            }
        }
        return values;
    }


    /**
     * It is working but, time limit exceeded
     *
     * @param s
     * @param queries
     * @return a list
     */


    public static List<String> weightedUniformStrings(String s, List<Integer> queries) {
        // Write your code here
        boolean entered = false;
        List<String> results = new ArrayList<>();
        HashMap<Character, Integer> weightMap = getWeightCharacterMap();
        for (int query : queries) {
            int poz1 = 0;
            int poz2 = 0;
            int sum = 0;
            while (poz1 < s.length() && poz2 < s.length()) {
                int weightLetter = weightMap.get(s.charAt(poz1));
                if (query == weightLetter) {
                    results.add("Yes");
                    entered = true;
                    break;
                } else {
                    if (s.charAt(poz1) == s.charAt(poz2)) {
                        sum += weightMap.get(s.charAt(poz1));
                        poz2++;
                        if (sum == query) {
                            results.add("Yes");
                            entered = true;
                            break;
                        }
                    } else {
                        poz1 = poz2;
                        sum = 0;

                    }


                }

            }
            if (!entered) {
                results.add("No");
            }
            entered = false;
        }


        return results;
    }

    /**
     * Method to resolve time limit exceeded -> just a quick o(n) trough queries, not O(n2) in method. However, by adding time in computeListOfValues is
     * still o(n squared)
     * @param s
     * @param queries
     * @return list
     */

    public static List<String> weightedUniformStrings2(String s, List<Integer> queries) {
        List<Integer> valuesInString = computeListOfValues(s);
        List<String> results = new ArrayList<>();
        for (int query:queries){
            if (valuesInString.contains(query)){
                results.add("Yes");
            }
            else{
                results.add("No");
            }
        }
        return results;
    }

    public static void main(String[] args) {
        List<Integer> queries = Arrays.asList(9,7,8,12,5);
        System.out.println(weightedUniformStrings("aaabbbbcccddd", queries));
        System.out.println(weightedUniformStrings2("aaabbbbcccddd", queries));

    }

}
