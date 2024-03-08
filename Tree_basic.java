

import java.util.*;

class pair{
    boolean yt;
    int d;
    pair(boolean yt,int d){
        this.yt=yt;
        this.d=d;
    }
}

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

public class Tree_basic {

   static int index = 0;

   //this array format of Preorder 
    public static Node create(int pre[]) { //time - o(n)

        if (index >= pre.length || pre[index] == -1) {

            return null;
        }

        Node root = new Node(pre[index]);
      
        index = index + 1;
        root.left = create(pre);
        index = index + 1;
        root.right = create(pre);
        return root;

        
    }

    public static void prePrint(Node root) {//time - o(n)
        if (root == null) {

            return;
        }
        System.out.println(root.data);
        prePrint(root.left);
        prePrint(root.right);
    }

    public static void inPrint(Node root) {//time - o(n)
        if (root == null) {
            return;
        }
        inPrint(root.left);
        System.out.println(root.data);

        inPrint(root.right);
    }

    public static void postPrint(Node root){//time - o(n)
        if (root == null) {
            return;
        }
        postPrint(root.left);
        postPrint(root.right);
        System.out.println(root.data);
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
            }
            else{
                ans.add(curr.data);
                if(curr.left!=null){
                    q.add(curr.left);
                    
                    
                }
                if(curr.right!=null){
                    q.add(curr.right);
                    
                }
            }
        }

        System.out.println(ans);

    }

    static int ans =0;
    public static int height(Node root,int count){ //Time - 0(n)

        //**Here we calculate height using node if calculate using edge then -1 from ans  */

        //Approach -1 (Count untill null then chosse maximum )****
        
        /*

         if(root==null){
            ans = Math.max(ans, count);
            return 0;
        }
        count++;
        height(root.left, count);
        height(root.right, count);
        return count ;
        
         */


         //Approach -2 (Using Level order Traversal)****

         /* 
         if(root==null){
            return 0  ;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
       
        while(!q.isEmpty()){
            Node curr = q.remove();
            if(curr==null){
                if(q.isEmpty()){
                    count++;
                    break;
                }
                q.add(null);
                count++;
            }
            else{
                
                if(curr.left!=null){
                        q.add(curr.left);
                }
                if(curr.right!=null){
                        q.add(curr.right);
                } 
            }
            
        }
        
        return count ;

        */

        //Approach 3 - (calculate left subtrre height and right sub then max and add current tree height)

        if(root==null){
            return 0;
        }
        int lh = height(root.left, count);
        int rh = height(root.right, count);
        int max = Math.max(lh, rh)+1;
        return max;
        
    }

    public static int countNode(Node root){  //Time - 0(n)
        if(root==null){
            return 0;
        }
        int left = countNode(root.left);
        int right = countNode(root.right);
        int total = left+right+1;
        return total ;
    }

    public static int sumNode(Node root){  //Time - 0(n)
        if(root==null){
            return 0;
        }
        int left = sumNode(root.left);
        int right = sumNode(root.right);
        int total = left+right+root.data;
        return total ;
    }
    
    //Change to Mirror Tree **
    public static Node flip(Node root){
        if(root==null){
            return null;
        }
        Node n = new Node(root.data);
        n.left = flip(root.right);
        n.right = flip(root.left);
        return n;  
    }

   
    public static void main(String[] args) {
        int pre[] = { 1,2,-1,-1,3,-1,-1,-1 }; //this is preorder of tree 
       Node root = null;
       
        root = create(pre);
        prePrint(root);
        // //inPrint(root);
        // //postPrint(root);
        //levelPrint(root);
        // //System.out.println(height(root, 0));
        // System.out.println(sumNode(root));



        // Node root = new Node(1);

        // root.left = new Node(2);
        // root.right = new Node(3);

        // root.left.left = new Node(4);

        // root.left.right = new Node(5);

        // //root.right.left = new Node(6);
        // root.right.right = new Node(6);
        // // prePrint(root);
        // // Node nr = flip(root);
        
        // // prePrint(nr);
        // String s="hgkp";
        // System.out.println(s.substring(1, 4));
        
        
    }
}
