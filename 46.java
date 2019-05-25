class Solution {
    
    static List<List<Integer>> list=new ArrayList<>();
    
    public static void func(int[] arr, boolean[] visited, List<Integer> curr){
        
        int flag=0;
        
        for(int i=0;i<arr.length;i++){
             if(!visited[i]){
                 flag=1;
                 curr.add(arr[i]);
                 visited[i]=true;
                 func(arr,visited,curr);
                 visited[i]=false;
                 curr.remove(curr.size()-1);
             }
        }
        
        if(flag==0){
            List<Integer> temp=new ArrayList<>();
            for(int i=0;i<curr.size();i++){
                temp.add(curr.get(i));
            }
            list.add(temp);
        }
        
        return ;
        
    }
    
    public List<List<Integer>> permute(int[] nums) {
        
        list=new ArrayList<>();
        boolean visited[]=new boolean[nums.length];
        func(nums,visited,new ArrayList<>());
        return list;
    }
}
