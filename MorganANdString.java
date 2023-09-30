package hackerRank;

import java.sql.SQLOutput;

public class MorganANdString {
    /*
    Respects test case 0 from the problem. As it has a way of chosing the letters, there are more possibilities to combine the letters
     */
    public static String morganAndString(String a, String b) {
        // Write your code here
        StringBuilder builder = new StringBuilder();
        // compare string length
        if (a.length() > b.length()) {
            int difference = a.length() - b.length();
            for (int i = 0; i < difference; i++) {
                builder.append(a.charAt(i));
            }
            int indexStringB = 0;
            int abosulteValue = difference;
            int power = difference;
            while (difference < a.length() && indexStringB < b.length()) {
                for (int i = 0; i < abosulteValue * power; i++) {
                    //need to append the second string first
                    builder.append(b.charAt(indexStringB));
                    indexStringB++;
                    if (indexStringB==b.length()) {
                        break;
                    }
                }

                for (int i = 0; i < abosulteValue * power; i++) {
                    //need to append the second string first
                    builder.append(a.charAt(difference));
                    difference++;
                    if (difference == a.length()) {
                        break;
                    }
                }
                power *= 2;
            }
        } else if (a.length() < b.length()) {
            int difference = b.length() - a.length();
            for (int i = 0; i < difference; i++) {
                builder.append(b.charAt(i));
            }
            int indexStringA = 0;
            int abosulteValue = difference;
            int power = difference;
            while (difference < b.length() && indexStringA < a.length()) {
                for (int i = 0; i < abosulteValue * power; i++) {
                    //need to append the second string first
                    builder.append(a.charAt(indexStringA));
                    indexStringA++;
                    if (indexStringA == a.length()) {
                        break;
                    }
                }

                for (int i = 0; i < abosulteValue * power; i++) {
                    //need to append the second string first
                    builder.append(b.charAt(difference));
                    difference++;
                    if (difference == b.length()) {
                        break;
                    }
                }
                power *= 2;
            }
        } else {
            int indexStringA = 0;
            int indexStringB = 0;
            int abosulteValue = 1;
            int power = 1;
            while (indexStringA < a.length() && indexStringB < b.length()) {
                for (int i = 0; i < abosulteValue * power; i++) {
                    //need to append the second string first
                    builder.append(a.charAt(indexStringA));
                    indexStringA++;
                    if (indexStringA == a.length()) {
                        break;
                    }
                }

                for (int i = 0; i < abosulteValue * power; i++) {
                    //need to append the first string first
                    builder.append(b.charAt(indexStringB));
                    indexStringB++;
                    if (indexStringB == b.length()) {
                        break;
                    }
                }
                power *= 2;
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(morganAndString("ACA", "BCF"));
        System.out.println(morganAndString("JACK", "DANIEL"));
        System.out.println(morganAndString("ABACABA", "ABACABA"));
    }
}
