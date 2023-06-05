6. Buy and Sell Stock

 public static int maximumProfit(ArrayList<Integer> prices){
        // Write your code here.
         int buyprice= Integer.MAX_VALUE, maxprofit= 0, profit = 0;
        
        for(int i = 0; i < prices.size(); i++){
            if(prices.get(i) < buyprice){
                buyprice= prices.get(i);
            }
            profit= prices.get(i)- buyprice;
            if(maxprofit< profit){
                maxprofit = profit;
            }
        }
        return maxprofit;
    
    }
