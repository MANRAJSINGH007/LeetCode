class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < ppid.size(); i++){
            if(!map.containsKey(ppid.get(i))) map.put(ppid.get(i), new ArrayList<>());
            map.get(ppid.get(i)).add(pid.get(i));
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(kill);
        while(q.size() > 0){
            int process = q.remove();
            ans.add(process);
            if(map.containsKey(process)){
                List<Integer> t = map.get(process);
                for(int i = 0; i < t.size(); i++) q.add(t.get(i));
            }
        }
        return ans;
    }
}
