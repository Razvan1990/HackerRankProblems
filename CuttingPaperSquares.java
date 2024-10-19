package hackerRank;

public class CuttingPaperSquares {

    public static long solve(int n, int m) {
        // Write your code here
        if (n ==1 && m ==1){
            return 0;
        }
        else{
            return (long)n * m -1;
        }



    }

    public static void main(String[] args) {
        System.out.println(solve(12,12));
        System.out.println(solve(1,1));
        System.out.println(solve(3,1));
    }
}
