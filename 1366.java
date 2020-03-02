class Team {
    int[] votes;
    char teamName;
    Team(char teamName) {
        this.votes = new int[26];
        this.teamName = teamName;
    }
}
class Solution {
    public String rankTeams(String[] votes) {
        int n = votes.length;
        String teams = votes[0];
        Team[] t = new Team[teams.length()];
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < teams.length(); i++) {
            t[i] = new Team(teams.charAt(i));
            map.put(teams.charAt(i), i);
        }
        for(int i = 0; i < n; i++) {
            String curr = votes[i];
            for(int j = 0; j < curr.length(); j++) {
                char c = curr.charAt(j);
                int index = map.get(c);
                t[index].votes[j]++;
            }
        }
        Arrays.sort(t, new Comparator<Team>(){
            public int compare(Team p1, Team p2) {
                for(int j = 0; j < 26; j++) {
                    if(p1.votes[j] > p2.votes[j]) return -1;
                    if(p1.votes[j] < p2.votes[j]) return 1;
                }
                if(p1.teamName < p2.teamName) return -1;
                else if(p2.teamName < p1.teamName) return 1;
                return 0;
            }
        });
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < t.length; i++) ans.append(t[i].teamName);
        return ans.toString();
    }
}
