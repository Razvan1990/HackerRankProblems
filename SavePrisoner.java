package hackerRank;

public class SavePrisoner {

    public static int saveThePrisoner(int n, int m, int s) {
        // Write your code here
        //count till we ran out of candy
        //if n is reached then go back to 1 and so on


        m -= 1;//we will give the first candy to the first prisoner
        int indexStart;
        if (s == n) {
            indexStart = 1;
        } else {
            indexStart = s + 1;
        }

        while (m > 1) {
            if (indexStart >= n) {
                m--;
                indexStart = 1;
            } else {
                m--;
                indexStart++;
            }


        }

        return indexStart;
    }


    public static void main(String[] args) {
        System.out.println(saveThePrisoner(5, 2, 1));
        System.out.println(saveThePrisoner(5, 2, 2));
        System.out.println(saveThePrisoner(7, 19, 2));
        System.out.println(saveThePrisoner(3, 7, 3));


    }

}
