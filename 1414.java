class Solution {
    public int findMinFibonacciNumbers(int k) {
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        ans.add(1);
        int p1 = 1, p2 = 1, curr = 2;
        while(curr <= k) {
            if(curr == k) return 1;
            ans.add(curr);
            p1 = p2;
            p2 = curr;
            curr = p1 + p2;
        }
        int n = ans.size();
        int count = 0;
        for(int i = n - 1; i >= 0; i--) {
            if(k == 0) return count;
            if(ans.get(i) <= k) {
                k -= ans.get(i);
                count++;
            } else continue;
        }
        return -1;
    }
}
