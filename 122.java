class Solution {
    public int maxProfit(int[] prices) {
        
        int n=prices.length;
        if(n<=1){
            return 0;
        }
        
        int ans=0;
        int bought=prices[0];
        
        for(int i=1;i<n;i++){
            if(prices[i]>bought){
                ans+=prices[i]-bought;
            }
            bought=prices[i];
        }
        
        return ans;
    }
}
