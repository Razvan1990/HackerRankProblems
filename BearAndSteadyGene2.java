package hackerRank;

import java.util.HashMap;

public class BearAndSteadyGene2 {

    private static boolean checkIfThereAreExtras(HashMap<Character, Integer>frequencyMap, int average){
        for (char key:frequencyMap.keySet()){
            if(frequencyMap.get(key)>average){
                return true;
            }
        }
        return false;
    }

    public static int steadyGene(String gene){
        HashMap<Character, Integer> myMap = new HashMap<>();
        myMap.put('A',0);myMap.put('C',0); myMap.put('T',0);myMap.put('G',0);
        for (int i =0;i<gene.length();i++){
            myMap.put(gene.charAt(i),myMap.get(gene.charAt(i))+1);
        }
        int average = gene.length()/4;

        if (!checkIfThereAreExtras(myMap, average)){
            return 0;
        }
        int right =0; int left = 0;int result =gene.length();
        while(right<gene.length()){
            while(right< gene.length() && checkIfThereAreExtras(myMap, average)){
                //aici practic vom scadea count-ul literelor din mapa si incrementam right
                char c = gene.charAt(right);
                myMap.put(c, myMap.get(c)-1);
                right++;
            }
            while(left<gene.length() && !checkIfThereAreExtras(myMap, average)){
                //aici vom incrementa din nou , dar nu mai dorim sa fie extra caractere si incrementam left
                char c = gene.charAt(left);
                myMap.put(c, myMap.get(c)+1);
                left++;
            }
            //minimul substringului nostru practic va fi minimul dintre resultul initial si diferenta dintre right- left+1(right este mereu mai mare
            //iar left, cu siguranta se va opri in momentul in care frecventa caracterului din mapa noastra este egala cu average
            result = Math.min(result, right-left+1);//right se duce cu 1 in plus decat trebuie
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(steadyGene("ACTGAAAG"));
        System.out.println(steadyGene("GAAATAAA"));
        System.out.println(steadyGene("TGATGCCGTCCCCTCAACTTGAGTGCTCCTAATGCGTTGC"));
        System.out.println(steadyGene("TATATAGCTTGTCTCCCTAATGTTAGTTCATGCTCGTAAGAGAACTTAGCCTACTAGGACGAGAGAACCGCACGGCGTCGTGAGGTATTTTTCGTAGGACACGCCAGATAGACGGTGGCAATGCCCGTTCAATATGACGCGATGTACGGCTAATGGGAACACTGCCCGACGCGTCTTTAGGACTGTGAGTTGCGGGTTACAGCTATGGTCTTATTGGTATCCGGCCCCTTTCGAGTCGCGATGCGCCTGCCACCACGATATTCGCCCGAAACGCGATTTGTGGGCGAGGTAGTCGTGTTCAACCCTGTAAATTTCCCTAGGTATAATCGTTCTAAGGTTCGCACATACACATCCACACCTACCTTTACACAGTTCGAGGTTCTATACGTCCTCTGAGTGCGTGTTAACACGCCCGTAAATGGGCATTTGGAGTCAGACCAGTACTTTGCGATAAACTTTACTTCCGCGAGACCTGTCCCTGGAACCCTGTTGTAAGGGTTAGGGTTTAATAGCTCCATGTCGTGTGCCTATAAGAAAAGGACGAATGGTGACAGTCCGGCTTAGCCAGGACAATGCGTGGCTGACGACGTCCAGGGTAAATTGAGTTGAATTCGCCTAATTTTAGGGTGTCTTGGTTCAATGAGGTGTCGACTTAACAAAAGGCGACATCAGTTGTCATCTTGCCTTGATAAAGTAAAACACGTGAATAGCCTATCCGGTCTGACCCCCGGGCCATGTGCTTCACCCAGGGAGCATCGCCGCTCTAGAGACGGTGTTCGTAGTCTCGATAACATGTGGGGTAATATAGAATATCCAAGACCGGTAGGAGGGGCGGTTCCGCGTCATAAGAAGTCCCAACGTGGCCTGCCACGTTCAAACAGGATACGCTATAACAGCTTCGTGGGTAATTGATGGATACGCCCGCAGGCTACCCATGCTCTTGCGATTTTGCAACCCTCGGAACCGTCACTCGTACACCCAGACATCATCTCATACAATTGCCTCACCTTCATGCCGGTACATAGGTGCCATCTCCGCTTAAGAATCCTCGCAGCAATTAATGTGACAGCACGCTAGTCCACTAGCGTATGATTACGCCACCGGGCCACCATGGACAAAAACGTTGAATTCCGACTAATAGACGAGTGTCCGATCGGGTCAACCGATCTCGGATGTTGCGTACCAGGACTACTGGGCTCGGGCCGAATCAGACACACGTATGCAACAGATACCGATAGGCGTCTTCCTAAGTAACAGCCGTAATCAATGGTGCCACAGATCTACTAATTACGGTGAAGATCATGGCCCACGACGCTGTACGGGTTTATAGCTGCCACAAACTTTAGGAAGTTTCAGCAATCGACGCGTAGTATGTGTGCTCAGACGGGTCGAGCATGCACTTGTGTATTAAGTTACTTGGCTGAACAACCTGTTGATAGATCTTGAGAGGACCGAGAAATTGCCCTCCGGTTATGAAACAGGTCCTGCGTACCAATCCTT"));

    }
}


