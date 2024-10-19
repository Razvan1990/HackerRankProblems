package hackerRank;

import java.util.*;
/*

NOT WORKING ON ALL TEST CASES
 */



public class AdjacentStrings {

    private static boolean checkIfAdjacentCharactersAreSame(String s) {
        if (s.length() == 2 && s.charAt(0) != s.charAt(1)) {
            return false;
        } else if (s.length() == 2 && s.charAt(0) == s.charAt(1)) {
            return true;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                return true;
            }
        }
        return false;
    }

    public static String superReducedString(String s) {
        // Write your code here
        String temp = s;
        if (s.length() == 2 && s.charAt(0) != s.charAt(1)){
            return s;
        }else if (s.length() ==2 && s.charAt(0)== s.charAt(1)){
            return "Empty String";
        }
        while (checkIfAdjacentCharactersAreSame(temp)) {
            if (temp.length() == 2 && temp.charAt(0) != temp.charAt(1)){
                return s;
            }else if (temp.length() ==2 && temp.charAt(0)== temp.charAt(1)){
                return "Empty String";
            }
            int counter = 0;
            StringBuilder builder = new StringBuilder();
            //boolean isChange = false;
            for (int i = 0; i < temp.length() - 1; i++) {
                if (i == s.length() - 2) {
                    if (temp.charAt(temp.length()-2) - 2 == temp.charAt(temp.length()-1)) {
                        counter++;
                        //because it is last we have to check here also
                        if (counter % 2 == 0 && counter > 0) {
                            builder.append(s.charAt(i));
                            counter = 0;
                        }
                    } else {
                        //just append last character
                        builder.append(s.charAt(s.length() - 1));


                    }
                } else {
                    if (temp.charAt(i) == temp.charAt(i + 1)) {
                        counter++;
                    } else {
                        if (counter % 2 == 0 && counter > 0) {
                            builder.append(s.charAt(i));
                            counter = 0;
                            //case in which we have only one letter
                        } else if (counter == 0) {
                            builder.append(s.charAt(i));
                        }
                    }
                }
            }
            temp = builder.toString();

        }
        if (temp.isEmpty()) {
            return "Empty String";
        } else {
            return temp;
        }
    }


    public static String superReducedString2(String s) {
// Write your code here
        s.toLowerCase();
        for (int i = 0; i < s.length()-1; i++) {
            if(s.charAt(i) == s.charAt(i+1)){
                s=s.replace(s.substring(i,i+2), "");
                i= -1;
            }
        }
        if(s.isEmpty()){
            return "Empty String";
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(superReducedString("aaabccddd"));
        System.out.println(superReducedString("aab"));
        System.out.println(superReducedString("abba"));
        System.out.println(superReducedString("aa"));

        System.out.println(superReducedString2("aaabccddd"));
        System.out.println(superReducedString2("aab"));
        System.out.println(superReducedString2("abba"));
        System.out.println(superReducedString2("aa"));



    }
}
