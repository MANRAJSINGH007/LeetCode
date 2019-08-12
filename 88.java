class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int i1=0;
        int i2=0;
        
        while(i2<n){
            
            if(i1==m){
                while(i2<n){
                    nums1[i1]=nums2[i2];
                    i1++;
                    i2++;
                }
                
                break;
            }
            
            if(nums1[i1]<=nums2[i2]){
                i1++;
            }
            else{
                int temp=nums1[i1];
                nums1[i1]=nums2[i2];
                nums2[i2]=temp;
                i1++;
                
                while(i2+1<n && nums2[i2]>nums2[i2+1]){
                    int swap=nums2[i2];
                    nums2[i2]=nums2[i2+1];
                    nums2[i2+1]=swap;
                    i2++;
                }
                
                i2=0;
            }
        }
        
    }
}
