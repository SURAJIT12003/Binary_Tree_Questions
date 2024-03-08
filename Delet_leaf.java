

import java.util.*;

//Delete leaf nodes with values as x

//We have abinary tree and a targe tinteger x,delete all the leaf nodes having value as x.Also,delete the newly formed leaves with the target value as x

public class Delet_leaf {
    
    public static Node dealLeaf(Node root,int x){
        if(root==null){
            return null;
        }
        root.left = dealLeaf(root.left, x);
        root.right = dealLeaf(root.right, x);

        if(root.data==x && root.left==null && root.right==null){
            return null;
        }
        return root;
    }

    public static void levelPrint(Node root){
        if(root==null){
            return;
        }
        
        Queue<Node> q  = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node curr = q.remove();
            if(curr==null){
                if(q.isEmpty()){
                    break;
                }
                System.out.println();
                q.add(null);
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

     

    }
    public static void main(String[] args) {
        Node root = new Node(1);

        root. left = new Node(2);
        root.right = new Node(6);

        root. left. left = new Node(6);
        root. left.right = new Node(5);
        root.right.left = new Node(6);

        levelPrint(root);
        Node rt = dealLeaf(root, 6);
        System.out.println();
        levelPrint(rt);
       

      
    }
}
