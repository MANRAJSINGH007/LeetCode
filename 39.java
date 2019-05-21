class Solution {
    static List<List<Integer>> l=new ArrayList<List<Integer>>();
    static HashMap<List<Integer>,Integer> map=new HashMap<List<Integer>,Integer>();
  
  	public static void func(int arr[], int n, int i, int sum, List<Integer> list)
    {
      if(sum==0)
      {
        int x=list.size();
        if(x==0)
        {
          return ;
        }
        List<Integer> temp=new ArrayList<Integer>();
        for(int p=0;p<x;p++)
        {
          temp.add(list.get(p));
        }
        map.put(temp,1);
        return ;
      }
      if(i==n)
      {
        return ;
      }
      int s=sum-arr[i];
      int count=0;
      while(s>=0)
      {
        count++;
        list.add(arr[i]);
        func(arr,n,i+1,s,list);
        s-=arr[i];
      }

      while(count!=0)
      {
        count--;
        list.remove(list.size()-1);
      }
      
      func(arr,n,i+1,sum,list);
      return ;
    }
    public List<List<Integer>> combinationSum(int[] arr, int sum) {
        
      l.clear();
      map.clear();
      java.util.Arrays.sort(arr);
      int n=arr.length;
      List<Integer> list=new ArrayList<Integer>();
      func(arr,n,0,sum,list);
      Set<List<Integer>> keys=map.keySet();
      for(List<Integer> k:keys)
      {
        l.add(k);
      }
      return l;
        
    }
}
