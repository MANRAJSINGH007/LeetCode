class Solution {
    public boolean checkRecord(String s) {
        int n = s.length();
        boolean absent = false;
        int lateCount = 0;
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == 'P'){
                lateCount = 0;
                continue;
            }
            if(s.charAt(i) == 'A'){
                if(absent) return false;
                absent = true;
                lateCount = 0;
                continue;
            }
            if(lateCount == 2) return false;
            lateCount++;
        }
        
        return true;
    }
}
