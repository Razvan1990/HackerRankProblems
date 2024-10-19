package hackerRank;

import java.util.ArrayList;
import java.util.List;

public class IsFibo {

    public static String isFiboHardCoded(long n) {
        // Write your code here
        long firstNr = 0;
        long secondNr = 1;
        long numberNext;
        List<Long> numbers = new ArrayList<>();
        numbers.add(firstNr); numbers.add(secondNr);
        while(numbers.get(numbers.size()-1)<=n){ // this ensures the case where it is 1
            numberNext = firstNr+ secondNr;
            numbers.add(numberNext);
            firstNr = secondNr;
            secondNr = numberNext;
            if (numbers.contains(n)){
                return "IsFibo";
            }
        }
        return "IsNotFibo";
    }

    public static void main(String[] args) {
        System.out.println(isFiboHardCoded(1));
    }
}
