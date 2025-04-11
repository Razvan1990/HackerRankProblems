package leetcode;

public class SolutionGuessGame extends GuessGame {
    public int guessNumber(int n) {
        int result;
        int guessResult = guess(n);
        while (guessResult != 0) {
            if (guessResult == 1) { //guess lower so we need to increase
                n++;
            } else if (guessResult == -1) { //guess higher so we need to decrease
                n--;

            }
            guessResult = guess(n);
        }
        result = n;
        return result;
    }

    public int guessNumber2(int n) {

        int low = 1;
        int high = n;

        while (low <= high) {
            int middle = (low + high) / 2;
            int result = guess(n);
            if (result == 0) {
                return middle;
            } else if (result == -1) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        //not valid number
        return -1;
    }


    public static void main(String[] args) {
        SolutionGuessGame solutionGuessGame = new SolutionGuessGame();
        System.out.println(solutionGuessGame.guessNumber(10));
        System.out.println(solutionGuessGame.guessNumber(1));
        System.out.println(solutionGuessGame.guessNumber(2));
    }

}
