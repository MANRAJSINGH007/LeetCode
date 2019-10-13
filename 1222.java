class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        
        int n = queens.length;
        
        boolean[][] aux = new boolean[8][8];
        
        for(int i = 0; i < n; i++){
            aux[queens[i][0]][queens[i][1]] = true;
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        
        while(true){
            for(int r = king[0] - 1; r >= 0; r--){
                if(aux[r][king[1]]){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(r);
                    temp.add(king[1]);
                    ans.add(temp);
                    break;
                }
            }
            for(int r = king[0] + 1; r < 8; r++){
                if(aux[r][king[1]]){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(r);
                    temp.add(king[1]);
                    ans.add(temp);
                    break;
                }
            }
            
            for(int c = king[1] - 1; c >= 0; c--){
                if(aux[king[0]][c]){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(king[0]);
                    temp.add(c);
                    ans.add(temp);
                    break;
                }
            }
            
            for(int c = king[1] + 1; c < 8; c++){
                if(aux[king[0]][c]){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(king[0]);
                    temp.add(c);
                    ans.add(temp);
                    break;
                }
            }
            
            int i1 = king[0] - 1;
            int i2 = king[1] - 1;
            
            while(i1 >= 0 && i2 >= 0){
                if(aux[i1][i2]){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i1);
                    temp.add(i2);
                    ans.add(temp);
                    break;
                }
                i1--;
                i2--;
            }
            
            i1 = king[0] - 1;
            i2 = king[1] + 1;
            
            while(i1 >= 0 && i2 < 8){
                if(aux[i1][i2]){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i1);
                    temp.add(i2);
                    ans.add(temp);
                    break;
                }
                i1--;
                i2++;
            }
            
            i1 = king[0] + 1;
            i2 = king[1] - 1;
            
            while(i1 < 8 && i2 >= 0){
                if(aux[i1][i2]){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i1);
                    temp.add(i2);
                    ans.add(temp);
                    break;
                }
                i1++;
                i2--;
            }
            
            i1 = king[0] + 1;
            i2 = king[1] + 1;
            
            while(i1 < 8 && i2 < 8){
                if(aux[i1][i2]){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i1);
                    temp.add(i2);
                    ans.add(temp);
                    break;
                }
                i1++;
                i2++;
            }
            
            break;
        }
        
        return ans;
        
    }
}
