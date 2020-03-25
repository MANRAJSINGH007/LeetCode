class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        for(int i = 0; i < n; i++) ans.add(index[i], nums[i]);
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = ans.get(i);
        return arr;
    }
}
