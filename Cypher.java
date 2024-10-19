package hackerRank;


public class Cypher {
   static int counterXor = 1;//cause in first part we just add 1 or 0

    private static char createXorValue(StringBuilder builder, char c, int k, int indexString) {

        int digitString = Integer.parseInt(String.valueOf(c));
        for (int i = 0; i < builder.length(); i++) {
            if (counterXor < k) {
                int digitBuilder = Integer.parseInt(String.valueOf(builder.charAt(i)));
                digitString ^= digitBuilder;

            } else {
                for (int j = 1; j < k; j++) {
                    //when i>k than we cannot shift anymore, so will do xor starting from the next index and so on
                    //we must make -1 shifts because we need to reach the first shift basically
                    if (counterXor == k) {
                        int digitBuilder = Integer.parseInt(String.valueOf(builder.charAt(j)));
                        digitString ^= digitBuilder;
                    } else {
                        int xorValue = indexString - k + 1 + i;
                        int digitBuilder = Integer.parseInt(String.valueOf(builder.charAt(xorValue)));
                        digitString ^= digitBuilder;
                        i++;
                    }
                }
                break;
            }
        }
            counterXor++;//basically counter xor is needed just in the first part
            String result = Integer.toString(digitString);
            return result.charAt(0);
        }

        public static String cipher ( int k, String s){
            // Write your code here

            StringBuilder builder = new StringBuilder();
            int lengthString = s.length();
            int lengthOriginalString = lengthString - k + 1;

            //there are 2 options - > start with 1 or with 0
            for (int i = 0; i < s.length(); i++) {
                if (i == lengthOriginalString) {//we need to stop when our idx reaches the length of the originalString which will be stringFinal-original+1
                    // cause it starts the xor from the original
                    break;
                }

                if (s.charAt(i) == '1' && i == 0) {
                    builder.append('1');
                } else if (s.charAt(i) == '0' && i == 0) {
                    builder.append('0');
                } else {
                    //basically we will do xor starting from the index of the original string and as it shifts right we need to do xor with all chars from the builder
                    // till we get the final result and that is our char at the respective index
               /* 1001010
                1001010
                1001010
                1001010
                        ----------
                1110100110*/
                    char result = createXorValue(builder, s.charAt(i), k, i);
                    builder.append(result);

                }


            }
            counterXor = 1;//we need to make the counter here back to the original value, because when we re-appeal the function the counter keeps it;s value as it is static
            return builder.toString();

        }

        public static void main (String[]args){
            System.out.println(cipher(4, "1110101001"));
            System.out.println(cipher(4, "1110100110"));
            System.out.println(cipher(2, "1110001"));
            System.out.println(cipher(3, "1110011011"));
        }
    }
