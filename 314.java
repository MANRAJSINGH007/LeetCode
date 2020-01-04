class Solution {
    static HashMap<Integer, HashMap<Integer, List<Integer>>> map;
    static int levelMax;
    static int l;
    static int r;
    public static void dfs(TreeNode root, int x, int y) {
        if(root == null) return;
        dfs(root.left, x - 1, y + 1);
        levelMax = Math.max(levelMax, y);
        l = Math.min(l, x);
        r = Math.max(r, x);
        if(!map.containsKey(x)) map.put(x, new HashMap<>());
        HashMap<Integer, List<Integer>> temp = map.get(x);
        if(!temp.containsKey(y)) temp.put(y, new ArrayList<>());
        temp.get(y).add(root.val);
        dfs(root.right, x + 1, y + 1);
    }
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        levelMax = 0;
        l = 0;
        r = 0;
        map = new HashMap<>();
        dfs(root, 0, 0);
        for(int p = l; p <= r; p++) {
            List<Integer> li = new ArrayList<>();
            HashMap<Integer, List<Integer>> m2 = map.get(p);
            for(int i = 0; i <= levelMax; i++) {
                if(m2.containsKey(i)) {
                    for(int j = 0; j < m2.get(i).size(); j++) {
                        li.add(m2.get(i).get(j));
                    }
                }
            }
            ans.add(li);
        }
        return ans;
    }
}
