class StockSpanner {
    class Pair{
        int x;
        int span;
        Pair(int price,int span){
            this.x = price;
            this.span = span;
        }
    }
    
    Stack<Pair> st;
    public StockSpanner() {
        st = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1;
        while(!st.isEmpty() && st.peek().x <= price){
            Pair p = st.pop();
            span += p.span;
        }
        st.push(new Pair(price,span));
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */