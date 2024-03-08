import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class children_sum_pro {

    public static void changeTree(Node root) {
        if (root == null) {
            return;
        }
        int total = 0;
        if (root.left != null) {
            total += root.left.data;
        }
        if (root.right != null) {
            total += root.right.data;
        }
        if (total < root.data) {
            if (root.left != null) {
                total += root.left.data;
            }
            if (root.right != null) {
                total += root.right.data;
            }
        }
        changeTree(root . left);
        changeTree(root . right);
      
        int tot = 0;
        if (root . left!=null) tot += root . left . data;
        if (root . right!=null) tot += root . right . data;
        if (root . left!=null || root . right!=null) root . data = tot;

    }

    public static void main(String[] args) {
        Node root = new Node(2);
        root.left = new Node(35);
        root.left.left = new Node(2);
        root.left.right = new Node(3);
        root.right = new Node(10);
        root.right.left = new Node(5);
        root.right.right = new Node(2);

        changeTree(root);
    }
}
