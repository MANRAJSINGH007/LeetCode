class Solution {
    public boolean detectCapitalUse(String word) {
        
        if(word==null){
            return true;
        }
        
        int n=word.length();
        if(n==1){
            return true;
        }
        
        int flag=0;
        char c=word.charAt(0);
        int index=(int)c;
        if(index>=65 && index<=90){
            flag=1;
        }
        
        for(int i=1;i<n;i++){
            
            index=(int)(word.charAt(i));
            
            if(flag==0 && index>=65 && index<=90){
                return false;
            }
            
            else if(flag==1 && index>=97 && index<=122){
                flag=0;
            }
            
            else if(flag==1 && index>=65 && index<=90){
                flag=3;
            }
            
            else if(flag==3 && index>=97 && index<=122){
                return false;
            }
            
        }
        
        return true;
        
        
    }
}
