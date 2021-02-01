package com.company.chapter3;

public class ArrayBub {
    private long[] a;
    private int nElems;

    public ArrayBub(int max){
        a = new long[max];
        nElems = 0;
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

    public void bubbleSort(){
        int right, left, current;

        for(right = nElems - 1; right>1; right --){
            for(current = 0; current < right;current++){
                if(a[current] > a[current+1]){
                    swap(current, current+1);
                }
            }
            for(left = right; left > 0; left--){
                if(a[left] < a[left-1]){
                    swap(left, left-1);
                }
            }
        }
    }

    private void swap(int one, int two){
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }

    public void oddEvenSort(){
        for(int i = 0; i<nElems;i++){
            for(int j = 1; j<nElems-1;j+=2){
                if(a[j] > a[j+1]){
                    swap(j,j+1);
                }
            }
            for(int j = 0; j<nElems-1;j+=2){
                if(a[j] > a[j+1]){
                    swap(j,j+1);
                }
            }
        }
    }
}
