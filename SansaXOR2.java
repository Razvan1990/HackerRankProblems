package hackerRank;

import java.util.*;

public class SansaXOR2 {

    private static LinkedHashMap<Integer, List<Integer>> makeResultMap(List<Integer> array) {
        //we use a linked list to keep correctly track of the order of xors for the element
        LinkedHashMap<Integer, List<Integer>> resultMap = new LinkedHashMap<>();
        int idx = 0;
        int result = array.get(0);
        for (int i = 1; i < array.size(); i++) {
            result ^= array.get(i);
        }
        List<Integer>temp = new ArrayList<>();
        temp.add(result);
        resultMap.put(idx, temp);
        int counter = 0;

        while (true) {
            List<Integer>countList = new ArrayList<>();
            int start = 0;int end = array.size();
            counter++;
            //every time here we decrease the end . In this way, we will start from -1 element till we reach 2 elements, which is minimum
            end -= counter;
            if (end < 2) {
                break;
            }
            int firstCount =1;
            while (end <= array.size()) {
                result = array.get(start);
                int count= 0;
                for (int i = start + 1;  firstCount+count< end; i++ ) {
                    result ^= array.get(i);
                    count++;
                }
                countList.add(result);
                //we use this firstCount cause it needs to e directly proportional with the end-> by doing this we ensure we calculate just moving the start and end, but having same number of xors per loop
                start++;
                end++;
                firstCount++;
            }
            idx++;
            resultMap.put(idx, countList);


        }
        return resultMap;
    }

    public static int sansaXor2(List<Integer> arr) {
        LinkedHashMap<Integer, List<Integer>> resultMap = makeResultMap(arr);
        int result = resultMap.get(0).get(0);
        //we need to make the loop reveresed, cause in our map we first have the elements which are just -1 element and at the end we have the list of just 2 elements each
        for (int i = resultMap.size()-1;i>=0 ; i--) {
            for (int number:resultMap.get(i)){
                result^=number;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        List<Integer>list1 = Arrays.asList(4,5,7,5);
        List<Integer>list2 = Arrays.asList(1,2,3);
        List<Integer>list3 = Arrays.asList(98,74,12);
        List<Integer>list4 = Arrays.asList(50,13,2);
        List<Integer>list5 = Arrays.asList(3,4,5);
        System.out.println(sansaXor2(list1));
        System.out.println(sansaXor2(list2));
        System.out.println(sansaXor2(list3));
        System.out.println(sansaXor2(list4));
        System.out.println(sansaXor2(list5));
    }

}