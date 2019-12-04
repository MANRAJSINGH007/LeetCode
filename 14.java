class TrieNode{
    char data;
    TrieNode[] children;
    int count;
    
    TrieNode(char data){
        this.data = data;
        this.count = 0;
        this.children = new TrieNode[26];
    }
}

class Trie{
    
    TrieNode root;
    static int min;
    static int max = 0;
    static int n = 0;
    
    Trie(int m, int number){
        root = new TrieNode('\0');
        min = m;
        n = number;
    }
    
    public void add(String word){
        add(root, word, 0);
    }
    
    public void add(TrieNode root, String word, int i){
        
        if(i == min) return ;
        root.count++;
        if(root.count == n) max = Math.max(i, max);
        int childIndex = word.charAt(i) - 'a';
        if(root.children[childIndex] == null) root.children[childIndex] = new TrieNode(word.charAt(i));
        add(root.children[childIndex], word, i + 1);
        return ;
    }
    
}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        int n = strs.length;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) min = Math.min(min, strs[i].length());
        
        Trie t = new Trie(min, n);
        
        for(int i = 0; i < n; i++) t.add(strs[i]);
        
        return strs[0].substring(0, Trie.max);
        
    }
}
