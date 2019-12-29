class Solution {
    public static void dfs(TreeNode root, List<Integer> l){
        if(root == null) return;
        dfs(root.left, l);
        l.add(root.val);
        dfs(root.right, l);
        return;
    }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> ans = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        dfs(root1, l1);
        dfs(root2, l2);
        int i1 = 0, i2 = 0;
        while(i1 < l1.size() || i2 < l2.size()){
            if(i2 == l2.size() || i1 < l1.size() && l1.get(i1) <= l2.get(i2)){
                ans.add(l1.get(i1));
                i1++;
            } else if(i2 < l2.size()){
                ans.add(l2.get(i2));
                i2++;
            }
        }
        return ans;
    }
}
