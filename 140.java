class Solution {
    
    public static List<String> func(String s, HashMap<String,Integer> map, HashMap<String,List<String>> dp)
    {
        if(s.length()==0)
        {
            return null;
        }
        if(dp.containsKey(s))
        {
            return dp.get(s);
        }
        int n=s.length();
        String temp="";
        int flag=0;
        
        List<String> for_this=new ArrayList<String>();
        
        for(int i=0;i<n;i++)
        {
            temp+=s.charAt(i);
            if(map.containsKey(temp))
            {
                flag=1;
                List<String> demo=func(s.substring(i+1,n),map,dp);
                if(demo==null)
                {
                    for_this.add(temp); 
                }
                else
                {
                    int q=demo.size();
                    for(int p=0;p<q;p++)
                    {
                        String w=demo.get(p);
                        w=temp+" "+w;
                        for_this.add(w);        
                    }
                }
                
            }
        }
        
        dp.put(s,for_this);
        return for_this;
    }
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        
        int n=s.length();
        HashMap<String,Integer> map=new HashMap<String,Integer>();
        HashMap<String,List<String>> dp=new HashMap();
        
        for(int i=0;i<wordDict.size();i++)
        {
            map.put(wordDict.get(i),1);
        }
        
        return func(s,map,dp);
        
        
        
    }
}
