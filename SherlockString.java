package hackerRank;

import java.util.*;

public class SherlockString {

    private static HashMap<Character, Integer> getFrequencyCharacterMap(String s) {
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (frequencyMap.containsKey(s.charAt(i))) {
                frequencyMap.put(s.charAt(i), frequencyMap.get(s.charAt(i)) + 1);
            } else {
                frequencyMap.put(s.charAt(i), 1);
            }
        }
        return frequencyMap;
    }

    private static int getMostFrequentElement(List<Integer> list) {
        HashMap<Integer, Integer> values = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            if (values.containsKey(list.get(i))) {
                values.put(list.get(i), values.get(list.get(i)) + 1);
            } else {
                values.put(list.get(i), 1);
            }
        }
        List<Integer> valuesList = new ArrayList<>(values.values());
        int max = getMaxValue(valuesList);
        return getKey(values, max);
    }

    private static int getKey(Map<Integer, Integer> map, Integer value) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                return entry.getKey();
            }
        }
        return 0;
    }

    private static int getMaxValue(List<Integer> list) {
        int max = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > max) {
                max = list.get(i);
            }
        }
        return max;

    }



    private static boolean checkNumbersOfList(List<Integer> values, int value) {
        int counter = 0;
        int difference = 0;
        int numbersOfOnes = 0;
        for (int number : values) {
            if (number == 1) {
                numbersOfOnes++;
            }
            if (number != value) {
                counter++;
                difference = Math.abs(number - value);

            }
        }
        if (numbersOfOnes > 1) {
            return false;
        }
        if (counter == 0) {
            return true;
        } else if (counter > 1) {
            return false;
        } else if (counter == 1 && numbersOfOnes == 1) {
            return true;
        } else if (counter == 1 && numbersOfOnes == 0) {
            if (difference == 1) {
                return true;
            } else {
                return false;
            }
        }
    return false;

    }

    public static String isValid(String s) {
        // Write your code here
        String resultFunction = "";
        HashMap<Character, Integer> freqMap = getFrequencyCharacterMap(s);
        List<Integer> characterAppereances = new ArrayList<>(freqMap.values());
        int mostFrequentElement = getMostFrequentElement(characterAppereances);
        boolean result = checkNumbersOfList(characterAppereances, mostFrequentElement);
        if (result) {
            resultFunction = "YES";
        } else {
            resultFunction = "NO";
        }
        return resultFunction;
    }

    public static void main(String[] args) {
        System.out.println(isValid("aabbccddeefghi"));
        System.out.println(isValid("abccc"));
        System.out.println(isValid("aabbcd"));
        System.out.println(isValid("abcdefghhgfedecba"));
        System.out.println(isValid("abcdefghhgfedecbad"));
        System.out.println(isValid("aabbc"));
        System.out.println(isValid("ibfdgaeadiaefgbhbdghhhbgdfgeiccbiehhfcggchgghadhdhagfbahhddgghbdehidbibaeaagaeeigffcebfbaieggabcfbiiedcabfihchdfabifahcbhagccbdfifhghcadfiadeeaheeddddiecaicbgigccageicehfdhdgafaddhffadigfhhcaedcedecafeacbdacgfgfeeibgaiffdehigebhhehiaahfidibccdcdagifgaihacihadecgifihbebffebdfbchbgigeccahgihbcbcaggebaaafgfedbfgagfediddghdgbgehhhifhgcedechahidcbchebheihaadbbbiaiccededchdagfhccfdefigfibifabeiaccghcegfbcghaefifbachebaacbhbfgfddeceababbacgffbagidebeadfihaefefegbghgddbbgddeehgfbhafbccidebgehifafgbghafacgfdccgifdcbbbidfifhdaibgigebigaedeaaiadegfefbhacgddhchgcbgcaeaieiegiffchbgbebgbehbbfcebciiagacaiechdigbgbghefcahgbhfibhedaeeiffebdiabcifgccdefabccdghehfibfiifdaicfedagahhdcbhbicdgibgcedieihcichadgchgbdcdagaihebbabhibcihicadgadfcihdheefbhffiageddhgahaidfdhhdbgciiaciegchiiebfbcbhaeagccfhbfhaddagnfieihghfbaggiffbbfbecgaiiidccdceadbbdfgigibgcgchafccdchgifdeieicbaididhfcfdedbhaadedfageigfdehgcdaecaebebebfcieaecfagfdieaefdiedbcadchabhebgehiidfcgahcdhcdhgchhiiheffiifeegcfdgbdeffhgeghdfhbfbifgidcafbfcd"));
        System.out.println(isValid("aaaabc"));
    }


}
