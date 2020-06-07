class BrowserHistory {
    static List<String> list;
    int i;
    int j;
    public BrowserHistory(String homepage) {
        list = new ArrayList<>();
        list.add(homepage);
        i = 0;
        j = 0;
    }
    
    public void visit(String url) {
        if(i < list.size() - 1) list.set(i + 1, url);
        else list.add(url);
        i++;
        j = i;
    }
    
    public String back(int steps) {
        i = Math.max(0, i - steps);
        return list.get(i);
    }
    
    public String forward(int steps) {
        i = Math.min(j, i + steps);
        return list.get(i);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
