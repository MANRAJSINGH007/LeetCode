class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        if(m == 0) return mat;
        int n = mat[0].length;
        for(int i = m - 1; i >= 0; i--) {
            int count = m - i, r = i, j = 0;
            int[] bucket = new int[101];
            while(r < m && j < n && count > 0) {
                count--;
                bucket[mat[r][j]]++;
                r++;
                j++;
            }
            count = m - i;
            r = i;
            j = 0;
            int index = 1;
            while(r < m && j < n && count > 0) {
                count--;
                while(bucket[index] == 0) index++;
                mat[r][j] = index;
                bucket[index]--;
                r++;
                j++;
            }
        }
        for(int j = 1; j < n; j++) {
            int count = n - j, c = j, i = 0;
            int[] bucket = new int[101];
            while(c < n && i < m && count > 0) {
                count--;
                bucket[mat[i][c]] += 1;
                i++;
                c++;
            }
            count = n - j;
            c = j;
            i = 0;
            int index = 1;
            while(c < n && i < m && count > 0) {
                count--;
                while(bucket[index] == 0) index++;
                mat[i][c] = index;
                bucket[index]--;
                i++;
                c++;
            }
        }
        return mat;
    }
}
