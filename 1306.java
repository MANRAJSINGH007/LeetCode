class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        boolean[] visited = new boolean[n];
        visited[start] = true;
        
        while(q.size() > 0){
            int index = q.remove();
            if(arr[index] == 0) return true;
            if(index + arr[index] >= 0 && index + arr[index] < n && !visited[arr[index] + index]){
                if(arr[arr[index] + index] == 0) return true;
                visited[index + arr[index]] = true;
                q.add(arr[index] + index);
            }
            if(index - arr[index] >= 0 && index - arr[index] < n && !visited[-arr[index] + index]){
                if(arr[-arr[index] + index] == 0) return true;
                visited[index - arr[index]] = true;
                q.add(-arr[index] + index);
            }
        }
        return false;
    }
}
