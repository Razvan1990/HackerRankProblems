package hackerRank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TimeConversionAndCircularyArrayRot {

    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        double counterPositives = 0;
        double counterNegatives = 0;
        double counterZeroes = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) > 0) {
                counterPositives++;
            } else if (arr.get(i) == 0) {
                counterZeroes++;
            } else if (arr.get(i) < 0) {
                counterNegatives++;
            }

        }
        double ratioPositive = (double) counterPositives / arr.size();
        double ratioZero = (double) counterZeroes / arr.size();
        double ratioNegative = (double) counterNegatives / arr.size();

        System.out.println(String.format("%.6f", ratioPositive));
        System.out.println(String.format("%.6f", ratioZero));
        System.out.println(String.format("%.6f", ratioNegative));


    }

    public static void staircase(int n) {
        // Write your code here
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (i >= j) {
                    System.out.print("#");
                } else {
                    System.out.print("+");
                }

            }
            System.out.println();

        }
    }
    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
        HashMap<Integer, Long> map = new HashMap<>();

        for (int i=0;i<arr.size();i++){
            long sum = 0;
            for (int j =0;j<arr.size();j++){
                sum+=arr.get(j);
            }
            long lastSum = sum-arr.get(i);
            map.put(arr.get(i), lastSum);
        }
        long min = 0;long max =0;
        for (int i:map.keySet()){
            min = map.get(i);
            max = map.get(i);
            break;

        }
        for(long value:map.values()){
            if (value>max){
                max = value;
            }

        }

        for(long value:map.values()){
            if (value<min){
                min = value;
            }

        }


        System.out.print(min+"  "+max);
    }


    public static String timeConversion(String s) {
        // Write your code here
        char timeArray[] = s.toCharArray();

        String newTime="";



        HashMap<String, String> timeValue = new HashMap<>();
        timeValue.put("00", "12");
        timeValue.put("01", "13");
        timeValue.put("02", "14");
        timeValue.put("03", "15");
        timeValue.put("04", "16");
        timeValue.put("05", "17");
        timeValue.put("06", "18");
        timeValue.put("07", "19");
        timeValue.put("08", "20");
        timeValue.put("09", "21");
        timeValue.put("10", "22");
        timeValue.put("11", "23");
        timeValue.put("12", "00");


        String hour ="";
        for (int i=0;i<timeArray.length;i++){

            hour += timeArray[i];
            if(i==1){
                break;
            }
        }
        if(s.contains("AM") && hour.equals("12")){
           newTime =s.replace("AM", "");
           newTime = newTime.replace(hour, timeValue.get(hour));
        }else if(s.contains("AM")){
            newTime = s.replace("AM","" );

        }

        if(s.contains("PM") && hour.equals("12")) {
            newTime=s.replace("PM", "");
        }
         else if(s.contains("PM")) {
            newTime = s.replace("PM", "");
            newTime = newTime.replace(hour, timeValue.get(hour));
        }

        return newTime;


    }
    private static void computeList (List<Integer>list, int rotations){
        for (int i =0;i<rotations;i++){
            int poz1 =0;int poz2 = list.size()-1;
            while(poz1<poz2){
                int temp = list.get(poz1);
                list.set(poz1, list.get(poz2));
                list.set(poz2, temp);
                poz1++;
            }

        }
    }

    private static List<Integer> computedList2(List<Integer>list, int rotations){
        List<Integer>newList = new ArrayList<>();


        int temp = list.get(list.size()-1);
        for (int i =1;i<list.size();i++){
            int temp2 = list.get(i-1);
            int temp3;
            temp3 = temp2;
            newList.add(temp3);
        }
        newList.add(0, temp);
        rotations--;
        if(rotations >0){
            newList = computedList2(newList, rotations);
        }
        return newList;
    }




    public static List<Integer> circularArrayRotation(List<Integer> a, int k, List<Integer> queries)throws Exception {
        // Write your code here
        List<Integer> listQueriesResult = new ArrayList<>();
        List<Integer> bla = computedList2(a, k);
        //computeList(a, k);
        if(queries.size()>a.size()){
            throw new Exception("Cannot be possible");
        }
        for (int number : queries) {
            listQueriesResult.add(bla.get(number));
        }
        return listQueriesResult;
    }

    private static List<Integer> createValidRange(int start, int end){
        List<Integer> rangeList = new ArrayList<>();

        int indexToAdd = 0;
        while(start+indexToAdd<end){
            rangeList.add(start+indexToAdd);
            indexToAdd++;
        }
        rangeList.add(end);
        return rangeList;
    }

    private static void printList(List<Integer> list){
        for (int i: list){
            System.out.println(i);
        }
    }


    public static void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {
        // Write your code here
        List<Integer> validValues = new ArrayList<>();
        List<Integer> validRange = createValidRange(s,t);
        int counterApples = 0; int counterOranges = 0;

        for (int apple:apples){
            int computedValue = apple+a;
            if(validRange.contains(computedValue)){
                counterApples++;
            }
        }
        for (int orange:oranges){
            int computedValue = orange+b;
            if(validRange.contains(computedValue)){
                counterOranges++;
            }
        }
        validValues.add(counterApples); validValues.add(counterOranges);
        printList(validValues);





    }

    static int flatlandSpaceStations(int n, int[] c) {
        int result = 0;
        int distance = 1;
        int spaceStation = 0;
        List<Integer> spaceStations = new ArrayList<>();
        if (n == c.length) {
            return result;
        }
        int m = c.length;
        for (int i = 0; i < m;i++) {
            for (int j = 0; j < n; ) {
                if (c[i] == j) {
                    spaceStations.add(0);
                    j++;
                } else if (c[i] != j && c[i] <= n / 2) {
                    if(j>n/2){
                        j++;
                        continue;

                    }
                    result = Math.abs(c[i] - j);
                    spaceStations.add(result);
                    j++;
                } else if (c[i] != j && c[i] >= n / 2) {
                    if(j<=n/2){
                        j++;
                        continue;
                    }
                    result = Math.abs(c[i] - j);
                    spaceStations.add(result);
                    j++;
                }
            }
        }
        result = getMaxOfList(spaceStations);
        return result;
    }

    private static int getMaxOfList(List<Integer> myList) {
        int max = myList.get(0);
        for(int i=1;i<myList.size();i++){
            if(max<myList.get(i)){
                max = myList.get(i);
            }
        }
        return max;
    }


    public static void main(String[] args) throws Exception {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        TimeConversionAndCircularyArrayRot.plusMinus(list);

        TimeConversionAndCircularyArrayRot.staircase(4);
        TimeConversionAndCircularyArrayRot.miniMaxSum(list);

        String s ="abcdefgt";
        char array[] = s.toCharArray();
        String bla = String.valueOf(array[0]+ array[1]);
        System.out.println(bla);
        System.out.println("++++++++++TimeConversion+++++++++++");
        String time = TimeConversionAndCircularyArrayRot.timeConversion("08:01:21PM");
        System.out.printf("%s", time);
        System.out.println("++++++++++queryList+++++++++++");
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(5);
        list2.add(3);
        list2.add(10);
        list2.add(8);
        List<Integer>queries = new ArrayList<>();
        queries.add(2);queries.add(4);
        List<Integer>finalList = circularArrayRotation(list2, 3,queries);
        for (int i: finalList){
            System.out.println(i);
        }

        System.out.println("++++++++++ApplesAndOranges+++++++++++");
        List<Integer> apples = new ArrayList<>();
        List<Integer> oranges = new ArrayList<>();
        apples.add(2); apples.add(3); apples.add(-4);
        oranges.add(3); oranges.add(-2); oranges.add(-4);
        int start = 7; int end = 10;
        int applePosition = 4; int orangePosition = 12;
        countApplesAndOranges(start, end,applePosition, orangePosition, apples, oranges);

        int [] givenArray = {1,4,8};
        int result = flatlandSpaceStations(10, givenArray);
        System.out.println("Max list is " + result);





    }
}
