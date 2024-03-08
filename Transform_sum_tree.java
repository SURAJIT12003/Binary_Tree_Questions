

import java.util.*;

public class Transform_sum_tree {

    public static int  sumTree(Node root){
        if(root==null){
            return 0;
        }

        int left = sumTree(root.left);
        int right = sumTree(root.right);
        int total = left+right;
        int t = root.data;
        root.data = total;
        total +=t;
        return total;

    }

    public static void levelPrint(Node root){
        if(root==null){
            return;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Node> q  = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node curr = q.remove();
            if(curr==null){
                if(q.isEmpty()){
                    break;
                }
                ans.add(-1);
                q.add(null);
                System.out.println();
            }
            else{
                System.out.print(curr.data+" ");
                if(curr.left!=null){
                    q.add(curr.left);
                    
                    
                }
                if(curr.right!=null){
                    q.add(curr.right);
                    
                }
            }
        }

       // System.out.println(ans);

    }
    public static void main(String[] args) {
          /*
             1
           /   \
          2     3
         / \   / \
        4   5  6  7
         
         */

         Node root = new Node(1);

         root. left = new Node(2);
         root.right = new Node(3);
 
         root. left. left = new Node(4);
         root. left.right = new Node(5);
         root.right.left = new Node(6);
         root.right.right = new Node(7);

         levelPrint(root);
         sumTree(root);
         System.out.println();
         levelPrint(root); 
    }
}
