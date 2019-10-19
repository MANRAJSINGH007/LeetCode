class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        
        int n1 = slots1.length;
        int n2 = slots2.length;
        
        Arrays.sort(slots1, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });
        
        Arrays.sort(slots2, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });
        
        int i1 = 0;
        int i2 = 0;
        
        List<Integer> ans = new ArrayList<>();
        
        while(i1 < n1 && i2 < n2){
            
            int[] t1 = slots1[i1];
            int[] t2 = slots2[i2];
            int st = Math.max(t1[0], t2[0]);
            int end = Math.min(t1[1], t2[1]);
            
            if(end - st >= duration){
                ans.add(st);
                ans.add(st + duration);
                return ans;
            }
            
            if(t1[1] < t2[1]) i1++;
            
            else if(t1[1] > t2[1]) i2++;
            
            else{
                if(t1[0] < t2[0]) i1++;
                else i2++;
            }
            
        }
        
        return ans;
        
    }
}
