package hackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class IcecreamParlour {

    public static List<Integer> icecreamParlor(int m, List<Integer> arr) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i =0;i<arr.size();i++){
            if (map.containsKey(m - arr.get(i))){
                result.add(map.get(m - arr.get(i))+1);
                result.add(i+1);
                break;
            }
            else{
                map.put(arr.get(i),i);
            }
        }


        return result;

    }

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1,4,5,3,2);
        List<Integer>list2 = Arrays.asList(2,2,4,3);
        System.out.println(icecreamParlor(4, list1));
        System.out.println(icecreamParlor(4, list2));

    }

}

