class Solution {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        
        int n=calories.length;
        
        int sum=0;
        
        for(int i=0;i<k;i++){
            sum+=calories[i];
        }
        
        int prev=sum;
        sum=0;
        
        if(prev<lower){
            sum--;
        }
        
        else if(prev>upper){
            sum++;
        }
        
        for(int i=k;i<n;i++){
            prev=prev-calories[i-k]+calories[i];
            if(prev<lower){
                sum--;
            }
            else if(prev>upper){
                sum++;
            }
        }
        
        return sum;
        
    }
}
