package com.greatlearning.bstconverter.main;

import com.greatlearning.bstconverter.model.Node;
import com.greatlearning.bstconverter.service.BSTServices;

/**
 * The BST given in the question is NOT a BST as 40 can not be part of the right subtree of 50.
 * **/
public class Main {
    public Node node;
    public static void main(String[] args) {
        //creating instance of BST Services
        var bSTServices = new BSTServices();

        //Hardcoding BST creation
        Main tree = new Main();
        tree.node = new Node(50);
        tree.node.left = new Node(30);
        tree.node.right = new Node(60);
        tree.node.left.left = new Node(10);
        //tree.node.right.left= new Node(40);// Breaking the condition of BST
        tree.node.left.right= new Node(40);// Placing 40 in its correct position

        System.out.println("Result before Conversion");
        bSTServices.inOrder(tree.node);

        //Convert BST into right Skewed BST using bSTServicesClass. Algo given in BST Service class
        Node skewedTree = bSTServices.convertBSTIntoRightSkewedBST(tree.node);

        //Display Skewed Tree
        System.out.println("\nResult After Conversion");
        Node rightNode = skewedTree;
        while(rightNode != null){
            System.out.print(rightNode.getData() + " ");
            rightNode = rightNode.right;
        }
    }
}
