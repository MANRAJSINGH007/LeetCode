class Solution {
    public double angleClock(int hour, int minutes) {
        double ans = (Math.abs(hour * 5 - minutes)) * 6.0;
        if(hour * 5 >= minutes) ans += (1.0 * minutes) / (2.0);
        else ans -= (1.0 * minutes) / (2.0);
        return Math.abs(Math.min(ans, 360 * 1.0 - ans));
    }
}
