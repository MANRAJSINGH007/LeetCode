class Solution {
    public static int func(boolean[] visited, int i, int n){
        if(i == n) return 1;
        int ans=0;
        for(int j = 1; j <= n; j++){
            if(!visited[j] && ((i + 1) % j == 0 || j % (i + 1) == 0)){
                visited[j] = true;
                ans += func(visited, i + 1, n);
                visited[j] = false;
            }
        }
        return ans;
    }
    public int countArrangement(int n) {
        boolean[] visited=new boolean[n+1];   
        return func(visited,0,n);
    }
}
