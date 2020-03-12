class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();
        outer : for(int i = left; i <= right; i++) {
            int temp = i;
            while(temp > 0) {
                int r = temp % 10;
                if(r == 0 || i % r != 0) continue outer;
                temp /= 10;
            }
            ans.add(i);
        }
        return ans;
    }
}
