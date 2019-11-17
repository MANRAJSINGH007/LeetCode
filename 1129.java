class Pair{
    int node;
    int ans;
    Pair(int node, int ans){
        this.node = node;
        this.ans = ans;
    }
}
class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        
        int[][] edges = new int[n][n];
        int[] ans = new int[n];
        for(int i = 0; i < n; i++) ans[i] = Integer.MAX_VALUE;
        
        for(int i = 0; i < red_edges.length; i++) edges[red_edges[i][0]][red_edges[i][1]] += 1;
        for(int i = 0; i < blue_edges.length; i++) edges[blue_edges[i][0]][blue_edges[i][1]] += 2;
        
        // for(int i = 0;i < n; i++){
        //     for(int j = 0; j < n; j++) System.out.print(edges[i][j] + " ");
        //     System.out.println();
        // }
        
        boolean[] visited1 = new boolean[n];
        boolean[] visited2 = new boolean[n];
        Queue<Pair> q1 = new LinkedList<>();
        Queue<Pair> q2 = new LinkedList<>();
        q1.add(new Pair(0, 0));
        q2.add(new Pair(0, 0));
        visited1[0] = true;
        visited2[0] = true;
        
        while(q1.size() > 0 || q2.size() > 0){
            while(q1.size() > 0){
                Pair p = q1.remove();
                // System.out.println("Q1 " + p.node);
                ans[p.node] = Math.min(ans[p.node], p.ans);
                for(int j = 0; j < n; j++){
                    if(!visited2[j] && edges[p.node][j] == 1 || edges[p.node][j] == 3){
                        visited2[j] = true;
                        q2.add(new Pair(j, p.ans + 1));
                    }
                }
            }
            while(q2.size() > 0){
                Pair p = q2.remove();
                // System.out.println("Q2 " + p.node);
                ans[p.node] = Math.min(ans[p.node], p.ans);
                for(int j = 0; j < n; j++){
                    if(!visited1[j] && edges[p.node][j] >= 2){
                        visited1[j] = true;
                        q1.add(new Pair(j, p.ans + 1));
                    }
                }
            }
        }
        
        for(int i = 0; i < n; i++) if(ans[i] == Integer.MAX_VALUE) ans[i] = -1;
        
        return ans;
        
    }
}
