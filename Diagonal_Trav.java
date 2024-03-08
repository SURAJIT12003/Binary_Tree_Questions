

import java.util.*;

public class Diagonal_Trav {

    //Diagonal Traverse ****
    public static ArrayList<Integer> diagonal(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();

        Queue<Node> q = new LinkedList<>();
      
        q.add(root);
        q.add(null);
        
       
        while(!q.isEmpty()){
            Node curr = q.remove();
            if(curr==null){
                if(q.isEmpty()){
                    
                    break;
                }
                else{
                    
                    q.add(null);
                }
            }
            else{
                //right traverse while curr node is null
                while(curr!=null){
                    //if currnode have left node that add in queue 
                    if(curr.left!=null){
                        q.add(curr.left);
                    }
                    //curr node add in ans 
                    ans.add(curr.data);
                    //curr node = curr.right 
                    curr=curr.right;
                }
            }
        }
        return ans ;
    }

    //Diagonal Sum *****Same approach 
    public static ArrayList<Integer> diagonalSum(Node root,ArrayList<Integer> ans){
        
        Queue <Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        
        int sum =0;
        while(!q.isEmpty()){
            Node curr = q.remove();
            if(curr==null){
                if(q.isEmpty()){
                    ans.add(sum);
                    break;
                }
                else{
                    ans.add(sum);
                    sum=0;
                    q.add(null);
                }
            }
            else{
                while(curr!=null){
                    if(curr.left!=null){
                        q.add(curr.left);
                    }
                    sum=sum+curr.data;
                    curr=curr.right;
                }
            }
        }
        return ans ;
    }
    
    public static void main(String[] args) {
             /*
           20
          /   \
         8     22
        /  \    \
        5   3    25
           / \
           10 14

         */
         
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left  = new Node(5);
        root.left.right = new Node(3);
        root.left.right.left  = new Node(10);
        root.left.right.right = new Node(14);
        root.right.right = new Node(25);

       ArrayList<Integer> as = diagonal(root);
       System.out.println(as);

    }
}