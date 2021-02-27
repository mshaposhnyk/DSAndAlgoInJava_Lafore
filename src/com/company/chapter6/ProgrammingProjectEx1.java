package com.company.chapter6;

public class ProgrammingProjectEx1 {
    public static void main(String[] args) {
        System.out.println(mult(2,3));
        System.out.println(mult(5,2));
        System.out.println(mult(5,5));
        System.out.println(mult(10,5));
        System.out.println(mult(4,4));
    }

    private static double mult(int x, int y) {
        if(y==1){
            return x;
        }
        return x + mult(x,y-1);
    }
}
