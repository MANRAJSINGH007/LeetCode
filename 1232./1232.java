class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        
        int n = coordinates.length;
        
        double diff = ((double)1 * (coordinates[1][1] - coordinates[0][1])) / ((double)1 * (coordinates[1][0] - coordinates[0][0]));
        
        for(int i = 1; i < n - 1; i++){
            
            double temp = ((double)1 * (coordinates[i + 1][1] - coordinates[i][1])) / ((double)1 * (coordinates[i + 1][0] - coordinates[i][0]));
            if(temp != diff) return false;
            
        }
        
        return true;
        
    }
}
