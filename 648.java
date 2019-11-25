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
    
    public String search(TrieNode root, String word){
        
        if(root.isTerminating) return "";
        
        if(word.length() == 0) return null;
        
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        
        if(child == null) return null;
        
        String ans = search(child, word.substring(1));
        if(ans == null) return ans;
        return word.charAt(0) + ans;
    }
    
    public String search(String word) {
        return search(root, word);
    }
    
}

class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        
        Trie t = new Trie();
        int n = dict.size();
        for(int i = 0; i < n; i++) t.add(dict.get(i));
        
        String[] aux = sentence.split(" ");
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < aux.length; i++){
            String curr = aux[i];
            String ans = t.search(curr);
            if(ans == null) sb.append(curr);
            else sb.append(ans);
            if(i != aux.length - 1) sb.append(" ");
        }
        
        return sb.toString();
    }
}
