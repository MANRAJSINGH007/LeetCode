class Solution {
    
    public static int func(List<List<Integer>> list, int n, int m, int i, int j, boolean[][] visited, int prev){
        
        if(i<0 || j<0 || i==n || j==m || visited[i][j] || list.get(i).get(j)==0){
            for(int a=0;a<n;a++){
                for(int b=0;b<m;b++){
                    if(!visited[a][b] && list.get(a).get(b)!=0 && list.get(a).get(b)!=1){
                        return Integer.MAX_VALUE;
                    }
                }
            }
            
            // because in the parent call it would have been added un necessarily.
            return -1;
        }
        
        visited[i][j]=true;
        int new_prev=list.get(i).get(j);
        
        if(new_prev!=1 && new_prev<=prev){
            return Integer.MAX_VALUE;
        }
        if(new_prev==1){
            new_prev=prev;
        }
        int x1=func(list,n,m,i+1,j,visited,new_prev);
        int x2=func(list,n,m,i-1,j,visited,new_prev);
        int x3=func(list,n,m,i,j+1,visited,new_prev);
        int x4=func(list,n,m,i,j-1,visited,new_prev);
        
        if(x1!=Integer.MAX_VALUE){
            x1++;
        }
        if(x2!=Integer.MAX_VALUE){
            x2++;
        }
        if(x3!=Integer.MAX_VALUE){
            x3++;
        }
        if(x4!=Integer.MAX_VALUE){
            x4++;
        }
        
        int ans=Math.min(x1,x2);
        ans=Math.min(ans,x3);
        ans=Math.min(ans,x4);
        visited[i][j]=false;
        return ans;
    }
    
    
    
    public int cutOffTree(List<List<Integer>> forest) {
        
        int n=forest.size();
        int m=forest.get(0).size();
        boolean visited[][]=new boolean[n][m];
        int ans=func(forest,n,m,0,0,visited,-1);
        if(ans==Integer.MAX_VALUE){
            ans=-1;
        }
        return ans;
        
    }
}
