

import java.util.*;

import javax.swing.tree.TreeNode;

class Node {

    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

}

public class Diameter_cal {

    /*
     * what is DIAMETER?
     * 
     * The diameter of a binary tree is the length of the longest path between any
     * two nodes in a tree. This path may or may not pass through the root.
     * 
     * The length of a path between two nodes is represented by the number of edges
     * between them
     */

    // Diameter is present 3 condition --
    // 1) Cal right diameter , 2)cal left diam
    // 3) include root leaft to right dimater(left sub hei+right sub hei +1)

    // Approach 2 - Here same process calculate height and dimater in together --
    // Time - 0(n)
    static class info {
        int dia;
        int height;

        info(int dia, int height) {
            this.dia = dia;
            this.height = height;
        }
    }

    public static info dia(Node root) {

        if (root == null) {
            return new info(0, 0);
        }

        info left = dia(root.left); // Calculate left dimaeter
        info right = dia(root.right); // Calculate right dimaeter

        int max = Math.max(left.dia, Math.max(right.dia, left.height + right.height + 1));

        // Self dimater = (left subtree hieght + right subtree height )+1

        int hei = Math.max(left.height, right.height) + 1;
        // Here calculate Height without height function

        return new info(max, hei); // return together height and diameter *

    }

    // Approach -1 (Here evry time calculate height ) --Time - 0(N^2)**

    /*
     * public static int height(Node root){
     * if(root==null){
     * return 0;
     * }
     * int lh = height(root.left);
     * int rh = height(root.right);
     * int max = Math.max(lh, rh)+1;
     * return max;
     * }
     */

    /*
     * public static int diame(Node root){
     * 
     * 
     * if(root==null){
     * return 0;
     * }
     * int left = diame(root.left); //Calculate left dimaeter
     * 
     * int right = diame(root.right); //Calculate right dimaeter
     * 
     * int self = height(root.left)+height(root.right)+1;
     * //Self dimater = (left subtree hieght + right subtree height )+1
     * 
     * int max = Math.max(left,Math.max(right, self));
     * //Calculate maximum dimater of 3 condition **
     * 
     * return max ;
     * 
     * 
     * }
     */

    // APPROACH -3  ---Height calulate for every node then return value 
    static int max = 0;

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        int length = left + right;
        int max1 = Math.max(left, Math.max(right, length));
        max = Math.max(max, max1);
        return Math.max(left, right) + 1;
    }

    public static int diameterOfBinaryTree(Node root) {
        height(root);
        return max;
    }

    public static void main(String[] args) {

        /*
         * 1
         * / \
         * 2 3
         * / \ / \
         * 4 5 6 7
         * 
         */

        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(diameterOfBinaryTree(root));
    }
}
