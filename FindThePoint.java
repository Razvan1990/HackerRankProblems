
package hackerRank;


import java.util.ArrayList;
import java.util.List;

public class FindThePoint {


    public static List<Integer> findPoint(int px, int py, int qx, int qy) {
        // Write your code here
        List<Integer>result = new ArrayList<>();
        //we need to calculate the distance between q and p -> the result will be in fact the double of q to make 180 degrees - p
        int resultX = 2 * qx - px;
        int resultY = 2 * qy - py;

        result.add(resultX);
        result.add(resultY);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findPoint(0,0,1,1));
        System.out.println(findPoint(1,1,2,2));

    }
}
