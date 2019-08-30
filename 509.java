class Solution {
    public int fib(int N) {
        
        if(N<=1){
            return N;
        }
        
        int m1=0;
        int m2=1;
        for(int i=2;i<=N;i++){
            int temp=m2;
            m2=m2+m1;
            m1=temp;
        }
        
        return m2;
        
    }
}
