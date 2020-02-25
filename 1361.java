class Solution {
    public static int getParent(int[] par, int i) {
        if(par[i] == i) return i;
        return par[i] = getParent(par, par[i]);
    }
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] par = new int[n];
        for(int i = 0; i < n; i++) par[i] = i;
        for(int i = 0; i < n; i++) {
            int currParent = i;
            int l = leftChild[i];
            int r = rightChild[i];
            int p2 = getParent(par, i);
            if(l != -1) {
                int p1 = getParent(par, l);
                if(p1 == p2) return false;
                par[l] = i;
            }
            if(r != -1) {
                int p1 = getParent(par, r);
                if(p1 == p2) return false;
                par[r] = i;
            }
        }
        int count = 0;
        for(int i = 0; i < n; i++) {
            if(par[i] == i) {
                count++;
                if(count == 2) return false;
            }
        }
        return true;
    }
}
