import java.util.LinkedList;
import java.util.Queue;

public class Tree {
    static class Node {
        int key;
        Node left, right;
    }

    // Create a new node
    static Node newNode(int key) {
        Node temp = new Node();
        temp.key = key;
        temp.left = temp.right = null;
        return temp;
    }

    // Inorder traversal
    static void inorder(Node temp) {
        if (temp == null)
            return;
        inorder(temp.left);
        System.out.print(temp.key + " ");
        inorder(temp.right);
    }

    // Delete the deepest node in the binary tree
    static void deleteDeepest(Node root, Node dNode) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node temp;

        while (!queue.isEmpty()) {
            temp = queue.poll();
            if (temp == dNode) {
                temp = null;
                return;
            }
            if (temp.right != null) {
                if (temp.right == dNode) {
                    temp.right = null;
                    return;
                } else
                    queue.add(temp.right);
            }
            if (temp.left != null) {
                if (temp.left == dNode) {
                    temp.left = null;
                    return;
                } else
                    queue.add(temp.left);
            }
        }
    }

    // Delete a specific node
    static Node deletion(Node root, int key) {
        if (root == null)
            return null;
        if (root.left == null && root.right == null) {
            if (root.key == key)
                return null;
            else
                return root;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node temp=null;
        Node  keyNode = null;

        while (!queue.isEmpty()) {
            temp = queue.poll();
            if (temp.key == key)
                keyNode = temp;
            if (temp.left != null)
                queue.add(temp.left);
            if (temp.right != null)
                queue.add(temp.right);
        }

        if (keyNode != null) {
            int x = temp.key;
            deleteDeepest(root, temp);
            keyNode.key = x;
        }
        return root;
    }

    public static void main(String[] args) {
        Node root = newNode(10);
        root.left = newNode(11);
        root.left.left = newNode(7);
        root.left.right = newNode(12);
        root.right = newNode(9);
        root.right.left = newNode(15);
        root.right.right = newNode(8);

        System.out.println("Inorder traversal before deletion:");
        inorder(root);

        int keyToDelete = 11;
        root = deletion(root, keyToDelete);

        System.out.println("\nInorder traversal after deleting node with key " + keyToDelete + ":");
        inorder(root);
    }

}
