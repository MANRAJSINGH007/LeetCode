class Solution {
    public boolean isAnagram(String s, String t) {
        
        int n=s.length();
        int m=t.length();
        if(n!=m){
            return false;
        }
        int arr[]=new int[26];
        for(int i=0;i<n;i++){
            int n1=(int)s.charAt(i)-97;
            int n2=(int)t.charAt(i)-97;
            arr[n1]++;
            arr[n2]--;
        }
        
        for(int i=0;i<26;i++){
            if(arr[i]!=0){
                return false;
                
            }
        }
        
        return true;
    }
}
