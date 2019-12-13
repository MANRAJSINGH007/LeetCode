class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        
        int n = A.length;
        int count = 0;
        HashMap<Integer, HashMap<Long, Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++) map.put(i, new HashMap<>());
        
        for(int i = n - 2; i >= 0; i--){
            HashMap<Long, Integer> curr = map.get(i);
            for(int j = n - 1; j > i; j--){
                long diff = (long)A[j] - (long)A[i];
                int c = 1;
                if(curr.containsKey(diff)) c += curr.get(diff);
                curr.put(diff, c);
            }
        }
        
        for(int i = n - 3; i >= 0; i--){
            HashMap<Long, Integer> curr = map.get(i);
            for(int j = n - 1; j > i; j--){
                long diff = (long)A[j] - (long)A[i];
                HashMap<Long, Integer> child = map.get(j);
                int temp = 0;
                if(child.containsKey(diff)) temp = child.get(diff);
                count += temp;
                int c = curr.get(diff);
                c += temp;
                curr.put(diff, c);
            }
        }
        
        return count;
        
    }
}
