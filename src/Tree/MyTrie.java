package Tree;

class TrieNode {
    TrieNode [] children = new TrieNode[26];
    boolean isEndOfWord = false;
}

public class MyTrie{
    private final TrieNode root;

    public MyTrie(){
        root = new TrieNode();
    }

    public void insert(String s){
        TrieNode node = root;
        s= s.toLowerCase();

        for(int i=0; i<s.length();i++){
            int index = s.charAt(i) - 'a';
            if(node.children[index]==null){
                node.children[index]= new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    public boolean searchPrefix(String s){
        TrieNode node = root;
        s=s.toLowerCase();
        for(int i=0; i<s.length(); i++){
            int index = s.charAt(i)- 'a';
            if(node.children[index] ==  null)
                return false;
            node = node.children[index];
        }
        return true;
    }

    public boolean search(String s){
        TrieNode node = root;
        s=s.toLowerCase();
        for(int i=0; i<s.length(); i++){
            int index = s.charAt(i) - 'a';
            if(node.children[index]== null)
                return false;
            node = node.children[index];
        }
        return node.isEndOfWord;
    }

    public static void main(String[] args) {
        MyTrie myTrie = new MyTrie();
        myTrie.insert("Yameen");
        System.out.println(myTrie.search("Yameen"));
        System.out.println(myTrie.searchPrefix("Yame"));

    }
}
