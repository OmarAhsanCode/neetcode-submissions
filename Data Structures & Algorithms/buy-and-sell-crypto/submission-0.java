
class Solution {
    public int maxProfit(int[] prices) {
        int l=0;
        int r=0;
        int max_profit=0;
        while(r<prices.length)
        {
            while(r < prices.length && prices[l]<=prices[r])
            {
                int profit = prices[r]-prices[l];
                max_profit= Math.max(max_profit,profit);
                r++;
            }
            l++;
        }
        return max_profit;
    }
}
