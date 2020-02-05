class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        if(m == 0) return new int[0];
        int n = mat[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] row1, int[] row2) {
                if(row1[1] < row2[1]) return 1;
                if(row2[1] < row1[1]) return -1;
                if(row1[0] < row2[0]) return 1;
                if(row1[0] > row2[0]) return -1;
                return 0;
            }
        });
        for(int i = m - 1; i >= m - k; i--) {
            int count = 0;
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == 0) break;
                count++;
            }
            pq.add(new int[]{i, count});
        }
        for(int i = m - k - 1; i > -1; i--) {
            int[] top = pq.peek();
            int count = 0;
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == 0) break;
                count++;
            }
            if(count <= top[1]) {
                pq.remove();
                pq.add(new int[]{i, count});
            }
        }
        int[] ans = new int[k];
        for(int i = 0; i < k; i++) ans[k - 1 - i] = pq.remove()[0];
        return ans;
    }
}
