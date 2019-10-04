class Solution {
    public int lengthOfLongestSubstring(String str) {
        
      int n=str.length();
      if(n<=1)
      {
        return n;
      }
      
      String ans="";
      String answer="";
      ans+=str.charAt(0);
      int start=0;
      int end=1;
      answer=ans;
      while(end<n)
      {
        char ch=str.charAt(end);
        int flag=0;
        int i=start;
        int index=-1;
        for(i=start;i<end;i++)
        {
          if(str.charAt(i)==ch)
          {
            index=i;
            flag=1;
            break;
          }
        }
        if(flag==1)
        {
          if(end-start>answer.length())
          {
            answer=ans;
          }
          else
          {
            
          }
          
          start=i+1;
          ans=str.substring(start,end+1);
          end++;
          
        }
        else
        {
          ans+=ch;
          end++;
        }
      }
      
      if(end-start>answer.length())
      {
        answer=ans;
      }
      
      return answer.length();
      
        
    }
}
