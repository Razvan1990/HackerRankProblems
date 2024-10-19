package hackerRank;

public class FibonacciFindingEasy {

    public static int solve(int a, int b, int n) {
        // Write your code here
        int result = 0;
        int constant = (int)1e+9 +7;
        if (n ==1) {
            result = b;
            return result;
        }
        for (int i =2;i<=n;i++){
            result = a+b;
            a =b;
            b = result;
        }
        result%=constant;
        return result;

    }

    public static int solve2(int a, int b, int n){
        /**
         * FORMULA from problem in wikipedia
         * https://en.wikipedia.org/wiki/Fibonacci_sequence#Matrix_form
         * Fn = 1/sqrt(5) *Math.pow(((1+sqrt(5))/2),n) - 1/sqrt(5) *Math.pow(((1-sqrt(5))/2),n)
         */
        int constant = (int)1e+9 +7;
        int result = (int) (1 /Math.sqrt(5) * (int)Math.pow(((1 + Math.sqrt(5))/2),n) - (1 /Math.sqrt(5) * (int)Math.pow(((1 - Math.sqrt(5))/2),n)));
        return result%constant;
    }

    public static void main(String[] args) {
        System.out.println(solve(2,3,1));
        System.out.println(solve(9,1,7));
        System.out.println(solve(9,8,3));
        System.out.println(solve(2,4,9));
        System.out.println(solve(1,7,2));
        System.out.println(solve(1,8,1));
        System.out.println(solve(4,3,1));
        System.out.println(solve(3,7,5));

        System.out.println(solve2(9,1,7));
    }
}
