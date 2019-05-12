class Solution {
    
    public static void dfs(int[] color, int n, ArrayList<ArrayList<Integer>> edges, int parent_color, boolean[] visited, int sv){
        
        visited[sv]=true;
        color[sv]=parent_color;
        
        ArrayList<Integer> curr=edges.get(sv);
        
        for(int i=0;i<curr.size();i++){
            int v=curr.get(i);
            if(!visited[v]){
                int c=0;
                ArrayList<Integer> child=edges.get(v);
                boolean dummy[]=new boolean[5];
                for(int j=0;j<child.size();j++){
                    if(color[child.get(j)]!=0){
                        dummy[color[child.get(j)]]=true;
                    }
                }
                for(int k=1;k<5;k++){
                    if(!dummy[k]){
                        c=k;
                        break;
                    }
                }
                dfs(color,n,edges,c,visited,v);
            }
        }
        
        return ;
        
    }
    
    
    public int[] gardenNoAdj(int n, int[][] paths) {
        
        int m=paths.length;
        boolean visited[]=new boolean[n];
        
        ArrayList<ArrayList<Integer>> edges=new ArrayList<>();
        
        for(int i=0;i<n;i++){
            edges.add(new ArrayList<>());
        }
        
        for(int i=0;i<m;i++){
            int sv=paths[i][0]-1;
            int ev=paths[i][1]-1;
            ArrayList<Integer> s1=edges.get(sv);
            s1.add(ev);
            ArrayList<Integer> s2=edges.get(ev);
            s2.add(sv);
        }
        
        int color[]=new int[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(color,n,edges,1,visited,i);
            }
        }
        
        return color;
        
        
    }
}
