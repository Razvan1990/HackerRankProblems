package hackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotateLeft {

    //1. iN ORDER TO CORRECTLY MAKE THE LEFT ROTATION WE NEED A  TEMP LIST IN WHICH WE KEEP THE ROTATED ARRAY AT EVERY STEP
    //2. WE NEED A COUNTER TO SEE HOW MANY CHANGES THERE ARE. WHEN THE COUNTER IS EQUAL TO d, then we return that list in that stage
    //3. At the first rotation. we rotate the original list and use it as an input, afterwards we use our formed list as input for the new list


    private static List<Integer> modifyList(List<Integer> originalList) {
        List<Integer> rotatedList = new ArrayList<>();
        int first = originalList.get(0);
        for (int i = 0; i < originalList.size() - 1; i++) {
            rotatedList.add(originalList.get(i+1));

        }
        rotatedList.add(first);
        return rotatedList;
    }

    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
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
    public static List<Integer> rotateLeft2(int d, List<Integer> arr) {
        // Write your code here
        List<Integer> rotation = new ArrayList<>();
        for (int i = 0; i < d; i++) {
            int first = arr.get(0);
            for (int j = 0; i < arr.size() - 1; i++) {
                arr.add(arr.get(i + 1));

            }
            rotation.add(first);
            rotateLeft2(d, rotation);
        }
        return rotation;
    }


    public static void main(String[] args) {
        List<Integer> ex1 = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(rotateLeft(4, ex1));

    }

}



