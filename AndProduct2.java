package hackerRank;

public class AndProduct2 {

    /*
    Facem cu puterile lui 2 pentru ca daca avem un zero in nr binar , el oricum la un moment dat devine 0. La final facem si pe biti cu b-ul nostru
     */
    public static long andProduct(long a, long b) {
        long result = a;
        int power = 0;
        while(a +(long)Math.pow(2,power)<b){
            result&=a +(long)Math.pow(2,power);//facem and doar cu puterile lui 2, ca oricum nu se va schimba rezultatul
            power++;

        }
        result&=b;
        return result;
    }
    public static void main(String[] args) {
        System.out.println(andProduct(12,15));
        System.out.println(andProduct(2,3));
        System.out.println(andProduct(8,13));
        System.out.println(andProduct(17,23));
        System.out.println(andProduct(11,15));
        System.out.println(andProduct(100799171, 102441676));
        System.out.println(andProduct(364011, 366022));
    }


}
