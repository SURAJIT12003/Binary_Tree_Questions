

import java.util.*;

class Tree {

    int data;
    Tree left;
    Tree right;

    Tree(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

}
public class Lowest_com_anc {

    // LOWEST COMMON ANSCECTOR MEANS TWO NODES MEET IN FIRST COMMON NODE FROM NODE
    // TO ROOT PATH (NOT COMMON LOWEST VALUE NODE IN PATH) (FIRST COMMON ANCESTOR
    // PATH - NODE TO ROOT)
    /*
     * 1 IN this tree 4 path is - 2,1 and 5 path is - 2,1 so here first meet
     * / \ common node in 2 . this is lowest common ancestor but in path 1 is
     * 2 3 lowest value but first meet point in node from node to root path
     * / \ / \ so 2 is lowest common ansector ***
     * 4 5 6 7
     */

    // Path calculate of two node ****(root to node)
    public static boolean path(Tree root, ArrayList<Integer> arr, Tree n1) {
        if (root == null) {
            return false;
        }

        if (root.data == n1.data) {
            return true;
        }

        arr.add(root.data);

        boolean left = path(root.left, arr, n1);
        boolean right = path(root.right, arr, n1);

        if (!left && !right) {
            arr.remove(arr.size() - 1);
            return false;
        }

        return true;

    }

    // APPROCH -1 -- two nodes path store and find lowest (first common ancestor)
    // time - o(n) , Space - 0(n) ** here use extra space for store path
    public static int lowestCommon(Tree root, Tree n1, Tree n2) {

        ArrayList<Integer> a1 = new ArrayList<>();
        ArrayList<Integer> a2 = new ArrayList<>();
        // Step - 1 store two node path (node to root path)
        path(root, a1, n1);
        path(root, a2, n2);

        System.out.println(a1);
        System.out.println(a2);

        // Step 2- traverse from last side to check first meet point because node store
        // from root to node value ....so loop is reverse **

        int lca = 0;

        for (int i = a1.size() - 1; i >= 0; i--) {
            if (a2.contains(a1.get(i))) {
                lca = a1.get(i);
                break;
            }

        }

        return lca;

    }

    // Approach 2 - if any node is lowest common ansector then this two node presnt
    // in this node's left subtree and right subtree --
    // (there two conditon then - 1)if two node present in left subtree , *if two
    // node present in right subtree(in this two case ancestor is which subtree
    // contains two node ),2) and one left or one right (vice versa in this case
    // current node is ansector)

    public static Tree lowestAnces(Tree root, Tree n1, Tree n2) { // time -0(n),space -0(n) (stack calls )(here not use
                                                                  // any data structure )

        if (root == null) {
            return null;
        }
        if (root.data == n1.data || root.data == n2.data) {
            return root;
        }

        Tree left = lowestAnces(root.left, n1, n2); // check left sub
        Tree right = lowestAnces(root.right, n1, n2);// check right sub

        if (right == null) { // if left is (two node) contains then left part is ancestor
            return left;
        }

        if (left == null) { // if right is (two node)contains then right part is ancestor
            return right;
        }

        return root; // this condion two part contains (one left , one right )
        // then curr node is ansector ....
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

        Tree root = new Tree(1);

        root.left = new Tree(2);
        root.right = new Tree(3);

        root.left.left = new Tree(4);

        root.left.right = new Tree(5);

        root.right.left = new Tree(6);
        root.right.right = new Tree(7);

        Tree n1 = null;
        n1 = root.left.right;

        Tree n2 = null;
        n2 = root.right.left;

        System.out.println("lowest common ancestor -> " + lowestCommon(root, n1, n2));
        System.out.println(lowestAnces(root, n1, n2).data);

    }
}
