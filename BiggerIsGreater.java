package hackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class BiggerIsGreater {

   /* public static String biggerIsGreater(String w) {
        // Write your code here
        StringBuilder result= new StringBuilder();
        char [] myArray = w.toCharArray();
        char maxCharacter = getMaxCharacter(myArray);
        for (int i = myArray.length-1;i>0;i--){
            if(i==1 && (int)myArray[i]>(int)myArray[i-1] && myArray[i]==maxCharacter){
                //try to find max character
            }

            if((int)myArray[i]>(int)myArray[i-1]){
                swapCharacters(myArray, i, i-1);
                break;
            }

        }
        for (char c : myArray) {
            result.append(c);
        }
        return result.toString();

    }*/
    public static String biggerIsGreater2(String w) {
        // Write your code here
        boolean foundDifferent = false;
        List<Character> characterList = new ArrayList<>();
        List<Character> characterListModification = new ArrayList<>();
        StringBuilder result= new StringBuilder();
        char [] myArray = w.toCharArray();
        for (char c:myArray){
            characterList.add(c);
        }

        if(w.length()==1){
            return "no answer";
        }
        if (w.length()==2){
            if(w.charAt(1)>w.charAt(0)){
                StringBuilder builder = new StringBuilder();
                builder.append(w.charAt(1));builder.append(w.charAt(0));
                return builder.toString();
            }
            else{
                return "no answer";
            }
        }
        char maxCharacter = getMaxCharacter(characterList);
        //char minCharacter = getMinCharacter(characterList);
        for (int i = myArray.length-1;i>0;i--){
            if(i==1 && myArray[i]>myArray[i-1] && myArray[i]==maxCharacter){
                StringBuilder builder = new StringBuilder();
                characterList.remove(Character.valueOf(maxCharacter));
                char etalon = characterList.get(0);
                char lowCharDiff = getCharLowestDifference(characterList, etalon);
                characterList.remove(Character.valueOf(lowCharDiff));
                arrangeListChars(characterList);
                //put all together
                characterListModification.add(lowCharDiff);
                characterListModification.addAll(characterList);
                characterListModification.add(maxCharacter);
                for (char c:characterListModification){
                    builder.append(c);
                }
                return builder.toString();
            }
            if(myArray[i]>myArray[i-1]){
                swapCharacters(myArray, i, i-1);
                foundDifferent = true;
                break;
            }
            else{
                result.delete(0, result.length());
                result.append("no answer");
            }

        }
        if(foundDifferent) {
            result.delete(0,result.length());
            for (char c : myArray) {
                result.append(c);
            }
        }
        return result.toString();

    }

    public static String biggerIsGreater3(String w) {
        char[] chars = w.toCharArray();
        int i= chars.length-1;
        while(i>0){
            if(chars[i-1]>=chars[i]){
                i--;
            }else{
                int j=i;
                //pivotul
                while(j<chars.length&&chars[j]>chars[i-1]){
                    j++;
                }
                char temp = chars[i-1];
                chars[i-1]=chars[j-1];
                chars[j-1]=temp;

                char[] newChar = new char[chars.length];
                for(int k=0;k<i;k++){
                    newChar[k]=chars[k];
                }
                int end = chars.length-1;
                for(int k=i;k<chars.length;k++){
                    newChar[k]=chars[end--];
                }
                return new String(newChar);
            }
        }
        return "no answer";
    }



    private static void swapCharacters(char []charcArrary, int a, int b){
        char temp = charcArrary[a];
        charcArrary[a]= charcArrary[b];
        charcArrary[b]= temp;
    }
    private static char getMaxCharacter(List<Character>chars){
        char max = chars.get(0);
        for (int i=0;i<chars.size();i++){
            if(chars.get(i)>max){
                max = chars.get(i);
            }
        }
        return max;
    }
    private static int getMinCharacter(List<Integer>ints){
        List<Integer>positiveIndexes = new ArrayList<>();
        for (int i:ints){
            if(i>0){
                positiveIndexes.add(i);
            }
        }
        int min = positiveIndexes.get(0);
        for(int i=1;i<positiveIndexes.size();i++){
            if (min<positiveIndexes.get(i)){
                min = positiveIndexes.get(i);
            }
        }
        return min;
    }

    private static char getCharLowestDifference(List<Character>chars, char start ){
        HashMap<Integer, Character> differenceMap = new HashMap<>();
        char result = 0;
        for (int i =1;i<chars.size();i++){
            int difference = chars.get(i)-start;
            differenceMap.put(difference,chars.get(i));
        }
        List<Integer> keyList = new ArrayList<>(differenceMap.keySet());
        int min = getMinCharacter(keyList);
        for (int key: differenceMap.keySet()){
            if (key == min && differenceMap.get(key)>start){
                result = differenceMap.get(key);
                break;
            }
        }
       return result;
    }

    private static void arrangeListChars(List<Character>list){
        for (int i =0;i<list.size();i++){
            for(int j =0;j<list.size();j++){
                if(list.get(j)>list.get(i)){
                    char temp = list.get(j);
                    list.set(j, list.get(i));
                    list.set(i, temp);
                }
            }
        }
    }

    public static void main(String[] args) {
        String w ="abzged";
        System.out.println(biggerIsGreater3(w));
    }


}
