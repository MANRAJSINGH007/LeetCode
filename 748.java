class Solution {
    public static boolean check(int[] arr, String word) {
        int[] brr = new int[26];
        for(int j = 0; j < word.length(); j++) brr[word.charAt(j) - 97]++;
        for(int j = 0; j < 26; j++) if(brr[j] < arr[j]) return false;
        return true;
    }
    public String shortestCompletingWord(String licensePlate, String[] words) {
        String[] aux = licensePlate.split("");
        int[] arr = new int[26];
        for(int i = 0; i < aux.length; i++) {
            for(int j = 0; j < aux[i].length(); j++) {
                char ch = aux[i].charAt(j);
                int ascii = (int)ch;
                if(ascii >= 97 && ascii <= 122) arr[ascii - 97]++;
                else if(ascii >= 65 && ascii <= 90) arr[ascii - 65]++;
            }
        }
        String ans = "";
        for(int i = 0; i < words.length; i++) {
            String word = words[i];
            if(check(arr, word)) {
                if(ans.equals("") || ans.length() > word.length()) ans = word;
            }
        }
        return ans;
    }
}
