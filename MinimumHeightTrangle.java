package hackerRank;

public class MinimumHeightTrangle {

    public static int lowestTriangle(int trianglebase, int area) {
        // Write your code here
        /*
        A = (b*h)/2;
         */
        double height = (double)(2 * area)/trianglebase;
        int heightInteger = (int) height;
        if (height/heightInteger >1){
            return heightInteger +1;
        }
        else{
            return heightInteger;
        }


    }

    public static void main(String[] args) {
        System.out.println(lowestTriangle(4,6));
        System.out.println(lowestTriangle(2,2));
        System.out.println(lowestTriangle(17, 100));


    }
}
