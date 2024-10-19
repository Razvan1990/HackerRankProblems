package hackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BetweenTwoSets {


    private static int resultNumbers(int number, List<Integer>list2){
        List<Integer>result =new ArrayList<>();
        boolean isNumberOk = true;
        while(number<=list2.get(0)){
            for(int element:list2){
                if(element %number!=0){
                    isNumberOk = false;
                    number++;
                    break;
                }else{
                    isNumberOk = true;
                }

            }
            if(isNumberOk){
                result.add(number);
                number++;
            }


        }



        return result.size();
    }

    private static int calculateCmmdc(int a, int b){
        while(b!=0){
            int r = a%b;
            a = b;
            b = r;
        }
        return a;
    }


    private static boolean checkIfNumberDivizor(int n, List<Integer>numbers){
        boolean isDivisor = true;
        for (int number:numbers){
            if (number%n!=0){
                return false;
            }
        }
        return isDivisor;
    }

    private static boolean checkIfNumberIsMultiple(int n, List<Integer>numbers){
        boolean isMultiple = true;
        for(int number:numbers){
            if(n % number!=0){
                return false;
            }
        }
        return isMultiple;

    }

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        // Write your code here
        //arrange first list and then take the maximum and see if division is correct
        //this list is used to not have duplicate values(test not working)
        List<Integer>resultNumbers = new ArrayList<>();
        if (a.size()==1 && b.size()==1){
            if(b.get(0)%a.get(0)==0){
                int result =0;
                for (int i =a.get(0);i<=b.get(0);i++){
                    if(b.get(0)%i==0){
                        result++;
                    }
                }
                return result;
            }
            else{
                return 0;
            }
        }
        if(a.size() == 1){
            return resultNumbers(a.get(0), b);
        }


        //check if both have 1 number


        int result =0;
        Collections.sort(a);
        boolean isLastNumberOk = checkIfNumberDivizor(a.get(a.size()-1),b);
        boolean isLiastNumberok2 = checkIfNumberIsMultiple(a.get(a.size()-1),a);
        if(isLastNumberOk && isLiastNumberok2){
            result++;
            resultNumbers.add(a.get(a.size()-1));
        }
        Collections.sort(b);
        boolean isFirstNumberOk = checkIfNumberDivizor(b.get(0), b);
        boolean isFirstNumberOk2 = checkIfNumberIsMultiple(b.get(0),a);
        if(isFirstNumberOk &&isFirstNumberOk2){
            result++;
            resultNumbers.add(b.get(0));
        }
        if (a.size()==2){
            int multiple = a.get(0) * a.get(1);
            boolean checkNumber = checkIfNumberDivizor(multiple, b);
            if (checkNumber){
                result++;

            }
        }
        else{
            int divizor = calculateCmmdc(a.get(a.size()-1), a.get(a.size()-2));
            int multiplier = a.get(a.size()-1)* a.get(a.size()-2)/divizor;
            boolean checkNumber = checkIfNumberDivizor(multiplier, b);
            if(multiplier<b.get(0) && checkNumber &&!resultNumbers.contains(multiplier)){
                result++;
            }
        }
        return result;









    }

    public static void main(String[] args) {
        List<Integer>list1 = Arrays.asList(2,6);
        List<Integer>list2 = Arrays.asList(24, 36);

        List<Integer>list3 = Arrays.asList(2,4);
        List<Integer>list4 = Arrays.asList(16, 32, 96);


        List<Integer>list5 = Arrays.asList(2,3,6);
        List<Integer>list6 = Arrays.asList(42, 84);

        System.out.println(getTotalX(list1, list2));
        System.out.println(getTotalX(list3, list4));
        System.out.println(getTotalX(list5, list6));


    }

}
