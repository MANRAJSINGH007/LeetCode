class Solution {
    public List<String> printVertically(String s) {
        String[] aux = s.split(" ");
        int n = aux.length;
        List<String> ans = new ArrayList<>();
        int c = 0;
        while(true) {
            StringBuilder sb = new StringBuilder();
            int flag = 0;
            int index = 0;
            for(int i = 0; i < n; i++) {
                if(c < aux[i].length()) {
                    sb.append(aux[i].charAt(c));
                    flag = 1;
                    index = i;
                } else sb.append(" ");
                
            }
            if(flag == 0) {
                return ans;
            }
            ans.add(sb.toString().substring(0, index + 1));
            c++;
        }
    }
}
