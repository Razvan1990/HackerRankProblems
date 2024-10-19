package hackerRank;

public class FirstStringIndexOccurence {

    public int strStr(String haystack, String needle) {
        if (haystack.contains(needle)){
            return haystack.indexOf(needle);
        }
        return -1;
    }

    public static void main(String[] args) {
        FirstStringIndexOccurence firstStringIndexOccurence = new FirstStringIndexOccurence();
        String haystack ="sadbutsad";
        String needle = "sad";
        System.out.println(firstStringIndexOccurence.strStr(haystack,needle));

    }
}
