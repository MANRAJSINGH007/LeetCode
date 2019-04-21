class StreamChecker {
    
    HashMap<String,Integer> map;
    ArrayList<String> list;

    public StreamChecker(String[] words) {
        
        map=new HashMap<>();
        list=new ArrayList<String>();
        for(int i=0;i<words.length;i++){
            map.put(words[i],1);
        }
        
    }
    
    public boolean query(char letter) {
        
        int flag=0;
        
        for(int i=0;i<list.size();i++){
            String word=list.get(i)+letter;
            list.set(i,word);
            if(map.size()!=0 && (map.containsKey(word) || map.containsKey(Character.toString(letter)))){
                flag=1;
            }
        }
        
        list.add(Character.toString(letter));
        if(flag==1){
            return true;
        }
        return false;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
