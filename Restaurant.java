package hackerRank;

public class Restaurant {

    private static int findCmmdc(int a, int b) {
        int divisor;
        if (a > b) {
            while (b != 0) {
                int r = a % b;
                a = b;
                b = r;
            }
            divisor =a;
        } else {
            while (a != 0) {
                int r = b % a;
                b = a;
                a = r;
            }
            divisor = b;
        }
        return divisor;
    }

    public static int restaurant(int l, int b) {
        // Write your code here
        if (l == b) {
            return 1;
        }
        int cmmdc = findCmmdc(l, b);
        int area = l * b;
        int areaCmmdc = cmmdc * cmmdc;
        return area/areaCmmdc;
    }

    public static void main(String[] args) {
        System.out.println(restaurant(2,2));
        System.out.println(restaurant(6,9));
        System.out.println(restaurant(36, 16));
    }

}
