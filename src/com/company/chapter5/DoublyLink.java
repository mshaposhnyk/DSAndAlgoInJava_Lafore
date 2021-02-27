package com.company.chapter5;

public class DoublyLink {
    public long dData;
    public DoublyLink next;
    public DoublyLink prev;

    public DoublyLink(long dd) {
        dData = dd;
    }

    public void displayLink() {
        System.out.print(dData + " ");
    }
}
