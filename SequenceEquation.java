package hackerRank;

import java.util.*;

public class SequenceEquation {

    public static List<Integer> permutationEquation(List<Integer> p) {
        // Write your code here
        //use a map to get the indeces of x
        //use then another map from the values of the previous map to get the indices of the new list
        //return the value of the map

        LinkedHashMap<Integer, Integer> indicesMap1 = new LinkedHashMap<>();
        LinkedHashMap<Integer, Integer> indicesMap2 = new LinkedHashMap<>();
        int x = 1;//start number
        while (x <= p.size()) {
            for (int i = 0; i < p.size(); i++) {
                if (p.get(i) == x) {
                    indicesMap1.put(x, i+1);//it need +1 to respect the fact that indices are from 1 to 5 in the list, but we start from index 0 in a list
                    break;
                }
            }
            x++;
        }

        List<Integer> indices = new ArrayList<>(indicesMap1.values());
        //repeat the process like above, but with the values of the new list
        int index = 0;
        while (index < indices.size()) {
            for (int i = 0; i <= p.size(); i++) {
                if (Objects.equals(indices.get(index), p.get(i))) {
                    indicesMap2.put(indices.get(index), i+1);
                    break;
                }

            }
            index++;
        }
        return new ArrayList<>(indicesMap2.values());


    }

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(5,2,1,3,4);
        List<Integer>list2 = Arrays.asList(2,3,1);
        List<Integer>list3 = Arrays.asList(4,3,5,1,2);
        System.out.println(permutationEquation(list1));
        System.out.println(permutationEquation(list2));
        System.out.println(permutationEquation(list3));

    }
}
