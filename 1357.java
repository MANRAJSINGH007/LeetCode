class Cashier {
    static int n;
    static int discount;
    static HashMap<Integer, Integer> prices;
    static int counter;
    public Cashier(int n, int discount, int[] products, int[] prices) {
        this.prices = new HashMap<>();
        this.n = n;
        counter = n;
        this.discount = discount;
        for(int i = 0; i < prices.length; i++) this.prices.put(products[i], prices[i]);
    }
    
    public double getBill(int[] product, int[] amount) {
        counter--;
        double ans = 0;
        for(int i = 0; i < product.length; i++) {
            ans += prices.get(product[i]) * amount[i];
        }
        boolean disc = false;
        if(counter == 0) {
            counter = n;
            disc = true;
            ans -= (discount * ans) / (100.0);
        }
        return ans;
    }
}
