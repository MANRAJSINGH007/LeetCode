class Solution {
    
    public static ArrayList<Integer> func(int n, int k, int use)
    {
        if(use<0 || use>9)
        {
            return new ArrayList<Integer>();
        }
        if(n==1)
        {
            
            ArrayList<Integer> list=new ArrayList<Integer>();
            list.add(use);
            return list;
        }
        
        
        int up=use+k;
        int down=use-k;
        int to_add=use*(int)Math.pow(10,n-1);
        int n1=0;
        int n2=0;
        
        ArrayList<Integer> list=new ArrayList<Integer>();
        ArrayList<Integer> list2=new ArrayList<Integer>();
        
        
        ArrayList<Integer> list1=func(n-1,k,up);
        
        if(k!=0)
            list2=func(n-1,k,down);
        
        for(int i=0;i<list1.size();i++)
        {
            int number=list1.get(i);
            list.add(number+to_add);
        }
        for(int i=0;i<list2.size();i++)
        {
            int number=list2.get(i);
            list.add(number+to_add);
        }
        
        
        return list;
        
    }
    
    public int[] numsSameConsecDiff(int n, int k) {
        
        if(n==0)
        {
            return new int[0];
        }
        
        if(n==1)
        {
            int arr[]=new int[10];
            
            for(int i=0;i<10;i++)
            {
                arr[i]=i;
            }
            
            return arr;
        }
        
        
        
        ArrayList<Integer> list=new ArrayList<Integer>();
        
        for(int t=1;t<=9;t++)
        {
            int to_add=t*(int)Math.pow(10,n-1);
            ArrayList<Integer> list1=func(n-1,k,t+k);
            ArrayList<Integer> list2=new ArrayList<Integer>();
            if(k!=0)
                list2=func(n-1,k,t-k);
            for(int i=0;i<list1.size();i++)
            {
                int number=list1.get(i);
                list.add(number+to_add);
            }
            for(int i=0;i<list2.size();i++)
            {
                int number=list2.get(i);
                list.add(number+to_add);
            }
            
        }
        
        int s=list.size();
        int arr[]=new int[s];
        
        for(int i=0;i<s;i++)
        {
            arr[i]=list.get(i);
        }
        
        
        return arr;
        
        
        
        
    }
}
