package com.company.chapter3;

public class ArrayIns {
    private long[] a;
    private int nElems;
    private int copies;
    private int comparisons;

    public ArrayIns(int max){
        a = new long[max];
        nElems = copies = comparisons = 0;
    }

    private ArrayIns(ArrayIns another){
        this.a = another.a;
        this.nElems = another.nElems;
    }


    public void insert(long value){
        a[nElems++] = value;
    }

    public void display(){
        for(int j = 0; j<nElems;j++){
            System.out.print(a[j]+" ");
        }
        System.out.println(" ");
    }

    public long median(){
        ArrayIns copy = new ArrayIns(this);
        copy.insertionSort();
        int indMed = (copy.nElems / 2);
        return copy.a[indMed];
    }

    public void noDups(){
        insertionSort();
        int deleted = 0;
        int i, j;
        for(i = 0, j = 1; j<nElems;j++){
            if(a[i] == a[j]){
                deleted++;
            } else {
                i++;
                a[i] = a[j];
            }
        }
        nElems -= deleted;
    }

    public void insertionSort(){
        int in,out;

        for(out = 1; out<nElems; out++){
            long temp = a[out];
            copies++;
            in = out;
            comparisons += 2;
            while(in > 0 && a[in-1] >= temp){
                comparisons +=2;
                a[in] = a[in-1];
                --in;
            }
            a[in] = temp;
        }
    }

    private void swap(int one, int two){
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }
}
