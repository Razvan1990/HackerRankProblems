package hackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LonelyInteger {

    public static int lonelyinteger(List<Integer> a) {
        // Write your code here
        HashMap<Integer, Integer>frequencyMap = new HashMap<>();
        for (int element:a){
            if (frequencyMap.containsKey(element)){
                frequencyMap.put(element, frequencyMap.get(element)+1);
            }else{
                frequencyMap.put(element, 1);
            }
        }
        for (int key:frequencyMap.keySet()){
            if(frequencyMap.get(key)==1){
                return key;
            }
        }

        return 0;

    }

    public static void main(String[] args) {
        System.out.println(lonelyinteger(Arrays.asList(0,0,1,1,2)));
    }
}
