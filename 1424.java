class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int k = 0;
        int max = 0;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < nums.size(); i++) {
            for(int j = 0; j < nums.get(i).size(); j++) {
                if(!map.containsKey(i + j)) map.put(i + j, new ArrayList<>());
                map.get(i + j).add(0, nums.get(i).get(j));
                k++;
                max = Math.max(i + j, max);
            }
        }
        int[] ans = new int[k];
        int it = 0;
        for(int i = 0; i <= max; i++) {
            for(int j = 0; j < map.get(i).size(); j++) {
                ans[it++] = map.get(i).get(j);
            }
        }
        return ans;
    }
}
