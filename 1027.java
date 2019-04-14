class Solution {
    public int longestArithSeqLength(int[] arr) {
        
        int n=arr.length;
        if(n==1){
            return 1;
        }
        int max=2;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                int diff=arr[j]-arr[i];
                int next=arr[j]+diff;
                int count=2;
                for(int k=j+1;k<n;k++){
                    if(arr[k]==next){
                        count++;
                        next=arr[k]+diff;
                    }
                }
                max=Math.max(max,count);
            }
        }
        
        return max;
        
    }
}
