package hackerRank;

public class PageCount {

    public static int pageCount(int n, int p) {
        // Write your code here
        //we will need a temporary value in order to check if n is divisible or not by 2
        //this is done because of a test for example 6 and 5 -> you need to turn a page to goto 5 even if result of min is 1
        //so when doing n--, you will change n

        //if p is 1 then result is 0 clearly
        //we will count till the first page through p and then from the last page through p and see the minimum
        //if the counter is greater than 1 -> then is means a page so we will have result = counter/2
        //if it is 1 then and number of pages is not even, then you are already at that page
        //if 1 and page even then result is 1 , cause last page is separate


        if (p == 1) {
            return 0;
        }

        int tempNumberPgs = n;
        int start1 = 0;
        int start2 = 0;

        while (start1 != p) {
            start1++;
        }
        while (tempNumberPgs != p) {
            tempNumberPgs--;
            start2++;
        }

        int resultFromStart = start1;
        int resultFromEnd = start2;

        int result = Math.min(resultFromStart, resultFromEnd);


        if (result == 1 && n % 2 == 0) {
            return result;
        } else if (result <= 1) {
            result = 0;
        } else {
            result = result / 2;
        }


        return result;
    }

    public static void main(String[] args) {
        System.out.println(pageCount(5, 3));
        System.out.println(pageCount(6, 2));
        System.out.println(pageCount(5, 4));
        System.out.println(pageCount(7, 3));


    }

}
