package hackerRank;

import java.util.*;

public class ReverseGame {

    private static Set<Integer> getNonRevertedElem(List<Integer>list, int startIndex){
        Set<Integer>elements = new HashSet<>();
        for (int i =0;i<startIndex;i++){
            elements.add(list.get(i));
        }
        return elements;


    }

    public static int getIndex(int n, int k){
        int result = 0;
        int countReversing = 0;
        List<Integer> numbers = new ArrayList<>();
        for (int i =0;i<n;i++){
            numbers.add(i);
        }
        List<Integer> finalList = new ArrayList<>();
        Set<Integer> removedElements = new HashSet<>();
        //first step
        Collections.reverse(numbers);
        countReversing++;
        //compute reversing
        while (countReversing<n){
            removedElements.add(numbers.get(0));
           //just the first index needs to be removed because in every step we just need to increment
            numbers.remove(numbers.get(0));
            Collections.reverse(numbers);
            countReversing++;

        }
        finalList.addAll(removedElements);
        finalList.addAll(numbers);

        for (int i =0;i<finalList.size();i++){
            if (finalList.get(i) == k){
                result =i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(getIndex(3,1));
        System.out.println(getIndex(5,2));
    }
}
