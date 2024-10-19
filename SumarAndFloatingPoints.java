package hackerRank;

public class SumarAndFloatingPoints {
    // we need to get the greatest common divisor of the two differences
    // the actual value is the gcd -1

    private static int getGreatestCommonDivisor(int x, int y){
        while (x!=0){
            int rest = y % x;
            y = x;
            x = rest;

        }
        return y;
    }

    public static int solve(int x1, int y1, int x2, int y2) {
        // Write your code here
        int yDifference = Math.abs(y2 -y1);
        int xDifference = Math.abs(x2-x1);
        return getGreatestCommonDivisor(xDifference, yDifference) -1;
    }

    public static void main(String[] args) {
        System.out.println(solve(0,2,4,0));
        System.out.println(solve(2,2,5,5));
        System.out.println(solve(1,9,8,16));
    }
}
