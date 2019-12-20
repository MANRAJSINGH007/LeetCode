class Solution {
    public String removeVowels(String S) {
        int n = S.length();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            char c = S.charAt(i);
            if(c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u') sb.append(c);
        }
        
        return sb.toString();
    }
}
