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
    
    Trie(){
        root = new TrieNode('\0');
    }
    
    public void add(String word){
        add(root, word);
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
    
    public boolean search(String word){
        return search(root, word, 0);
    }
    
    public boolean search(TrieNode root, String word, int state){
        
        if(word.length() == 0) return state == 1 ? root.isTerminating : false;
        
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        
        if(child != null){
            if(search(child, word.substring(1), state)) return true;
        }
        
        if(state == 1) return false;
        
        for(int j = 0; j < 26; j++){
            child = root.children[j];
            if(j == childIndex || child == null) continue;
            if(search(child, word.substring(1), 1)) return true;
        }

        return false;
    }
    
}

class MagicDictionary {

    Trie t;
    /** Initialize your data structure here. */
    public MagicDictionary() {
        t = new Trie();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        
        int n = dict.length;
        for(int i = 0; i < n; i++) t.add(dict[i]);
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        return t.search(word);
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */
