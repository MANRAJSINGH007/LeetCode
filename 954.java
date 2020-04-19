class Solution {
    public boolean canReorderDoubled(int[] A) {
        int n = A.length;
        Arrays.sort(A);
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            if(A[i] % 2 == 0 && map.containsKey(A[i] / 2)) {
                int count = map.get(A[i]/2);
                count--;
                if(count > 0) map.put(A[i] / 2, count);
                else map.remove(A[i] / 2);
            } else if(map.containsKey(A[i] * 2)) {
                int count = map.get(A[i] * 2);
                count--;
                if(count > 0) map.put(A[i] * 2, count);
                else map.remove(A[i] * 2);
            } else {
                if(!map.containsKey(A[i])) map.put(A[i], 1);
                else map.put(A[i], map.get(A[i]) + 1);
            }
        }
        return map.size() == 0;
    }
}
