/*
A Binary Search Tree (BST) is a data structure that facilitates fast lookups, insertions, and deletions. The BST property ensures that for any given node:

All values in its left subtree are less than the node's value.
All values in its right subtree are greater than the node's value.
This property allows efficient searching, as each comparison allows the operations to skip about half of the remaining tree, leading to average-case time complexities of O(log n) for search, insertion, and deletion operations.
 */
public class BinarySearchTree {
    private class Node{
        private int val;
        private int size;
        private Node left;
        private Node right;
        public Node(int val){
            this.val=val;
            this.left=this.right=null;
            this.size=1;
        }
    }
    private Node root;
    public BinarySearchTree(){
        root=null;
    }
    public boolean isEmpty(){
        return root==null;
    }
    public int getSize(Node node){
        if(node==null){
            return 0;
        }
        return node.size;
    }
    public Node insert(Node node,int val){
        if(node==null){
            node=new Node(val);
        }else{
            Node curr=node;
            if(curr.val>=val){
                curr.left=insert(curr.left,val);
            }else{
                curr.right=insert(curr.right,val);
            }
        }
        node.size=1+getSize(node.left)+getSize(node.right);
        return node;
    }
    public void insert(int val){
        if(isEmpty()){
            root=new Node(val);
        }else{
            root=insert(root,val);
        }
    }
    public Node min(Node node){
        if(node.left!=null){
            node=min(node.left);
        }
        return node;
    }
    public int min(){
        return min(root).val;
    }
    public Node max(Node node){
        if(node.right!=null){
            node=max(node.right);
        }
        return node;
    }
    public int max(){
        return max(root).val;
    }
    public Node delete(Node node,int val){
        if(node==null){
            return null;
        }
        if(node.val>val){
            node.left=delete(node.left,val);
        }else if(node.val<val){
            node.right=delete(node.right,val);
        }else{
            if(node.left==null){
                return node.right;
            }
            if(node.right==null){
                return node.left;
            }
            Node successor=min(node.right);
            node.val=successor.val;
            node.right=delete(node.right,successor.val);
        }
        node.size=1+getSize(node.left)+getSize(node.right);
        return node;
    }
    public void delete(int val){
        root=delete(root,val);
    }
    public boolean search(int val){
        Node curr=root;
        while(curr!=null){
            if(curr.val>val){
                curr=curr.left;
            }else if(curr.val<val) {
                curr=curr.right;
            }else{
                return true;
            }
        }
        return false;
    }
    private void inOrder(Node node){
        if(node==null){
            return;
        }
        inOrder(node.left);
        System.out.print(node.val+" ");
        inOrder(node.right);
    }
    public void inOrder(){
        inOrder(root);
        System.out.println();
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
    private void postOrder(Node node){
        if(node==null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val+" ");
    }
    public void postOrder(){
        postOrder(root);
        System.out.println();
    }
    public static  void main(String[] args){
        BinarySearchTree bst=new BinarySearchTree();
        bst.insert(1);
        bst.insert(2);
        bst.insert(3);
        bst.inOrder();
        bst.postOrder();
        bst.preOrder();
        System.out.println(bst.search(1));
        System.out.println(bst.search(5));
        System.out.println(bst.min());
        System.out.println(bst.max());
        bst.delete(2);
        bst.inOrder();
        System.out.println(bst.getSize(bst.root));
    }
}