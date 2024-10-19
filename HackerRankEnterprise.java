package hackerRank;

public class HackerRankEnterprise {
    public static int viralAdvertising(int n) {
        // Write your code here
        int sum =0;
        int result = 5;//exactly the start number
        int startDay = 1;
        int shared = 3;
        for (int i = startDay; i <= n; i++) {
            if (i == 1) {
                result = result / 2;
                sum+=result;
            }else{
                result = result *shared/2;
                sum+=result;
            }

        }
        return sum;

    }

    public static void main(String[] args) {
        System.out.println(viralAdvertising(5));
        System.out.println(viralAdvertising(3));
    }
}
