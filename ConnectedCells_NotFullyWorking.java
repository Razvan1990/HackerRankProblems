package hackerRank;


import java.util.*;

public class ConnectedCells_NotFullyWorking {

    private static boolean checkIfListContainsIndices(Set<List<Integer>> myList, int i, int j) {
        List<Integer> temp = Arrays.asList(i, j);
        return myList.contains(temp);
    }

    private static List<List<Integer>> neighboursThatAreOne(List<List<Integer>> matrix, int i, int j) {
        //just need to check on the right and down and down -right ->?
        //check horizontally
        List<List<Integer>> neighbours = new ArrayList<>();
        if (i == matrix.size() - 1 && j == matrix.get(i).size() - 1) {
            return neighbours;
        }
        if (j == matrix.get(i).size() - 1) {
            return neighbours;
        }

        if (i == 0 && j == matrix.get(i).size() - 1) {
            if (matrix.get(i + 1).get(j) == 1) {
                List<Integer> tempList = Arrays.asList(i + 1, j);
                neighbours.add(tempList);
            }
            if (matrix.get(i + 1).get(j - 1) == 1) {
                List<Integer> tempList = Arrays.asList(i + 1, j - 1);
                neighbours.add(tempList);
            }
        }
        if (i == matrix.size() - 1) {
            if (matrix.get(i).get(j + 1) == 1) {
                List<Integer> tempList = Arrays.asList(i, j + 1);
                neighbours.add(tempList);
            }
        } else {
            if (matrix.get(i).get(j + 1) == 1) {
                List<Integer> tempList = Arrays.asList(i, j + 1);
                neighbours.add(tempList);
            }
            if (matrix.get(i + 1).get(j) == 1) {
                List<Integer> tempList = Arrays.asList(i + 1, j);
                neighbours.add(tempList);
            }
            if (matrix.get(i + 1).get(j + 1) == 1) {
                List<Integer> tempList = Arrays.asList(i + 1, j + 1);
                neighbours.add(tempList);
            }
        }
        return neighbours;
    }

    /**
     * TODO
     * 1.make a boolean which sees if we encounter a match in all cases
     * 2. If the boolean remains false, then we can stop counting and make comparision
     * 3. Check for 0 if there are neighbours in the list, if so, we just continue
     * 4. If not, then we will have our tempResult to 0 and compare with result which was the previous tempResult
     */
    private static boolean checkIfOneIsRelatedToOne(Set<List<Integer>> counters, List<List<Integer>> matrix, int i, int j) {
        List<List<Integer>> neighbours = neighboursThatAreOne(matrix, i, j);
        for (List<Integer> list : neighbours) {

            if (i == 0 && j == 0) {

            }
            //we need to check upwards in this situation
            if (i == 0 && j != 0) {
                int row = list.get(0);
                int column = list.get(1);
                List<Integer> combination = Arrays.asList(row, column - 1);
                if (counters.contains(combination)) {
                    return true;
                }
            }
            if (j == 0 && i != 0) {
                int row = list.get(0);
                int column = list.get(1);
                List<Integer> combination1 = Arrays.asList(row - 1, column);
                List<Integer> combination2 = Arrays.asList(row - 1, column + 1);
                if (counters.contains(combination1) || counters.contains(combination2)) {
                    return true;
                }
            }
            if (j == matrix.get(i).size() - 1 && i == matrix.size() - 1) {
                int row = list.get(0);
                int column = list.get(1);
                List<Integer> combination1 = Arrays.asList(row, column - 1);
                List<Integer> combination2 = Arrays.asList(row - 1, column);
                List<Integer> combination3 = Arrays.asList(row - 1, column - 1);
                if (counters.contains(combination1) || counters.contains(combination2) || counters.contains(combination3)) {
                    return true;
                }
            }
            int row = list.get(0);
            int column = list.get(1);
            List<Integer> combination1 = Arrays.asList(row, column - 1);
            List<Integer> combination2 = Arrays.asList(row - 1, column);
            List<Integer> combination3 = Arrays.asList(row - 1, column - 1);
            List<Integer> combination4 = Arrays.asList(row - 1, column + 1);
            if (counters.contains(combination1) || counters.contains(combination2) || counters.contains(combination3) || counters.contains(combination4)) {
                return true;
            }

        }


        return false;
    }

    public static int connectedCell(List<List<Integer>> matrix) {
        // Write your code here
        //need a list to keep track if the element is already there
        Set<List<Integer>> countList = new HashSet<>();
        int result = 0;
        int tempResult = 0;
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                boolean check = false;
                boolean hasNeighbours = false;
                if (matrix.get(i).get(j) == 1) {
                    //check for i neighbours which are 1 and if so put them in the list
                    List<Integer> tempList = Arrays.asList(i, j);
                    //countList.add(tempList);
                    //1. CHECK HORIZONTALLY
                    //a. check if on last column
                    //tempResult++;
                    if (j == matrix.get(i).size() - 1) {
                        if (matrix.get(i).get(j - 1) == 1 && !checkIfListContainsIndices(countList, i, j - 1)) {
                            countList.add(Arrays.asList(i, j - 1));
                            check = true;
                        }//b. check if on first column
                    } else if (j == 0) {
                        if (matrix.get(i).get(j + 1) == 1 && !checkIfListContainsIndices(countList, i, j + 1)) {
                            tempResult++;
                            countList.add(Arrays.asList(i, j + 1));
                            check = true;
                        }
                    } else {
                        if (matrix.get(i).get(j - 1) == 1 && !checkIfListContainsIndices(countList, i, j - 1)) {
                            tempResult++;
                            countList.add(Arrays.asList(i, j - 1));
                            check = true;
                        }
                        if (matrix.get(i).get(j + 1) == 1 && !checkIfListContainsIndices(countList, i, j + 1)) {
                            tempResult++;
                            countList.add(Arrays.asList(i, j + 1));
                            check = true;
                        }

                    }
                    //CHECK VERTICALLY
                    //1. check to see if it is not first row
                    if (i == 0) {
                        if (matrix.get(i + 1).get(j) == 1
                                && !checkIfListContainsIndices(countList, i + 1, j)) {
                            tempResult++;
                            countList.add(Arrays.asList(i + 1, j));
                            check = true;
                        }

                    } else if (i == matrix.size() - 1) {///check diagonal now
                        // 2. check to see if it is not last row
                        if (matrix.get(i - 1).get(j) == 1
                                && !checkIfListContainsIndices(countList, i - 1, j)) {
                            tempResult++;
                            countList.add(Arrays.asList(i - 1, j));
                            check = true;
                        }
                    } else {
                        if (matrix.get(i + 1).get(j) == 1
                                && !checkIfListContainsIndices(countList, i + 1, j)) {
                            tempResult++;
                            countList.add(Arrays.asList(i + 1, j));
                            check = true;
                        }
                        if (matrix.get(i - 1).get(j) == 1
                                && !checkIfListContainsIndices(countList, i - 1, j)) {
                            tempResult++;
                            countList.add(Arrays.asList(i - 1, j));
                            check = true;
                        }

                    }
                    //CHECK DIAGONAL
                    //1. CHECK TO SEE IF FIRST ROW AND FIRST COLUMN
                    if (j == 0 && i == 0) {
                        if (matrix.get(i + 1).get(j + 1) == 1 &&
                                !checkIfListContainsIndices(countList, i + 1, j + 1)) {
                            tempResult++;
                            countList.add(Arrays.asList(i + 1, j + 1));
                            check = true;
                        }
                    }//2. CHECK FIRST ROW AND LAST COLUMN
                    else if (i == 0 && j == matrix.get(i).size() - 1) {
                        if (matrix.get(i + 1).get(j - 1) == 1 &&
                                !checkIfListContainsIndices(countList, i + 1, j - 1)) {
                            tempResult++;
                            countList.add(Arrays.asList(i + 1, j - 1));
                            check = true;
                        }
                    }
                    //3. CHECK LAST ROW AND FIRST COLUMN
                    else if (i == matrix.size() - 1 && j == 0) {
                        if (matrix.get(i - 1).get(j + 1) == 1 &&
                                !checkIfListContainsIndices(countList, i - 1, j + 1)) {
                            tempResult++;
                            countList.add(Arrays.asList(i - 1, j + 1));
                            check = true;
                        }

                    } //4. CHECK LAST ROW AND LAST COLUMN
                    else if (i == matrix.size() - 1 && j == matrix.get(i).size() - 1) {
                        if (matrix.get(i - 1).get(j - 1) == 1 &&
                                !checkIfListContainsIndices(countList, i - 1, j - 1)) {
                            tempResult++;
                            countList.add(Arrays.asList(i - 1, j - 1));
                            check = true;
                        }
                    }//5. CHECK JUST FIRST ROW
                    else if (i == 0) {
                        if (matrix.get(i + 1).get(j + 1) == 1 &&
                                !checkIfListContainsIndices(countList, i + 1, j + 1)) {
                            tempResult++;
                            countList.add(Arrays.asList(i + 1, j + 1));
                            check = true;
                        }
                        if (matrix.get(i + 1).get(j - 1) == 1 &&
                                !checkIfListContainsIndices(countList, i + 1, j - 1)) {
                            tempResult++;
                            countList.add(Arrays.asList(i + 1, j - 1));
                            check = true;
                        }

                    }
                    //6. CHECK JUST LAST ROW
                    else if (i == matrix.size() - 1) {
                        if (matrix.get(i - 1).get(j + 1) == 1 &&
                                !checkIfListContainsIndices(countList, i - 1, j + 1)) {
                            tempResult++;
                            countList.add(Arrays.asList(i + 1, j + 1));
                            check = true;
                        }
                        if (matrix.get(i - 1).get(j - 1) == 1 &&
                                !checkIfListContainsIndices(countList, i - 1, j - 1)) {
                            tempResult++;
                            countList.add(Arrays.asList(i - 1, j - 1));
                            check = true;
                        }

                    }
                    //7. CHECK JUST FIRST COLUMN
                    else if (j == 0) {
                        if (matrix.get(i - 1).get(j + 1) == 1 &&
                                !checkIfListContainsIndices(countList, i - 1, j + 1)) {
                            tempResult++;
                            countList.add(Arrays.asList(i - 1, j + 1));
                            check = true;
                        }
                        if (matrix.get(i + 1).get(j + 1) == 1 &&
                                !checkIfListContainsIndices(countList, i + 1, j + 1)) {
                            tempResult++;
                            countList.add(Arrays.asList(i + 1, j + 1));
                            check = true;
                        }

                    }
                    //8. CHECK JUST LAST COLUMN
                    else if (j == matrix.get(i).size()-1) {
                        if (matrix.get(i - 1).get(j - 1) == 1 &&
                                !checkIfListContainsIndices(countList, i - 1, j - 1)) {
                            tempResult++;
                            countList.add(Arrays.asList(i - 1, j - 1));
                            check = true;
                        }
                        if (matrix.get(i + 1).get(j - 1) == 1 &&
                                !checkIfListContainsIndices(countList, i + 1, j - 1)) {
                            tempResult++;
                            countList.add(Arrays.asList(i + 1, j - 1));
                            check = true;
                        }

                    } else {
                        if (matrix.get(i - 1).get(j - 1) == 1 &&
                                !checkIfListContainsIndices(countList, i - 1, j - 1)) {
                            tempResult++;
                            countList.add(Arrays.asList(i - 1, j - 1));
                            check = true;
                        }
                        if (matrix.get(i + 1).get(j - 1) == 1 &&
                                !checkIfListContainsIndices(countList, i + 1, j - 1)) {
                            tempResult++;
                            countList.add(Arrays.asList(i + 1, j - 1));
                            check = true;
                        }
                        if (matrix.get(i - 1).get(j + 1) == 1 &&
                                !checkIfListContainsIndices(countList, i - 1, j + 1)) {
                            tempResult++;
                            countList.add(Arrays.asList(i - 1, j + 1));
                            check = true;
                        }
                        if (matrix.get(i + 1).get(j + 1) == 1 &&
                                !checkIfListContainsIndices(countList, i + 1, j + 1)) {
                            tempResult++;
                            countList.add(Arrays.asList(i + 1, j + 1));
                            check = true;
                        }

                    }
                    //+1 comes from the first element
                    List<Integer> currentIndices = Arrays.asList(i, j);
                    if (!check && !countList.contains(currentIndices)) {
                        result = Math.max(result, tempResult);
                        tempResult = 0;

                    }
                } else {
                    //check horizontally
                    if (j == matrix.get(i).size() - 1) {
                        if (checkIfListContainsIndices(countList, i, j - 1)) {
                            hasNeighbours = true;
                        } else if (checkIfOneIsRelatedToOne(countList, matrix, i, j)) {
                            hasNeighbours = true;
                        }
                    } else if (j == 0) {
                        if (checkIfListContainsIndices(countList, i, j + 1)) {
                            hasNeighbours = true;
                        } else if (checkIfOneIsRelatedToOne(countList, matrix, i, j)) {
                            hasNeighbours = true;
                        }
                    } else {
                        if (checkIfListContainsIndices(countList, i, j + 1) || checkIfListContainsIndices(countList, i, j - 1)) {
                            hasNeighbours = true;
                        } else if (checkIfOneIsRelatedToOne(countList, matrix, i, j)) {
                            hasNeighbours = true;
                        }
                    }
                    //check vertically
                    if (i == 0) {
                        if (checkIfListContainsIndices(countList, i + 1, j)) {
                            hasNeighbours = true;
                        } else if (checkIfOneIsRelatedToOne(countList, matrix, i, j)) {
                            hasNeighbours = true;
                        }
                    } else if (i == matrix.size() - 1) {
                        if (checkIfListContainsIndices(countList, i - 1, j)) {
                            hasNeighbours = true;
                        } else if (checkIfOneIsRelatedToOne(countList, matrix, i, j)) {
                            hasNeighbours = true;
                        }
                    } else {
                        if (checkIfListContainsIndices(countList, i + 1, j) || checkIfListContainsIndices(countList, i - 1, j)) {
                            hasNeighbours = true;
                        } else if (checkIfOneIsRelatedToOne(countList, matrix, i, j)) {
                            hasNeighbours = true;
                        }
                    }
                    //check diagonally
                    if (i == 0 && j == 0) {
                        if (checkIfListContainsIndices(countList, i + 1, j + 1)) {
                            hasNeighbours = true;
                        } else if (checkIfOneIsRelatedToOne(countList, matrix, i, j)) {
                            hasNeighbours = true;
                        }
                    } else if (i == 0 && j == matrix.get(i).size() - 1) {
                        if (checkIfListContainsIndices(countList, i + 1, j - 1)) {
                            hasNeighbours = true;
                        } else if (checkIfOneIsRelatedToOne(countList, matrix, i, j)) {
                            hasNeighbours = true;
                        }
                    } else if (i == matrix.size() - 1 && j == 0) {
                        if (checkIfListContainsIndices(countList, i - 1, j + 1)) {
                            hasNeighbours = true;
                        } else if (checkIfOneIsRelatedToOne(countList, matrix, i, j)) {
                            hasNeighbours = true;
                        }
                    } else if (i == matrix.size() - 1 && j == matrix.get(i).size() - 1) {
                        if (checkIfListContainsIndices(countList, i - 1, j - 1)) {
                            hasNeighbours = true;
                        } else if (checkIfOneIsRelatedToOne(countList, matrix, i, j)) {
                            hasNeighbours = true;
                        }
                    } else if (i == 0) {
                        if (checkIfListContainsIndices(countList, i + 1, j + 1) || checkIfListContainsIndices(countList, i + 1, j - 1)) {
                            hasNeighbours = true;
                        } else if (checkIfOneIsRelatedToOne(countList, matrix, i, j)) {
                            hasNeighbours = true;
                        }
                    } else if (i == matrix.size() - 1) {
                        if (checkIfListContainsIndices(countList, i - 1, j + 1) || checkIfListContainsIndices(countList, i - 1, j - 1)) {
                            hasNeighbours = true;
                        } else if (checkIfOneIsRelatedToOne(countList, matrix, i, j)) {
                            hasNeighbours = true;
                        }
                    } else if (j == 0) {
                        if (checkIfListContainsIndices(countList, i - 1, j + 1) || checkIfListContainsIndices(countList, i + 1, j + 1)) {
                            hasNeighbours = true;
                        } else if (checkIfOneIsRelatedToOne(countList, matrix, i, j)) {
                            hasNeighbours = true;
                        }
                    } else if (j == matrix.get(i).size() - 1) {
                        if (checkIfListContainsIndices(countList, i - 1, j - 1) || checkIfListContainsIndices(countList, i + 1, j - 1)) {
                            hasNeighbours = true;
                        } else if (checkIfOneIsRelatedToOne(countList, matrix, i, j)) {
                            hasNeighbours = true;
                        }
                    } else {
                        if (checkIfListContainsIndices(countList, i - 1, j - 1) || checkIfListContainsIndices(countList, i - 1, j + 1) ||
                                checkIfListContainsIndices(countList, i + 1, j - 1) || checkIfListContainsIndices(countList, i + 1, j + 1)) {
                            hasNeighbours = true;
                        } else if (checkIfOneIsRelatedToOne(countList, matrix, i, j)) {
                            hasNeighbours = true;
                        }
                    }
                    if (!hasNeighbours) {
                        result = Math.max(result, tempResult + 1);
                        tempResult = 0;
                    }


                    /*
                    We will check to see if a neighbour(horizontal, vertical,diagonal) is in the list. If so, we will continue
                    We need to keep track again of the positions to not get overflow

                    If there will be no neighbour, then we will compare the result with tempResult+1, and have the max-> will be tempResult
                    Result will be equal to temp Result and then the temp result will be 0 again
                     */


                }

            }
        }

        return result;
}

    public static void main(String[] args) {
        List<List<Integer>> myList = new ArrayList<>();
        List<List<Integer>> myList2 = new ArrayList<>();
        List<List<Integer>> myList3 = new ArrayList<>();
        List<List<Integer>> myList4 = new ArrayList<>();
        List<List<Integer>> myList5 = new ArrayList<>();
        Set<List<Integer>> mySet = new HashSet<>();
        Integer[][] a = new Integer[][]{{1, 1, 0, 0,}, {0, 1, 1, 0}, {0, 0, 1, 0}, {1, 0, 0, 0}};
        Integer[][] b = new Integer[][]{{1, 1, 0}, {1, 0, 0}, {0, 0, 1}};
        Integer[][] c = new Integer[][]{{0, 0, 1, 1}, {0, 0, 1, 0}, {0, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        Integer[][] d = new Integer[][]{{1, 1, 0, 0,0}, {0, 1, 1, 0,0}, {0, 0, 1, 0,1}, {1, 0, 0, 0,1}, {0, 1, 0, 1,1}};
        Integer[][] e = new Integer[][]{{1, 1, 0, 0,1}, {0, 0, 1, 0,0}, {1, 1, 0, 1,0}, {0, 1, 1, 0,0}, {0, 0, 0, 0,0},{0, 1, 0, 0, 0},{0, 0, 1, 1, 0}};
        for (Integer[] row : b) {
            List<Integer> tempList = new ArrayList<>(Arrays.asList(row));
            myList2.add(tempList);
        }

        for (Integer[] row : a) {
            List<Integer> tempList = new ArrayList<>(Arrays.asList(row));
            myList.add(tempList);

        }
        for (Integer[] row : c) {
            List<Integer> tempList = new ArrayList<>(Arrays.asList(row));
            myList3.add(tempList);

        }
        for (Integer[] row : d) {
            List<Integer> tempList = new ArrayList<>(Arrays.asList(row));
            myList4.add(tempList);

        }
        for (Integer[] row : e) {
            List<Integer> tempList = new ArrayList<>(Arrays.asList(row));
            myList5.add(tempList);

        }
        for (Integer[] row : a) {
            List<Integer> tempList = new ArrayList<>(Arrays.asList(row));
            mySet.add(tempList);

        }


//        System.out.println(myList);
//        System.out.println(mySet);
//        System.out.println(myList.size());
//
//        for (List<Integer> integers : myList) {
//            System.out.println(integers.size());
//        }

        System.out.println(connectedCell(myList));
        System.out.println(connectedCell(myList2));
        System.out.println(connectedCell(myList3));
        System.out.println(connectedCell(myList4));
        System.out.println(connectedCell(myList5));

    }
}


