

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;



public class Bottom_View {

    static class info {
        Node node;
        int hd;

       public  info(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static void botView(Node root) {
        if (root == null) {
            return;
        }
        // for horizontal distance and node contains *
        HashMap<Integer, Node> hs = new HashMap<>(); // map store key and node 

        // Step -1 - Level order traversal
        Queue<info> q = new LinkedList<>();

        //contains min and maxium horizontal distance 
        int min = 0;
        int max = 0;
        
        //At first q add root and horizantal value 0
        q.add(new info(root, 0));
        q.add(null);

        while(!q.isEmpty()){

            info curr  = q.remove();

            if(curr==null){
                if(q.isEmpty()){
                    break;
                }
                else{
                     q.add(null);
                }
               
            }
            else{

                //Step - 2 - add in map (if already key preset then update value)
                
                hs.put(curr.hd,curr.node);

                //Step -3 if left is not null then (horizantal value - 1 )
                if(curr.node.left!=null){
                    q.add(new info(curr.node.left,curr.hd-1));
                    min = Math.min(min, curr.hd-1); // minimum value calculate 
                }

                //Step -4 if right  is not null then (horizantal value + 1 )
                if(curr.node.right!=null){
                    q.add(new info(curr.node.right, curr.hd+1));
                    max = Math.max(max, curr.hd+1); //maximum value calculate 
                }

               
            }
        }

        //Print min to max using in map key **
        for(int i=min;i<=max;i++){
            System.out.println(hs.get(i).data);
        }

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

        botView(root);
    }
}
