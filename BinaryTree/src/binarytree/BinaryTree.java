package binarytree;

import java.io.*;

public class BinaryTree <E> implements Serializable {
    /**
     * The inner Node class
     */
    protected static class Node <E> implements Serializable {
        protected E data;
        protected Node <E> left;
        protected Node <E> right;
        
        public Node(E data) {
            this.data = data;
            left = null;
            right = null;
        }
        
        @Override
        public String toString() {
            return data.toString();
        }
    }
    
    protected Node <E> root;
    
    /**
     * no parameter constructor to create empty tree
     */
    public BinaryTree() {
        root = null;
    }
    
    /**
     * create tree with a given node as root
     */
    public BinaryTree(Node <E> root) {
        this.root = root;
    }
    
    /**
     * constructs tree with given data in the root and the roots of left subtree and right subtree
     */
    public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree) {
        root = new Node <E>(data);
        
        if(leftTree != null) {
            root.left = leftTree.root;
        }
        else {
            root.left = null;
        }
        
        if(rightTree != null) {
            root.right = rightTree.root;
        }
        else {
            root.right = null;
        }
    }
    
    public BinaryTree <E> getLeftSubtree() {
        if(root != null && root.left != null) {
            return new BinaryTree<E>(root.left);
        }
        else {
            return null;
        }
    }

    public BinaryTree <E> getRightSubtree() {
        if(root != null && root.right != null) {
            return new BinaryTree<E>(root.right);
        }
        else {
            return null;
        }
    }
    
    public E getData() {
        return root.data;
    }
    
    public boolean isLeaf() {
        return (root.left == null && root.right == null);
    }

    private void preOrderTraverse(Node <E> node, int depth, StringBuilder sb) {
        for(int i = 1; i < depth; i++) {
            sb.append(" ");
        }
        
        if(node == null) {
            sb.append("null\n");
        }
        else {
            sb.append(node.toString());
            sb.append("\n");
            preOrderTraverse(node.left, depth + 1, sb);
            preOrderTraverse(node.right, depth + 1, sb);
        }
    }
    
     private void inOrderTraverse(Node <E> node, int depth, StringBuilder sb) {
        /*for(int i = 1; i < depth; i++) {
            sb.append(" ");
        }*/
        
        if(node == null) {
            //sb.append("null\n");
        }
        else {
            inOrderTraverse(node.left, depth + 1, sb);
            sb.append(node.toString());
            sb.append("\n");
            inOrderTraverse(node.right, depth + 1, sb);            
        }
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        inOrderTraverse(root, 1, sb);
        return sb.toString();
    }
    
   /** Method to read a binary tree.
      pre: The input consists of a pre order traversal
           of the binary tree. The line "null" indicates a null tree.
      @param bR The input file
      @return The binary tree
      @throws IOException If there is an input error
   */

    public static BinaryTree <String> readBinaryTree(BufferedReader bR) throws IOException {
        String data = bR.readLine().trim();
        if (data.equals("null")) {
            return null;
        }
        else {
            BinaryTree < String > leftTree = readBinaryTree(bR);
            BinaryTree < String > rightTree = readBinaryTree(bR);
            return new BinaryTree < String > (data, leftTree, rightTree);
        }
    }
}