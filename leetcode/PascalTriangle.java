package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> oneElement = new ArrayList<>();
        List<Integer> twoElement = new ArrayList<>();
        if (numRows == 1) {
            oneElement.add(1);
            result.add(oneElement);
            return result;
        } else if (numRows == 2) {
            oneElement.add(1);
            result.add(oneElement);
            twoElement.add(1);
            twoElement.add(1);
            result.add(twoElement);
            return result;
        }
        oneElement.add(1);
        result.add(oneElement);
        twoElement.add(1);
        twoElement.add(1);
        result.add(twoElement);
        for (int i = 2; i < numRows; i++) {
            List<Integer>tempNumberList = addNewListElements(result.get(result.size()-1));
            result.add(tempNumberList);
        }
    return result;
    }

    private List<Integer> addNewListElements(List<Integer> myList) {
        List<Integer> numberList = new ArrayList<>();
        numberList.add(1);
        for (int i =0;i<myList.size()-1;i++){
            numberList.add(myList.get(i)+ myList.get(i+1));
        }
        numberList.add(1);
        return numberList;
    }

    public static void main(String[] args) {
        PascalTriangle pascalTriangle = new PascalTriangle();
        System.out.println(pascalTriangle.generate(1));
        System.out.println(pascalTriangle.generate(5));
    }
}
