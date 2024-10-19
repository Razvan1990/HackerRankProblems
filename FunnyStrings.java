package hackerRank;

import java.util.ArrayList;
import java.util.List;

public class FunnyStrings {

    private static int getNeighbourDifference(char a, char b){
        return Math.abs (a-b);
    }
    private static String getReversedString(String s){
        StringBuilder reverse = new StringBuilder();
        for(int i = s.length()-1;i>=0;i--){
            reverse.append(s.charAt(i));
        }
        return reverse.toString();
    }

    public static String funnyString(String s) {
        // Write your code here
        String reverse = getReversedString(s);
        List<Integer> normalStringDifferences = new ArrayList<>();
        List<Integer>reverseStringDifferences = new ArrayList<>();
        boolean isFunny = false;

        for (int i =0;i<s.length()-1;i++){
            int difference = getNeighbourDifference(s.charAt(i+1), s.charAt(i));
            normalStringDifferences.add(difference);
        }
        for (int i =0;i<reverse.length()-1;i++){
            int difference = getNeighbourDifference(reverse.charAt(i+1), reverse.charAt(i));
            reverseStringDifferences.add(difference);
        }

        //make now the comparision
        for (int i =0;i<normalStringDifferences.size();){
            for(int j =0;j<reverseStringDifferences.size();){
                if(normalStringDifferences.get(i)==reverseStringDifferences.get(j)){
                    isFunny=true;
                    i++;j++;
                }
                else
                {
                    isFunny=false;
                    break;
                }
            }
            if(!isFunny){
                break;
            }
        }

        return isFunny?"Funny":"Not Funny";



    }

    public static void main(String[] args) {
        System.out.println(funnyString("acxz"));
    }

}
