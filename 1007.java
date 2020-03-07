class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        int n = A.length;
        int[] count = new int[7];
        for(int i = 0; i < n; i++) {
            count[A[i]]++;
            if(A[i] == B[i]) continue;
            count[B[i]]++;
        }
        int min = n + 1;
        for(int i = 1; i < 7; i++) {
            if(count[i] == n) {
                int a = 0, b = 0;
                for(int j = 0; j < n; j++) {
                    if(A[j] == i) a++;
                    if(B[j] == i) b++;
                }
                min = Math.min(min,n - a);
                min = Math.min(min, n - b);
            }
        }
        return min == n + 1 ? -1 : min;
    }
}
