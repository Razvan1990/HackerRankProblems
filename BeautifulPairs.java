package hackerRank;

import java.util.*;

public class BeautifulPairs {

    private static HashMap<Integer, Integer> getMapFrequency(List<Integer> list) {
        HashMap<Integer, Integer> mapFrequency = new HashMap<>();
        for (int number : list) {
            if (mapFrequency.containsKey(number)) {
                mapFrequency.put(number, mapFrequency.get(number));
            } else {
                mapFrequency.put(number, 1);
            }
        }
        return mapFrequency;
    }

    public static int beautifulPairs(List<Integer> A, List<Integer> B) {
        // Write your code here
        HashMap<Integer, Integer> map1 = getMapFrequency(A);
        HashMap<Integer, Integer> map2 = getMapFrequency(B);

        Collections.sort(A);
        Collections.sort(B);
        for (int i = A.size() - 1; i >=0 ; i--) {
            if (!B.contains(A.get(i)) || !Objects.equals(map1.get(A.get(i)), map2.get(A.get(i)))) {
                B.add( A.get(i));
                break;
            }
        }
        //re=sort the list
        int result = 0;
        Collections.sort(B);
        for (int i = 0; i < A.size(); ) {
            if (B.contains(A.get(i))) {
                if (Objects.equals(map1.get(A.get(i)), map2.get(B.get(i)))) {
                    result += map1.get(A.get(i));
                    i += map1.get(A.get(i));
                } else {
                    result += 1;
                    i++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> list1A = Arrays.asList(1, 2, 3, 4);
        List<Integer>list1A1 = new ArrayList<>(list1A);
        List<Integer> list1B = Arrays.asList(1, 2, 3, 4);
        List<Integer> list1B1 = new ArrayList<>(list1B);
        List<Integer> list2A = Arrays.asList(3, 5, 7, 11, 5, 8);
        List<Integer> list2A1 = new ArrayList<>(list2A);
        List<Integer> list2B = Arrays.asList(5, 7, 11, 10, 5, 8);
        List<Integer> list2B1 = new ArrayList<>(list2B);
        System.out.println(beautifulPairs(list1A1, list1B1));
        System.out.println(beautifulPairs(list2A1, list2B1));
    }


}
