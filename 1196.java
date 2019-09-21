class Solution {
    public int maxNumberOfApples(int[] arr) {
        
        int n = arr.length;
        
        Arrays.sort(arr);
        
        int count = 0;
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += arr[i];
            if(sum <= 5000){
                count++;
            }
            else{
                return count;
            }
        }
        
        return count;
    }
}
