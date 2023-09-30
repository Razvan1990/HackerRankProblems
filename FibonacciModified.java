package hackerRank;

public class FibonacciModified {

    public static int fibonacciModified(int t1, int t2, int n) {
        // Write your code here
        int result =0;
        for (int i =2;i<n;i++){
            result = t1 + (int)Math.pow(t2,2);
            t1 = t2;
            t2 = result;
        }

    return result;
    }

    public static void main(String[] args) {
        System.out.println(fibonacciModified(0,1,5));
        System.out.println(fibonacciModified(0,1,6));
        System.out.println(fibonacciModified(0,1,8));

    }
}
