class Solution {
    public String longestPalindrome(String s) {
        
        int count=0;
        int n=s.length();
        if(n==0)
        {
            return "";
        }
        int max=0;
        String ans="";
        int left=0;
        int right=0;
        for(int i=0;i<n;i++)
        {
            // count++;
            int start=i-1;
            int end=i+1;
            while(start>=0 && end<n)
            {
                if(s.charAt(start)==s.charAt(end))
                {
                    // count++;
                    if(end-start+1>max)
                    {
                        left=start;
                        right=end;
                        max=right-left+1;
                    }
                    start--;
                    end++;
                }
                else
                {
                    break;
                }
            }
        }
        
        for(int i=0;i<n-1;i++)
        {
            if(s.charAt(i)==s.charAt(i+1))
            {
                // count++;
                int start=i;
                int end=i+1;
                while(start>=0 && end<n)
                {
                    if(s.charAt(start)==s.charAt(end))
                    {
                        if(end-start+1>max)
                        {
                            left=start;
                            right=end;
                            max=right-left+1;
                        }
                        // count++;
                        start--;
                        end++;
                    }
                    else
                    {
                        break;
                    }
                }
            }
        }
        
        return s.substring(left,right+1);
        
    }
}
