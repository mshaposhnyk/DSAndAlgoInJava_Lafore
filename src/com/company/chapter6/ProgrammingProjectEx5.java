package com.company.chapter6;

import java.util.ArrayList;

public class ProgrammingProjectEx5 {
    public static void main(String[] args) {
        makeCombi(5,3);
        System.out.println();
        makeCombi(10,8);
        System.out.println();
        makeCombi(6,4);
    }

    static void makeCombiUtil(ArrayList<Integer> tmp, int n, int left, int k)
    {
        if (k == 0) {
            System.out.println(tmp);
            return;
        }

        for (int i = left; i <= n; ++i)
        {
            tmp.add(i);
            makeCombiUtil(tmp, n, i + 1, k - 1);

            tmp.remove(tmp.size()-1);
        }
    }

    static void makeCombi(int n, int k)
    {

        ArrayList<Integer> tmp=new ArrayList<>();
        makeCombiUtil(tmp, n, 1, k);
    }
}
