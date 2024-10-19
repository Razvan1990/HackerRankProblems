package leetcode;

public class Number1Bits {
    public int hammingWeight(int n) {
        int counter =0;
        while (n!=0){
            int rest = n%2;
            if (rest ==1){
                counter ++;
            }
            n/=2;
        }
        return counter;
    }

    public static void main(String[] args) {
        Number1Bits number1Bits = new Number1Bits();
        System.out.println(number1Bits.hammingWeight(11));
        System.out.println(number1Bits.hammingWeight(128));
        System.out.println(number1Bits.hammingWeight(2147483645));
    }

}
