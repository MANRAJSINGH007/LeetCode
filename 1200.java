class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        
        int n = arr.length;
        
        Arrays.sort(arr);
        int min = arr[1] - arr[0];
        
        for(int i = 0; i < n - 1; i++){
            min = Math.min(arr[i + 1] - arr[i], min);
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i = 0; i < n - 1; i++){
            if(arr[i + 1] - arr[i] == min){
                List<Integer> temp = new ArrayList<>();
                temp.add(arr[i]);
                temp.add(arr[i + 1]);
                ans.add(temp);
            }
        }
        
        return ans;
    }
}
