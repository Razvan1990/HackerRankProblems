package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle2 {
    /**
     * Only difference here is that we return just the row of the index wanted and not the whole pascal triangle list
     * Also, as index start from 0, the condition for i will be to be less or equal to rowIndex
     * @param rowIndex
     * @return the list of the Pascal triangle at the indexRow
     */
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> oneElement = new ArrayList<>();
        List<Integer> twoElement = new ArrayList<>();
        if (rowIndex == 0) {
            oneElement.add(1);
            result.add(oneElement);
            return oneElement;
        } else if (rowIndex == 1) {
            oneElement.add(1);
            result.add(oneElement);
            twoElement.add(1);
            twoElement.add(1);
            result.add(twoElement);
            return twoElement;
        }
        oneElement.add(1);
        result.add(oneElement);
        twoElement.add(1);
        twoElement.add(1);
        result.add(twoElement);
        for (int i = 2; i <= rowIndex; i++) {
            List<Integer> tempNumberList = addNewListElements(result.get(result.size() - 1));
            result.add(tempNumberList);
        }
        return result.get(rowIndex);
    }

    private List<Integer> addNewListElements(List<Integer> myList) {
        List<Integer> numberList = new ArrayList<>();
        numberList.add(1);
        for (int i = 0; i < myList.size() - 1; i++) {
            numberList.add(myList.get(i) + myList.get(i + 1));
        }
        numberList.add(1);
        return numberList;
    }

    public static void main(String[] args) {
        PascalTriangle2 pascalTriangle2 = new PascalTriangle2();
        System.out.println(pascalTriangle2.getRow(1));
        System.out.println(pascalTriangle2.getRow(3));
        System.out.println(pascalTriangle2.getRow(0));
        System.out.println(pascalTriangle2.getRow(5));
    }
}


