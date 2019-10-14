class Solution {
    
    public static double func(double x, int n){
        boolean flag = false;
        
        if(n < 0){
            flag = true;
            n = -n;
        }
        
        if(n == 0) return (double)1;
        
        double temp = func(x, n/2);
        
        if(temp == 0) return 0;
        
        if(temp == Double.MAX_VALUE){
            if(flag) return 0;
            return temp;
        }
        
        if(temp <= Math.sqrt(Double.MAX_VALUE))
            temp = Math.pow(temp, 2);
        
        else{
            if(flag) return 0;
            return Double.MAX_VALUE;
        }
        
        if(temp <= (Double.MAX_VALUE / x) && n % 2 == 1) temp *= x;
        
        if(flag) temp = (double)(1 / temp);
        
        return temp;
    }
    
    
    public double myPow(double x, int n) {
        
        boolean flag = false;
        
        if(x < 0){
            flag = true;
            x = -x;
        }
        
        double ans = func(x, n);
        if(ans == 0) return ans;
        
        if(n % 2 == 0) return ans;
        
        if(n % 2 == 1 && flag) return -(ans);
        
        return ans;
        
    }
}
