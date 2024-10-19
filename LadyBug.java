package hackerRank;

import java.util.*;

public class LadyBug {
    private static boolean checkCharArray(char [] array){
        boolean result = true;
        for (char c :array){
            if(c!='_'){
                return false;
            }
        }
        return result;
    }

    public static void switchCharacters(List<Character> charList, char a, char b,int poz1, int poz2){
        charList.set(poz1,b);
        charList.set(poz2, a);
    }

    private static boolean getResultOfCounts(List<Character>array){
        boolean result = false;
        int poz1 =0;int poz2=0;
        List<Character> countingList = new ArrayList<>();
        while(poz1<=array.size()-1 && poz2<=array.size()-1){
            if(array.get(poz1)==array.get(poz2)){
                countingList.add(array.get(poz1));
                poz1++;
            }
            else if(array.get(poz1)!=array.get(poz2) && countingList.size()<2){
                break;
            }
            else{
                countingList.clear();
                poz2++;
                }
            }
        if(countingList.size()>=2){
            result = true;
        }
        return result;

        }


    public static String happyLadybugs2(String b) {
        HashMap<Character, Integer> mapCharacters = new HashMap<>();
        char[] bugArray = b.toCharArray();
        List<Character> modifiedList = new ArrayList<>();
        List<Character> alphabeticalList = new ArrayList<>();
        List<Character> underscoreList = new ArrayList<>();
        boolean areJustUnderscores = checkCharArray(bugArray);
        String result = "";
        if (areJustUnderscores) {
            return "YES";
        }
        if(b.length()==1){
            return "NO";
        }
        if(b.length()==2){
            if(b.charAt(0)==b.charAt(1)){
                return "YES";
            }
            else {
                return "NO";
            }
        }

        for (int i = 0; i < bugArray.length; i++) {
            if (bugArray[i] == '_') {
                underscoreList.add(bugArray[i]);
            } else {
                alphabeticalList.add(bugArray[i]);
            }
        }
        if (underscoreList.size() != 0) {
            Collections.sort(alphabeticalList);
        }

        modifiedList.addAll(alphabeticalList);
        modifiedList.addAll(underscoreList);
        /*
        if (modifiedList.contains('_')) {
            for (int i = 0; i < modifiedList.size(); i++) {
                if (mapCharacters.containsKey(modifiedList.get(i))) {
                    if (modifiedList.get(i) != modifiedList.get(i - 1) && modifiedList.get(i) != '_' && modifiedList.get(i) != modifiedList.get(i + 1)) {
                        int poz = mapCharacters.get(modifiedList.get(i));
                        switchCharacters(modifiedList, modifiedList.get(poz + 1), modifiedList.get(i), poz + 1, i);
                    }
                } else {
                    mapCharacters.put(modifiedList.get(i), i);
                }
            }
        }
        */

        if(alphabeticalList.size()==1){
            return "NO";
        }
        if(alphabeticalList.size()==2){
            if(alphabeticalList.get(0)==alphabeticalList.get(1)){
                return "YES";
            }
            else {
                return "NO";
            }
        }
        if(alphabeticalList.get(0)!=alphabeticalList.get(1)){
            return "NO";
        }


        System.out.println("New list is " + alphabeticalList);
        for (int i = 1; i < alphabeticalList.size() - 1; i++) {
            if (alphabeticalList.get(i) != '_') {
                if(i==alphabeticalList.size()-2){
                    if(alphabeticalList.get(i)==alphabeticalList.get(i+1)){
                        result ="YES";
                        break;
                    }
                    else{
                        result ="NO";
                        break;
                    }
                }

                if (alphabeticalList.get(i) == alphabeticalList.get(i - 1) || alphabeticalList.get(i) == alphabeticalList.get(i + 1)) {
                    result = "YES";
                } else {
                    result = "NO";
                    break;
                }

            }
        }
        return result;
    }











    public static void main(String[] args) {
        System.out.println(happyLadybugs2("____ACCC__DD_EE_BCFFFB"));


        }

    }




