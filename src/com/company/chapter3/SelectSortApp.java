package com.company.chapter3;

public class SelectSortApp {
    public static void main(String[] args) {
        int maxSize = 120000;
        ArraySel arr;
        arr = new ArraySel(maxSize);
        /* //Experiment 1
        for(int j = 0; j<maxSize;j++){
            long n = (long) (java.lang.Math.random()*(maxSize-1));
            arr.insert(n);
        }*/
        /*
        //Experiment 2
        for(int j = maxSize; j>0;j--){
            arr.insert(j);
        }*/
        //Experiment 3
        for(int j = 0; j<maxSize;j++){
            arr.insert(j);
        }
        /*
        arr.insert(77);
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(0);
        arr.insert(66);
        arr.insert(33);
*/
        //arr.display();
        long start = System.currentTimeMillis();

        arr.selectionSort();
        long stop = System.currentTimeMillis();
        //arr.display();

        double seconds = (stop - start)/1000d;
        System.out.println("Sort took "+seconds);
        //Takes 10 seconds with 120 000 random elements
        //Takes 10 seconds with 120 000 in inverse order
        //Takes 3.5 seconds with 120 000 in order
    }
}
