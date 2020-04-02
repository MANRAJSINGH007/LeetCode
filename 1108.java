class Solution {
    public String defangIPaddr(String address) {
        int n = address.length();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            char curr = address.charAt(i);
            if(curr != '.') sb.append(curr);
            else sb.append("[.]");
        }
        return sb.toString();
    }
}
