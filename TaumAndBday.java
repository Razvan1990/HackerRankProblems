package hackerRank;

public class TaumAndBday {

    public static long taumBday(int b, int w, int bc, int wc, int z) {
        // Write your code here
        int result = 0;
        if (bc == wc) {
            result = b * bc + w * wc;
            return result;
        } else if ((wc - bc == z) || (bc - wc == z)) {
            //there will be same amount if you make the conversion
            result = b * bc + w * wc;
            return result;

        } else if (bc - wc > z) {
            result = w * wc + b * (z + wc);
            return result;
        } else if (wc - bc > z) {
            result = b * bc + w * (z + bc);
            return result;

        } else if (b > w && bc - wc > z) {
            result = b * (wc + z) + w * wc;
            return result;

        } else if (w > b && wc - bc > z) {
            result = b * bc + w * (bc + z);
            return result;
        } else if (w > b && wc > bc && wc - bc < z) {
            result = b * bc + w * wc;
            return result;
        } else if (b > w && bc > wc && bc - wc < z) {
            result = b * bc + w * wc;
            return result;
        }


        return result;

    }


    public static void main(String[] args) {
        System.out.println(taumBday(3, 5, 3, 4, 1));
        System.out.println(taumBday(10, 10, 1, 1, 1));
        System.out.println(taumBday(5, 9, 2, 3, 4));
        System.out.println(taumBday(3, 6, 9, 1, 1));
        System.out.println(taumBday(7, 7, 4, 2, 1));
        System.out.println(taumBday(3, 3, 1, 9, 2));

    }


}
