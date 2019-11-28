class Solution {
    public int[] distributeCandies(int candies, int n) {
        
        int[] ans = new int[n];
        int i = 0;
        int sum = 0;
        
        while(true){
            int t = ((int)Math.pow(n, 2) * i) + (n * (n + 1))/2;
            if(sum + t > candies) break;
            sum += t;
            i++;
        }
        
        i--;
        
        for(int j = 0; j < n; j++){
            ans[j] = (i + 1) * (j + 1) + (i * n * (i + 1))/2; 
        }
        
        i++;
        // System.out.println(i + " " + candies + " " + sum);
        candies -= sum;
        int start = n * i + 1;
        int j = 0;
        while(candies >= start){
            ans[j] += start;
            candies -= start;
            start++;
            j++;
        }
        
        if(candies > 0) ans[j] += candies;
        
        return ans;
        
    }
}
