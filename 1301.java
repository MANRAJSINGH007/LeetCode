class Pair{
    int val;
    long paths;
    Pair(int val, long paths){
        this.val = val;
        this.paths = paths;
    }
}
class Solution {
    static int mod = (int)Math.pow(10, 9) + 7;
    public static Pair func(List<String> arr, int i, int j, Pair[][] dp){
        if(i == 0 && j == 0) return new Pair(0, 1);
        if(i < 0 || j < 0 || arr.get(i).charAt(j) == 'X') return new Pair(Integer.MIN_VALUE, 0);
        if(dp[i][j] != null) return dp[i][j];
        int curr = 0;
        if(arr.get(i).charAt(j) != 'S') curr = (arr.get(i).charAt(j)) - '0';
        Pair x1 = func(arr,i - 1, j, dp);
        Pair x2 = func(arr, i, j - 1, dp);
        Pair x3 = func(arr, i - 1, j - 1, dp);
        Pair max = new Pair(Integer.MIN_VALUE, 0);
        if(x1.val != Integer.MIN_VALUE) max = new Pair(x1.val, x1.paths); 
        if(x2.val != Integer.MIN_VALUE){
            if(x2.val > max.val) max = new Pair(x2.val, x2.paths);
            else if(x2.val == max.val) max = new Pair(max.val, (max.paths + x2.paths) % mod);
        }
        if(x3.val != Integer.MIN_VALUE){
            if(x3.val > max.val) max = new Pair(x3.val, x3.paths);
            else if(x3.val == max.val) max = new Pair(max.val, (max.paths + x3.paths) % mod);
        } 
        if(max.val != Integer.MIN_VALUE) max.val += curr;
        return dp[i][j] = max;
    }
    
    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        Pair[][] dp1 = new Pair[n][n];
        Pair ans = func(board, n - 1, n - 1, dp1);
        if(ans.val == Integer.MIN_VALUE) return new int[2];
        int[] a = new int[2];
        a[0] = ans.val;
        a[1] = (int)ans.paths;
        return a;
    }
}
