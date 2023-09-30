package hackerRank;

public class AorB {

    public static char makeXorString(char a, char b) {
        if (a == '1' || b == '1') {
            return '1';
        } else {
            return '0';
        }
    }

    public static String convertHexaToBinary(String hexaNumber) {
        StringBuilder fullBuilder = new StringBuilder();
        for (int i = 0; i < hexaNumber.length(); i++) {
            StringBuilder builder = new StringBuilder();
            switch (hexaNumber.charAt(i)) {
                case '0':
                    builder.append("0000");
                    break;
                case '1':
                    builder.append("0001");
                    break;
                case '2':
                    builder.append("0010");
                    break;
                case '3':
                    builder.append("0011");
                    break;
                case '4':
                    builder.append("0100");
                    break;
                case '5':
                    builder.append("0101");
                    break;
                case '6':
                    builder.append("0110");
                    break;
                case '7':
                    builder.append("0111");
                    break;
                case '8':
                    builder.append("1000");
                    break;
                case '9':
                    builder.append("1001");
                    break;
                case 'A':
                    builder.append("1010");
                    break;
                case 'B':
                    builder.append("1011");
                    break;
                case 'C':
                    builder.append("1100");
                    break;
                case 'D':
                    builder.append("1101");
                    break;
                case 'E':
                    builder.append("1110");
                    break;
                case 'F':
                    builder.append("1111");
                    break;
            }
            fullBuilder.append(builder);
        }
        return fullBuilder.toString();
    }

    public static void aOrB(int k, String a, String b, String c) {
        // Write your code here
        String binaryA = convertHexaToBinary(a);
        String binaryB = convertHexaToBinary(b);
        String binaryC = convertHexaToBinary(c);

        String binaryA2;
        String binaryB2;
        String binaryC2;

        if (binaryA.length()>binaryB.length()){
            long difference = binaryA.length()-binaryB.length();
            StringBuilder builder = new StringBuilder();
            for (int i =0;i<difference/4;i++){
                builder.append("0000");
            }
            binaryB2 =builder+binaryB;
        }


        if (binaryB.length()>binaryA.length()){
            long difference = binaryB.length()-binaryA.length();
            StringBuilder builder = new StringBuilder();
            for (int i =0;i<difference/4;i++){
                builder.append("0000");
            }
            binaryA2 =builder+binaryA;
        }





    }
}