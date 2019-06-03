class Solution {
    public Interval[] intervalIntersection(Interval[] arr, Interval[] brr) {
        
        ArrayList<Interval> list=new ArrayList<Interval>();
        
        int n=arr.length;
        int m=brr.length;
        
        int i=0;
        int j=0;
        
        while(i<n && j<m)
        {
            Interval obj1=arr[i];
            Interval obj2=brr[j];
            if(obj1.end<obj2.start || obj2.end<obj1.start)
            {
                if(obj1.end<obj2.start)
                {
                    i++;
                }
                else
                {
                    j++;
                }
            }
            else
            {
                // there is an overlapping.
            
                int s=Math.max(obj1.start,obj2.start);
                int e=Math.min(obj1.end,obj2.end);

                Interval ans=new Interval(s,e);
                list.add(ans);

                if(obj1.start==obj2.start)
                {
                    if(obj1.end<obj2.end)
                    {
                        i++;
                    }
                    else
                    {
                        j++;
                    }
                }

                else if(s==obj2.start)
                {
                    if(obj1.end<=obj2.end)
                        i++;
                    else
                        j++;
                }

                else
                {
                    if(obj2.end<=obj1.end)
                        j++;
                    else
                        i++;
                }
            }
            
            
        }
        
        int p=list.size();
        Interval answer[]=new Interval[p];
        
        for(int t=0;t<p;t++)
        {
            answer[t]=list.get(t);
        }
        
        return answer;
        
    }
}
