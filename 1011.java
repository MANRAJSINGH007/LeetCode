class Solution {
    public static int check(int[] weights, int cap){
        int n = weights.length;
        int count = 1;
        int sum = 0;
        for(int i = 0; i < n; i++){
            if(sum + weights[i] <= cap) sum += weights[i];
            else{
                count++;
                sum = weights[i];
            }
        }
        return count;
    }
    public int shipWithinDays(int[] weights, int D) {
        int n = weights.length;
        int start = weights[0], end = 0;
        for(int i = 0; i < n; i++){
            start = Math.max(start, weights[i]);
            end += weights[i];
        }
        int ans = Integer.MAX_VALUE;
        while(start <= end){
            int mid = (start + end)/2;
            int val = check(weights, mid);
            if(val <= D){
                ans = Math.min(ans, mid);
                end = mid - 1;
            }
            else start = mid + 1;
        }
        return ans;
    }
}
