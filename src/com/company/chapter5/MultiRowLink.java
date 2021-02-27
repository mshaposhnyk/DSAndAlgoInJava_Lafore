package com.company.chapter5;

public class MultiRowLink {
    public long value;
    public MultiRowLink above;
    public MultiRowLink left;

    public MultiRowLink(long value){
        this.value = value;
        above = null;
        left = null;
    }
}
