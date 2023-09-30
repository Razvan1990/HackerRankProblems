package hackerRank;

import java.util.*;

public class JimAndTheOrders {

    //create a hashmap to store the index of all orders -> customer order is indices the order appear in the list
    private static HashMap<Integer, Integer> makeIndicesMap(List<Integer> finalTimes) {
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        int index = 1;
        for (int time : finalTimes) {
            indexMap.put(index, time);
            index++;
        }
        return indexMap;
    }

    public static List<Integer> jimOrders(List<List<Integer>> orders) {
        // Write your code here
        //calculate now the times
        List<Integer>result = new ArrayList<>();
        List<Integer> finalTimes = new ArrayList<>();
        for (List<Integer> order : orders) {
            int orderNumber = order.get(0);
            int prepTime = order.get(1);
            finalTimes.add(orderNumber + prepTime);
        }
        HashMap<Integer, Integer> indexMap = makeIndicesMap(finalTimes);
        //using method comparingByValue
        List<Map.Entry<Integer, Integer>> listMap = new ArrayList<>(indexMap.entrySet());
        listMap.sort(Map.Entry.comparingByValue());
        for (Map.Entry entry:listMap){
            result.add((Integer)entry.getKey());
        }
        return result;

    }

    public static void main(String[] args) {
        List<List<Integer>>test1 = new ArrayList<>();
        List<Integer>list1 = Arrays.asList(8,1);
        List<Integer>list2 = Arrays.asList(4,2);
        List<Integer>list3 = Arrays.asList(5,6);
        List<Integer>list4 = Arrays.asList(3,1);
        List<Integer>list5 = Arrays.asList(4,3);
        test1.add(list1);test1.add(list2);test1.add(list3); test1.add(list4); test1.add(list5);
        System.out.println(jimOrders(test1));
    }

}
