class Solution {
    public int[][] reconstructQueue(int[][] people) {
        
        int n = people.length;
        
        Arrays.sort(people, new Comparator<int[]>(){
            public int compare(int[] a1, int[] a2){
                if(a1[0] < a2[0]) return -1;
                else if(a1[0] > a2[0]) return 1;
                if(a1[1] < a2[1]) return -1;
                return 1;
            }
        });
        
        int[][] ans = new int[n][2];
        for(int i = 0; i < n; i++) ans[i][0] = -1;
        
        for(int i = 0; i < n; i++){
            int x = people[i][1];
            int count = 0;
            for(int j = 0; j < n; j++){
                if(ans[j][0] == -1 || ans[j][0] >= people[i][0]){
                    count++;
                    if(count == x + 1){
                        ans[j][0] = people[i][0];
                        ans[j][1] = people[i][1];
                        break;
                    }
                }
            }
        }
        
        return ans;
        
    }
}
