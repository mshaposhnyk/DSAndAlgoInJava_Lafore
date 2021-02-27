package com.company.chapter5;

import com.company.chapter4.PriorityQ;

public class PriorityQueueApp {
    public static void main(String[] args) {
        PriorityQueue thePQ = new PriorityQueue();
        thePQ.insert(30);
        thePQ.insert(50);
        thePQ.insert(10);
        thePQ.insert(40);
        thePQ.insert(20);

        while (!thePQ.isEmpty())
        {
            long item = thePQ.remove();
            System.out.print(item+ " ");
        }
        System.out.println("");
    }
}
