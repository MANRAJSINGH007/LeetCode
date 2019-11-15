class Solution {
    public int[] advantageCount(int[] A, int[] B) {
        int n = A.length;
        if(n == 0) return new int[0];
        int[] sortedA = A.clone();
        int[] sortedB = B.clone();
        Arrays.sort(sortedA);
        Arrays.sort(sortedB);
        
        HashMap<Integer, ArrayList<Integer>> assigned = new HashMap();
        for (int b: B) assigned.put(b, new ArrayList());
        
        ArrayList<Integer> remaining = new ArrayList();

        int j = 0;
        for (int a: sortedA) {
            if (a > sortedB[j]) {
                assigned.get(sortedB[j++]).add(a);
            } else {
                remaining.add(a);
            }
        }

        int[] ans = new int[B.length];
        for (int i = 0; i < B.length; ++i) {
            if (assigned.get(B[i]).size() > 0)
                ans[i] = assigned.get(B[i]).remove(0);
            else
                ans[i] = remaining.remove(0);
        }
        return ans;
        
    }
}
