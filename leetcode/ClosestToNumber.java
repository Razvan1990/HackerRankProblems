package leetcode;

public class ClosestToNumber {

    public static int getClosestValueToNumber(int[] exampleArray, int target) {
        if (exampleArray.length ==0){
            return 0;
        }
        if (exampleArray.length ==1){
            return exampleArray[0];
        }
        int result = Math.abs(exampleArray[0] - target);
        int currentValue = exampleArray[0];
        for (int i = 1; i < exampleArray.length; i++) {
            if (Math.abs(exampleArray[i] - target) < result) {
                result = Math.abs(exampleArray[i] - target);
                currentValue = exampleArray[i];
            } else if (Math.abs(exampleArray[i] - target) == result && exampleArray[i] > 0 && currentValue < 0) {
                result = Math.abs(exampleArray[i] - target);
                currentValue = exampleArray[i];
            }
        }
        return currentValue;
    }

    public static void main(String[] args) {
        int [] example1 = {2, -2, -3, -4, 4, 3};
        int [] example2 = {1, 2, -3, -4, 2, 3, -2, -1, 3};
        int [] example3 = {-1, 2, -3, -4, 2, 3, -2, 1, 3,10};
        int [] example4 = {-1, 2, -3, -4, 2, 3, -2, 1, 3,0};
        int [] example5 = {-5,-4, -3, -2, -1, 2, 3, 4,5};
        System.out.println(ClosestToNumber.getClosestValueToNumber(example1, 0));
        System.out.println(ClosestToNumber.getClosestValueToNumber(example2, 0));
        System.out.println(ClosestToNumber.getClosestValueToNumber(example3, 0));
        System.out.println(ClosestToNumber.getClosestValueToNumber(example4, 0));
        System.out.println(ClosestToNumber.getClosestValueToNumber(example5, 0));


    }
}
