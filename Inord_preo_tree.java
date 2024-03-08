
import java.util.*;

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

public class Inord_preo_tree {

    // ----Question -- Inorder + Preorder = Binary Tree [*No Duplicate*][NOT BST
    // ONLY BINARY TREE]

    public static int find(int in[], int data, int n) {
        for (int i = 0; i < n; i++) {
            if (in[i] == data) {
                return i;
            }
        }
        return -1;
    }

    static int index = 0;

    public static Node create(int pre[], int in[], int start, int end, ArrayList<Integer> postOrder) {
        if (start > end || index >= pre.length) {
            return null;
        }
        int data = pre[index];
        Node root = new Node(data);
        index++;
        int position = find(in, data, pre.length);

        Node left = create(pre, in, start, position - 1, postOrder);
        Node right = create(pre, in, position + 1, end, postOrder);
        postOrder.add(root.data);
        return root;

    }

    public static void main(String[] args) {
        int inorder[] = { 3, 5, 12, 9, 7, 1, 4, 2 };
        int preorder[] = { 12, 5, 3, 7, 9, 4, 1, 2 };
        ArrayList<Integer> postOrder = new ArrayList<>();
        Node root = null;
        root = create(preorder, inorder, 0, preorder.length, postOrder);
        System.out.println(postOrder);

    }
}
