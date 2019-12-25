class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] arr = new int[length];
        for(int i = 0; i < updates.length; i++){
            arr[updates[i][0]] += updates[i][2];
            if(updates[i][1] + 1 < length) arr[updates[i][1] + 1] -= updates[i][2];
        }
        int sum = 0;
        for(int i = 0; i < length; i++){
            sum += arr[i];
            arr[i] = sum;
        }
        return arr;
    }
}
