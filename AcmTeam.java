package hackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class AcmTeam {
    //need a static variable to increment the map index
    static int index = 1;

    /**
     * make or between characters
     * @param a
     * @param b
     * @return 0 or 1
     */

    private static char getOrResult(char a, char b) {
        if (a == '0' && b == '0') {
            return '0';
        } else {
            return '1';
        }
    }

    /**
     * counts the numbers of ones in each result string
     * @param results
     * @return a list of ints that contain the number of ones in each result string
     */

    private static List<Integer> getListOfOnes(List<String> results) {
        List<Integer> numberOnes = new ArrayList<>();
        for (String binaryNumber : results) {
            int number = 0;
            for (int i = 0; i < binaryNumber.length(); i++) {
                if (binaryNumber.charAt(i) == '1') {
                    number++;
                }

            }
            numberOnes.add(number);


        }
        return numberOnes;

    }

    /**
     *
     * @param onesList
     * @return max number of the count of 1 in the list of ones
     */

    private static int getMaxNumberOfOnes(List<Integer> onesList) {
        int max = onesList.get(0);
        for (int i = 1; i < onesList.size(); i++) {
            if (onesList.get(i) > max) {
                max = onesList.get(i);
            }
        }
        return max;
    }


    public static List<Integer> acmTeam(List<String> topic) {
        // Write your code here
        List<Integer>finalResult = new ArrayList<>();
        //we need a list first to add all the results of the computations between the digits of the strings from topics
        List<String> results = new ArrayList<>();
        //this map will store the index of the team (from static int index) and the number of ones
        HashMap<Integer, Integer> map = new HashMap<>();
        //we will make or for every pair possible and concatenate them with the help of a stringbuilder. Finally we put the value of each computation in the results list
        int i = 0;
        while (i < topic.size()-1) {
            for (int j = i + 1; j < topic.size(); j++) {
                StringBuilder builder = new StringBuilder();
                for (int k = 0; k < topic.get(i).length(); k++) {
                    char result = getOrResult(topic.get(i).charAt(k), topic.get(j).charAt(k));
                    builder.append(result);
                }
                results.add(builder.toString());
                builder.delete(0, builder.length());
            }
            i++;
        }
        //we find the number of ones for each computed string-> the size is the same as the number of results
        List<Integer>numberOfOnes = getListOfOnes(results);
        for (int idx =0;idx<numberOfOnes.size();idx++){
            map.put(index, numberOfOnes.get(idx));
            index++;
        }
        int numberTeamsMax =0;
        //we find the max number of ones from the ones list and we then check how many teams from the map have the max value
        int maxOnes = getMaxNumberOfOnes(numberOfOnes);
        for (int number:map.keySet()){
            if (map.get(number)==maxOnes){
                numberTeamsMax++;
            }
        }
        finalResult.add(maxOnes);
        finalResult.add(numberTeamsMax);
        return finalResult;



    }

    public static void main(String[] args) {
        //to put the results
        List<String>test1 = Arrays.asList("10101","11110","00010");
        List<String>test2 = Arrays.asList("10101","11100","11010","00101");
        System.out.println(acmTeam(test1));
        System.out.println(acmTeam(test2));
    }
}
