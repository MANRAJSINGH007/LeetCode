class Solution {
    
    public static boolean searchColumn(int[][] matrix, int n, int m, int index, int target){
        
        int start = 0;
        int end = m-1;
        
        int mid = (start + end)/2;
        
        while(start <= end){
            
            mid = (start + end)/2;
            
            if(matrix[index][mid] == target){
                return true;
            }
            
            else if(matrix[index][mid] <= target){
                start = mid + 1;
            }
            
            else{
                end = mid - 1;
            }
            
        }
        
        return false;
        
    }
    
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int n = matrix.length;
        if(n == 0){
            return false;
        }
        
        int m = matrix[0].length;
        
        if(m == 0){
            return false;
        }
        
        int start = 0;
        int end = n-1;
        
        int mid = (start + end)/2;
        
        while(start <= end){
            
            mid = (start + end)/2;
            
            if(matrix[mid][0] <= target && matrix[mid][m-1] >= target){
                return searchColumn(matrix, n, m, mid, target);
            }
            
            else if(matrix[mid][0] >= target){
                end = mid - 1;
            }
            
            else{
                start = mid + 1;
            }
            
        }
        
        return false;
        
    }
}
