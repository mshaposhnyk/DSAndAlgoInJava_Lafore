package com.company.chapter6;

import java.awt.image.Kernel;
import java.util.Arrays;

public class ProgrammingProjectEx4 {
    static int[] knapsack = new int[5];

    public static void main(String[] args) {
        int[] firstExample = {11,8,7,6,5};
        int[] secondExample = {15,2,1,7,4};

        fillKnapsack(20,firstExample);
        System.out.println(Arrays.toString(knapsack));
        knapsack = new int[5];
        fillKnapsack(18,secondExample);
        System.out.println(Arrays.toString(knapsack));
    }

    public static void fillKnapsack(int target, int[] items){
       fillKnapsack(target,items,0,0,0);
    }

    public static void fillKnapsack(int target, int[] items, int start, int knapsackPosition ,int itemPos){
        if(itemPos != items.length){
            knapsack[knapsackPosition] =  items[itemPos];
            if(knapsack[knapsackPosition]==target){
                return;
            }
            if(knapsack[knapsackPosition]<target){
                fillKnapsack(target - knapsack[knapsackPosition],items,start,knapsackPosition+1,itemPos+1);
            } else {
                fillKnapsack(target,items,start,knapsackPosition,itemPos+1);
            }
        } else {
            if(start+1==items.length){
                for(int i = knapsackPosition-1;i>=0;i-- ){
                    target += knapsack[i];
                }
                fillKnapsack(target,items,0,0,1);
                return;
            }
            start += 1;
            target += knapsack[knapsackPosition-1];
            for(int i = 1; i<knapsack.length;i++){
                knapsack[i] = 0;
            }
            fillKnapsack(target,items,start,1,start+1);
        }
    }

}
