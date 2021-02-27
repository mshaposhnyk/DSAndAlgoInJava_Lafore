package com.company.chapter5;

public class EndlessListApp {
    public static void main(String[] args) {
        EndlessList endlessList = new EndlessList();
        endlessList.insert(2);
        endlessList.search(2);
        endlessList.insert(4);
        endlessList.search(2);
        endlessList.search(4);
        endlessList.insert(10);
        endlessList.insert(58);
        endlessList.search(10);
        System.out.println(endlessList.remove(10).dData);

        endlessList.displayList();
    }
}
