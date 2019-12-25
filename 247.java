class Solution {
    static List<String> ans;
    static char[] st = {'0', '1', '6', '8', '9'};
    static char[] end = {'0', '1', '9', '8', '6'};
    public static void generate(char[] ch, int i, int j){
        if(i > j){
            ans.add(new String(ch));
            return;
        }
        if(i == j){
            for(int k = 0; k < 4; k++){
                if(k == 2 || i == 0 && k == 0 && j != 0) continue;
                ch[i] = st[k];
                ch[j] = end[k];
                generate(ch, i + 1, j - 1);
            }
            return;
        }
        for(int k = 0; k < 5; k++){
            if(i == 0 && k == 0 && j != 0) continue;
            ch[i] = st[k];
            ch[j] = end[k];
            generate(ch, i + 1, j - 1);
        }
        
        return;
    }
    public List<String> findStrobogrammatic(int n) {
        ans = new ArrayList<>();
        generate(new char[n], 0, n - 1);
        return ans;
    }
}
