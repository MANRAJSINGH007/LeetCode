class Solution {
    public int maxProfit(int[] prices) {
        
        int n=prices.length;
        if(n==0 || n==1)
        {
            return 0;
        }
        int max[]=new int[n];
        int min[]=new int[n];
        min[0]=prices[0];
        for(int i=1;i<n;i++)
        {
            if(prices[i]<min[i-1])
            {
                min[i]=prices[i];
            }
            else
            {
                min[i]=min[i-1];
            }
            
        }
        
        // max on the right side.
        max[n-2]=prices[n-1];
        int mm=prices[n-1];
        for(int i=n-3;i>=0;i--)
        {
            if(prices[i+1]>mm)
            {
                mm=prices[i+1];
            }
            max[i]=mm;
        }
        
        int max_profit=0;
        for(int i=0;i<n-1;i++)
        {
            if(max[i]-min[i]>max_profit)
            {
                max_profit=max[i]-min[i];
            }
        }
        
        return max_profit;
        
    }
}
