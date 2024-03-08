
import java.util.*;

public class sum_node_dis_K {


     public static void parent(Node root,HashMap<Node,Node> hs ){
        Queue<Node> q = new LinkedList<>();
        hs.put(root,null);
        q.add(root);
        while(!q.isEmpty()){
            Node curr = q.remove();
            if(curr.left!=null){
                hs.put(curr.left,curr);
                q.add(curr.left);
            }
            if(curr.right!=null){
                hs.put(curr.right,curr);
                q.add(curr.right);
            }
        }

    }
    public static int  getElement(Node target,int k,HashMap<Node,Node> parent){
        int count =0;
        Queue<Node> q = new LinkedList<>();
        HashSet<Integer> hs = new HashSet<>();
        int ans =0;
        q.add(target);
        q.add(null);

        while(!q.isEmpty()){
              if(count==k){
                    break;
                }
            Node curr = q.remove();
              
            if(curr==null){
                if(q.isEmpty()){
                    break;
                }
                else{
                    count++;
                    q.add(null);
                }
            }
            else{
               ans+=curr.data;
                hs.add(curr.data);
                if(curr.left!=null && hs.contains(curr.left.data)==false){
                    q.add(curr.left);
                }
                if(curr.right!=null && hs.contains(curr.right.data)==false){
                    q.add(curr.right);
                }
                if(parent.get(curr)!=null && hs.contains(parent.get(curr).data)==false){
                    q.add(parent.get(curr));
                }
                Queue<Node> dup = new LinkedList<>();
                
            }
        }

        while(!q.isEmpty()){
            Node curr = q.remove();
            if(curr!=null){
               
                ans+=curr.data;
            }
        }

        return ans;
    }
    
    static Node t = null;
    public static void find(Node root,int g ){
        if(root==null){
            return ;
        }
        if(g==root.data){
            t = root;
            return ;
        }
        find(root.left,g);
        find(root.right,g);
    }
    public static int sum(Node root, int target, int k){
          HashMap<Node,Node> hs = new HashMap<>();
         parent(root,hs);
         find(root,target);
         int fff = getElement(t,k,hs);
         t =null;
         return fff;
    }
    public static void main(String[] args) {
        Node root = null;
        sum(root,0,1);
    }
}
