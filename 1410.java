class Solution {
    public String entityParser(String text) {
        int n = text.length();
        String[] key = {"&quot", "&apos", "&amp", "&gt", "&lt", "&frasl"};
        String[] value = {"\"", "'", "&", ">", "<", "/"};
        String[] arr = text.split(";");
        String ans = "";
        outer : for(int i = arr.length - 1; i > -1; i--) {
            for(int j = 0; j < 6; j++) {
                String k = key[j];
                if(arr[i].length() >= k.length() && arr[i].substring(arr[i].length() - k.length()).equals(k)) {
                    ans = arr[i].substring(0, arr[i].length() - k.length()) + value[j] + ans;
                    continue outer;
                }
            }
            if(i != arr.length - 1) ans = arr[i] + ";" + ans;
            else ans = arr[i] + ans;
        }
        return ans;
    }
}
