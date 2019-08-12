class Solution {
    public int subarraysDivByK(int[] A, int K) {
        
        int n=A.length;
        int arr[]=new int[K];
        
        int s=0;
        for(int i=0;i<n;i++){
            s+=A[i];
            int mod=s%K;
            if(mod<0){
                mod=K+mod;
            }
            arr[mod]++;
        }
        
        int count=0;
        arr[0]++;
        
        for(int i=0;i<K;i++){
            count+=(arr[i]*(arr[i]-1))/2;
        }
        
        return count;
    }
}
