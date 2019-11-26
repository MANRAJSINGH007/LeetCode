class TrieNode {
    TrieNode left;
    TrieNode right;
}


class Solution {
    
    TrieNode root = new TrieNode();
    
    public void insert(int val){
        
        TrieNode curr = root;
        
        for(int j = 31; j >= 0; j--){
            int bit = val>>j & 1;
            if(bit == 0){
                if(curr.left == null) curr.left = new TrieNode();
                curr = curr.left;
            } else{
                if(curr.right == null) curr.right = new TrieNode();
                curr = curr.right;
            }
        }
        
        return ;
        
    }
    
    public int returnMaxXor(int[] nums, int n){
        
        int max = 0;
        for(int i = 0; i <n; i++){
            insert(nums[i]);
            TrieNode curr = root;
            int aux = 0;
            for(int j = 31; j >= 0; j--){
                int bit = nums[i]>>j & 1;
                if(bit == 1){
                    if(curr.left != null){
                        curr = curr.left;
                        aux += (int)Math.pow(2, j);
                    } else {
                        curr = curr.right;
                    }
                } else {
                    if(curr.right != null){
                        curr = curr.right;
                        aux += (int)Math.pow(2, j);
                    } else {
                        curr = curr.left;
                    }
                }
            }
            
            max = Math.max(max, aux);
        }
        
        return max;
        
    }
    
    public int findMaximumXOR(int[] nums) {
        
        int n = nums.length;
        
        return returnMaxXor(nums, n);
    }
}
