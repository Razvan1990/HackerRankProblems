package hackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GridChallenge {



    public static String gridChallenge(List<String> grid) {
        // Write your code here


        List<String>orderedList = new ArrayList<>();
        for (String word:grid){
            char [] arrayWord = word.toCharArray();
            Arrays.sort(arrayWord);
            String newWord = new String(arrayWord);
            orderedList.add(newWord);
        }
        if(orderedList.size()==1){
            return "YES";
        }

        //check every character of every word in list if they are ordered
        //there could be 4 words with 3 letters that is why we need the length of the word
        int idx = 0;
        int j = 0;
        int sizeWord = orderedList.get(idx).length();
        while (idx < sizeWord) {
            if ((int) orderedList.get(j).charAt(idx) > (int) orderedList.get(j + 1).charAt(idx)) {
                return "NO";
            }
            else if (j == orderedList.size()-2) {
                idx++;
                j = 0;
            }else{
                j++;
            }


        }

        return"YES";


}

    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("abc", "ade", "efg");
        List<String> list2 = Arrays.asList("ebacd", "fghij","olmkn","trpqs","xywuv");
        System.out.println(gridChallenge(list1));
        System.out.println(gridChallenge(list2));

    }
}
