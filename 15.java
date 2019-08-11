class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        
        int n=arr.length;
        Arrays.sort(arr);
        
        List<List<Integer>> ans=new ArrayList<>();
        
        for(int i=0;i<n;i++){
            
            int start=i+1;
            int end=n-1;
            int sum=arr[i];
            
            while(start<end){
                
                sum=arr[i]+arr[start]+arr[end];
                if(sum==0){
                    List<Integer> list=new ArrayList<>();
                    list.add(arr[i]);
                    list.add(arr[start]);
                    list.add(arr[end]);
                    ans.add(list);
                    
                    while(start<end && arr[start]==arr[start+1]){
                        start++;
                    }
                    
                    while(start<end && arr[end]==arr[end-1]){
                        end--;
                    }
                    
                    start++;
                }
                
                else if(sum<0){
                    start++;
                }
                
                else{
                    end--;
                }
                
            }
            
            while(i<n-2 && arr[i]==arr[i+1]){
                i++;
            }
            
        }
        
        return ans;
        
    }
}
