package com.company.chapter2;

public class OrderedApp {
    public static void main(String[] args) {
        int maxSize = 100;
        OrdArray arr;
        arr = new OrdArray(maxSize);

        arr.insert(77);
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(0);
        arr.insert(66);
        arr.insert(33);
        arr.display();



        int searchKey = 55;
        if(arr.find(searchKey) != arr.size())
            System.out.println("Found " + searchKey);
        else
            System.out.println("Can't find "+ searchKey);
        arr.display();

        arr.delete(0);
        arr.delete(55);
        arr.delete(99);

        arr.display();


        System.out.println("First array before merging");
        OrdArray firstArr = new OrdArray(3);
        firstArr.insert(10);
        firstArr.insert(3);
        firstArr.insert(15);
        firstArr.display();

        System.out.println("Second array before merging");
        OrdArray secondArr = new OrdArray(5);
        secondArr.insert(98);
        secondArr.insert(2);
        secondArr.insert(924);
        secondArr.insert(754);
        secondArr.insert(23);
        secondArr.display();


        System.out.println("Merged arrays");
        OrdArray merged = OrdArray.merge(firstArr,secondArr);
        merged.display();
    }
}
