import java.util.*;

public class inord_posto_tree {
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

    public static Node create(int pre[], int in[], int start, int end) {
        if (start > end || index >= pre.length) {
            return null;
        }
        int data = pre[index];
        Node root = new Node(data);
        index++;
        int position = find(in, data, pre.length);

        Node left = create(pre, in, start, position - 1);
        Node right = create(pre, in, position + 1, end);
        
        return root;

    }

    public static void main(String[] args) {
        int inorder[] = { 3, 5, 12, 9, 7, 1, 4, 2 };
        int postorder[] = { 12, 5, 3, 7, 9, 4, 1, 2 };
        
        Node root = null;
        index = inorder.length-1;
        root = create(postorder, inorder, 0, postorder.length);
        

    }
}
