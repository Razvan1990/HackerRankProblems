package hackerRank;

public class BeautifulDays {

    private static int getInvert(int n) {
        int invert = 0;
        while (n != 0) {
            invert = n % 10 + invert * 10;
            n /= 10;
        }

        return invert;
    }

    private static boolean checkIfDifferenceDivisible(int n, int k) {
        int numberInverted = getInvert(n);
        return Math.abs(n - numberInverted) % k == 0;
    }

    public static int beautifulDays(int i, int j, int k) {
        // Write your code here
        int result = 0;
        for (int idx = i; idx <= j; idx++) {
            if (checkIfDifferenceDivisible(idx, k)) {
                result++;
            }
        }
        return result;

    }

    public static void main(String[] args) {
        System.out.println(beautifulDays(20, 23, 6));
    }


}
