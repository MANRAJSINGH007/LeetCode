class TrieNode {
    char data;
    boolean isTerminating;
    TrieNode[] children;
    TrieNode(char data){
        this.data = data;
        this.children = new TrieNode[26];
        this.isTerminating = false;
    }
}

class Trie {
    
    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode('\0');
    }
    
    /** Inserts a word into the trie. */
    
    public void add(TrieNode root, String word){
        
        if(word.length() == 0) {
            root.isTerminating = true;
            return ;
        }
        
        int childIndex = word.charAt(0) - 'a';
        if(root.children[childIndex] == null) root.children[childIndex] = new TrieNode(word.charAt(0));
        
        add(root.children[childIndex], word.substring(1));
    }
    
    public void insert(String word) {
        add(root, word);
    }
    
    /** Returns if the word is in the trie. */
    
    public boolean search(TrieNode root, String word){
        
        if(word.length() == 0) return root.isTerminating;
        
        int childIndex = word.charAt(0) - 'a';
        
        return root.children[childIndex] == null ? false : search(root.children[childIndex], word.substring(1));
        
    }
    
    public boolean search(String word) {
        return search(root, word);
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    
    public boolean startsWith(TrieNode root, String word){
        
        if(word.length() == 0) return true;
        
        int childIndex = word.charAt(0) - 'a';
        
        return root.children[childIndex] == null ? false : startsWith(root.children[childIndex], word.substring(1));
        
    }
    
    public boolean startsWith(String prefix) {
        return startsWith(root, prefix);
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
