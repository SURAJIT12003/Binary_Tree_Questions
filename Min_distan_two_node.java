

public class Min_distan_two_node {

    // calclate minimum distance of two node
    // this rule is -
    // 1) at fisrt calculate lowest common ancestor of two node

    // 2) then calculate distance of LCA node to node n1 , Lca to node n2

    // 3) then add two distance of (LCA TO N1 DISTANCE AND LCA TO N2 DIS)

    // APPROACH 1 = Here use recursion for calculate LCA and LCA to (n1,n2)distance

    // CALCULATE LCA OF N1 AND N2
    public static Node lowestAnces(Node root, Node n1, Node n2) {

        if (root == null) {
            return null;
        }
        if (root.data == n1.data || root.data == n2.data) {
            return root;
        }

        Node left = lowestAnces(root.left, n1, n2);
        Node right = lowestAnces(root.right, n1, n2);

        if (right == null) {
            return left;
        }

        if (left == null) {
            return right;
        }

        return root;
    }

    // CALCULATE DISTANCE LCA TO N1 (AND N2)
    public static int distance(Node root, Node node) {

        if (root == null) {
            return -1; // here -1 return because always every call add +1
        }
        if (root.data == node.data) {
            return 0;
        }
        int left = distance(root.left, node);
        int right = distance(root.right, node);

        // if two side are -1 then -1
        if (left == -1 && right == -1) {
            return -1;
        }

        int total = 1;
        // if one side >-1 then +1 of this value and return
        if (left != -1) {
            total += left;
        }
        if (right != -1) {
            total += right;
        }
        return total;
    }

    public static int minDis(Node root, Node n1, Node n2) {
        // Calculate lca
        Node lca = lowestAnces(root, n1, n2);

        // lca to n1 distance
        int dis1 = distance(lca, n1);

        // lca to n2 distance *
        int dis2 = distance(lca, n2);

        // add to distance
        int Dis = dis1 + dis2;
        return Dis;
    }

    // APPROCAH -2 - Also work for full path add in array list of root to n1 ,n2 and
    // then find LCA
    // Then calculate distance LCA to n1 ,n2 using index
    /*

     * Here add path root to n1 and n2 in array list then ***
        int lca=0;
        int in =0;
        for(int i=a1.size()-1;i>=0;i--){
            if(a2.contains(a1.get(i))){
                lca = a1.get(i);
                in++;
                break;
            }
            in++;
        }
        
        int t = a2.indexOf(lca);
        t = a2.size()-t;
        int dis = in+t;
        
     */


    
    public static void main(String[] args) {
        /*
            1
          /   \
          2    3
         / \  / \
         4  5 6  7
          
         */

        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);

        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Node n1 = null;
        n1 = root.left.right;

        Node n2 = null;
        n2 = root.right.left;

        System.out.println(minDis(root, n1, n2));
      

    }
}
