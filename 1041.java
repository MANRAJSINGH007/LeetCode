class Solution {
    public boolean isRobotBounded(String instructions) {
        
        int x=0;
        int y=0;
        int direction=0;
        
        for(int i=0;i<5;i++){
            
            for(int k=0;k<instructions.length();k++){
                char curr=instructions.charAt(k);
                if(curr=='G'){
                    if(direction==0){
                        y+=1;
                    }
                    else if(direction==1){
                        x-=1;
                    }
                    else if(direction==2){
                        y-=1;
                        
                    }
                    else if(direction==3){
                        x+=1;   
                    }
                }
                else if(curr=='L'){
                    direction=(direction+1)%4;
                }
                else{
                    if(direction==0){
                        direction=3;
                    }
                    else
                        direction=(direction-1)%4;
                }
            }
            
            if(x==0 && y==0){
                return true;
            }
        }
        
        return false;
        
    }
}
