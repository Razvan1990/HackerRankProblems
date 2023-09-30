package hackerRank;

public class MarsExploration {


    private static String getOriginalMessage(String s){
        String subsequenceMessage = "SOS";
        StringBuilder builder = new StringBuilder();
        int nrOfSos = s.length()/subsequenceMessage.length();//it is always round number of constraint
        for (int i =0;i<nrOfSos;i++){
            builder.append(subsequenceMessage);
        }
        return builder.toString();
    }

    public static int marsExploration(String s) {
        // Write your code here
        int result= 0;
        String originalMessage = getOriginalMessage(s);
        for(int i = 0;i<s.length();) {
            for (int j = 0; j < originalMessage.length(); ) {
                if (s.charAt(i) != originalMessage.charAt(j)) {
                    result++;
                    i++;
                    j++;
                }
                else{
                    i++;j++;
                }
            }
        }
            return result;
    }









    public static void main(String[] args) {
        System.out.println(marsExploration("SOSSPSSQSSOR"));
    }
}
