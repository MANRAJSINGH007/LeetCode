class Solution {
    public int[] twoSum(int[] a, int target) {
        int b[]=new int[2];
        int n=a.length; 
        for(int i=0;i<n-1;i++)     
        {   int flag=0;
         
            for(int j=i+1;j<n;j++)
            {
                if(a[i]+a[j]==target)
                {
                    b[0]=i;
                    b[1]=j;
                    flag=1;
                    break;
                }
            }
         
         if(flag==1)
         {
             break;
         }
         
        }
        
        return b;
        
    }
}
