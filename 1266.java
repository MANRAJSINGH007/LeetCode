class Solution {
    
    public int minTimeToVisitAllPoints(int[][] points) {
        
        int n = points.length;
        if(n <= 1) return 0;
        int ans = 0;
        int x = points[0][0];
        int y = points[0][1];
        
        for(int i = 1; i < n; i++){
            
            while(x != points[i][0] || y != points[i][1]){
                
                if(x == points[i][0]){
                    ans += Math.abs(points[i][1] - y);
                    y = points[i][1];
                    break;
                }
                
                if(y == points[i][1]){
                    ans += Math.abs(points[i][0] - x);
                    x = points[i][0];
                    break;
                }
                
                ans++;
                if(points[i][0] > x) x++;
                else x--;
                if(points[i][1] > y) y++;
                else y--;
            }
        }
        
        return ans;
        
    }
}
