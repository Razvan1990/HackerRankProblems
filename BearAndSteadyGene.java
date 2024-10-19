package hackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class BearAndSteadyGene {
    @SuppressWarnings({"Typo","Unused"})

    private static HashMap<Character, Integer> makeFrequencyMap(String s) {
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

    private static int getMostFoundElementOfString(HashMap<Character, Integer> map) {
        List<Integer> values = new ArrayList<>(map.values());
        int max = values.get(0);
        for (int i = 1; i < values.size(); i++) {
            if (values.get(i) > max) {
                max = values.get(i);
            }
        }
        return max;

    }

    private static int getMostRareElementOfString(HashMap<Character, Integer> map) {
        List<Integer> values = new ArrayList<>(map.values());
        int min = values.get(0);
        for (int i = 1; i < values.size(); i++) {
            if (values.get(i) < min) {
                min = values.get(i);
            }
        }
        return min;

    }

    private static char getMostOccurringKey(HashMap<Character, Integer> map, int max) {
        char result = 0;
        for (char key : map.keySet()) {
            if (map.get(key) == max) {
                result = Character.valueOf(key);
            }
        }
        return result;
    }

    private static char getMostRareKey(HashMap<Character, Integer> map, int min) {
        char result = 0;
        for (char key : map.keySet()) {
            if (map.get(key) == min) {
                result = Character.valueOf(key);
                break;
            }
        }
        return result;
    }

    private static String getSubstringBasedOnLetter(String s, int appereanceMax, int appereanceMin, int position, char c, char r) {
        List<Character> myList = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        int counterAppeareance = 0;
        for (int i = position; i < s.length(); i++) {
            myList.add(s.charAt(i));
            if (s.charAt(i) == c) {
                counterAppeareance++;
            }
            if (counterAppeareance == appereanceMax && ((myList.size() == appereanceMin && myList.contains(r)) || myList.size() > appereanceMin)) {
                for (char character : myList) {
                    builder.append(character);
                }
                return builder.toString();
            }
        }
        return " ";
    }

    /**
     * @param gene
     * @return number of modifications
     * 1. Make a frequency map of each character
     * 2. Get max occurrence of element and also min occurence of element
     * 3. See which is the keys which have these frequencies
     * 4. Make a method which counts and sees the length of substrings till we have exactly the difference of letters(both for min and max) based on average
     * 5. result will be the min of result and the created substring
     */

    public static int steadyGene(String gene) {
        // Write your code
        int result = gene.length();
        HashMap<Character, Integer> map = makeFrequencyMap(gene);
        int max = getMostFoundElementOfString(map);
        int min = getMostRareElementOfString(map);
        char mostFrequentLetter = getMostOccurringKey(map, max);
        char mostRareLetter = getMostRareKey(map, min);
        int average = gene.length() / 4;
        int differenceMax = max - average;
        int differenceMin = average - min;
        for (int i = 0; i < gene.length(); i++) {
            if (gene.charAt(i) == mostFrequentLetter) {
                //get the substring based on the most occuring letter and the least occuring one
                String substring = getSubstringBasedOnLetter(gene, differenceMax, differenceMin, i, mostFrequentLetter, mostRareLetter);
                if (!substring.equals(" ")) {
                    result = Math.min(result, substring.length());
                }
            }
        }


        if (result == gene.length()) {
            return 0;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(steadyGene("ACTGAAAG"));
        System.out.println(steadyGene("GAAATAAA"));
        System.out.println(steadyGene("TGATGCCGTCCCCTCAACTTGAGTGCTCCTAATGCGTTGC"));
        System.out.println(steadyGene("TATATAGCTTGTCTCCCTAATGTTAGTTCATGCTCGTAAGAGAACTTAGCCTACTAGGACGAGAGAACCGCACGGCGTCGTGAGGTATTTTTCGTAGGACACGCCAGATAGACGGTGGCAATGCCCGTTCAATATGACGCGATGTACGGCTAATGGGAACACTGCCCGACGCGTCTTTAGGACTGTGAGTTGCGGGTTACAGCTATGGTCTTATTGGTATCCGGCCCCTTTCGAGTCGCGATGCGCCTGCCACCACGATATTCGCCCGAAACGCGATTTGTGGGCGAGGTAGTCGTGTTCAACCCTGTAAATTTCCCTAGGTATAATCGTTCTAAGGTTCGCACATACACATCCACACCTACCTTTACACAGTTCGAGGTTCTATACGTCCTCTGAGTGCGTGTTAACACGCCCGTAAATGGGCATTTGGAGTCAGACCAGTACTTTGCGATAAACTTTACTTCCGCGAGACCTGTCCCTGGAACCCTGTTGTAAGGGTTAGGGTTTAATAGCTCCATGTCGTGTGCCTATAAGAAAAGGACGAATGGTGACAGTCCGGCTTAGCCAGGACAATGCGTGGCTGACGACGTCCAGGGTAAATTGAGTTGAATTCGCCTAATTTTAGGGTGTCTTGGTTCAATGAGGTGTCGACTTAACAAAAGGCGACATCAGTTGTCATCTTGCCTTGATAAAGTAAAACACGTGAATAGCCTATCCGGTCTGACCCCCGGGCCATGTGCTTCACCCAGGGAGCATCGCCGCTCTAGAGACGGTGTTCGTAGTCTCGATAACATGTGGGGTAATATAGAATATCCAAGACCGGTAGGAGGGGCGGTTCCGCGTCATAAGAAGTCCCAACGTGGCCTGCCACGTTCAAACAGGATACGCTATAACAGCTTCGTGGGTAATTGATGGATACGCCCGCAGGCTACCCATGCTCTTGCGATTTTGCAACCCTCGGAACCGTCACTCGTACACCCAGACATCATCTCATACAATTGCCTCACCTTCATGCCGGTACATAGGTGCCATCTCCGCTTAAGAATCCTCGCAGCAATTAATGTGACAGCACGCTAGTCCACTAGCGTATGATTACGCCACCGGGCCACCATGGACAAAAACGTTGAATTCCGACTAATAGACGAGTGTCCGATCGGGTCAACCGATCTCGGATGTTGCGTACCAGGACTACTGGGCTCGGGCCGAATCAGACACACGTATGCAACAGATACCGATAGGCGTCTTCCTAAGTAACAGCCGTAATCAATGGTGCCACAGATCTACTAATTACGGTGAAGATCATGGCCCACGACGCTGTACGGGTTTATAGCTGCCACAAACTTTAGGAAGTTTCAGCAATCGACGCGTAGTATGTGTGCTCAGACGGGTCGAGCATGCACTTGTGTATTAAGTTACTTGGCTGAACAACCTGTTGATAGATCTTGAGAGGACCGAGAAATTGCCCTCCGGTTATGAAACAGGTCCTGCGTACCAATCCTT"));


    }
}
