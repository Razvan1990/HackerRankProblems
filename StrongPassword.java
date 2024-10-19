package hackerRank;

public class StrongPassword {

    private static int getNumberOfPasswordChecks(String s1, String s2, String s3, String s4, String password) {
        int result = 0;
        //check s1
        for (int i = 0; i < s1.length(); i++) {
            //in order to do a char sequence
            if (password.contains("" + s1.charAt(i))) {
                result++;
                break;
            }
        }
        //check s2
        for (int i = 0; i < s2.length(); i++) {
            //in order to do a char sequence
            if (password.contains("" + s2.charAt(i))) {
                result++;
                break;
            }
        }
        //check s3
        for (int i = 0; i < s3.length(); i++) {
            //in order to do a char sequence
            if (password.contains("" + s3.charAt(i))) {
                result++;
                break;
            }
        }
        //check s4
        for (int i = 0; i < s4.length(); i++) {
            //in order to do a char sequence
            if (password.contains("" + s4.charAt(i))) {
                result++;
                break;
            }
        }
        return result;
    }


    public static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong
        int result = 0;
        String numbers = "0123456789";
        String lowerCase = "abcdefghijklmnopqrstuvwxyz";
        String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String specialCharacters = "!@#$%^&*()-+";
        int minLength = 6;

        //we check first the length . If length is below or equal to 3 then it does not matter what there is already in the password
        if (password.length() <= 3) {
            return minLength - n;
        }
        int numberConditionsPassword = getNumberOfPasswordChecks(numbers, lowerCase, upperCase, specialCharacters, password); //never can be 0
        //check now if it is interval between 4 and 6 based on the number of conditions
        if (password.length() < 7) {
            switch (numberConditionsPassword) {
                case 1:
                    result = 3;//as only 1 condition is met
                    break;
                case 2:
                    result = 2;//as only 2 conditions are met
                    break;
                case 3:
                    // here we need to check if the length matches too
                    int value = 1;
                    if (n + value < 6) {
                        result = minLength - n - value + (minLength - n - value);//it should be 1 in this case
                    } else {
                        result = value;
                    }
                    break;
                case 4:
                    //we just need to check the length as all conditions are met
                    result = minLength - n;
                    break;

            }
        } else {
            //in this case we know that the length is met, and we just check based on the conditions
            switch (numberConditionsPassword) {
                case 1:
                    result = 3;//as only 1 condition is met
                    break;
                case 2:
                    result = 2;//as only 2 conditions are met
                    break;
                case 3:
                    result =1;//as only 2 conditions are met
                    break;


            }
        }
        return result;


    }

    public static void main(String[] args) {
        System.out.println(minimumNumber("2bbbb".length(), "2bbbb"));
        System.out.println(minimumNumber("Ab1".length(), "Ab1"));
        System.out.println(minimumNumber("#HackerRank".length(),"#HackerRank" ));
        System.out.println(minimumNumber("1z2!".length(),"1z2!" ));

    }
}
