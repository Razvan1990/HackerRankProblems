package hackerRank;

public class TimeInWords {

    private static String getHourInWords(int hour){
        String result ="";
        switch (hour){
            case 1:
                result ="one";
                return result;
            case 2:
                result ="two";
                return result;
            case 3:
                result ="three";
                return result;
            case 4:
                result ="four";
                return result;
            case 5:
                result ="five";
                return result;
            case 6:
                result ="six";
                return result;
            case 7:
                result ="seven";
                return result;
            case 8:
                result ="eight";
                return result;
            case 9:
                result ="nine";
                return result;
            case 10:
                result ="ten";
                return result;
            case 11:
                result ="eleven";
                return result;
            case 12:
                result ="twelve";
                return result;
            default:
                System.out.println("Something not correct");
                return "Wrong";

        }
    }

    private static String getMinutesInWords(int minutes){
        String result ="";
        switch (minutes){
            case 1:
                result ="one";
                return result;
            case 2:
                result ="two";
                return result;
            case 3:
                result ="three";
                return result;
            case 4:
                result ="four";
                return result;
            case 5:
                result ="five";
                return result;
            case 6:
                result ="six";
                return result;
            case 7:
                result ="seven";
                return result;
            case 8:
                result ="eight";
                return result;
            case 9:
                result ="nine";
                return result;
            case 10:
                result ="ten";
                return result;
            case 11:
                result ="eleven";
                return result;
            case 12:
                result ="twelve";
                return result;
            case 13:
                result ="thirteen";
                return result;
            case 14:
                result ="fourteen";
                return result;
            case 15:
                result ="quarter";
                return result;
            case 16:
                result ="sixteen";
                return result;
            case 17:
                result ="seventeen";
                return result;
            case 18:
                result ="eighteen";
                return result;
            case 19:
                result ="nineteen";
                return result;
            case 20:
                result ="twenty";
                return result;
            case 21:
                result ="twenty one";
                return result;
            case 22:
                result ="twenty two";
                return result;
            case 23:
                result ="twenty three";
                return result;
            case 24:
                result ="twenty four";
                return result;
            case 25:
                result ="twenty five";
                return result;
            case 26:
                result ="twenty six";
                return result;
            case 27:
                result ="twenty seven";
                return result;
            case 28:
                result ="twenty eight";
                return result;
            case 29:
                result ="twenty nine";
                return result;
            case 30:
                result ="half";
                return result;
            case 45:
                result ="quarter";
                return result;

        }
        return result;
    }



    public static String timeInWords(int h, int m) {
        // Write your code here
        String correctTime ="";
        int mediumMinute = 30;
        int hourInMinutes =60;
        String hourInWords = getHourInWords(h);
        String minuteInWords = getMinutesInWords(m);
        if (m<=mediumMinute){
            if(m==0){
                correctTime = hourInWords+" o' clock";
                return correctTime;
            }
            if(m==1){
                correctTime = minuteInWords+" minute past "+hourInWords;
                return correctTime;
            }
            if(m==15 || m==30){
                correctTime = minuteInWords+" past "+hourInWords;
                return correctTime;
            }
            correctTime = minuteInWords+" minutes past "+hourInWords;
        }
        else{
            int remainingTime = hourInMinutes-m;
            String newMinutesInWords = getMinutesInWords(remainingTime);
            String newHourInWords = getHourInWords(h+1);
            //cases
            if(remainingTime==15){
                correctTime = newMinutesInWords+" to "+newHourInWords;
                return correctTime;
            }
            if (remainingTime==1){
                correctTime = newMinutesInWords+" minute to "+newHourInWords;
                return correctTime;
            }
            correctTime = newMinutesInWords+" minutes to "+newHourInWords;



        }


        return correctTime;
    }

    public static void main(String[] args) {

        System.out.println(timeInWords(4,59));

    }
}
