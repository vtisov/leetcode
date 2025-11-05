// https://leetcode.com/problems/implement-trie-prefix-tree

class TrieNode {

    private boolean end;
    private TrieNode[] nodes = new TrieNode[26];

    public boolean has(char c) {
        return nodes[c - 'a'] != null;
    }

    public TrieNode get(char c) {
        return nodes[c - 'a'];
    }

    public TrieNode insert(char c) {
        nodes[c - 'a'] = new TrieNode();
        return nodes[c - 'a'];
    }

    public void setEnd() {
        this.end = true;
    }

    public boolean isEnd() {
        return this.end;
    }

}

public class Trie {

    private final TrieNode root = new TrieNode();

    public Trie() {
        
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for (char c: word.toCharArray()) {
            if (curr.has(c)) {
                curr = curr.get(c);
            } else {
                curr = curr.insert(c);
            }
        }
        curr.setEnd();
    }
    
    public boolean search(String word) {
       TrieNode node = searchPrefix(word);
       return node != null && node.isEnd();
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }

    private TrieNode searchPrefix(String prefix) {
        TrieNode curr = root;
        for (char c: prefix.toCharArray()) {
           if (curr.has(c)) {
               curr = curr.get(c);
           } else {
               return null;
           }
        }
        return curr;
    }
}



/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
