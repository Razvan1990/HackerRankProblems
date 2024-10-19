package hackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaxMInNotFullyWorking {


    private static int getDifferenceOfElements(int a, int b){
        return a -b;
    }

    public static int maxMin(int k, List<Integer> arr){
        //create a first list which stores the first k elements
        List<Integer>resultList = new ArrayList<>();
        for (int i =0;i<k;i++){
            resultList.add(arr.get(i));
        }
        //sort now the list
        Collections.sort(resultList);
        //get the difference between first and last element
        int difference = getDifferenceOfElements(resultList.get(resultList.size()-1), resultList.get(0));
        //go and check if difference of min and firest element of the array is less
        for (int i = k ;i<arr.size();i++) {
            if (arr.get(i) < resultList.get(0)) {
                //check to see if the new virtual difference is bigger than the existing difference
                int difference2 = getDifferenceOfElements(resultList.get(resultList.size() - 2), arr.get(i));
                if (difference2 < difference) {
                    resultList.remove(resultList.size()-1);
                    resultList.add(0, arr.get(i));
                    difference = getDifferenceOfElements(resultList.get(resultList.size() - 1), resultList.get(0));
                }
            } else if (arr.get(i)> resultList.get(resultList.size()-1)){
                int difference2 = getDifferenceOfElements(arr.get(i), resultList.get(1));
                if (difference2 < difference) {
                    //add the new element and remove the last element of the resultList
                    resultList.remove(0);
                    resultList.add(arr.get(i));
                    difference = getDifferenceOfElements(resultList.get(resultList.size() - 1), resultList.get(0));
                }
            }
            else{
                //get the difference between the first and previousLastElement as well as the difference between the second element and last
                int differenceFirstPreviousLast = getDifferenceOfElements(resultList.get(resultList.size()-2), resultList.get(0));
                int differenceSecondLast = getDifferenceOfElements(resultList.get(resultList.size()-1), resultList.get(1));
                //check now if the element is bigger than the first element of the list and also the difference SecondLast < difference FirstPreviousLast
                //if so, it is certain that we can remove the first element of the list
                if (arr.get(i)>=resultList.get(1) && differenceSecondLast<=differenceFirstPreviousLast){
                    resultList.remove(0);
                    resultList.add(arr.get(i));
                    Collections.sort(resultList);
                    difference = getDifferenceOfElements(resultList.get(resultList.size() - 1), resultList.get(0));
                    //check now if the element is smaller than the previous last element of the list and also the difference PreviousLast < difference secondLast
                    //if so, it is certain that we can remove the last element of the list
                }else if (arr.get(i)<=resultList.get(resultList.size()-2) && differenceFirstPreviousLast<= differenceSecondLast){
                    resultList.remove(resultList.size()-1);
                    resultList.add(arr.get(i));
                    Collections.sort(resultList);
                    difference = getDifferenceOfElements(resultList.get(resultList.size() - 1), resultList.get(0));
                }else{
                    //first we check that the difference SecondLast <= differenceFirstPreviousLast and if the element is bigger that the second element of the list
                    //if so then we can remove the first element
                    if(differenceSecondLast<=differenceFirstPreviousLast){
                        if(arr.get(i)>=resultList.get(1)){
                            resultList.remove(0);
                            resultList.add(arr.get(i));
                            Collections.sort(resultList);
                            difference = getDifferenceOfElements(resultList.get(resultList.size() - 1), resultList.get(0));
                        }
                        else {
                            //in this case we need to see what is the difference between the last element of the list and the index element
                            int differenceToMax = getDifferenceOfElements(resultList.get(resultList.size() - 1), arr.get(i));
                            //2 posibilites -> either is bigger than the differenceFirstPrevioius, either is lower
                            //if the difference is lower than the difference between first and previousToLast then we can remove the first element
                            if (differenceToMax <= differenceFirstPreviousLast) {
                                resultList.remove(0);
                                resultList.add(arr.get(i));
                                Collections.sort(resultList);
                                difference = getDifferenceOfElements(resultList.get(resultList.size() - 1), resultList.get(0));
                            } else {
                                //in this case we will remove the max element to ensure a smaller difference
                                resultList.remove(resultList.size() - 1);
                                resultList.add(arr.get(i));
                                Collections.sort(resultList);
                                difference = getDifferenceOfElements(resultList.get(resultList.size() - 1), resultList.get(0));
                            }
                        }
                    }else {
                        //analog algorithm here as in the above case
                        if(arr.get(i)<=resultList.get(resultList.size()-2)){
                            resultList.remove(resultList.size()-1);
                            resultList.add(arr.get(i));
                            Collections.sort(resultList);
                            difference = getDifferenceOfElements(resultList.get(resultList.size() - 1), resultList.get(0));
                        }else{
                            int differenceToMin = getDifferenceOfElements(arr.get(i), resultList.get(0));
                            if(differenceToMin<=differenceSecondLast){
                                resultList.remove(resultList.size() - 1);
                                resultList.add(arr.get(i));
                                Collections.sort(resultList);
                                difference = getDifferenceOfElements(resultList.get(resultList.size() - 1), resultList.get(0));
                            }else{
                                resultList.remove(0);
                                resultList.add(arr.get(i));
                                Collections.sort(resultList);
                                difference = getDifferenceOfElements(resultList.get(resultList.size() - 1), resultList.get(0));
                            }
                        }
                    }
                }
            }
        }
        return resultList.get(resultList.size()-1) - resultList.get(0);
    }

    public static void main(String[] args) {
        List<Integer>list1 = Arrays.asList(1,4,7,2);
        List<Integer> list2 = Arrays.asList(10, 100, 300, 200, 1000, 20, 30);
        List<Integer> list3 = Arrays.asList(1,2,1,2,1);
        List<Integer> list4 = Arrays.asList(1,2,3,4,10, 20, 30, 40,100, 200);
        List<Integer> list5 = Arrays.asList(4504, 1520, 5857,4094,4157,3902,822,6643,2422,7288,8245,9948,2822,1784,7802,3142,9739,5629,5413,7232);
        System.out.println(maxMin(2, list1));
        System.out.println(maxMin(3, list2));
        System.out.println(maxMin(2, list3));
        System.out.println(maxMin(4, list4));
        System.out.println(maxMin(5, list5));
    }
}


