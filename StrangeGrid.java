package hackerRank;

import java.util.Arrays;
import java.util.List;

public class StrangeGrid {

    public static int strangeGrid(int r, int c) {
        // Write your code here
        int result;
        List<Integer> row1 = Arrays.asList(0, 2, 4, 6, 8);
        List<Integer> row2 = Arrays.asList(1, 3, 5, 7, 9);

        //check first on what row it is
        if (r % 2 == 0) {
            //we use row2
            result = (int) (row2.get(c - 1) + 10 * ((r - 1) / 2));
        } else {
            //we use row 1
            result = (int) (row1.get(c - 1) + 10 * ((r - 1) / 2));
        }
        return result;


    }

    public static void main(String[] args) {
        System.out.println(strangeGrid(6, 3));
        System.out.println(strangeGrid(5, 5));
        System.out.println(strangeGrid(7, 1));
        //overflow
        System.out.println(strangeGrid(2000000000, 2));
        System.out.println(strangeGrid(1000000011, 5));

    }
}

