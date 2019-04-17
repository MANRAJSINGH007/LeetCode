import java.util.*;
import java.io.*;

class Pair implements Comparable<Pair>{
    
    int data;
    int level;
    int x;
    
    Pair(int data, int level, int x)
    {
        this.data=data;
        this.level=level;
        this.x=x;
    }
    
    public int compareTo(Pair o1)
    {
        if(this.level<o1.level)
        {
            return -1;
        }
        else if(o1.level<this.level)
        {
            return 1;
        }
        else
        {
            if(this.data<o1.data)
            {
                return -1;
            }

            return 1;
        }
    }
    
}


class Solution {
    
    static HashMap<Integer,ArrayList<Pair>> map=new HashMap<>();
    
    static int l=Integer.MAX_VALUE;
    static int r=Integer.MIN_VALUE;
    
    public static void function(TreeNode root, int level, int x)
    {
        if(root==null)
        {
            return ;
        }
        
        if(x<l)
        {
            l=x;
        }
        
        if(x>r)
        {
            r=x;
        }
        
        if(map.containsKey(x))
        {
            ArrayList<Pair> temp=map.get(x);
            temp.add(new Pair(root.val,level,x));

        }
        else
        {
            ArrayList<Pair> temp=new ArrayList<>();
            temp.add(new Pair(root.val,level,x));
            map.put(x,temp);
            
        }
        
        
        function(root.left,level+1,x-1);
        function(root.right,level+1,x+1);
        
        return ;
        
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) { 
        
        map.clear();
        
        l=Integer.MAX_VALUE;
        r=Integer.MIN_VALUE;
        
        function(root,0,0);
        
        Set<Integer> keys=map.keySet();
        
        for(Integer i : keys)
        {
            ArrayList<Pair> curr=map.get(i);
            Collections.sort(curr);
            
        }
        
        
        List<List<Integer>> master=new ArrayList<>();
        
        for(int k=l;k<=r;k++)
        {
            ArrayList<Pair> temp=map.get(k);
            ArrayList<Integer> small=new ArrayList<Integer>();
            for(int p=0;p<temp.size();p++)
            {
                small.add(temp.get(p).data);
            }
            master.add(small);
        }
        
        
        return master;
        
        
    }
}
