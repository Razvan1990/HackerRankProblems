package hackerRank;

import java.util.*;

public class FairRations {

    private static boolean checkWhichElementsAreMore(List<Integer> exampleList) {
        int counterOdd = 0;
        int counterEven = 0;
        for (int element : exampleList) {
            if (element % 2 == 0) {
                counterEven++;
            } else {
                counterOdd++;
            }
        }
        return counterEven > counterOdd;
    }

    private static List<Integer> getNumberOfOddNumbers(List<Integer> exampleList) {
        List<Integer> result = new ArrayList<>();
        int counterOdd = 0;
        int counterEven = 0;
        for (int element : exampleList) {
            if (element % 2 == 0) {
                counterEven++;
            } else {
                counterOdd++;
            }
        }
        result.add(exampleList.size() - counterOdd);
        result.add(exampleList.size() - counterEven);
        return result;

    }

    public static String fairRations(List<Integer> B) {
        String result = "";
        // Write your code here
        //check if we can do it -> if we have 2
        if (B.size() == 2) {
            if ((B.get(0) % 2 == 0 && B.get(1) % 2 == 1) || (B.get(0) % 2 == 1 && B.get(1) % 2 == 0)) {
                return "NO";
            }
        }
        if (B.size() == 3) {
            boolean check = checkWhichElementsAreMore(B);
            if (check) {
                return "NO";
            } else {
                return String.valueOf(4);
            }
        }
        List<Integer> oddEvenCheck = getNumberOfOddNumbers(B);
        if (B.size() > 4 && Objects.equals(oddEvenCheck.get(0), oddEvenCheck.get(1)) ||
                B.size() > 4 && (oddEvenCheck.get(1) - oddEvenCheck.get(0)) == 1) {
            return "NO";
        }
        if (Objects.equals(oddEvenCheck.get(0), B.size())) {
            return String.valueOf(0);
        }
        if (B.size() == 4 && Objects.equals(oddEvenCheck.get(0), oddEvenCheck.get(1))) {
            return String.valueOf(4);
        }


        // MAKE A FIRST CHECK with last and the first from last element
        if (B.get(B.size() - 2) % 2 == 0 && B.get(B.size() - 1) % 2 == 1) {
            int elementNew = B.get(B.size() - 2) + 1;
            int elementNeighbourNew = B.get(B.size() - 1) + 1;
            if (B.get(B.size() - 3) % 2 == 1 && elementNeighbourNew % 2 == 0) {
                if (B.size() % 2 == 1) {
                    return String.valueOf(B.size() - 1);
                } else {
                    return String.valueOf(B.size());
                }

            }
        }
        //MAKE SECOND CHECK with second and third element
        //needs to start with even number
        if (B.get(0) % 2 == 0) {
            if (B.get(1) % 2 == 1 && B.get(2) % 2 == 0) {
                int elementNew = B.get(1) + 1;
                int elementNeighbourNew = B.get(2) + 1;
                if (B.get(3) % 2 == 1 && elementNeighbourNew % 2 == 1) {
                    if (B.size() % 2 == 1) {
                        return String.valueOf(B.size() - 1);
                    } else {
                        return String.valueOf(B.size());
                    }

                }
            }
        }

        if (B.size() % 2 == 1) {
            result += String.valueOf(B.size() - 1);
        } else {
            result += String.valueOf(B.size());
        }
        return result;
    }

    /*
    Working method
    Check at final the first to last value if it is odd
     */
    public static String fairRations2(List<Integer>B){
        int minCount = 0;
        int currentNum = B.get(0);
        for (int i = 0; i < B.size() - 1; i++) {
            int nextNum = B.get(i + 1);
            if (currentNum % 2 == 0) currentNum = nextNum;
            else {
                currentNum = nextNum + 1;
                minCount += 2;
            }
        }
        return currentNum % 2 == 0 ? Integer.toString(minCount) : "NO";
    }


    public static void main(String[] args) {
        List<Integer> test1 = Arrays.asList(4,5,6,7);
        List<Integer> test2 = Arrays.asList(2,3,4,5,6);
        List<Integer> test3 = Arrays.asList(1,2);
        System.out.println(fairRations(test1));
        System.out.println(fairRations(test2));
        System.out.println(fairRations(test3));

        System.out.println(fairRations2(test1));

    }

}
