class Solution {
    
    public static int[] get_freq(String[] words, int m){
        
        int[] ans=new int[m];
        
        for(int i=0;i<m;i++){
            
            String curr=words[i];
            int index=123;
            int freq=0;
            
            for(int j=0;j<curr.length();j++){
                char c=curr.charAt(j);
                if((int)c<index){
                    index=(int)c;
                    freq=1;
                }
                else if((int)c==index){
                    freq++;
                }
            }
            
            ans[i]=freq;
        }
        
        Arrays.sort(ans);
        return ans;
        
    }
    
    public static int[] get_freq2(String[] words, int m){
        
        int[] ans=new int[m];
        
        for(int i=0;i<m;i++){
            
            String curr=words[i];
            int index=123;
            int freq=0;
            
            for(int j=0;j<curr.length();j++){
                char c=curr.charAt(j);
                if((int)c<index){
                    index=(int)c;
                    freq=1;
                }
                else if((int)c==index){
                    freq++;
                }
            }
            
            ans[i]=freq;
        }
        
        return ans;
        
    }
    
    public static int find(int target, int[] ans, int m){
        
        int start=0;
        int end=m-1;
        int mid=(start+end)/2;
        int curr_ans=0;
        
        while(start<=end){
            
            mid=(start+end)/2;
            if(ans[mid]>target){
                curr_ans=Math.max(curr_ans,m-mid);
                end=mid-1;
            }
            
            else if(ans[mid]<=target){
                start=mid+1;
            }
            
        }
        
        return curr_ans;
        
    }
    
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        
        int n=queries.length;
        
        int m=words.length;
        
        int[] ans=get_freq(words,m);
        
        int[] query_ans=get_freq2(queries,n);
        
        int[] ret=new int[n];
        
        for(int i=0;i<n;i++){
            int target=query_ans[i];
            ret[i]=find(target,ans,m);
        }
        
        return ret;
    }
}
