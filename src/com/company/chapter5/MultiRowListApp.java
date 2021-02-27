package com.company.chapter5;

public class MultiRowListApp {
    public static void main(String[] args) {
        MultiRowList list = new MultiRowList(10,7);
        list.insert(1,2, 123);
        list.insert(1,1, 163);
        list.insert(0,0, 128);
        list.insert(9,6,85);

        for(int i = 0; i<10;i++){
            for(int j = 0; j<7;j++){
                System.out.print(list.displayItem(i,j) + " ");
            }
            System.out.println();
        }
    }
}
