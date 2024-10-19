package leetcode;

public class SqrtNotFunction {
    public int mySqrt(int x) {
        if (x ==1){
            return 1;
        }
        if (x ==0){
            return 0;
        }
        int tempResult = x / 2;
        /**check to see if the tempResult * tempResult is equal to x
         if not we need to continue till we find if the multiplication
         gives the same number or something smaller
         */
        while (x <tempResult * tempResult){
            tempResult --;
        }
        return tempResult;
    }

    public static void main(String[] args) {
        SqrtNotFunction sqrtNotFunction = new SqrtNotFunction();
        System.out.println(sqrtNotFunction.mySqrt(4));
        System.out.println(sqrtNotFunction.mySqrt(8));
        System.out.println(sqrtNotFunction.mySqrt(16));
        System.out.println(sqrtNotFunction.mySqrt(28));
    }


}
