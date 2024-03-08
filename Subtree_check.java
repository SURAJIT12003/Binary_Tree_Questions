

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
public class Subtree_check {

    //if check two tree are equal then same code ****

    public static boolean eqaul(Node root,Node subroot){
        if(root ==null && subroot==null){
            return true;
        }

        if(root!=null && subroot==null){
            return false;
        }

        if(root==null && subroot!=null){
            return false;
        }
        
        if(root.data!=subroot.data){
            return false;
        }

        boolean left = eqaul(root.left, subroot.left);
        
        boolean right = eqaul(root.right, subroot.right);
        
        if(right && left){
            return true;
        }

        return false;


    }

    public static boolean check (Node root,Node subroot){
        if(root==null){
            return false;
        }
        if(root.data==subroot.data){
            boolean yt = eqaul(root,subroot);
            if(yt){
                return true ;
            }
        }
        boolean left = check(root.left, subroot);
        
        boolean right = check(root.right, subroot);
        
        if(left || right){
            return true;
        }
        

        return false;
        


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

         /*
              2     
             / \   
            4   5  

          */

          Node subroot = new Node(2);
          subroot.left = new Node(4);
          subroot.right = new Node(5);

          System.out.println(check(root, subroot));
 
    }
}
