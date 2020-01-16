class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        
        int arr[]=new int[3];
        arr[0] = a;
        arr[1] = b;
        arr[2] = c;
        Arrays.sort(arr);
        
        int x = arr[0];
        int y = arr[1];
        int z = arr[2];
        
        int min = 0;
        int max = z - y - 1 + y - x - 1;
        
        while(true){
            
            if(y==x+1 && z==y+1){
                break;
            }
            
            if(y==x+1){
                min+=1;
                break;
            }
            if(z==y+1){
                min+=1;
                break;
            }
            
            if(y-x>z-y){
                x=y;
                y=y+1;
            }
            else{
                y=y-1;
                z=y+1;   
            }
            min++;
        }
        
        int ans[]={min, max};
        return ans;
        
    }
}
