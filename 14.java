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
        max = 0;
        n = number;
    }
    
    public void add(String word){
        add(root, word);
    }
    
    public void add(TrieNode root, String word){
        
        root.count++;
        if(word.length() == 0) return;
        int childIndex = word.charAt(0) - 'a';
        root.children[childIndex] = new TrieNode(word.charAt(0));
        add(root.children[childIndex], word.substring(1));
    }
    
    public void search(TrieNode root, String word, int i){
        
        root.count++;
        if(root.count == n) max = i;
        if(i == min) return;
        int childIndex = word.charAt(i) - 'a';
        if(root.children[childIndex] == null) return ;
        search(root.children[childIndex], word, i + 1);
        
    }
    
    public void search(String word){
        search(root, word, 0);
    }
    
}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        int n = strs.length;
        if(n == 0) return "";
        if(n == 1) return strs[0];
        int min = Integer.MAX_VALUE;
        String minString = "";
        int index = -1;
        
        for(int i = 0; i < n; i++){
            if(strs[i].length() < min){
                minString = strs[i];
                min = strs[i].length();
                index = i;
            }
        }
        
        Trie t = new Trie(min, n);
        t.add(minString);
        
        for(int i = 0; i < n; i++){
            if(index != i){
                t.search(strs[i]);
            }
        }
        
        return strs[0].substring(0, Trie.max);
        
    }
}
