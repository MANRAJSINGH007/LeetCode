class Solution {
    public int[] sortByBits(int[] arr) {
        int n = arr.length;
        List<int[]> brr = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            brr.add(new int[]{arr[i]});
        }
        Collections.sort(brr, new Comparator<int[]>(){
            public int compare(int[] x1, int[] x2) {
                int e1 = x1[0], e2 = x2[0];
                int c1 = 0, c2 = 0;
                while(e1 > 0) {
                    c1 += e1 % 2;
                    e1 /= 2;
                } 
                while(e2 > 0) {
                    c2 += e2 % 2;
                    e2 /= 2;
                }
                if(c1 < c2) return -1;
                if(c2 < c1) return 1;
                if(x1[0] < x2[0]) return -1;
                if(x2[0] < x1[0]) return 1;
                return 0;
            }
        });
        for(int i = 0; i < n; i++) arr[i] = brr.get(i)[0];
        return arr;
    }
}
