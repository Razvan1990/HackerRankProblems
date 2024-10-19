package hackerRank;

import java.util.*;

public class ManasaAndStones {

    public static List<Integer> stones(int n, int a, int b) {
        // Write your code here

        int sum = 0;
        Set<Integer> result = new HashSet<>();
        // bring first results -> from difference into difference
        for (int i = n-1;i>=0;i--){
            result.add((i*a)+(n-i-1)*b);
        }


        List<Integer>myList = new ArrayList<>(result);
        Collections.sort(myList);
        return myList;
    }

    public static void main(String[] args) {
        System.out.println(stones(3, 1, 2));
        System.out.println(stones(4, 10, 100));

    }
}
