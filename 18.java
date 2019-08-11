class Solution {
    public List<List<Integer>> fourSum(int[] arr, int target) {
        
        int n=arr.length;
        
        Arrays.sort(arr);
        
        List<List<Integer>> ans=new ArrayList<>();
        
        for(int i=0;i<n-3;i++){
            
            for(int j=i+1;j<n-2;j++){
                
                int start=j+1;
                int end=n-1;
                
                while(start<end){
                    
                    int sum=arr[i]+arr[j]+arr[start]+arr[end];
                    
                    if(sum==target){
                        List<Integer> list=new ArrayList<>();
                        list.add(arr[i]);
                        list.add(arr[j]);
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
                    
                    else if(sum<target){
                        start++;
                    }
                    
                    else{
                        end--;
                    }
                    
                }
                
                while(j<n-2 && arr[j]==arr[j+1]){
                    j++;
                }
                
            }
            
            while(i<n-1 && arr[i]==arr[i+1]){
                i++;
            }
            
        }
        
        return ans;
        
    }
}
