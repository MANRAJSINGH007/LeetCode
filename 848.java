class Solution {
    public String shiftingLetters(String S, int[] shifts) {
        
        int n = S.length();
        long[] aux = new long[n];
        
        for(int i = 0; i < n; i++){
            int amount = shifts[i];
            aux[0] += (long)amount;
            if(i + 1 < n) aux[i + 1] -= (long)amount;
        }

        StringBuilder sb = new StringBuilder();
        long currSum = 0;
        for(int i = 0; i < n; i++){
            currSum += aux[i];
            int shift = (int)(currSum % 26);
            if(shift <= 122 - (int)S.charAt(i)) sb.append((char)((int)S.charAt(i) + shift));
            else{
                shift -= 122 - (int)S.charAt(i);
                sb.append((char)(96 + shift));
            }
        }
        
        return sb.toString();
        
    }
}
