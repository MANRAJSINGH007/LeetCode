class Solution {
    static double x;
    static double y;
    static double r;
    public Solution(double radius, double x_center, double y_center) {
        x = x_center;
        y = y_center;
        r = radius;
    }
    public double getRandom(double max) {
        return Math.random() * max;
    }
    public double[] randPoint() {
        double[] ans = new double[2];
        double angle = getRandom(2 * Math.PI);
        double l = Math.sqrt(getRandom(1)) * r;
        ans[0] = x + l * Math.cos(angle);
        ans[1] = y + l * Math.sin(angle);
        return ans;
    }
}
