package leetcode;

public class ReverseString {

    public void reverseString(char[] s) {
        int first = 0;
        int last = s.length -1;
        while (first<last){
            char temp = s[first];
            s[first] = s[last];
            s[last] = temp;
            first++;
            last--;
        }
        System.out.println(s);
    }

    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        char [] example ={'h', 'e', 'l', 'l', 'o'};
        reverseString.reverseString(example);
    }
}
