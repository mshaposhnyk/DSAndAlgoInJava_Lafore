package com.company.chapter3;

public class InsertSortApp {
    public static void main(String[] args) {
        int maxSize = 100;
        ArrayIns arr;
        arr = new ArrayIns(maxSize);

        //Experiment 1
        /*
        for(int j = 0; j<maxSize;j++){
            long n = (long) (java.lang.Math.random()*(maxSize-1));
            arr.insert(n);
        }*/
        /*
        //Experiment 2

        for(int j = maxSize; j>0;j--){
            arr.insert(j);
        }*/
        /*//Experiment 3
        for(int j = 0; j<maxSize;j++){
            arr.insert(j);
        }*/
        arr.insert(77);
        arr.insert(99);
        arr.insert(99);
        arr.insert(55);
        arr.insert(22);
        arr.insert(99);
        arr.insert(11);
        arr.insert(11);
        arr.insert(66);
        arr.insert(33);

        arr.display();
        long start = System.currentTimeMillis();

        arr.insertionSort();
        long stop = System.currentTimeMillis();
        arr.display();

        double seconds = (stop - start)/1000d;
        System.out.println("Sort took "+seconds);
        //Takes 2.257 seconds with 120 000 random elements
        //Takes 4.4 seconds with 120 000 in inverse order
        //Takes 0.024 seconds with 120 000 in order
        System.out.println("Median element is "+arr.median());
        arr.noDups();
        arr.display();
    }
}
