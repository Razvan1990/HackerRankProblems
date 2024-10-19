package hackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Quicksort {

    private static int getMinValue(List<Integer> list) {
        int min = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < min) {
                min = list.get(i);
            }
        }
        return min;
    }

    private static int getDifferenceValues(int a, int b) {
        return Math.abs(a - b);
    }

    public static List<Integer> quickSort(List<Integer> arr) {
        // Write your code here
        List<Integer> sortedList = new ArrayList<>();
        int pivot = arr.get(0);
        sortedList.add(pivot);
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) > pivot) {
                sortedList.add(arr.get(i));
                pivot = arr.get(i);
            } else if (arr.get(i) <= pivot) {
                int minValue = getMinValue(sortedList);
                if (arr.get(i) <= minValue) {
                    sortedList.add(0, arr.get(i));
                } else {
                    int diff = getDifferenceValues(pivot, arr.get(i));
                    for (int j = sortedList.size() - 2; j >= 0; j--) {
                        int diffList = getDifferenceValues(pivot, sortedList.get(j));
                        if (diff <= diffList) {
                            sortedList.add(j + 1, arr.get(i));
                            break;

                        }
                    }


                }
            }
        }
        return sortedList;
    }

    private static void addElementsArray(List<Integer> result, List<Integer> values) {
        result.addAll(values);
    }

    public static List<Integer> quickSort2(List<Integer> arr) {
        List<Integer> left = new ArrayList<>();
        List<Integer> middle = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        int pivot = arr.get(0);
        middle.add(pivot);

        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) > pivot) {
                right.add(arr.get(i));
            } else if (arr.get(i) < pivot) {
                left.add(arr.get(i));
            } else {
                middle.add(arr.get(i));
            }
        }
        addElementsArray(result, left);
        addElementsArray(result, middle);
        addElementsArray(result, right);
        return result;
    }

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(4, 5, 3, 7, 2);
        List<Integer> list2 = Arrays.asList(26, 13, 31, 15, 100, 41, 6, 45);
        System.out.println(quickSort(list1));
        System.out.println(quickSort(list2));
        System.out.println(quickSort2(list1));

    }
}
