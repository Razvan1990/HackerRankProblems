package hackerRank;

import java.util.ArrayList;
import java.util.List;

public class XorSequence {

    // Complete the xorSequence function below.
    public static long xorSequence(long l, long r) {
        //need to determine what is the value at index r
        long value = 0;
        long result = 0;
        List<Long> numbersSequence = new ArrayList<>();
        for (long i = 1; i <= l; i++) {
            value = value ^ i;
        }
        numbersSequence.add(value);
        for (long i = l + 1; i <= r; i++) {
            value = value ^ i;
            numbersSequence.add(value);
        }
        result = numbersSequence.get(0);
        for (int i = 1; i < numbersSequence.size(); i++) {
            result ^= numbersSequence.get(i);
        }


        return result;
    }

    //0 1 |3 0 4 1 7 0  -> make xor again with these numbers, element per element . Here the l from the function in fact is the index
    //0 1 |2 2 6 7 0 0

    private static long getNumberRest(long index) {
        long result = 0;
        if (index % 8 == 1 || index % 8 == 0) {
            return index;
        } else if (index % 8 == 3 || index % 8 == 2) {
            return 2;
        } else if (index % 8 == 4 || index % 8 == 5) {
            return index + 2;
        } else {
            return 0;
        }

    }

    private static long findNumbers(long number) {
        long result = 0;
        if (number % 4==0){
            result = number;
        }
        else if(number %4 ==1){

        }
        else if(number %4==3){
            result=1;
        }else{
            result = number+1;
        }
    return result;
    }
    public static long xorSequence2(long l, long r) {
        //need to determine what is the value at index r and at index l-1, because we need to make the whole sequence, including the first
        long indexL_1 = getNumberRest(l-1);
        long indexR = getNumberRest(r);
        long result = indexR ^indexL_1;//minimum sum
        return result;
    }
    public static long xorSequence3(long l, long r) {
        //need to determine what is the value at index r and at index l-1, because we need to make the whole sequence, including the first
        long indexL_1 = findNumbers(l-1);
        long indexR = findNumbers(r);
        long result = indexR ^indexL_1;//minimum sum
        return result;
    }



    public static void main(String[] args) {
        System.out.println(xorSequence(5, 26));
        System.out.println(xorSequence(2, 8));
        System.out.println(xorSequence(5, 9));

        System.out.println(xorSequence(3, 5));
        System.out.println(xorSequence(4, 6));
        System.out.println(xorSequence(15, 20));

        System.out.println(xorSequence2(1, 2));
        System.out.println("Method2");
        System.out.println(xorSequence2(5, 26));
        System.out.println(xorSequence2(2, 8));
        System.out.println(xorSequence2(5, 9));
//
        System.out.println(xorSequence2(3, 5));
        System.out.println(xorSequence2(4, 6));
        System.out.println(xorSequence2(15, 20));

//        System.out.println("Method3");
//        System.out.println(xorSequence3(5, 26));
//        System.out.println(xorSequence3(2, 8));
//        System.out.println(xorSequence3(5, 9));
////
//        System.out.println(xorSequence3(3, 5));
//        System.out.println(xorSequence3(4, 6));
//        System.out.println(xorSequence3(15, 20));

        //System.out.println(xorSequence2(1,2));
    }

}
