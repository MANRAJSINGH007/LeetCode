class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] x = sentence.split(" ");
        int n = x.length;
        for(int i = 0; i < n; i++) {
            String word = x[i];
            int j = 0, k = 0;
            while(j < word.length() && k < searchWord.length() && word.charAt(j) == searchWord.charAt(j)) {
                j++;
                k++;
            }
            if(k == searchWord.length()) return i + 1;
        }
        return -1;
    }
}
