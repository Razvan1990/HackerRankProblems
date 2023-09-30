package hackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HackerRankString {
    /*
        private static List<Integer>getCharacterPositions(String s, char letter){
            List<Integer> charsPosition = new ArrayList<>();
            for (int i =0;i<s.length();i++){
                if (s.charAt(i)==letter){
                    charsPosition.add(i);
                }
            }
            return charsPosition;
        }

        private static boolean checkCharacter(String s, char letter, List<Integer> positions){
            for (int i =0;i<s.length();i++){
                if (s.charAt(i)==letter){
                    for (int position:positions){
                        if (i<position){
                            return true;
                        }
                    }
                }

            }
            return false;
        }

        private static boolean checkFinalK(String s, char letter, List<Integer> positions){
            for (int i =0;i<s.length();i++){
                if (s.charAt(i)==letter){
                    for (int position:positions){
                        if (i>position){
                            return true;
                        }
                    }
                }

            }
            return false;
        }




        public static String hackerrankInString(String s) {
            String resultToCompare = "hackerrank";
            if (s.equals(resultToCompare)){
                return "YES";
            }
            // Write your code here


            //Get all lists needed for every character

            List<Integer>listOfa = getCharacterPositions(s, 'a');
            List<Integer>listOfc = getCharacterPositions(s, 'c');
            List<Integer>listOfk = getCharacterPositions(s, 'k');
            List<Integer>listOfe = getCharacterPositions(s, 'e');
            List<Integer>listOfr = getCharacterPositions(s, 'r');
            List<Integer>listOfn = getCharacterPositions(s, 'n');

            //Check result for every character

            boolean result1 = checkCharacter(s, 'h',listOfa);
            boolean result2 = checkCharacter(s, 'a',listOfc);
            boolean result3 = checkCharacter(s, 'c',listOfk);
            boolean result4 = checkCharacter(s, 'k',listOfe);
            boolean result5 = checkCharacter(s, 'e',listOfr);
            boolean result6 = checkCharacter(s, 'r',listOfr);
            boolean result7 = checkCharacter(s, 'r',listOfa);
            boolean result8 = checkCharacter(s, 'a',listOfn);
            boolean result9 = checkCharacter(s, 'n',listOfk);
            boolean result10 = checkFinalK(s,'k',listOfn );
            if(result1 && result2 && result3 && result4 && result5 && result6 && result7 && result8 && result9 && result10){
                return "YES";
            }
            return "NO";
        }
        */
    private static int getIndexOfLettersInString(String s, char letter) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == letter) {
                return i;
            }

        }
        return 0;
    }

    private static boolean checkIfListIsOrdered(List<Integer> positionList) {
        boolean result = false;
        for (int i = 0; i < positionList.size() - 1; i++) {
            if (positionList.get(i) == 0) {
                return result;
            } else if (positionList.get(i) < positionList.get(i + 1)) {
                result = true;
            } else {
                return false;
            }
        }
        return result;
    }


    public static String hackerrankInString(String s) {
        String resultToCompare = "hackerrank";
        if (s.equals(resultToCompare)) {
            return "YES";
        }
        //get booleans of all letters?
        List<Integer> countingList = new ArrayList<>();
        List<Integer> modelList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int poz1 = 0;int poz2 =0;int step =1;

        //iterrate everything
        while (poz1 < s.length()) {
            if (s.charAt(poz1) == 'h' && step==1) {
                //poz1 = s.indexOf('h');
                step = 2;
                countingList.add(1);
                poz1++;
            }
            else if (s.charAt(poz1) == 'a' && step==2) {
               //poz1 = s.indexOf('a');
                step =3;
                countingList.add(2);
                poz1++;

            }
            else if (s.charAt(poz1) == 'c' && step==3) {
                //poz1 = s.indexOf('c');
                step =4;
                countingList.add(3);
                poz1++;
            }
            else if (s.charAt(poz1) == 'k' && step==4) {
               // poz1 = s.indexOf('k');
                step =5;
                countingList.add(4);
                poz1++;
            }
            else if (s.charAt(poz1) == 'e' && step ==5) {
                //poz1 = s.indexOf('e');
                step =6;
                countingList.add(5);
                poz1++;
            }
            else if (s.charAt(poz1) == 'r' && step ==6) {
               // poz1 = s.indexOf('r');
                poz2 = s.indexOf('r');
                step = 7;
                countingList.add(6);
                poz1++;
            }
            else if (s.charAt(poz1) == 'r' && step ==7 && poz1>poz2) {
                //poz1 = s.indexOf('r');
                step =8;
                countingList.add(7);
                poz1++;
            }
            else if (s.charAt(poz1) == 'a' && step ==8) {
                //poz1 = s.indexOf('a');
                step =9;
                countingList.add(8);
                poz1++;
            }
            else if (s.charAt(poz1) == 'n' && step ==9) {
               // poz1 = s.indexOf('n');
                step =10;
                countingList.add(9);
                poz1++;
            }
            else if (s.charAt(poz1) == 'k' && step ==10) {
                countingList.add(10);
                break;
            }
            else {
                poz1++;
            }
        }
        for (int element:countingList){
            System.out.println(element+" ");
        }

        if (countingList.containsAll(modelList)) {
            return "YES";
        }

        return "NO";

    }

    public static void main(String[] args) {
        System.out.println(hackerrankInString("hereiamstackerrank"));

    }
}
