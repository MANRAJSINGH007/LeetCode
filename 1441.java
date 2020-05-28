class Solution {
    public List<String> buildArray(int[] target, int n) {
        int i = 1, j = 0;
        List<String> ans = new ArrayList<>();
        while(j < target.length) {
            while(i < n && j < target.length && i < target[j]) {
                ans.add("Push");
                ans.add("Pop");
                i++;
            }
            ans.add("Push");
            i++;
            j++;
        }
        return ans;
    }
}
