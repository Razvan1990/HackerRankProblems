package hackerRank;

import java.util.Arrays;

public class GreedyFlorist {

    private static int getSum(int[] array) {
        int sum = 0;
        for (int number : array) {
            sum += number;
        }
        return sum;
    }

    // Complete the getMinimumCost function below.
    public static int getMinimumCost(int k, int[] c) {
        int startPriceIndex = 1;
        int result = 0;
        if (c.length <= k) {
            return getSum(c);
        } else {
            Arrays.sort(c);
            //vedem diferenta intre lungimea array-u;ui si k. Vom adauga elementele cele mai mari la rezultatul final pentru a obtine minimul
            int difference = c.length - k;
            for (int i = c.length - 1; i >= difference; i--) {
                result += c[i];
            }
            //dupa ce k-ul nostru este 0, atunci va trebui de la indexul ramas sa adaugam 1 la calcultul pretului
            int indexArrayLeft = difference - 1;
            int adding = 1;
            //all flowers are already once bought so we start incrementing
            while (indexArrayLeft >= 0) {
                int extraCost = 0;
                //pentru fiecare om(k) vom adauga in costul final pretul pana ajungem la indexul 0. La fiecare tura de oameni, inseamna ca vom creste din nou pretul prin adding
                //pentru a mentine minimul, la indexul 0 addingul va fi cel mai mare, pentru a mentine pretul scazut
                for (int i = 0; i < k; i++) {
                    extraCost = (adding + startPriceIndex) * c[indexArrayLeft];
                    result += extraCost;
                    indexArrayLeft--;
                    difference--;
                    if (indexArrayLeft < 0) {
                        break;
                    }
                }
                adding++;

            }

            return result;

        }
    }

    public static void main(String[] args) {
        int[] array1 = new int[]{1, 2, 3, 4};
        int[] array2 = new int[]{2, 5, 6};
        int[] array3 = new int[]{1, 3, 5, 7, 9};
        int[] array4 = new int[]{4, 1, 7, 3, 9};

        System.out.println(getMinimumCost(3, array1));
        System.out.println(getMinimumCost(3, array2));
        System.out.println(getMinimumCost(2, array2));
        System.out.println(getMinimumCost(3, array3));
        System.out.println(getMinimumCost(1, array4));
    }

}
