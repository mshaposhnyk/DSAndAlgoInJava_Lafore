package com.company.chapter2;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class HighArray {
    private long[] a;
    private int nElems;

    public HighArray(int max){
        a = new long[max];
        nElems = 0;
    }

    public boolean find(long searchKey){
        int j ;
        for (j = 0; j<nElems;j++)
            if(a[j] == searchKey)
                break;
        if (j == nElems)
            return false;
        else
            return true;
    }

    public void insert(long value){
        a[nElems] = value;
        nElems++;
    }

    public boolean delete(long value){
        int j;
        for(j = 0; j<nElems;j++)
            if(value==a[j])
                break;
        if(j == nElems)
            return false;
        else{
            for (int k = j; k<nElems-1;k++)
                a[k] = a[k+1];
            nElems--;
            return true;
        }
    }

    public void display(){
        for(int j = 0; j<nElems;j++){
            System.out.print(a[j] + " ");
            System.out.println("");
        }
    }

    public long getMax(){
        if(nElems != 0){
            long max = a[0];
            for(int i = 0; i<a.length;i++){
                if(a[i]>max){
                    max = a[i];
                }
            }
            return max;
        } else {
            return -1;
        }
    }

    public long removeMax(){
        long max = getMax();
        if(max != -1){
            delete(max);
        }
        return max;
    }


    public int getnElems() {
        return nElems;
    }

    public void noDups(){
        Map<Long,Integer> repeat = new TreeMap<>();
        for(int i = 0; i<a.length;i++){
            if(repeat.containsKey(a[i])){
                int numRepeats = repeat.get(a[i]) + 1;
                repeat.put(a[i],numRepeats);
            } else {
                repeat.put(a[i],0);
            }
        }

        for(Long key : repeat.keySet()){
            int numRepeats = repeat.get(key);
            for(int i = numRepeats; i > 0; i--){
                delete(key);
            }
        }
    }
}
