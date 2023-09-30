package hackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RightRotation {

    private static List<Integer> modifyList(List<Integer> originalList) {
        List<Integer> rotatedList = new ArrayList<>();
        int end = originalList.get(originalList.size()-1);
        for (int i = 0; i < originalList.size() - 1; i++) {
                rotatedList.add(originalList.get(i));

        }
        rotatedList.add(0, end);
        return rotatedList;
    }

    public static List<Integer> rotateRight(int d, List<Integer> arr) {
        // Write your code here
        List<Integer> rotation = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        if (d == 0) {
            return new ArrayList<>(arr);
        }
        int counter = 0;
        for (int i = 0; i < d; i++) {
            if (i == 0) {
                tempList = modifyList(arr);
                counter++;
                if (counter == d) {
                    rotation = tempList;
                    break;
                }
            } else {
                tempList = modifyList(tempList);
                counter++;
                if (counter == d) {
                    rotation = tempList;
                    break;
                }
            }
        }

        return rotation;
    }
    public static void main(String[] args) {
        List<Integer> ex1 = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(rotateRight(4, ex1));

    }

}

