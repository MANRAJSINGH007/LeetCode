class Solution {
    public boolean isPathCrossing(String path) {
        int n = path.length();
        int x = 0, y = 0;
        HashSet<String> set = new HashSet<>();
        set.add("0;0");
        for(int i = 0; i < n; i++) {
            char ch = path.charAt(i);
            if(ch == 'N') x++;
            else if(ch == 'S') x--;
            else if(ch == 'E') y++;
            else y--;
            String hash = Integer.toString(x) + ";" + Integer.toString(y);
            if(set.contains(hash)) return true;
            set.add(hash);
        }
        return false;
    }
}
