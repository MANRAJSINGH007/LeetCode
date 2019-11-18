class Solution {
    public int findLongestChain(int[][] pairs) {
        
        int n = pairs.length;
        if(n <= 1) return n;
        
        Arrays.sort(pairs, new Comparator<int[]>(){
            public int compare(int[] a1, int[] a2){
                if(a1[1] < a2[1]) return -1;
                else if(a1[1] > a2[1]) return 1;
                else if(a1[0] <= a2[0]) return -1;
                return 1;
            }
        });
        
        int count = 1;
        int prevEnd = pairs[0][1];
        for(int i = 1; i < n; i++){
            if(pairs[i][0] <= prevEnd) continue;
            count++;
            prevEnd = pairs[i][1];
        }
        
        return count;
        
    }
}
