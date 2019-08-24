class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        
        int n=A.length;
        
        int sum=0;
        
        for(int i=0;i<n;i++){
            sum+=A[i];
        }
        
        if(sum%3!=0){
            return false;
        }
        
        int s=0;
        
        boolean b1=false;
        boolean b2=false;
        
        for(int i=0;i<n;i++){
            s+=A[i];
            if(s==sum/3){
                b1=true;
            }
            else if(s==(2*sum/3)){
                
                if(b1){
                    b2=true;
                }
            }
        }
        
        return b1 && b2;
    }
}
