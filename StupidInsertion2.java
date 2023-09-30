package hackerRank;

import java.util.*;

public class StupidInsertion2 {
    /**
     *
     * @param n - size of array
     * @param arr - the array
     * 1. We will need an intermediary set in which we will keep sort what is computed
     * 2. We also need the original list stored as a duplicate
     *            a. We will have 2 pointers, which will compare two adjacent numbers
     *            b. If the right number is lower than the left number then:
     *              b1. In the intermediate set we will add the numbers
     *              b2. the original array, will be cleared
     *              b3. We will need a temp list in which we will add the intermediate set numbers and then will sort them
     *              b4. The original list(arr) will be for the moment equal to the temp list
     *              b5. Finally, we will loop through the original duplicate list and check if the new arr contains all elements. If not, we will add the missing numbers at the end
     *              b6. We will print the array and increment both pointers
     *            c. If not, then we will just add in the intermediate list the two compared numbers, print the array and again increment the pointers
     *            d. This will continue till the right pointer is less than the size of the array
     */

    public static void insertionSort2(int n, List<Integer> arr) {
        // Write your code here
        List<Integer>duplicate = new ArrayList<>(arr);
        Set<Integer>intermediateList = new HashSet<>();
        int left =0;
        int right =1;
        while(right<n){
            if(arr.get(left)>=arr.get(right)){
                intermediateList.add(arr.get(left));
                intermediateList.add(arr.get(right));
                arr.clear();
                List<Integer>array = new ArrayList<>(intermediateList);
                arr = new ArrayList<>(array);
                Collections.sort(arr);
                for(int dup:duplicate){
                    if(!arr.contains(dup)){
                        arr.add(dup);
                    }
                }
                for (int i =0;i<n;i++){
                    System.out.print(arr.get(i)+" ");
                }
                System.out.println();
                left++; right++;

            }
            else{
                intermediateList.add(arr.get(left));
                intermediateList.add(arr.get(right));
                for (int i =0;i<n;i++){
                    System.out.print(arr.get(i)+" ");
                }
                System.out.println();
                left++; right++;
            }

        }

    }

    public static void main(String[] args) {
        List<Integer>myList = Arrays.asList(3,4,7,5,6,2,1);
        List<Integer>myList2 = new ArrayList<>(myList);
        insertionSort2(7,myList2);
        List<Integer>myList3 = Arrays.asList(1,4,3,5,6,2);
        List<Integer>myList4 = new ArrayList<>(myList3);
        insertionSort2(6,myList4);
        List<Integer> bigList1 = Arrays.asList(157,406,415,318,472,46,252,187,364,481,450,90,390,35,452,74,196,312,142,160,143,220,483,392,443,488,79,234,68,150,356,496,69,88,177,12,288,120,222,270,441,422,103,321,65,316,448,331,117,183,184,128,323,141,467,31,172,48,95,359,239,209,398,99,440,171,86,233,293,162,121,61,317,52,54,273,30,226,421,64,204,444,418,275,263,108,10,149,497,20,97,136,139,200,266,238,493,22,17,39);
        System.out.println("____");
        List<Integer>bigList2 = new ArrayList<>(bigList1);
        insertionSort2(100, bigList2);
    }

}
