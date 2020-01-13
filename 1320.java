class Solution {
    public static int function(String word, int n, int i, int f1x, int f1y, int f2x, int f2y, HashMap<Character, String> map, int[][][][][] dp) {
        if(i == n) return 0;
        if(dp[i][f1x][f1y][f2x][f2y] != -1) return dp[i][f1x][f1y][f2x][f2y];
        char curr = word.charAt(i);
        int currRow = map.get(curr).charAt(0) - '0';
        int currColumn = map.get(curr).charAt(1) - '0';
        int p1 = 0, p2 = 0;
        if(f1x != 5 || f1y != 5) p1 += Math.abs(f1x - currRow) + Math.abs(f1y - currColumn);
        if(f2x != 5 || f2y != 5) p2 += Math.abs(f2x - currRow) + Math.abs(f2y - currColumn);
        p1 += function(word, n, i + 1, currRow, currColumn, f2x, f2y, map, dp);
        p2 += function(word, n, i + 1, f1x, f1y, currRow, currColumn, map, dp);
        return dp[i][f1x][f1y][f2x][f2y] = Math.min(p1, p2);
    }
    public int minimumDistance(String word) {
        int n = word.length();
        HashMap<Character, String> map = new HashMap<>();
        int[][][][][] dp = new int[n][6][6][6][6];
        for(int l = 0; l < n; l++) {
                for(int i = 0; i < 6; i++) {
                for(int j = 0; j < 6; j++) {
                    for(int t = 0; t < 6; t++) {
                        for(int p = 0; p < 6; p++) dp[l][i][j][t][p] = -1;R
                    }
                }
            }
        }
        for(int i = 0; i < 26; i++) {
            char curr = (char)(65 + i);
            int r = (i % 6), c = (i / 6); 
            map.put(curr, Integer.toString(r) + Integer.toString(c));
        }
        return function(word, n, 0, 5, 5, 5, 5, map, dp);
    }
}
