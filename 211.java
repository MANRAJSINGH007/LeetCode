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

    public Trie() {
        root = new TrieNode('\0');
    }
    
    public void add(TrieNode root, String word){
        
        if(word.length() == 0) {
            root.isTerminating = true;
            return ;
        }
        
        int childIndex = word.charAt(0) - 'a';
        if(root.children[childIndex] == null) root.children[childIndex] = new TrieNode(word.charAt(0));
        
        add(root.children[childIndex], word.substring(1));
    }
    
    public void add(String word) {
        add(root, word);
    }
    
    public boolean search(TrieNode root, String word){
        
        if(word.length() == 0) return root.isTerminating;
        
        if(word.charAt(0) == '.'){
            for(int j = 0; j < 26; j++){
                if(root.children[j] != null){
                    if(search(root.children[j], word.substring(1))) return true;
                }
            }
            
            return false;
        }
        
        int childIndex = word.charAt(0) - 'a';
        return root.children[childIndex] == null ? false : search(root.children[childIndex], word.substring(1));
        
    }
    
    public boolean search(String word) {
        return search(root, word);
    }
    
}

class WordDictionary {
    
    Trie t;

    /** Initialize your data structure here. */
    public WordDictionary() {
        t = new Trie();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        t.add(word);
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return t.search(word);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
