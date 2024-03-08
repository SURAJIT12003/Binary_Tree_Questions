

import java.util.*;

public class kth_ancestar {

    public static int kthAnces(Node root,Node n1,int k){
        if(root==null){
            return -1;
        }

        if(root.data==n1.data){
            return 0;
        }
        int left = kthAnces(root.left, n1, k);
        int right = kthAnces(root.right, n1, k);

        if(left==-1 && right ==-1){
            return -1;
        }

        int total =1;
        if(left!=-1){
            total +=left;
        }

        if(right!=-1){
            total += right;
        }

        if(total==k){
            System.out.println(root.data);
        }

        return total;
    }
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
 
      
        kthAnces(root, n1,1);
    }
}
