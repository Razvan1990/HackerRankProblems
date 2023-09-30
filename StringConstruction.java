package hackerRank;

import java.util.ArrayList;
import java.util.List;

public class StringConstruction {

    public static int stringConstruction(String s) {
        /**
         * use of maps/even list to see if character already exists. If so, you can append it till you find a new letter
         */
        // Write your code here
        int result =0;
        List<Character>characterList = new ArrayList<>();
        for (int i =0;i<s.length();i++){
            if(characterList.contains(s.charAt(i))){

            }
            else{
                characterList.add(s.charAt(i));
                result++;
            }
        }
        return result;

    }

    public static void main(String[] args) {
        int result1 = stringConstruction("abcd");
        int result2 = stringConstruction("abcabc");
        int result3 = stringConstruction("abab");
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }
}
