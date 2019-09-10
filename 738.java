class Solution {
    public int monotoneIncreasingDigits(int n) {
        
        if(n < 10){
            return n;
        }
        
        String str = Integer.toString(n);
        
        int m = str.length();
        
        int arr[] = new int[m];
        
        for(int i = 0; i < m; i++){
            int digit = Integer.parseInt("" + str.charAt(i));
            arr[i] = digit;
        }
        
        int index = -1;
        int flag = 0;
        
        for(int i = 0; i < m - 1; i++){
            if(arr[i] > arr[i+1]){
                flag = 1;
                index = i;
                break;
            }
        }
        
        if(flag == 0){
            return n;
        }
        
        int pointer = index;
        int flag2 = 0;
        
        while(index >= 1 && arr[index] == arr[index - 1]){
            index--;
            flag2 = 1;
        }
        
        if(flag2 == 1){
            arr[index]--;
        }
        
        else{
            arr[pointer]--;
            index = pointer;
        }
        
        String ans = "";
        
        int j = 0;
        while(j < m && arr[j] == 0){
            j++;
        }
        
        
        for(int i = j; i <= index; i++){
            ans += Integer.toString(arr[i]);
        }
        
        for(int i = index + 1; i < m; i++){
            ans += Integer.toString(9);
        }
        
        return Integer.parseInt(ans);
        
    }
}
