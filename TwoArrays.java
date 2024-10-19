package hackerRank;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TwoArrays {


    private static int getSum(List<Integer> myList) {
        int sum = 0;
        for (int number : myList) {
            sum += number;
        }
        return sum;
    }

    public static String twoArrays(int k, List<Integer> A, List<Integer> B) {
        // Write your code here
        int sumA = getSum(A);
        int sumB = getSum(B);
        if ((sumA + sumB) / A.size() >= k) {
            return "YES";
        }
        return "NO";


    }
    //if we sort the lists then we can see just if the first element of list1 + last element of list2 is >=k. If not, we can already return No.
    // We then still count with first+1 and last-1 till we reach traverse the lists (one list left to right, the other one opposite)

    public static String twoArrays2(int k, List<Integer> A, List<Integer> B) {
        // Write your code here
        Collections.sort(A);
        Collections.sort(B);
        int first = 0;
        int last = A.size()-1;

        while(first<A.size() && last>=0){ //NO NEED FOR TWO CONDITIONS HERE AS BOTH LISTS HAVE SAME SIZE
            if (A.get(first)+B.get(last)<k){
                return "NO";
            }
            else{
                first++;
                last--;
            }
        }
        return "YES";
    }




    public static void main(String[] args) {
        List<Integer>list1 = Arrays.asList(2,1,3);
        List<Integer>list2 = Arrays.asList(7,8,9);
        List<Integer>list3 = Arrays.asList(1,2,2,1);
        List<Integer>list4 = Arrays.asList(3,3,3,4);

        System.out.println(twoArrays(10,list1,list2));
        System.out.println(twoArrays(5,list3,list4));
    }


}
