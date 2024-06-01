package Tree;

public class Trie {

    static class Node{
        Node [] children = new Node[26];
        boolean eow = false;
        Node(){
            for(int i=0; i<26; i++){
                children[i] = null;
            }
        }
    }
    public static Node root = new Node();

    public static void insert(String word){
        Node curr = root;
        for(int level=0; level<word.length(); level++){
            int index = word.charAt(level)-'a';
            if(curr.children[index] ==  null){
                curr.children[index] =  new Node();
            }
            curr = curr.children[index];
        }
        curr.eow = true;
    }

    public static boolean search(String key){
        Node curr = root;
        for(int level=0; level<key.length(); level++){
            int index = key.charAt(level)-'a';
            if(curr.children[index] == null) return false;
            curr = curr.children[index];
        }
        return curr.eow == true;
    }

    public static void main(String[] args) {
        String [] words = {"the", "an", "there", "their", "any", "thee"};
        for(String s:words){
            insert(s);
        }
        System.out.println(search(" "));
    }
}
