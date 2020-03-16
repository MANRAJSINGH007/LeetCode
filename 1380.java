class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] rows = new int[m];
        int[] cols = new int[n];
        for(int i = 0; i < n; i++) {
            int max = Integer.MIN_VALUE;
            for(int j = 0; j < m; j++) max = Math.max(max, matrix[j][i]);
            cols[i] = max;
        }
        for(int i = 0; i < m; i++) {
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < n; j++) min = Math.min(min, matrix[i][j]);
            rows[i] = min;
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) if(rows[i] == matrix[i][j] && cols[j] == matrix[i][j]) ans.add(rows[i]);
        }
        return ans;
    }
}
