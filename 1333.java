class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        int n = restaurants.length;
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(restaurants[i][3] <= maxPrice && restaurants[i][4] <= maxDistance && (veganFriendly == 0 || restaurants[i][2] == 1)) {
                list.add(new int[]{i, restaurants[i][1], restaurants[i][0]});
            }
        }
        Collections.sort(list, new Comparator<int[]>(){
            public int compare(int[] r1, int[] r2) {
                if(r1[1] > r2[1]) return -1;
                if(r2[1] > r1[1]) return 1;
                if(r1[2] > r2[2]) return -1;
                return 1;
            }
        });
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < list.size(); i++) ans.add(list.get(i)[2]);
        return ans;
    }
}
