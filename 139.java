class Solution {
    public static boolean func(String s, HashMap<String,Integer> map, HashMap<String,Boolean> dp)
    {
        if(s.length()==0)
        {
            return true;
        }
        
        if(dp.containsKey(s))
        {
            if(dp.get(s))
            {
                return true;
            }
            
            return false;
        }
        String temp="";
        int n=s.length();
        for(int i=0;i<s.length();i++)
        {
            temp+=s.charAt(i);
            if(map.containsKey(temp))
            {
                boolean b=func(s.substring(i+1,n),map,dp);
                if(b)
                {
                    dp.put(s,true);
                    return true;
                }
            }
        }
        
        dp.put(s,false);
        return false;
        
        
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        
        int n=wordDict.size();
        HashMap<String,Integer> map=new HashMap<String,Integer>();
        HashMap<String,Boolean> dp=new HashMap<String,Boolean>();
        for(int i=0;i<n;i++)
        {
            map.put(wordDict.get(i),1);
        }
        
        return func(s,map,dp);
        
    }
}
