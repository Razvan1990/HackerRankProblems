package hackerRank;

import javax.xml.stream.events.Characters;
import java.util.*;

public class TwoCharacters {


    private static List<Character> getCharList(String s){
        List<Character>characterList = new ArrayList<>();
        for(int i =0;i<s.length();i++){
            characterList.add(s.charAt(i));
        }
        return characterList;
    }


    private static String getWordComputed(List<Character>list){
        List<Character> originalList = new ArrayList<>(list);
        StringBuilder builder = new StringBuilder();
        for (int i =0;i<list.size()-1;i++){
          if(list.get(i)==list.get(i+1)){
              list.removeAll(Collections.singleton(list.get(i)));
              break;
          }
      }
      for (char c: list){
          builder.append(c);
      }
      if(list.size()==originalList.size()){
          return builder.toString();
      }
      return getWordComputed(list);

    }




    private static int getMax(List<Integer>listValues){
        if(listValues.size()==0){
            return 0;
        }
        if (listValues.size()==1){
            return listValues.get(0);
        }
        int max = listValues.get(0);
        for(int i =1;i<listValues.size();i++){
            if(listValues.get(i)>max){
                max = listValues.get(i);
            }


        }
        return max;
    }

    private static String getMaxLength(List<String>strings) {
        String result = "";
        List<Integer>values = new ArrayList<>();
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for (String word : strings) {
            map.put(word, word.length());
            values.add(word.length());
        }
        int max = getMax(values);
        for (String s : map.keySet()) {
            if (map.get(s) == max) {
                result = s;
            }
        }
    return result;
    }


    private static String findOccurenceOfCharacters(String s){
        LinkedHashMap<Character, Integer> frequencyCharacterMap = new LinkedHashMap<>();
        LinkedHashMap<Character, Integer> nonOneFrequencyCharacterMap = new LinkedHashMap<>();
        List<String>maximumStrings = new ArrayList<>();
        List<Character>neighbourCharacters = new ArrayList<>();
        for (int i =0;i<s.length();i++){
            if(frequencyCharacterMap.containsKey(s.charAt(i))){
                frequencyCharacterMap.put(s.charAt(i), frequencyCharacterMap.get(s.charAt(i))+1);
            }
            else{
                frequencyCharacterMap.put(s.charAt(i),1);
            }
        }

        for (char c:frequencyCharacterMap.keySet()){
            if(frequencyCharacterMap.get(c)==1){
                s = s.replace(String.valueOf(c),"");

            }
            else{
                nonOneFrequencyCharacterMap.put(c, frequencyCharacterMap.get(c));
            }
        }


        List<Character>characters = getCharList(s);
        Set<Character>mySet = new HashSet<>(characters);
        if(mySet.size()==2){
            return s;
        }
        String beforeConversion = s;
        for(char c:nonOneFrequencyCharacterMap.keySet()){
            for(int i =0;i<s.length();i++){
                if(String.valueOf(c).equals(String.valueOf(s.charAt(i)))){
                    neighbourCharacters.add(c);
                    neighbourCharacters.add(s.charAt(i + 1));
                    for(char letter :characters){
                        if(letter!=neighbourCharacters.get(0) && letter!=neighbourCharacters.get(1)){
                           s = s.replace(String.valueOf(letter),"");
                        }
                    }
                   String result = getWordComputed(getCharList(s));
                    neighbourCharacters.clear();
                   if(result.length()>3){
                       maximumStrings.add(result);
                   }
                   break;

                }
            }
            s = beforeConversion;
        }

        return getMaxLength(maximumStrings);
    }

    public static int alternate(String s) {
        // Write your code here

        if (s.length()<2){
            return 0;
        }
        if(s.length()==2){
            return s.length();
        }

        String result1 =getWordComputed(getCharList(s));
        String result2  = findOccurenceOfCharacters(result1);
        System.out.println(result2);
        return result2.length();

    }

    public static void main(String[] args) {
        //System.out.println(alternate("abaacdabd"));
        //System.out.println(alternate("beabeefeab"));
        System.out.println(alternate("asdcbsdcagfsdbgdfanfghbsfdab"));
    }
}
