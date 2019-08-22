class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        
        int m=bookings.length;
        
        int temp[]=new int[n];
        
        for(int i=0;i<m;i++){
            
            int l=bookings[i][0];
            int r=bookings[i][1];
            l--;
            r--;
            
            int curr=bookings[i][2];
            
            temp[l]+=curr;
            if(r!=n-1){
                temp[r+1]-=curr;
            }
        }
        
        int sum=temp[0];
        for(int i=1;i<n;i++){
            temp[i]+=sum;
            sum=temp[i];
        }
        
        return temp;
        
    }
}
