package hackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Clouds {
    static int jumpingOnClouds(int[] c, int k) {
        int energyLevel = 100;
        int start= 0;
        int nrOfSteps = c.length/k;

        for(int i=start+k;i<=c.length;i+=k){
            if(i==c.length){
                if(c[start]==0){
                    energyLevel-=1;
                    break;
                }
                else{
                    //lands on cumulus cloud
                    energyLevel= energyLevel-1-2;
                    break;
                }
            }
            if(c[i]==0){
                energyLevel-=1;
            }
            else{
                //lands on cumulus cloud
                energyLevel= energyLevel-1-2;
            }

        }


    return energyLevel;

    }
    static int jumpingOnCloudsWithRepeat(int[] c, int k) {
        int energyLevel = 100;
        int start= 0;
        int i = start+k;
        int precIdx;
        if(i==c.length){
            if(c[start]==0){
                return energyLevel-1;
            }
            else{
                return energyLevel-1-2;
            }
        }

        while(i!=start){
            if(c[i]==0){
                energyLevel-=1;
                precIdx=i;
                i+=k;
            }
            else{
                //lands on cumulus cloud
                energyLevel= energyLevel-1-2;
                precIdx =i;
                i+=k;
            }
            if(i>c.length-1){
                i=precIdx-c.length+k;
            }

        }
            if(c[start]==0){
                energyLevel-=1;
            }
            else{
                //lands on cumulus cloud
                energyLevel= energyLevel-1-2;
            }



        return energyLevel;

    }

    private static List<Integer> permitedCloudIndexList(List<Integer> clouds){
        List<Integer>list = new ArrayList<>();
        for (int i =0;i<clouds.size();i++){
            if(clouds.get(i)==0){
                list.add(i);
            }
        }
        return list;
    }

    public static int jumpingOnClouds2(List<Integer> c) {
        // Write your code here
        int jumps =0;
        List<Integer>zeroClouds = permitedCloudIndexList(c);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i =0;i<zeroClouds.size();i++){
            map.put(zeroClouds.get(i),i);
        }
        int idx =0;
        while(idx<zeroClouds.size()-1){
            if (zeroClouds.contains(zeroClouds.get(idx)+2)){
                idx = map.get(zeroClouds.get(idx)+2);
                jumps++;
            }
            else {
                idx++;
                jumps++;
            }
        }
        return jumps;

    }




    public static void main(String[] args) {
        int [] array = {1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1};
        System.out.println(jumpingOnCloudsWithRepeat(array,19));
        Integer [] array2 = {0, 0, 0, 0,  1, 0};
        List<Integer> convertedList = Arrays.asList(array2);
        System.out.println(jumpingOnClouds2(convertedList));

    }

}
