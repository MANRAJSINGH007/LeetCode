class Pair implements Comparable<Pair> {
    
    int x;
    int y;
    int distance;
    
    Pair(int x, int y, int distance){
        this.x=x;
        this.y=y;
        this.distance=distance;
    }
    
    public int compareTo(Pair obj){
        return this.distance-obj.distance;
    }
    
    
}
class Solution {
    public int[][] allCellsDistOrder(int n, int m, int r0, int c0) {
        
        Pair list[]=new Pair[n*m];
        int k=0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int distance=Math.abs(i-r0)+Math.abs(j-c0);
                list[k]=new Pair(i,j,distance);
                k++;
            }
        }
        
        Arrays.sort(list);
        
        int ans[][]=new int[n*m][2];
        for(int t=0;t<n*m;t++){
            Pair curr=list[t];
            ans[t][0]=curr.x;
            ans[t][1]=curr.y;
        }
        
        return ans;
        
    }
}
