class Solution {
    
    public static int func(String[] words, int n, int i, int[] freq, int[] score, ArrayList<HashMap<String, Integer>> dp){
        
        if(i == n) return 0;
        
        // memoize using the configuration of the freq array 
        StringBuilder sb = new StringBuilder();
        for(int j = 0; j < 26; j++){
            if(freq[j] != 0) sb.append(Integer.toString(freq[j]) + (char)(j + 97));
        }
        
        String t = sb.toString();
        
        // memoization 
        if(dp.get(i).containsKey(t)) return dp.get(i).get(t);
        
        // try excluding the current word
        int p1 = func(words, n, i + 1, freq, score, dp);
        
        // if we want to include the current word
        int p2 = 0;
        
        // stores the freq of characters which are there in current word
        // meanwhile the loop will check if it is possible to include the current string
        int[] temp = new int[26];
        int flag = 0;
        for(int j = 0; j < words[i].length(); j++){
            int curr = (int)words[i].charAt(j) - 97;
            temp[curr] ++;
            if(temp[curr] > freq[curr]){
                flag = 1;
                break;
            }
        }
        
        if(flag == 0){
            
            // if we can include the current word
            
            int currScore = 0;
            
            // update freq array
            for(int j = 0; j < 26; j++){
                freq[j] -= temp[j];
                currScore += temp[j] * score[j];
            }
                             
            // call on remaining array
            p2 = currScore + func(words, n, i + 1, freq, score, dp);
            
            // update freq array back to its original state
            for(int j = 0; j < 26; j++) freq[j] += temp[j];
        }
        
        // return max of both the possibilities
        int ans = Math.max(p1, p2);
        
        dp.get(i).put(t, ans);
        
        return ans;
    }
    
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        
        int n = words.length;
        if(n == 0) return 0;
        int m = letters.length;
        if(m == 0) return 0;
        
        int[] freq = new int[26];
        for(int i = 0; i < m; i++) freq[(int)letters[i] - 97] ++;
        
        ArrayList<HashMap<String, Integer>> dp = new ArrayList<>();
        for(int i = 0; i < n; i++) dp.add(new HashMap<>());
        
        return func(words, n, 0, freq, score, dp);
        
        
    }
}
