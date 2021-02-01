package com.company.chapter2;

public class HighArrayApp {

    public static void main(String[] args) {
	    int maxSize = 100;
	    HighArray arr;
	    arr = new HighArray(maxSize);

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

	    arr.display(); // display items

        int searchKey = 35;
        if(arr.find(searchKey)){
            System.out.println("Found " + searchKey);
        } else {
            System.out.println("Can't find "+ searchKey);
        }

        arr.delete(0);
        arr.delete(55);
        arr.delete(99);

        arr.display();


        System.out.println("The maximum is: "+ arr.removeMax());
        System.out.println("The maximum has been removed");
        arr.display();

        long[] sortedArr = new long[arr.getnElems()];
        for(int i = 0; i < sortedArr.length;i++){
            sortedArr[i] = arr.removeMax();
        }
        System.out.println("Sorted array");
        for (long temp:
             sortedArr) {
            System.out.println(temp);
        }

        System.out.println("Duplicate array");
        HighArray duplicateArr = new HighArray(10);

        duplicateArr.insert(1);
        duplicateArr.insert(1);
        duplicateArr.insert(1);
        duplicateArr.insert(1);
        duplicateArr.insert(1);

        duplicateArr.insert(10);
        duplicateArr.insert(10);
        duplicateArr.insert(10);
        duplicateArr.insert(10);
        duplicateArr.insert(10);

        duplicateArr.display();

        duplicateArr.noDups();
        System.out.println("Now without duplicates");
        duplicateArr.display();
    }
}
