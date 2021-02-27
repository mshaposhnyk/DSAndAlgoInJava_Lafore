package com.company.chapter4;

public class DequeApp {
    public static void main(String[] args) {
        Deque theStack = new Deque(10);
        theStack.insertRight(20);
        theStack.insertRight(40);
        theStack.insertRight(60);
        theStack.insertRight(80);

        while(!theStack.isEmpty()){
            long value = theStack.removeRight();
            System.out.print(value);
            System.out.print(" ");
        }
        System.out.println("");
    }
}
