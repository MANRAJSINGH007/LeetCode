class Solution {
    
    public static boolean check(int[] arr, int[] brr){
        
        for(int i=0;i<256;i++){
            if(arr[i]>brr[i]){
                return false;
            }
        }
        
        return true;
        
    }
    
    public String minWindow(String s, String t) {
        
        int m=t.length();
        int n=s.length();
        
        if(n<m){
            return "";
        }
        
        int min=n+1;
        int ss=-1;
        int e=-1;
        
        int arr[]=new int[256];
        for(int i=0;i<m;i++){
            arr[(int)t.charAt(i)]++;
        }
        
        int brr[]=new int[256];
        
        for(int i=0;i<m;i++){
            
            char ch=s.charAt(i);
            brr[(int)ch]++;
        }
        
        int start=0;
        int end=m-1;
        
        while(end<n && start<=end-m+1){
            
            while(end<n && start<=end-m+1 && check(arr,brr)){
                if(end-start+1<min){
                    min=end-start+1;
                    ss=start;
                    e=end;
                }
                int curr=(int)s.charAt(start);
                brr[curr]--;
                start++;
                
            }
            
            while(end<n && start<=end-m+1 && !check(arr,brr)){
                end++;
                if(end==n){
                    break;
                }
                int curr=(int)s.charAt(end);
                brr[curr]++;
            }
            
        }
        
        if(min!=n+1){
            return s.substring(ss,e+1);
        }
        
        return "";
        
    }
}
