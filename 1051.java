class Solution {
    public int heightChecker(int[] heights) {
        
        int n=heights.length;
        int temp[]=new int[n];
        for(int i=0;i<n;i++){
            temp[i]=heights[i];
        }
        
        Arrays.sort(temp);
        int count=0;
        for(int i=0;i<n;i++){
            if(temp[i]!=heights[i]){
                count++;
            }
        }
        
        return count;
    }
}
