package com.company.chapter5;

public class StackApplication {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(2);
        stack.search(2);
        stack.push(4);
        stack.search(2);
        stack.search(4);
        stack.push(10);
        stack.push(58);
        stack.search(10);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());


        stack.displayList();
    }
}
