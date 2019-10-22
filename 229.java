class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        int n=nums.length;
        
        if(n==0){
            return new ArrayList<>();
        }
        
        ArrayList<Integer> ans=new ArrayList<>();
        
        int count1=1;
        int count2=0;
        int candidate1=nums[0];
        
        int i=1;
        
        while(i<n && nums[i]==candidate1){
            i++;
            count1++;
        }
        
        if(i==n){
            ans.add(candidate1);
            return ans;
        }
        
        int candidate2=nums[i];
        count2=1;
        i++;
        
        while(i<n && nums[i]==candidate2){
            i++;
            count2++;
        }
        
        int freq=(int)Math.floor(n/3);
        
        if(i==n){
            if(count1>freq){
                ans.add(candidate1);
            }
            
            if(count2>freq){
                ans.add(candidate2);
            }
            
            return ans;
        }
        
        for(int j=i;j<n;j++){
            
            if(nums[j]==candidate1){
                count1++;
            }
            
            else if(nums[j]==candidate2){
                count2++;
            }
            
            else{
                
                if(count1==0){
                    count1=1;
                    candidate1=nums[j];
                }
                
                else if(count2==0){
                    count2=1;
                    candidate2=nums[j];
                }
                
                else{
                    count1--;
                    count2--;
                }
                
            }
            
        }
        
        count1=0;
        count2=0;
        
        for(int j=0;j<n;j++){
            if(nums[j]==candidate1){
                count1++;
            }
            else if(nums[j]==candidate2){
                count2++;
            }
        }
        
        if(count1>freq){
            ans.add(candidate1);
        }
        
        if(count2>freq){
            ans.add(candidate2);
        }
        
        return ans;
        
    }
}
