class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        int n = arr.length;
        if(n == 0) return new ArrayList<>();
        int start = 0;
        int end = n - 1;
        int mid = (start + end)/2;
        int minDiff = Integer.MAX_VALUE;
        int index = n;
        
        while(start <= end){
            mid = (start + end)/2;
            if(arr[mid] == x){
                minDiff = 0;
                index = mid;
                break;
            }
            else if(arr[mid] > x){
                if(arr[mid] - x < minDiff){
                    minDiff = arr[mid] - x;
                    index = mid;
                }
                else if(arr[mid] - x == minDiff) index = Math.min(index, mid);
                end = mid - 1;
            }
            else{
                if(x - arr[mid] < minDiff){
                    minDiff = x - arr[mid];
                    index = mid;
                }
                else if(x - arr[mid] == minDiff) index = Math.min(index, mid);
                start = mid + 1;
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        int left = index - 1, right = index + 1;
        int count = 0;
        while(count < k - 1){
            count++;
            if(left == -1) right++;
            else if(right == n) left--;
            else if(x - arr[left] <= arr[right] - x) left--;
            else right++;
        }
        
        for(int i = left + 1; i < right; i++) ans.add(arr[i]);
        return ans;
        
    }
}
