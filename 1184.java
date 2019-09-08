class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        
        if(start == destination){
            return 0;
        }
        
        int n = distance.length;
        
        int min = 0;
        
        int curr = start;
        
        while(curr != destination){
            
            min += distance[curr];
            curr++;
            curr = curr % n;
        }
        
        curr = start;
        
        int back = 0;
        
        while(curr != destination){
            curr--;
            if(curr == -1){
                curr = n - 1;
            }
            back += distance[curr];
        }
        
        min = Math.min(min, back);

        return min;
        
    }
}
