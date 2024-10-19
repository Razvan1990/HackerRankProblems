package leetcode;



public class TitleToColumn {
    public int titleToNumber(String columnTitle) {
        /**
         * reverse engineering like in TableColumn
         * here we traverse through the string and get first value
         * then we multiply by 26 and keep adding and finding the value of each letter by subtracking A and add 1
         * AB = 65-65 +1 *26 + 66-65+1
         * B = 66 and A = 65  -> 66-65+1 -> 2
         */
        int sum = (int) columnTitle.charAt(0) - 'A' + 1;
        for (int i = 1; i < columnTitle.length(); i++) {
            sum *= 26;
            sum+=columnTitle.charAt(i)-'A' +1;
        }
        return sum;
    }

    public static void main(String[] args) {
        TitleToColumn titleToColumn = new TitleToColumn();
        System.out.println(titleToColumn.titleToNumber("A"));
        System.out.println(titleToColumn.titleToNumber("AB"));
        System.out.println(titleToColumn.titleToNumber("ZY"));

    }

}
