class Solution {
    public int maxSumTwoNoOverlap(int[] arr, int n1, int n2) {
        
        int n=arr.length;
        int sum[]=new int[n];
        int s=0;
        
        for(int i=0;i<n;i++){
            s+=arr[i];
            sum[i]=s;
        }
        
        int max=Integer.MIN_VALUE;
        
        for(int i=0;i<n;i++){
            if(i+n1-1<n){
                int s1=0;
                if(i==0){
                    s1+=sum[i+n1-1];
                }
                else{
                    s1=sum[i+n1-1]-sum[i-1];
                }
                
                if(i+n1-1<n-n2){
                    // then s2 is possible
                    int s2=0;
                    for(int k=i+n1;k<=n-n2;k++){
                        s2=Math.max(s2,sum[k+n2-1]-sum[k-1]);
                        max=Math.max(max,s1+s2);
                    }
                }
                
                if(i>=n2){
                    int s2=0;
                    for(int k=0;k<i-n2;k++){
                        if(k==0){
                            s2=sum[n2-1];
                        }
                        else{
                            s2=sum[k+n2-1]-sum[k-1];
                        }
                        max=Math.max(s1+s2,max);
                    }
                }
                
            }
        }
        
        return max;
        
    }
}
