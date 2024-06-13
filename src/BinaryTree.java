import java.util.*;
import java.util.LinkedList;
/*
A binary tree is a hierarchical data structure in which each node has at most two children, referred to as the left child and the right child.
 */
public class BinaryTree {
    private class Node{
        private int val;
        private Node left;
        private Node right;
        public Node(int val){
            this.val=val;
            this.left=this.right=null;
        }
    }
    private Node root;
    public BinaryTree(){
        this.root=null;
    }
    public Node insert(Node node,int val){
        if(node==null){
            node=new Node(val);
            return node;
        }
        Queue<Node>q=new LinkedList<>();
        q.offer(node);
        while(!q.isEmpty()){
            Node curr=q.poll();
            if(curr.left==null){
                curr.left=new Node(val);
                break;
            }else{
                q.offer(curr.left);
            }
            if(curr.right==null){
                curr.right=new Node(val);
                break;
            }else{
                q.offer(curr.right);
            }
        }
        return node;
    }
    public void insert(int val){
        root=insert(root,val);
    }
    public Node delete(Node node,int val){
        if(node==null){
            return null;
        }
        if(node.left==null&&node.right==null){
            if(node.val==val){
                return null;
            }else{
                return root;
            }
        }
        Queue<Node>q=new LinkedList<>();
        q.offer(node);
        Node curr=null,del_node=null;
        while(!q.isEmpty()){
           curr=q.poll();
            if(curr.val==val){
                del_node=curr;
            }
            if(curr.left!=null){
                q.offer(curr.left);
            }
            if(curr.right!=null){
                q.offer(curr.right);
            }
        }
        if(del_node!=null){
            int x=curr.val;
            deleteDeepest(node,curr);
            del_node.val=x;
        }
        return node;
    }
    public void deleteDeepest(Node root, Node delNode) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        Node curr;
        while (!q.isEmpty()) {
            curr = q.poll();

            if (curr == delNode) {
                curr = null;
                return;
            }

            if (curr.right != null) {
                if (curr.right == delNode) {
                    curr.right = null;
                    return;
                } else {
                    q.offer(curr.right);
                }
            }

            if (curr.left != null) {
                if (curr.left == delNode) {
                    curr.left = null;
                    return;
                } else {
                    q.offer(curr.left);
                }
            }
        }
    }
    public void delete(int val){
        root=delete(root,val);
    }
    public boolean search(int val){
        Queue<Node>q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            Node curr=q.poll();
            if(curr.val==val){
                return true;
            }
            if(curr.left!=null){
                q.offer(curr.left);
            }
            if(curr.right!=null){
                q.offer(curr.right);
            }
        }
        return false;
    }
    private void preOrder(Node node){
        if(node==null){
            return;
        }
        System.out.print(node.val+" ");
        preOrder(node.left);
        preOrder(node.right);
    }
    public void preOrder(){
        preOrder(root);
        System.out.println();
    }
    public static void main(String[] args){
        BinaryTree bt=new BinaryTree();
        bt.insert(1);
        bt.insert(2);
        bt.insert(3);
        bt.insert(4);
        bt.insert(5);
        bt.preOrder();
        System.out.println(bt.search(5));
        System.out.println(bt.search(6));
        bt.delete(3);
        bt.preOrder();
    }
}