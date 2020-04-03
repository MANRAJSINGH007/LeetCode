class TrieNode{

	char data;
	TrieNode children[];
        boolean isTerminating;
    int count;

	public TrieNode(char data) {
		this.data = data;
		children = new TrieNode[26];
        this.isTerminating = false;
        this.count = 0;
	}
}

public class Trie {

	public TrieNode root;
	public Trie() {
		root = new TrieNode('\0');
	}	

	public void add(TrieNode root, String word){
		
        if(word.length() == 0){
            root.isTerminating = true;
            root.count++;
            return ;
        }
        
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if(child == null){
			child = new TrieNode(word.charAt(0));
			root.children[childIndex] = child;
		}
        
		add(child, word.substring(1));

	}
    
    static int c = 0;
    
    public void getList(TrieNode root, String ans, List<String> l){ 
        
        if(root.isTerminating){
           for(int j = 0; j < root.count; j++){
                l.add(ans);
                c++;
                if(c == 3) return ;
           }
        }
        
        for(int j = 0; j < 26; j++){
            TrieNode child = root.children[j];
            if(child == null) continue;
            getList(child, ans + (char)(97 + j), l);
            if(c == 3) return ;
        }
        
        return ;
    }
    
  	public List<String> search_helper(TrieNode root, String word, int i, int n){
        
        if(i == n){
            c = 0;
            List<String> l = new ArrayList<>();
            getList(root, word, l);
            return l;
        }
        
        int child_index = word.charAt(i) - 'a';
        TrieNode child = root.children[child_index];
        if(child == null) return new ArrayList<>();
        
        return search_helper(root.children[child_index], word, i + 1, n);
      
    }
	
}


class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        
        int n = products.length;
        int m = searchWord.length();
        Trie t = new Trie();
        
        List<List<String>> ans = new ArrayList<>();
        
        for(int i = 0; i < n; i++) t.add(root, products[i]);
        
        String prefix = "";
        
        for(int i = 0; i < m; i++){
            prefix += searchWord.charAt(i);
            ans.add(t.search(root, prefix, 0, prefix.length()));
        }
        
        return ans;
        
    }
}
