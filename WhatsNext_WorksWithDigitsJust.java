package hackerRank;

import java.util.*;

public class WhatsNext_WorksWithDigitsJust {

    private static HashMap<Integer, List<String>> getNumberMap() {
        HashMap<Integer, List<String>> mapResult = new HashMap<>();
        List<String> temp1 = Arrays.asList("0", "1");
        mapResult.put(1, temp1);

        List<String> temp2 = Arrays.asList("00", "11");
        mapResult.put(2, temp2);

        List<String> temp3 = Arrays.asList("000", "111");
        mapResult.put(3, temp3);

        List<String> temp4 = Arrays.asList("0000", "1111");
        mapResult.put(4, temp4);

        List<String> temp5 = Arrays.asList("00000", "11111");
        mapResult.put(5, temp5);

        List<String> temp6 = Arrays.asList("000000", "111111");
        mapResult.put(6, temp6);

        List<String> temp7 = Arrays.asList("0000000", "1111111");
        mapResult.put(7, temp7);

        List<String> temp8 = Arrays.asList("00000000", "11111111");
        mapResult.put(8, temp8);

        List<String> temp9 = Arrays.asList("000000000", "111111111");
        mapResult.put(9, temp9);

        return mapResult;


    }

    public static Integer getKeyByValue(Map<Integer, List<String>> map, String value) {
        for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
            for (String number : entry.getValue()) {
                if (Objects.equals(number, value)) {
                    return entry.getKey();
                }
            }
        }
        return null;
    }

    private static String changeIndices(String s, int index) {
        StringBuilder builder = new StringBuilder();
        if (index == s.length() - 1) {
            builder.append(s, 0, s.length() - 1);
            builder.append('1');
            return builder.toString();
        }
        //make swap here
        if (index == s.length() - 2) {
            builder.append(s, 0, index - 1);
            builder.append("10");//reversed
            return builder.toString();
        } else {
            builder.append(s, 0, index);
            builder.append("10");//reversed
            builder.append(s, index + 2, s.length());
        }
        return builder.toString();
    }

    private static String findNextPowerString(String s) {
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                index = i;
            }
        }
        //check if it last index -> if so just replace with 1
        return changeIndices(s, index);
    }

    public static void whatsNext(List<Integer> arr) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        HashMap<Integer, List<String>> conversionMap = getNumberMap();
        for (int i = 0; i < arr.size(); i++) {
            if (i % 2 == 0) {

                    builder.append(conversionMap.get(arr.get(i)).get(1));

                }

             else {

                    builder.append(conversionMap.get(arr.get(i)).get(0));



            }
        }
        String binaryNumber = builder.toString();
        String nextBinaryNumber = findNextPowerString(binaryNumber);
        builder.delete(0, builder.length());
        for (int i = 0; i < nextBinaryNumber.length() - 1; i++) {
            if (nextBinaryNumber.charAt(i) != nextBinaryNumber.charAt(i + 1)) {
                builder.append(nextBinaryNumber.charAt(i));
                Integer number = getKeyByValue(conversionMap, builder.toString());
                result.add(number);
                builder.delete(0, builder.length());
            } else if (i== binaryNumber.length()-2 &&nextBinaryNumber.charAt(i) == nextBinaryNumber.charAt(i + 1)) {
                builder.append(nextBinaryNumber.charAt(i));
                builder.append(nextBinaryNumber.charAt(i+1));
                Integer number = getKeyByValue(conversionMap, builder.toString());
                result.add(number);
            }else{
                builder.append(nextBinaryNumber.charAt(i));
            }
        }
        System.out.println(result.size());
        for (Integer number : result) {
            System.out.print(number + " ");
        }


    }


    public static void main(String[] args) {
       List<Integer>test1 = Arrays.asList(4,1,3,2,4);
       whatsNext(test1);
       List<Integer>test2 = Arrays.asList(4737, 6002, 2242, 737, 8817);
       whatsNext(test2);
    }
}
