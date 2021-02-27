package com.company.chapter5;

public class Deque {
    private DoublyLink left;
    private DoublyLink right;
    private int currentSize = 0;

    public void insertLeft(long item){
        if(currentSize == 0){
            left = right =  new DoublyLink(item);
        } else {
            DoublyLink newItem = new DoublyLink(item);
            newItem.next = left;
            left.prev = newItem;
            left = newItem;
        }
        currentSize++;
    }

    public void insertRight(long item){
        if(currentSize == 0){
            right = left = new DoublyLink(item);
        } else {
            DoublyLink newItem = new DoublyLink(item);
            newItem.prev = right;
            right.next = newItem;
            right = newItem;
        }
        currentSize++;
    }

    public long removeRight(){
        long temp = right.dData;
        if(this.right.prev!=null){
            right.prev.next = null;
        }
        right = right.prev;
        currentSize--;
        return temp;
    }

    public long removeLeft(){
        long temp = left.dData;
        if(left.next!=null){
            left.next.prev = null;
        }
        left = left.next;
        currentSize--;
        return temp;
    }

    public boolean isEmpty(){
        return (currentSize==0);
    }
    public long peekLeft(){
        return left.dData;
    }

    public long peekRight(){
        return right.dData;
    }

    public int size() {
        return currentSize;
    }

}
