class Solution {
    static int ans = 0;
    static char[] m1; 
    static int[] m2;
    static HashSet<String> dp;
    public static boolean check(String result, int i, int n, int currSum){
        if(i == n) return currSum == ans;
        if(m2[result.charAt(i) - 'A'] != -1) return check(result, i + 1, n, currSum * 10 + m2[result.charAt(i) - 'A']);
        for(int j = 0; j <= 9; j++){
            if(m1[j] == '.'){
                m1[j] = result.charAt(i);
                m2[result.charAt(i) - 'A'] = j;
                if(check(result, i + 1, n, currSum * 10 + j)) return true;
                m1[j] = '.';
                m2[result.charAt(i) - 'A'] = -1;
            }
        }
        return false;
    }
    
    public static boolean func(String words[], int i, int j, int n, String result, int currSum, int c){
        if(i == n){
            ans = currSum + c;
            return check(result, 0, result.length(), 0);
        } 
        if(j == 0){
            currSum += c;
            c = 0;
        }
        if(m2[words[i].charAt(j) - 'A'] != -1){
            int next1 = j + 1;
            int next2 = i;
            if(j + 1 == words[i].length()){
                next1 = 0;
                next2 = i + 1;
            }
            return func(words, next2, next1, n, result, currSum, c * 10 + m2[words[i].charAt(j) - 'A']);
        }
        for(int d = 0; d <= 9; d++){
            if(m1[d] == '.'){
                m1[d] = words[i].charAt(j);
                m2[words[i].charAt(j) - 'A'] = d;
                int next1 = j + 1;
                int next2 = i;
                if(j + 1 == words[i].length()){
                    next1 = 0;
                    next2 = i + 1;
                }
                if(func(words, next2, next1, n, result, currSum, c * 10 + d)) return true;
                m1[d] = '.';
                m2[words[i].charAt(j) - 'A'] = -1;
            }
        }
        return false;
    }
    
    public boolean isSolvable(String[] words, String result) {
        int n = words.length;
        m1 = new char[10];
        m2 = new int[26];
        for(int i = 0; i < 10; i++) m1[i] = '.';
        for(int i = 0; i < 26; i++) m2[i] = -1;
        return func(words, 0, 0, n, result, 0, 0);
    }
}
