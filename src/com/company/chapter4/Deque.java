package com.company.chapter4;

public class Deque {
    private int maxSize;
    private long[] queArray;
    private int front;
    private int rear;
    private int nItems;

    public Deque(int s){
        maxSize = s;
        queArray = new long[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void insertLeft(long j){
        if(rear == maxSize-1){
            rear = -1;
        }
        queArray[++rear] = j;
        nItems++;
    }

    public void insertRight(long j){
        if(front == 0){
            front = maxSize;
        }
        queArray[--front] = j;
        nItems++;
    }

    public long removeRight(){
        long temp = queArray[front++];
        if(front==maxSize) {
            front = 0;
        }
        nItems--;
        return temp;
    }

    public long removeLeft(){
        long temp = queArray[rear--];
        if(rear==0) {
            rear = maxSize - 1;
        }
        nItems--;
        return temp;
    }

    public long peekLeft(){
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
}
