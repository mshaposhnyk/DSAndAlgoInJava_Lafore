package com.company.chapter2;

public class OrdArray {
    private long[] a;
    private int nElems;

    public OrdArray(int max){
        a = new long[max];
        nElems = 0;
    }

    public int size(){
        return nElems;
    }

    public int find(long searchKey){
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn;

        while(true){
            curIn = (lowerBound + upperBound) / 2;
            if(a[curIn] == searchKey){
                return curIn;
            } else if(lowerBound > upperBound){
                return nElems;
            } else {
                if(a[curIn] < searchKey){
                    lowerBound = curIn + 1;
                } else {
                    upperBound = curIn - 1;
                }
            }
        }
    }


    public void insert(long value){
        int j;
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn;

        while(true){
            curIn = (lowerBound + upperBound) / 2;
            if(a[curIn] == value){
                j = curIn;
                break;
            } else if(lowerBound > upperBound){
                j = lowerBound;
                break;
            } else {
                if(a[curIn] < value){
                    lowerBound = curIn + 1;
                } else {
                    upperBound = curIn - 1;
                }
            }
        }

        for(int k = nElems; k>j; k--){
            a[k] = a[k-1];
        }
        a[j] = value;
        nElems++;
    }

    public boolean delete(long value){
        int j = find(value);
        if(j==nElems){
            return false;
        }
        else {
            for(int k = j; k<nElems; k++){
                a[k] = a[k+1];
            }
            nElems--;
            return true;
        }
    }

    public void display(){
        for(int j = 0; j<nElems;j++){
            System.out.print(a[j] + " ");
        }
        System.out.println("");
    }

    public static OrdArray merge(OrdArray first, OrdArray second){
        OrdArray result = new OrdArray(first.size()+second.size());
        int i = 0;
        int j = 0;
        int k = 0;

        while(j < first.size() && k < second.size()){
            if(first.a[j]<second.a[k]){
                result.a[i] = first.a[j];
                i++;
                j++;
            } else {
                result.a[i] = second.a[k];
                i++;
                k++;
            }
        }
        if(j == first.size()){
            while( k < second.size()){
                result.a[i] = second.a[k];
                k++;
                i++;
            }
        } else {
            while(j< first.size()){
                result.a[i] = first.a[j];
                i++;
                j++;
            }
        }

        result.nElems = first.nElems + second.nElems;
        return result;
    }
}
