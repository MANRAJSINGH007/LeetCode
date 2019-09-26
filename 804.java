class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        
        int n = words.length;
        
        String[] morse_code = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        HashSet<String> set = new HashSet<>();
        
        for(int i = 0; i < n; i++){
            String curr = words[i];
            String temp = "";
            for(int j = 0; j < curr.length(); j++){
                temp += morse_code[(int)(curr.charAt(j)) - 97];
            }
            set.add(temp);
        }
        
        return set.size();
    }
}
