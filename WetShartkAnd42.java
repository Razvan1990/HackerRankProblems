package hackerRank;

public class WetShartkAnd42 {
    public static int solve(long s) {
        // Write your code here
        int modulo = (int) (1E9+7);
        int counter =1;
        while (s>0){
            if ((counter %4 ==0 || counter % 2 ==0) && counter % 42!=0){ //
                s--;
            }
            if (s==0){
                break;
            }
            counter ++;
        }
    return counter % modulo;
    }

    public static void main(String[] args) {
        long s1 = 2;
        long s2 = 3;
        long s3 = 4;
        System.out.println(solve(2));
        System.out.println(solve(3));
        System.out.println(solve(4));
    }

}
