package hackerRank;

import java.util.*;

public class BestDivisor {


    public static int getBestDivisor(int n) {
        List<Integer> divisorList = new ArrayList<>();
        List<Integer> sums = new ArrayList<>();
        //find the divisors
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                divisorList.add(i);
            }
        }

        for (int divisor : divisorList) {
            if (divisor > 9) {
                int sum = 0;
                while (divisor != 0) {
                    sum += divisor % 10;
                    divisor /= 10;
                }
                sums.add(sum);
            } else {
                sums.add(divisor);
            }
        }


        //create a map that stores divisor and sum value
        HashMap<Integer, Integer> divisorSum = new HashMap<>();
        for (int i = 0; i < divisorList.size(); i++) {
            divisorSum.put(divisorList.get(i), sums.get(i));
        }
        //sort map by value now
        List<Map.Entry> list = new ArrayList<>(divisorSum.entrySet());

        list.sort((o1, o2) -> Integer.compare((int) o2.getValue(), (int) o1.getValue()));
        LinkedHashMap<Integer, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry entry : list) {
            sortedMap.put((int) entry.getKey(), (int) entry.getValue());
        }

        //check if we have duplicate max values
        List<Integer> listSorted = new ArrayList<>(sortedMap.values());
        int max = listSorted.get(0);
        List<Integer> maxs = new ArrayList<>();
        maxs.add(max);
        for (int i = 1; i < listSorted.size(); i++) {
            if (listSorted.get(i) == max) {
                maxs.add(listSorted.get(i));
            }
        }
        if (maxs.size() == 1) {
            return sortedMap.keySet().iterator().next();
        } else {
            int lengthList = maxs.size();
            List<Integer> maxKeys = new ArrayList<>();
            for (int i = 0; i < lengthList; i++) {
                int key = (int) sortedMap.keySet().toArray()[i];
                maxKeys.add(key);
            }
            //get the min value
            int min = maxKeys.get(0);
            for (int i = 1; i < maxKeys.size(); i++) {
                if (maxKeys.get(i) < min) {
                    min = maxKeys.get(i);
                }
            }
            return min;
        }
    }

    public static void main(String[] args) {
        //System.out.println(getBestDivisor(12));
        System.out.println(getBestDivisor(180));


    }


}
