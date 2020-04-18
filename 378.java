class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int row = 0, col = 0;
        outer : for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                pq.add(matrix[i][j]);
                if(pq.size() == k) {
                    row = i;
                    col = j;
                    break outer;
                }
            }
        }
        if(col == n - 1) {
            row++;
            col = 0;
        } else col++;
        while(row < n) {
            if(pq.peek() > matrix[row][col]) {
                pq.poll();
                pq.add(matrix[row][col]);
                col++;
            } else {
                row++;
                col = 0;
            }
        }
        return pq.peek();
    }
}
