package com.company.chapter5;


public class DequeApp {
    public static void main(String[] args) {
        Deque theStack = new Deque();
        theStack.insertRight(20);
        theStack.insertRight(40);
        theStack.insertLeft(60);
        theStack.insertLeft(80);

        while(!theStack.isEmpty()){
            long value = theStack.removeRight();
            System.out.print(value);
            System.out.print(" ");
        }
        System.out.println("");
    }
}
