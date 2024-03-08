

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

public class Kth_level {

    //Approach -1 kth level print using Recursion -*(Pre order traversal)
    public static void kthLevel(Node root,int i,int k){
        if(root==null){
            return;
        }

        if(i==k){
            System.out.println(root.data);
            return;
        }
       
        kthLevel(root.left, i+1, k); // i+1 for left sub tree
        kthLevel(root.right, i+1, k);//i+1 for right sub tree
    }

    //Approach 2 - Level order traversal 
    public static void kthlevel(Node root,int k ){
        if(root==null){
            return;
        }
       
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        int i=1;
        
        while(!q.isEmpty()){
            Node curr = q.remove();
            if(curr==null){
                if(q.isEmpty()){
                    break;
                }
                q.add(null);
                if(i==k){
                    break;
                }
                i++;

                
            }
            else{
                if(i==k){
                   System.out.println(curr.data);
                }
                if(curr.left!=null){
                        q.add(curr.left);
                }
                if(curr.right!=null){
                        q.add(curr.right);
                } 
            }
            
        }
      
        
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

         kthLevel(root, 1, 1);
         kthlevel(root, 2);
    }
}
