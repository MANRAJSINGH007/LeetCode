/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        
        long start = 1;
        long end = (long)n;
        long mid = (start + end)/2;
        
        while(start <= end){
            mid = (start + end)/2;
            int ans = guess((int)mid);
            if(ans == 0) return (int)mid;
            if(ans == -1) end = (int)mid - 1;
            else start = (int)mid + 1;
        }
        
        return -1;
    }
}
