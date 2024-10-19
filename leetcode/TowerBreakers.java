package hackerRank;

public class TowerBreakers {

    public static int towerBreakers(int n, int m) {
        // Write your code here

        if (m == 1) {
            return 2;
        }
        if (n == 1) {
            return 1;
        }

        if (n % 2 == 1 & m % 2 == 1) {
            return 1;
        } else if (n % 2 == 1 && m % 2 == 0) {
            return 1;

        }
        return 2;

    }
}
