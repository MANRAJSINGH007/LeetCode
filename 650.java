class Solution {
    
    public static int func(int i, int n, int copy)
    {
        if(i==n)
        {
            return 0;
        }
        if(i>n)
        {
            return Integer.MAX_VALUE;
        }
        
        int m1=Integer.MAX_VALUE;
        int m2=Integer.MAX_VALUE;
        
        //copy all
        if(copy!=i)
            m1=func(i,n,i);
        
        // paste what copied
        if(copy!=0)
            m2=func(i+copy,n,copy);
        
        if(m1<=m2)
        {
            if(m1==Integer.MAX_VALUE)
                return m1;
            
            return m1+1;
        }
        
        return m2+1;
    }
    
    public int minSteps(int n) {
        
        return func(1,n,0);
        
    }
}
