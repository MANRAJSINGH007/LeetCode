class Solution {
    public boolean hasValidPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[] up =    {0, 1, 0, 0, 1, 1};
        int[] down =  {0, 1, 1, 1, 0, 0};
        int[] left =  {1, 0, 1, 0, 1, 0};
        int[] right = {1, 0, 0, 1, 0, 1};
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        q.add(new int[]{0, 0});
        while(q.size() > 0) {
            int[] arr = q.remove();
            // System.out.println(arr[0] + " " + arr[1]);
            if(arr[0] == m - 1 && arr[1] == n - 1) return true;
            int val = grid[arr[0]][arr[1]] - 1;
            int b1 = up[val], b2 = down[val], b3 = left[val], b4 = right[val];
            if(b1 == 1) {
                int x = arr[0] - 1, y = arr[1];
                if(x >= 0 && x < m && !visited[x][y] && down[grid[x][y] - 1] == 1) {
                    visited[x][y] = true;
                    q.add(new int[]{x, y});
                } 
            }if(b2 == 1) {
                int x = arr[0] + 1, y = arr[1];
                if(x >= 0 && x < m && !visited[x][y] && up[grid[x][y] - 1] == 1) {
                    visited[x][y] = true;
                    q.add(new int[]{x, y});
                } 
            }if(b3 == 1) {
                int x = arr[0], y = arr[1] - 1;
                if(y >= 0 && y < n && !visited[x][y] && right[grid[x][y] - 1] == 1) {
                    visited[x][y] = true;
                    q.add(new int[]{x, y});
                } 
            }if(b4 == 1) {
                int x = arr[0], y = arr[1] + 1;
                if(x >= 0 && y < n && !visited[x][y] && left[grid[x][y] - 1] == 1) {
                    visited[x][y] = true;
                    q.add(new int[]{x, y});
                } 
            }
        }
        return false;
    }
}
