package com.company.chapter8;

import java.util.Stack;

public class ProgrammingProjEx1 {


    public static void main(String[] args) {
        TreeSpec tree = new TreeSpec();
        tree.insert("A");
        tree.insert("B");
        tree.insert("C");
        tree.insert("D");
        tree.insert("E");
        tree.displayTree();
        System.out.println();
    }
}
class NodeSpec {
    public String iData;
    public NodeSpec leftChild;
    public NodeSpec rightChild;

    public void displayNode(){
        System.out.print('{');
        System.out.print(iData);
        System.out.print("} ");
    }
}
class TreeSpec {
    private NodeSpec root;

    public TreeSpec(){
        root = null;
    }

    public void insert(String ins){
        if(root == null){
            root = new NodeSpec();
            root.iData = ins;
        } else {
            NodeSpec newNode = new NodeSpec();
            newNode.iData = "+";
            NodeSpec newRightNode = new NodeSpec();
            newRightNode.iData = ins;
            newNode.rightChild = newRightNode;
            newNode.leftChild = root;

            root = newNode;
        }
    }


    private Node getSuccesor(Node delNode){
        Node succesorParent = delNode;
        Node succesor = delNode;
        Node current = delNode.rightChild;
        while(current != null){
            succesorParent = succesor;
            succesor = current;
            current = current.leftChild;
        }

        if(succesor != delNode.rightChild){
            succesorParent.leftChild = succesor.rightChild;
            succesor.rightChild = delNode.rightChild;
        }
        return succesor;
    }

    public void traverse(int traverseType){
        switch (traverseType){
            case 1: System.out.print("\nPreorder traversal: ");
                preOrder(root);
                break;
            case 2: System.out.print("\nInorder traversal: ");
                inOrder(root);
                break;
            case 3: System.out.print("\nPostorder traversal: ");
                postOrder(root);
                break;
        }
        System.out.println();
    }

    private void preOrder(NodeSpec localRoot){
        if(localRoot != null){
            System.out.print(localRoot.iData + " ");
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }

    private void inOrder(NodeSpec localRoot){
        if(localRoot != null){
            inOrder(localRoot.leftChild);
            System.out.print(localRoot.iData + " ");
            inOrder(localRoot.rightChild);
        }
    }

    private void postOrder(NodeSpec localRoot){
        if(localRoot != null){
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
            System.out.print(localRoot.iData + " ");
        }
    }

    public void displayTree(){
        Stack<NodeSpec> globalStack = new Stack<>();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println(
                "......................................................");
        while(!isRowEmpty){
            Stack<NodeSpec> localStack = new Stack<>();
            isRowEmpty = true;

            for(int j=0; j<nBlanks;j++){
                System.out.print(' ');
            }

            while (!globalStack.isEmpty()){
                NodeSpec temp = globalStack.pop();
                if(temp!=null){
                    System.out.print(temp.iData);
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);

                    if(temp.leftChild != null || temp.rightChild != null){
                        isRowEmpty = false;
                    } else {
                        System.out.print("..");
                        localStack.push(null);
                        localStack.push(null);
                    }
                    for (int j = 0; j<nBlanks*2-2;j++){
                        System.out.print(' ');
                    }
                    System.out.println();
                    nBlanks /= 2;
                    while (!localStack.isEmpty()){
                        globalStack.push(localStack.pop());
                    }
                    System.out.println(
                            "......................................................");
                }
            }
        }
    }
}

