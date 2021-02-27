package com.company.chapter5;

public class EndlessList {
    private Link current;
    private int size = 0;

    public void insert(long item){
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

    public Link search(long item){
        Link found = null;
        Link last = current;
        if(size > 0){
            while (last.next != current){
                if(last.dData == item){
                    found = last;
                    break;
                }
                last = last.next;
            }
            if(last.dData == item){
                found = last;
            }
        }
        return found;
    }

    public Link remove(long item){
        Link removed = null;
        Link prev;
        Link last = current;
        if (size>0){
            do {
                prev = last;
                last = last.next;
                if(last.dData == item){
                    removed = last;
                    break;
                }
            }while (last != current);
            prev.next = removed.next;
            current = removed.next;
            size--;
        }
        return removed;
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

    public long step(){
        current = current.next;
        return current.dData;
    }

    public int getSize() {
        return size;
    }
}
