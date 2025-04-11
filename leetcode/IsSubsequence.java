package leetcode;

import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {
       int start =0;
       int next = 0;
       while(next<t.length() && start < s.length()){
           if (s.charAt(start) == t.charAt(next)){
               start++;
           }
           next++;

       }
       //finally we should check if the start indeed matches the s length
        return start == s.length();
    }




    public static void main(String[] args) {
        IsSubsequence isSubsequence = new IsSubsequence();
        String t = "ahbgdcab";
        String s = "abcb";

        String s1 = "abc";
        String t1 = "ahbgdc";
        System.out.println(isSubsequence.isSubsequence(s,t));
        System.out.println(isSubsequence.isSubsequence(s1,t1));
    }
}
