package com.company.chapter4;

public class QueueApp {
    public static void main(String[] args) {
        Queue theQueue = new Queue(5);

        theQueue.insert(10);
        theQueue.insert(20);
        theQueue.insert(30);
        theQueue.insert(40);

        theQueue.display();

        theQueue.remove();
        theQueue.remove();
        theQueue.remove();

        theQueue.display();

        theQueue.insert(50);
        theQueue.insert(60);
        theQueue.insert(70);
        theQueue.insert(80);

        theQueue.display();

        theQueue.remove();
        theQueue.remove();
        theQueue.remove();

        theQueue.display();

        theQueue.insert(90);
        theQueue.insert(100);
        theQueue.insert(110);
        theQueue.display();

        /*while(!theQueue.isEmpty()){
            long n = theQueue.remove();
            System.out.print(n);
            System.out.print(" ");
        }
        System.out.println("");*/
    }
}
