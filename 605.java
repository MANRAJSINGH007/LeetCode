class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        
        int m = flowerbed.length;
        
        int count = 0;
        
        int i = 0;
        int prev = -10;
        
        while(i < m){
            
            if(flowerbed[i] == 1){
                prev = i;
                i++;
            }
            
            else{
                if(i == 0){
                    if(i == m - 1){
                        prev = i;
                        count++;
                        i++;
                    }
                    
                    else if(i + 1 < m && flowerbed[i + 1] == 1){
                        i++;
                    }
                    
                    else{
                        prev = i;
                        count++;
                        i++;
                    }
                }
                
                else if(prev == i - 1){
                    i++;
                }
                
                else{
                    if(i == m - 1){
                        prev = i;
                        count++;
                        i++;
                    }
                    
                    else if(i + 1 < m && flowerbed[i + 1] == 1){
                        i++;
                    }
                    
                    else{
                        prev = i;
                        count++;
                        i++;
                    }
                }
            }
            
            
        }
        
        return count >= n;
        
    }
}
