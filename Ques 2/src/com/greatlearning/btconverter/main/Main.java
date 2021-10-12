package com.greatlearning.btconverter.main;

import com.greatlearning.btconverter.model.Node;
import com.greatlearning.btconverter.service.BSTServices;

import java.util.Scanner;

/**
 * The BST given in the question is NOT a BST as 40 can not be part of the right subtree of 50.
 * **/
public class Main {
    public Node node;
    public static void main(String[] args) {

        var bSTServices = new BSTServices();

        //Taking input from user for new BST
        Scanner sc = new Scanner(System.in);
        int value, num;
        System.out.println("Enter no of values: ");
        num = sc.nextInt();
        Node root = null;
        Node result = null;
        for (int i = 0; i < num; i++) {
            System.out.println("\nInsert value at " + (i + 1) + ": ");
            value = sc.nextInt();
            if (root == null) {
                root = bSTServices.insert(root, value);
            } else {
                result = bSTServices.insert(root, value);
                if (result.getData() == value)
                    i -= 1;
            }
        }
        sc.close();

//
//        //Hardcoding BST creation
//        Main tree = new Main();
//        tree.node = new Node(50);
//        tree.node.left = new Node(30);
//        tree.node.right = new Node(60);
//        tree.node.left.left = new Node(10);
//        //tree.node.right.left= new Node(40);// Breaking the condition of BST
//        tree.node.left.right= new Node(40);// Placing 40 in its correct position

        //Convert BST into right Skewed BST using bSTServicesClass

        System.out.println("Result before Conversion");
        bSTServices.inOrder(root);

        Node skewedTree = bSTServices.convertBSTIntoRightSkewedBST(root);

        //Display Skewed Tree
        System.out.println("\nResult After Conversion");
        Node rightNode = skewedTree;
        while(rightNode != null){
            System.out.print(rightNode.getData() + " ");
            rightNode = rightNode.right;
        }
    }
}
