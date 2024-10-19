package hackerRank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SalesByMatch {

    public static HashMap<Integer, Integer> frequencySockMap(List<Integer> list){
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for(int number:list){
            if(freqMap.containsKey(number)){
                freqMap.put(number, freqMap.get(number)+1);
            }else{
                freqMap.put(number, 1);
            }
        }
        return freqMap;
    }

    public static int sockMerchant(int n, List<Integer> ar) {
        // Write your code here
        //make a dictionary to see how many of that socks we have
        //if it is bigger than 1 than the result will be x /2
        int result = 0;
        HashMap<Integer, Integer> socksNumber = frequencySockMap(ar);
        for(int number:socksNumber.keySet()){
            if(socksNumber.get(number)>1){
                result+=socksNumber.get(number)/2;
            }
        }
        return result;

    }

    public static void main(String[] args) {
        List<Integer>test1 = Arrays.asList(1,2,1,2,1,3,2);
        List<Integer>test2 = Arrays.asList(10, 20, 20, 10, 10, 30, 50, 10, 20);
        System.out.println(sockMerchant(test1.size(), test1));
        System.out.println(sockMerchant(test2.size(), test2));
    }
}
