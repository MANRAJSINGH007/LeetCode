class Solution {
    public static int func(String s, HashMap<String,Integer> map, HashMap<String,Integer> dp)
    {
        if(s.length()==0)
        {
            return 1;
        }
        if(dp.containsKey(s))
        {
            return dp.get(s);
        }
        String temp="";
        int n=s.length();
        int count=0;
        
        for(int i=0;i<n;i++)
        {
            temp+=s.charAt(i);
            if(map.containsKey(temp))
            {
                count+=func(s.substring(i+1,n),map,dp);
                if(count==2)
                {
                    dp.put(s,count);
                    return count;
                }
            }
        }
        
        dp.put(s,count);
        return count;
        
        
    }
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        
        HashMap<String,Integer> map=new HashMap<String,Integer>();
        HashMap<String,Integer> dp=new HashMap<String,Integer>();
        int n=words.length;
        
        for(int i=0;i<n;i++)
        {
            map.put(words[i],1);
        }
        
        
        List<String> list=new ArrayList<String>();
        
        Arrays.sort(words);
        for(int i=0;i<n;i++)
        {
            if(func(words[i],map,dp)>1)
            {
                list.add(words[i]);
            }
        }
        
        
        return list;
        
    }
}
