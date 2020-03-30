class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        if(n == 0) return false;
        int m = matrix[0].length;
        int i = 0, j = m - 1;
        while(i < n && j > - 1) {
            if(target == matrix[i][j]) return true;
            if(target < matrix[i][j]) j--;
            else i++;
        }
        return false;
    }
}
