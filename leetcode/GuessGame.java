package leetcode;

import java.util.Scanner;

public class GuessGame {

    public int guess(int num){
        System.out.println("Pick the number ");
        Scanner scanner = new Scanner(System.in);
        int pick = scanner.nextInt();
        if (num >pick){
            return -1;
        } else if (num <pick){
            return 1;
        }
        return 0;
    }
}

