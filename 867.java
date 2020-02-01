class Solution {
    public int[][] transpose(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        int[][] transpose = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) transpose[i][j] = A[j][i];
        }
        return transpose;
    }
}
