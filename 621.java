class Solution {
    public int leastInterval(char[] tasks, int interval) {
        
        int n = tasks.length;
        int[] arr = new int[26];
        int[] prev = new int[26];
        
        for(int i = 0; i < n; i++) arr[(int)tasks[i] - 65] ++;
        for(int i = 0; i < 26; i++) prev[i] = -interval - 5;
        
        int count = 0;
       
        for(int i = 0; ; i++){
            int max = 0;
            int index = -1;
            int c = 0;
            for(int j = 0; j < 26; j++){
                if(arr[j] != 0 && i > prev[j] + interval){
                    if(arr[j] > max){
                        index = j;
                        max = arr[j];
                    }
                }
                else if(arr[j] == 0) c ++;
            }
            
            if(c == 26) return count;
            if(index == -1) count ++;
            else{
                arr[index] --;
                prev[index] = i;
                count ++;
            }
        }
        
    }
}
