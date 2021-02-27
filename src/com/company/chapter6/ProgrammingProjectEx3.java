package com.company.chapter6;

public class ProgrammingProjectEx3 {
    public static void main(String[] args) {
        System.out.println(power(2,4));
        System.out.println(power(3,10));
        System.out.println(power(4,2));
        System.out.println(power(5,2));
    }

    public static int power(int base, int power){
        if(power==0){
            return 1;
        }
        return base*power(base,power-1);
    }
}
