public class Trie {
    class Node{
        char val;
        Node[] child;
        boolean isWord;

        public Node(char val){
            this.val=val;
            child=new Node[26];
            isWord=false;
        }
    }
    Node root;
    public Trie(){
        root=new Node('\0');
    }
    public void addWord(String word){
        char[] wordArray=word.toCharArray();
        Node curr=root;
        for(char c:wordArray){
            if(curr.child[c-'a']==null){
                curr.child[c-'a']=new Node(c);
            }
            curr=curr.child[c-'a'];
        }
        curr.isWord=true;
    }
    public Node helper(String word){
        char[] wordArray=word.toCharArray();
        Node curr=root;
        for(char c:wordArray){
            if(curr.child[c-'a']==null){
                return null;
            }
            curr=curr.child[c-'a'];
        }
        return curr;
    }
    public boolean searchWord(String word){
        Node curr=helper(word);
        return curr==null?false:curr.isWord;
    }
    public boolean wordStartsWith(String word){
        Node curr=helper(word);
        return curr==null?false:true;
    }

    public static void main(String[] args) {
        Trie trie=new Trie();
        trie.addWord("apple");
        trie.addWord("ball");
        trie.addWord("cat");
        System.out.println(trie.searchWord("apple"));
        System.out.println(trie.searchWord("app"));
        System.out.println(trie.wordStartsWith("app"));
    }
}
