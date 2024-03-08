

import java.util.*;

public class Mirror_tree {
     //Time - 0(n) all approach 

    // this question has many form check two tree are mirror of one , one node
    // mirror
    // all same approach **

    //  Approach 1 - Create a new Node --Given a Tree and change to Mirror tree (Also caled invert tree,synmatric
    // tree) 
    public static Node flip(Node root) {
        if (root == null) {
            return null;
        }
        Node n = new Node(root.data); //create new node 
        n.left = flip(root.right); // new node left part is root node's right
        n.right = flip(root.left);// new node right part is root node's left
        return n;
    }


    //Approach 2 - without create new node change this oroginal root (same approach)
      public static Node mirror(Node root){
        if(root==null){
            return null;
        }

        Node leftNode = mirror(root.left);
        Node rightNode = mirror(root.right);

        //Here point root.left = right node; 
        root.left  = rightNode ; // right node

        //Here point root.right  = left node;
        root.right = leftNode;  //left node 

        return root;
    }


    // Level order tarverse
    public static void levelPrint(Node root) {
        if (root == null) {
            return;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node curr = q.remove();
            if (curr == null) {
                if (q.isEmpty()) {
                    break;
                }
                ans.add(-1);
                q.add(null);
            } else {
                ans.add(curr.data);
                if (curr.left != null) {
                    q.add(curr.left);

                }
                if (curr.right != null) {
                    q.add(curr.right);

                }
            }
        }

        System.out.println(ans);

    }

    public static void main(String[] args) {

        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);

        root.left.right = new Node(5);

        root.right.right = new Node(6);

        levelPrint(root);
        Node nr = flip(root);
        levelPrint(nr);
    }
}
