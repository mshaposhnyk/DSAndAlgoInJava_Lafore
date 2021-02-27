package com.company.chapter8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class ProgrammingProjEx2 {

    public static void main(String[] args) {
        TreeSpec2 tree = new TreeSpec2();
        tree.insert("A");
        tree.insert("B");
        tree.insert("C");
        tree.insert("D");
        tree.insert("E");
        tree.traverse(1);
        System.out.println();
    }
}
class NodeSpec2 {
    public String iData;
    public int height;
    public NodeSpec2 leftChild;
    public NodeSpec2 rightChild;

    public void displayNode(){
        System.out.print('{');
        System.out.print(iData);
        System.out.print("} ");
    }
}
class TreeSpec2 {
    private NodeSpec2 root;

    public TreeSpec2(){
        root = null;
    }

    public void insert(String ins){
        if(root == null){
            root = new NodeSpec2();
            root.height = 0;
            root.iData = ins;
        } else {
            NodeSpec2 rightMost = root;
            while(rightMost.rightChild!=null){
                rightMost = rightMost.rightChild;
            }
            NodeSpec2 newLeft = new NodeSpec2();
            newLeft.iData = rightMost.iData;
            rightMost.iData = "+";
            rightMost.leftChild = newLeft;
            NodeSpec2 newRight = new NodeSpec2();
            newRight.iData = ins;
            rightMost.rightChild = newRight;
            rightMost.height = 1;

            NodeSpec2 current = root;
            while (current!=rightMost){
                current.height += 1;
                current = current.rightChild;
            }
            /*
            NodeSpec2 newNode = new NodeSpec2();
            newNode.iData = "+";
            NodeSpec2 newRightNode = new NodeSpec2();
            newRightNode.height = 0;
            newRightNode.iData = ins;
            newNode.rightChild = newRightNode;
            newNode.leftChild = root;
            newNode.height = (++newNode.leftChild.height > ++newNode.rightChild.height) ? newNode.leftChild.height:newNode.rightChild.height;
            root = newNode;*/
            if(Math.abs(root.leftChild.height- root.rightChild.height) > 1){
                balance();
            }
        }
    }

    private void balance() {
        ArrayList<NodeSpec2> nodes = new ArrayList<>();
        preOrder(root,nodes);
        int height = 1;
        while(nodes.size()!=1){
            ArrayList<NodeSpec2> newNodes = new ArrayList<>();
            for(int i =0; i<nodes.size();i = i+2){
                NodeSpec2 temp1 = new NodeSpec2();
                temp1.iData = "+";
                temp1.height = height;
                temp1.leftChild = nodes.get(i);
                temp1.rightChild = nodes.get(i+1);
                newNodes.add(temp1);
            }
            height++;
            nodes = newNodes;
        }
        root = nodes.get(0);
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

    private void preOrder(NodeSpec2 localRoot, ArrayList<NodeSpec2> nodeList){
        if(localRoot != null){
            if(!localRoot.iData.equals("+")){
                localRoot.height = 0;
                nodeList.add(localRoot);
            }
            preOrder(localRoot.leftChild,nodeList);
            preOrder(localRoot.rightChild,nodeList);
        }
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

    private void preOrder(NodeSpec2 localRoot){
        if(localRoot != null){
            System.out.print(localRoot.iData + " ");
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }

    private void inOrder(NodeSpec2 localRoot){
        if(localRoot != null){
            inOrder(localRoot.leftChild);
            System.out.print(localRoot.iData + " ");
            inOrder(localRoot.rightChild);
        }
    }

    private void postOrder(NodeSpec2 localRoot){
        if(localRoot != null){
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
            System.out.print(localRoot.iData + " ");
        }
    }

    public void displayTree(){
        Stack<NodeSpec2> globalStack = new Stack<>();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println(
                "......................................................");
        while(!isRowEmpty){
            Stack<NodeSpec2> localStack = new Stack<>();
            isRowEmpty = true;

            for(int j=0; j<nBlanks;j++){
                System.out.print(' ');
            }

            while (!globalStack.isEmpty()){
                NodeSpec2 temp = globalStack.pop();
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