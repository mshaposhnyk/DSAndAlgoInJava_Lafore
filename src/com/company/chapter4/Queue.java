package com.company.chapter4;

public class Queue {
    private int maxSize;
    private long[] queArray;
    private int front;
    private int rear;
    private int nItems;

    public Queue(int s){
        maxSize = s;
        queArray = new long[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void insert(long j){
        if(rear == maxSize-1){
            rear = -1;
        }
        queArray[++rear] = j;
        nItems++;
    }

    public long remove(){
        long temp = queArray[front++];
        if(front==maxSize) {
            front = 0;
        }
        nItems--;
        return temp;
    }

    public long peekFront(){
        return queArray[front];
    }

    public boolean isEmpty(){
        return (nItems==0);
    }

    public boolean isFull(){
        return nItems==maxSize;
    }

    public int size() {
        return nItems;
    }

    public void display()
    {
        int numDisplayed = 0;
        if(front < rear){
            for (int i = rear; i >=front; i-- ){
                System.out.print(queArray[i] + " ");
                numDisplayed++;
                if(numDisplayed == nItems){
                    System.out.println();
                    return;
                }
            }
        } else if(front != rear) {
            for (int i = front-1; i >=0; i-- ){
                System.out.print(queArray[i] + " ");
                numDisplayed++;
                if(numDisplayed == nItems){
                    System.out.println();
                    return;
                }
            }
            for (int i = nItems-1; i >=front; i-- ){
                System.out.print(queArray[i] + " ");
                numDisplayed++;
                if(numDisplayed == nItems){
                    System.out.println();
                    return;
                }
            }
        } else {
            for (int i = front; i >=0; i-- ){
                System.out.print(queArray[i] + " ");
                numDisplayed++;
                if(numDisplayed == nItems){
                    System.out.println();
                    return;
                }
            }
            for (int i = nItems-1; i >=front; i-- ){
                System.out.print(queArray[i] + " ");
                numDisplayed++;
                if(numDisplayed == nItems){
                    System.out.println();
                    return;
                }
            }
        }
    }
}
