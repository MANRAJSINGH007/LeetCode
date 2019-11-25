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
        root.isTerminating = true;
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
    
    public String search(){
        return search(root);
    }
    
    public String search(TrieNode root){
        
        if(!root.isTerminating) return "";
        
        String curr = "";
        if(root.data != '\0') curr = curr + root.data;
        String ans = "";
        int flag = 0;
        
        for(int j = 0; j < 26; j++){
            TrieNode child = root.children[j];
            if(child == null) continue;
            flag = 1;
            String t = search(child);
            if(t.length() != 0){
                if(t.length() > ans.length()) ans = t;
            }
        }
        
        if(flag == 0) return curr;
        return curr + ans;
    }
    
}

class Solution {
    public String longestWord(String[] words) {
        
        int n = words.length;
        Trie t = new Trie();
        for(int i = 0; i < n; i++) t.add(words[i]);
        return  t.search();
        
    }
}
