package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class TableColumn {
    public String convertToTitle(int columnNumber) {
        StringBuilder builder = new StringBuilder();
        /**
         * 1. Trebuie sa scadem 1 mereu ca sa pornim de la 0, ptr ca 1 este A si in builder vom adauga 1(A) + rest
         * 2. Vom face un loop si luam de fiecare restul impartirii la column number
         * 3. Restul respectiv trebuie sa il adunam cu "A" deoarece asa putem vedea care este litera, convertand intr-un char
         * 4. punem in stringbuilder restul si impartim apoi la 26 columnNumber
         * 5. Trebuie sa facem reverse apoi
         */
        while (columnNumber > 0) {
            columnNumber--;
            int rest = columnNumber % 26;
            char currentChar = (char) (rest + 'A');
            builder.append(currentChar);
            columnNumber /= 26;
        }
        String tempResult = builder.toString();
        return reverseString(tempResult);
    }

    private String reverseString(String s) {
        StringBuilder s_new = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            s_new.append(s.charAt(i));

        }
        return s_new.toString();
    }

    public static void main(String[] args) {
        TableColumn tableColumn = new TableColumn();
        System.out.println(tableColumn.convertToTitle(701));
        System.out.println(tableColumn.convertToTitle(25));
        System.out.println(tableColumn.convertToTitle(703));
    }

}

