package hackerRank;

public class ArmyGame {

    public static int gameWithCells(int n, int m) {
        // Write your code here
        int result;
        int numberColumns;
        if ((n == 1 || n == 2) && (m == 1 || m == 2)) {
            return 1;
        }
        if (m > 2) {
            if (m % 2 == 0) {
                numberColumns = m / 2;
            } else {
                numberColumns = m / 2 + 1;
            }
        } else {
            numberColumns = 1;
        }
        if (n <= 2) {
            result = numberColumns;
        } else {
            int multiplier;
            if (n % 2 == 0) {
                multiplier = n / 2;
            } else {
                multiplier = n / 2 + 1;
            }
            result = numberColumns *multiplier;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(gameWithCells(2, 3));
        System.out.println(gameWithCells(2, 2));
        System.out.println(gameWithCells(5, 7));
    }


}
