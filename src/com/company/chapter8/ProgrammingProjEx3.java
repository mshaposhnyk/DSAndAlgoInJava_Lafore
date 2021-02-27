package com.company.chapter8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class ProgrammingProjEx3 {
    public static void main(String[] args) {
        TreeSpec3 tree = new TreeSpec3();
        tree.insert('j');
        tree.insert('i');
        tree.insert('h');
        tree.insert('g');
        tree.insert('f');
        tree.insert('e');
        tree.insert('d');
        tree.insert('c');
        tree.insert('b');
        tree.insert('a');
        tree.traverse(2);
    }
}


class TreeSpec3 {
    private ArrayList<Character> root;

    public TreeSpec3(){
        root = new ArrayList<>();
    }

    public void insert(Character ins){
        root.add(ins);
        Collections.sort(root);
    }



    /*private void preOrder(NodeSpec2 localRoot, ArrayList<NodeSpec2> nodeList){
        if(localRoot != null){
            if(!localRoot.iData.equals("+")){
                localRoot.height = 0;
                nodeList.add(localRoot);
            }
            preOrder(localRoot.leftChild,nodeList);
            preOrder(localRoot.rightChild,nodeList);
        }
    }*/

    public void traverse(int traverseType){
        switch (traverseType){
            case 1: System.out.print("\nPreorder traversal: ");
                preOrder(0);
                break;
            case 2: System.out.print("\nInorder traversal: ");
                inOrder(0);
                break;
            case 3: System.out.print("\nPostorder traversal: ");
                postOrder(0);
                break;
        }
        System.out.println();
    }

    private void preOrder(int parrentIndex){
        if(root.size() > parrentIndex){
            System.out.print(root.get(parrentIndex) + " ");
            preOrder(2*parrentIndex+1);
            preOrder(2*parrentIndex+2);
        }
    }

    private void inOrder(int parrentIndex){
        if(root.size() > parrentIndex){
            inOrder(2*parrentIndex+1);
            System.out.print(root.get(parrentIndex) + " ");
            inOrder(2*parrentIndex+2);
        }
    }

    private void postOrder(int parrentIndex){
        if(root.size() > parrentIndex){
            postOrder(2*parrentIndex+1);
            postOrder(2*parrentIndex+2);
            System.out.print(root.get(parrentIndex) + " ");
        }
    }
}

