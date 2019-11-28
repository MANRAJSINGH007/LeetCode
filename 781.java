class Solution {
    public int numRabbits(int[] answers) {
        
        int n = answers.length;
        if(n == 0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        
        for(int i = 0; i < n; i++){
            if(answers[i] == 0){
                count++;
                continue;
            } else if(map.containsKey(answers[i])){
                int c = map.get(answers[i]);
                c++;
                if(c == answers[i] + 1) map.remove(answers[i]);
                else map.put(answers[i], c);
            } else{
                count += answers[i] + 1;
                map.put(answers[i], 1);
            }
        }
        
        return count;
        
    }
}
