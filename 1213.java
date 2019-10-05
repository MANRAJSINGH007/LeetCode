class Solution {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        
        int n1 = arr1.length;
        int n2 = arr2.length;
        int n3 = arr3.length;
        
        int i1 = 0;
        int i2 = 0;
        int i3 = 0;
        
        List<Integer> ans = new ArrayList<>();
        
        while(i1 < n1 && i2 < n2 && i3 < n3){
            
            if(arr1[i1] == arr2[i2] && arr1[i1] == arr3[i3]){
                ans.add(arr1[i1]);
                i1++;
                i2++;
                i3++;
            }
            
            else if(arr1[i1] >= arr2[i2] && arr1[i1] >= arr3[i3]){
                if(arr1[i1] != arr2[i2])
                    i2++;
                if(arr1[i1] != arr3[i3])
                    i3++;
            }
            else if(arr2[i2] >= arr1[i1] && arr2[i2] >= arr3[i3]){
                if(arr1[i1] != arr2[i2])
                    i1++;
                if(arr3[i3] != arr2[i2])
                    i3++;
            }
            else if(arr3[i3] >= arr2[i2] && arr3[i3] >= arr1[i1]){
                if(arr3[i3] != arr2[i2])
                    i2++;
                if(arr1[i1] != arr3[i3])
                    i1++;
            }
            
        }
        
        return ans;
        
    }
}
