package hackerRank;

public class BeautifulBinaryString {

    public static int beautifulBinaryString(String b) {
        // Write your code here
        boolean wentThere = true;
        String model = "010";
        int counter = 0;
        int result = 0;
        char[] characterModel = model.toCharArray();
        int idx = 0;
        for (int i = 1; i < b.length(); ) {
            if (b.charAt(0) == '0' && wentThere) {
                idx++;counter++;
                wentThere= false;
            }
            //000010 -> without this when reaching the 0 adjacent to 1 it will compare 0 to model[1] -> false
            if (b.charAt(i - 1) == '0' && b.charAt(i)=='0') {
                idx =0;counter =0;
            }
            if (b.charAt(i) == characterModel[idx]) {
                counter++;
                i++;
                idx++;
                if (counter == 3) {
                    result++;
                    counter = 0;
                    idx = 0;
                }
                if (i > b.length() - 1) {
                    break;
                }


            } else {
                counter = 0;
                i++;
                idx = 0;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(beautifulBinaryString("0101010"));
        System.out.println(beautifulBinaryString("010"));
        System.out.println(beautifulBinaryString("01100"));
        System.out.println(beautifulBinaryString("0100101010"));
        System.out.println(beautifulBinaryString("0100101010100010110100100110110100011100111110101001011001110111110000101011011111011001111100011101"));
        System.out.println(beautifulBinaryString("0101000010011100111110011000001000100101100010000011010111111101110110001110111110110101001011"));


    }

}
