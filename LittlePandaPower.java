package hackerRank;

public class LittlePandaPower {

    public static int solve(int a, int b, int x) {
        // Write your code here

        if (b == 0 && x == 1) {
            return 0;
        } else if (b == 0) {
            return 1;
        }else if(a==1){
            return 1;
        }
        else if (b > 0) {
            return (int) Math.pow(a, b) % x;
        } else {
            double powerCalculation = Math.pow(a, b);
            int partialResult = (int) (1 / powerCalculation);
            return partialResult % x;

        }


    }

    public static void main(String[] args) {
        System.out.println(solve(1,2,3));
        System.out.println(solve(3,4,2));
        System.out.println(solve(4,-1,5));
    }



}
