import java.util.*;

class Solution {
    class Stock implements Comparable<Stock> {
        int price;
        int index;
        
        public Stock(int price, int index) {
            this.price = price;
            this.index = index;
        }
        
        @Override
        public int compareTo(Stock o) {
            return o.price - this.price;
        }
    }
    
    public int[] solution(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];
        
        PriorityQueue<Stock> pq = new PriorityQueue<>();
        
        for(int i = 0; i < len; i++) {
            pq.offer(new Stock(prices[i], i));
            while(pq.peek().price > prices[i]) {
                Stock stock = pq.poll();
                answer[stock.index] = i - stock.index;
            }
        }
        
        while(!pq.isEmpty()) {
            Stock stock = pq.poll();
            answer[stock.index] = len - stock.index - 1;
        }
        
        
        
        return answer;
    }
}