package com.company.chapter6;

public class ProgrammingProjectEx2 {

    static char[][] fullBinTree;

    public static void main(String[] args) {
        display(8);
        System.out.println();
        display(16);
        System.out.println();
        display(32);
        System.out.println();
    }

    public static void display(int charNum){
        int height = 1 + log2(charNum);
        fullBinTree = new char[height][charNum];
        for(int i = 0; i<height;i++){
            for(int j = 0; j<charNum;j++){
                fullBinTree[i][j] = '-';
            }
        }
        makeBranches(height,0,0,charNum-1);
        for(int i = 0; i<height;i++){
            for(int j = 0; j<charNum;j++){
                System.out.print(fullBinTree[i][j]);
            }
            System.out.println();
        }
    }

    public static void makeBranches(int maxLevel,int level,int left, int right){
        if(level == maxLevel){
            return;
        }
        int middle = (left + right)/2;
        makeBranches(maxLevel,level+1,left,middle);
        makeBranches(maxLevel,level+1,middle+1,right);
        fullBinTree[level][middle] = 'X';
    }

    public static int log2(int N)
    {

        // calculate log2 N indirectly
        // using log() method
        int result = (int)(Math.log(N) / Math.log(2));

        return result;
    }


}
