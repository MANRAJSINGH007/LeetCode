class Solution {
    public boolean checkPerfectNumber(int num) {
        if(num == 0) return false;
        int sum = -num;
        for(int i = 1; i <= (int)Math.sqrt(num); i++) {
            if(num % i == 0) sum += i + num / i;
            if(i * i == num) sum -= i;
        }
        return sum == num;
    }
}
