package hackerRank;

public class HallowenSale {

    public static int howManyGames(int p, int d, int m, int s) {
        // Return the number of games you can buy
        int result =0;
        int totalCost = 0;
        while (totalCost<s){
            totalCost+=p;
            if (totalCost>s){
                break;
            }
            p -=d;
            if(p<=m){
                p = m;
            }
            result++;

        }
        return result;

    }

    public static void main(String[] args) {
        System.out.println(howManyGames(20,3,6,70));
        System.out.println(howManyGames(20,3,6,80));
        System.out.println(howManyGames(20,3,6,85));
    }


}
