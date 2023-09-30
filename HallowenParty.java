package hackerRank;

public class HallowenParty {

    public static long halloweenParty(int k) {
        // Write your code here
        //we need to have more horizontal lines than vertical to achieve max value
        //7 /2 =3 -> 3 vertical lines and 4 horizontal lines
        long numberVerticalLines = k /2;
        long numberHorizontalLines = k - numberVerticalLines;
        return numberVerticalLines *numberHorizontalLines;

    }

    public static void main(String[] args) {
        System.out.println(halloweenParty(5));
        System.out.println(halloweenParty(6));
        System.out.println(halloweenParty(7));
        System.out.println(halloweenParty(8));
        System.out.println(halloweenParty(2));

    }
}
