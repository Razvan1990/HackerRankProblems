package hackerRank;

public class Handshakes {

    public static int handshake(int n) {
        // Write your code here
        int result =0;
        if (n ==0){
            result =1;
        }
        else{
            for (int i =1;i<n;i++){
                result+=n-i;
            }
        }
        return result;

    }

    public static void main(String[] args) {
        System.out.println(handshake(1));
        System.out.println(handshake(5));
        System.out.println(handshake(2));
    }
}
