package com.greatlearning.btconverter.service;

import com.greatlearning.btconverter.model.Node;

public class BSTServices {

    Node skewedTreeNode = null;
    Node tempPrevNode = null;

    public void inOrder(Node root) {
        if (root == null) return;
        else {
            inOrder(root.left);
            System.out.print(root.getData() + " ");
            inOrder(root.right);
        }
    }

    public Node convertBSTIntoRightSkewedBST(Node node) {

        if (node == null) {
            return skewedTreeNode;
        }

        convertBSTIntoRightSkewedBST(node.left);

        if (skewedTreeNode == null) {
            skewedTreeNode = node;
            tempPrevNode = node;
        } else {
            tempPrevNode.right = node;
            tempPrevNode = node;
        }
        node.left = null;

        convertBSTIntoRightSkewedBST(node.right);

        return skewedTreeNode;
    }

    public Node insert(Node root, int key) {
        Node newNode = new Node(key);
        Node x = root;
        Node y = null; // y maintains pointer to x
        while (x != null) {
            y = x;
            if (key < x.getData()) x = x.left;
            else if (key > x.getData()) x = x.right;
            else {
                System.out.println("Value already exists!!!");
                return newNode;
            }
        }// If the root is null, the tree is empty.
        if (y == null)
            y = newNode;
        // assign new node to the left child
        else if (key < y.getData())
            y.left = newNode;
        // assign the new node to the right child
        else
            y.right = newNode;// return pointer to new node
        return y;
    }
}
