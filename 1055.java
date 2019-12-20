class Solution {
    public int shortestWay(String source, String target) {
        int n = source.length();
        int m = target.length();
        int i = 0;
        int count = 0;
        while(i < m){
            int index = i;
            int j = 0;
            int flag = 0;
            while(i < m && j < n){
                if(source.charAt(j) == target.charAt(i)){
                    flag = 1;
                    i++;
                }
                j++;
            }
            if(flag == 0) return -1;
            if(index != i) count++;
        }
        
        return count;
    }
}
