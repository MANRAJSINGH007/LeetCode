class Solution {
    public List<Integer> findDisappearedNumbers(int[] arr) {
        
        int n=arr.length;
        
        for(int i=0;i<n;i++){
            if(arr[i]<0){
                int num=-arr[i]-1;
                if(arr[num]>0){
                    int k=arr[num];
                    arr[num]=-k;
                }
            }
            else{
                int num=arr[i]-1;
                if(arr[num]>0){
                    int k=arr[num];
                    arr[num]=-k;
                }
            }
        }
        
        List<Integer> list=new ArrayList<>();
        
        for(int i=0;i<n;i++){
            if(arr[i]>0){
                list.add(i+1);
            }
        }
        
        return list;
    }
}
