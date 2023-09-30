package hackerRank;

public class MaximizingXOR {

    public static int maximizingXor(int l, int r) {
        // Write your code here
        int result =0;
        for (int i = l; i<=r;i++){
            for (int j = l;j <=r; j++){
                int resultXOR = i ^ j;
                result = Math.max(result, resultXOR);
            }
        }
        return result;

    }

    public static void main(String[] args) {

        System.out.println(maximizingXor(10, 15));
        System.out.println(maximizingXor(11, 12));
        System.out.println(maximizingXor(11, 100));

    }
}
