package com.company.chapter5;

public class PriorityQueue {
    private Link first;

    public PriorityQueue(){
        first = null;
    }

    public boolean isEmpty(){
        return (first == null);
    }

    public void insert(long key){
        Link newLink = new Link(key);
        Link previous = null;
        Link current = first;

        while(current != null && key > current.dData){
            previous = current;
            current = current.next;
        }

        if(previous==null){
            first = newLink;
        } else {
            previous.next = newLink;
        }
        newLink.next = current;
    }

    public long remove(){
        Link temp = first;
        first = first.next;
        return temp.dData;
    }

    public void displayQueue(){
        System.out.print("List (first-->last): ");
        Link current = first;
        while (current != null){
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }

}
