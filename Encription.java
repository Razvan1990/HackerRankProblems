package hackerRank;

import java.util.ArrayList;
import java.util.List;

public class Encription {

    public static String encryption(String s) {
        // Write your code here
        //StringBuilder result= new StringBuilder();
        String wordNoSpaces = s.replace(" ","");
        int lengthWord = wordNoSpaces.length();
        //create to see boundaries
        double rowCol = Math.sqrt(lengthWord);
        //make them ints apprximazied
        int row = (int) Math.floor(rowCol);
        int column = (int) Math.ceil(rowCol);

        if(row * column<lengthWord){
            row= row+1;
        }
        System.out.println("Number of rows "+row);
        System.out.println("Number of columns "+column);

       //alghoritm
        //feedthedog
        //fto ehg ee dd

        //feed
        //thed
        //og

//        int poz1 =0;int counterColumns =0;int counterRows =0;int poz2 =0;
//        result.append(wordNoSpaces.charAt(poz1));
//        while(poz1<wordNoSpaces.length()){
//            poz1++;counterColumns++;
//            if(counterColumns==column){
//                result.append(poz1);counterColumns=0;
//            }
//            if(result.length() % row==0){
//                result.append(" ");
//            }
//        }
//        return result.toString();
        String result = createString(row,column,wordNoSpaces);
        String finalResult = computeString(result);
        return finalResult;




    }

    private static String computeString(String s){
        StringBuilder builder = new StringBuilder();
        for (int i=0;i<s.length()-1;i++){
            if(s.charAt(i)=='\u0000' && s.charAt(i+1)==' '){
            }
            else{
               builder.append(s.charAt(i));
            }
        }
        builder.append(s.charAt(s.length()-1));
        return builder.toString();
    }

    private static String createString(int row, int column, String s){
        List<Character> myList = new ArrayList<>();
        int poz=0;int i=0;int j;int counter =1;int counterLetters =1;
        boolean needsAppends = false;boolean appendedSpace = false;
        myList.add(s.charAt(0));
        while(i<s.length()) {
            if(counterLetters>s.length()){
                break;
            }
            if(needsAppends){
                myList.add(s.charAt(poz));
                needsAppends= false;
            }
            j = i + column;//4

            if (j > s.length()-1) {
                myList.add('\u0000');//empty char
                appendedSpace = true;

            }else{
                myList.add(s.charAt(j));
                counter+=1;
                counterLetters++;
            }
            i+=column;//2 4
            if (counter==row || appendedSpace) {
                myList.add(' ');
                counter=1;
                poz += 1;
                needsAppends= true;
                i = poz;counterLetters++;appendedSpace= false;
            }

        }

        StringBuilder builder = new StringBuilder();
        for (char c:myList){
            builder.append(c);
        }
        return builder.toString();

    }



    public static void main(String[] args) {
        System.out.println(Encription.encryption("iou"));

    }
}


