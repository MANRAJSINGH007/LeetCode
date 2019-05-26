class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int x) {
        
        int n=customers.length;
        HashMap<Integer,Integer> map1=new HashMap<>();
        HashMap<Integer,Integer> map2=new HashMap<>();
        
        int s2=0;
        map2.put(-1,0);
        for(int i=0;i<n;i++){
            if(grumpy[i]==0){
                grumpy[i]=1;
            }
            else{
                grumpy[i]=0;
            }
            if(grumpy[i]==1)
                s2+=customers[i];
            map2.put(i,s2);
        }
        
        int s1=0;
        map1.put(-1,0);
        for(int i=0;i<x-1;i++){
            s1+=customers[i];
            map1.put(i,s1);
        }
        
        int max=0;
        for(int i=x-1;i<n;i++){
            s1+=customers[i];
            int temp=map1.get(i-x);
            int curr_max=s1-temp;
            curr_max+=map2.get(i-x)+s2-map2.get(i);
            max=Math.max(curr_max,max);
            map1.put(i,s1);
        }
        
        return max;
        
    }
}
