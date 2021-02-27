package com.company.chapter4;

//Quick insertion, slow removal
public class PriorityQ {
    private int maxSize;
    private long[] queArray;
    private int nItems;

    public PriorityQ(int s)
    {
        maxSize = s;
        queArray = new long[maxSize];
        nItems = 0;
    }

    public void insert(long item)
    {
        queArray[nItems++] = item;
        /*else
        {
            for(j=nItems-1;j>=0;j--){
                if(item>queArray[j]){
                    queArray[j+1] = queArray[j];
                } else {
                    break;
                }
            }
            queArray[j+1] = item;
            nItems++;
        }*/
    }

    public long remove(){
        long temp = queArray[0];
        for (int i = 0; i<nItems;i++) {
            if(temp>queArray[i]){
                temp = queArray[i];
            }
        }
        nItems--;
        long[] nArray = new long[nItems];
        for(int i = 0, j = 0; i<queArray.length;i++){
            if(queArray[i]!=temp){
                nArray[j++] = queArray[i];
            }
        }
        this.queArray = nArray;
        return temp;
    }

    public long peekMin(){
        return queArray[nItems-1];
    }

    public boolean isEmpty(){
        return nItems==0;
    }

    public boolean isFull(){
        return nItems==maxSize;
    }
}
