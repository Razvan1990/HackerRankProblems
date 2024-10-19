package hackerRank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class PickingNumbers {

    //the problem has been done in python-> this was just reformated for java
    private static int getMax(List<Integer> my_list) {
        int max = my_list.get(0);
        for (int i =1 ;i<my_list.size();i++) {
            if (my_list.get(i) > max) {
                max = my_list.get(i);
            }
        }

            return max;
    }


    public static int  pickingNumbers(List<Integer>a){
        //Write your code here

        int temp_index = 0;
        List<Integer>results = new ArrayList<>();
        int result = 1;  // cause we need an element at least
        Collections.sort(a);
        int index = 0;
        int i = 1;
        // this is used to not overrite the temp_index -> just when we have the first switch of values
        boolean has_changed = true;
        while (index < a.size()-1) {
            if (Math.abs(a.get(index) - a.get(i)) <= 1) {
                result += 1;
                //here we compare and see if the value has changed and keep track of the index where the value change to then start counting from here
                if (!Objects.equals(a.get(index), a.get(i)) && has_changed) {
                    temp_index = i;
                    has_changed = false;
                }
                i += 1;
                if (i >= a.size()) {
                    results.add(result);
                    break;
                }
            } else {

                results.add(result);
                if (temp_index == 0) {
                    index = i;
                }
                // test case d will have a infinite loop cause temp index will not change withut this conditions to see if the index changed. The else then is used just to updated correctly
                else if (!has_changed) {
                    index = temp_index;
                } else {
                    index = i;
                }
                result = 1;
                // i will become index+1 to continue counting corectly from the index where the value changed
                i = index + 1;
                has_changed = true;
            }
        }
        return getMax(results);
    }

    public static void main(String[] args) {
        
    }
}
