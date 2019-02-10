class Solution {
    public boolean equationsPossible(String[] equations) {
        
        int n=equations.length;
        
        int parent[]=new int[26];
        
        for(int i=0;i<26;i++)
        {
            parent[i]=i;
            
        }
        
        for(int i=0;i<n;i++)
        {
            String str=equations[i];
            if(str.charAt(1)=='=')
            {
                char c1=str.charAt(0);
                char c2=str.charAt(3);
                if(c1==c2)
                {
                    continue;
                    
                }
                
                int index1=(int)c1-97;
                while(parent[index1]!=index1)
                {
                    index1=parent[index1];
                }
                
                int index2=(int)c2-97;
                while(parent[index2]!=index2)
                {
                    index2=parent[index2];
                    
                }
                
                parent[index1]=index2;
                
            }
            
        }
        
        
        for(int i=0;i<n;i++)
        {
            String str=equations[i];
            if(str.charAt(1)=='!')
            {
                char c1=str.charAt(0);
                char c2=str.charAt(3);
                
                int index1=(int)c1-97;
                while(parent[index1]!=index1)
                {
                    index1=parent[index1];
                }
                
                int index2=(int)c2-97;
                while(parent[index2]!=index2)
                {
                    index2=parent[index2];
                    
                }
                
                if(index1==index2)
                {
                    return false;
                }
                
            }
            
        }
        
        return true;
        
    }
}
