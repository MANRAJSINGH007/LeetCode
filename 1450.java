class Solution {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int[] aux = new int[1001];
        for(int i = 0; i < startTime.length; i++) {
            aux[startTime[i]]++;
            if(endTime[i] < 1000) aux[endTime[i] + 1]--;
        }
        int s = 0;
        for(int i = 0; i <= queryTime; i++) s += aux[i];
        return s;
    }
}
