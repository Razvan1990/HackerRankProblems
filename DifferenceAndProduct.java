package hackerRank;

public class DifferenceAndProduct {


    public static int solve(int d, int p) {
        // Write your code here
        // if we have a negative difference then the value is 0
        if (d<0){
            return 0;
        }
        if (d ==0){
            if ((p/2) * (p/2) ==p){
                return 2;
            }else{
                return 0;
            }
        }

        if (p -d ==1){
            //only thing is 1 and 2
            if (d==1){
                return 4;
            }
            else{
                return 2;
            }
        }

        if (p % d==0 && (p/d * d ==p)){
            return 2;
        }
        return 0;

    }

}
