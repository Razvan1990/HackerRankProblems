package hackerRank;

import java.util.Arrays;
import java.util.List;

public class BeautifulTriplets {

    public static int beautifulTriplets(int d, List<Integer> arr) {
        // Write your code here
        // check if the array contains number +d and if so then check if it also contains that number +d -> number +d+d
        int result = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.contains(arr.get(i) + d) && arr.contains(arr.get(i) + d * 2)) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> test1 = Arrays.asList(2,2,3,4,5);
        List<Integer> test2 = Arrays.asList(1, 2, 4, 5, 7, 8, 10);
        System.out.println(beautifulTriplets(1, test1));
        System.out.println(beautifulTriplets(3, test2));
    }


}
