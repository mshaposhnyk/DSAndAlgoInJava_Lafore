package com.company.chapter5;

public class Stack {
    private Link current;
    private int size = 0;

    public void push(long item){
        if(size == 0){
            current = new Link(item);
            current.next = current;
        } else {
            Link newItem = new Link(item);
            newItem.next = current;
            Link last = current;
            while (last.next != current){
                last = last.next;
            }
            current = newItem;
            last.next = current;
        }
        size++;
    }

    public boolean isEmpty(){
        return (size==0);
    }

    public long pop(){
        long removed = 0;
        Link last = current;
        if (size>0){
            removed = current.dData;
            while (last.next != current){
                last = last.next;
            }
            if(size == 1){
                current = null;
            } else {
                last.next = current.next;
                current = current.next;
            }
            size--;
        }
        return removed;
    }

    public long peek(){
        long peeked = 0;
        if (size > 0){
            peeked = current.dData;
        }
        return peeked;
    }

    public Link search(long key){
        Link found = null;
        Link last = current;
        if(size > 0){
            while (last.next != current){
                if(last.dData == key){
                    found = last;
                    break;
                }
                last = last.next;
            }
            if(last.dData == key){
                found = last;
            }
        }
        return found;
    }

    public void displayList(){
        if(size > 0){
            Link last = current;
            System.out.print(last.dData + " ");
            while (last.next != current){
                last = last.next;
                System.out.print(last.dData + " ");
            }
            //System.out.print();
        }
    }
}
