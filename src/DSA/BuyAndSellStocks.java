package DSA;

public class BuyAndSellStocks {

    /*

    profit = selling price - buying price
    set buying price as  Max integer
    if buying price is less than todays price => profit = today's price - buying price

    buying price  = min(todays' price and  buying price )


     */


    public static void maxProfitInStocks(int []a){
        int min_buy_price = Integer.MAX_VALUE;
        int max_profit = 0;

        for(int i=0;i<a.length;i++){
            int profit = 0;

            if(min_buy_price < a[i]){
                profit = a[i]- min_buy_price;
                max_profit = Math.max(profit, max_profit);
            } else {
                min_buy_price = a[i];
            }
        }
        System.out.println(max_profit);
    }

    public static int bullAndSell(int [] arr){
        int min = arr[0];
        int maxProfit = 0;
        for(int i=1; i<arr.length; i++){
            int cost = arr[i]-min;
            maxProfit = Math.max(maxProfit, cost);
            min = Math.min(min, arr[i]);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int [] price_day = {7,1,5,3,6,4};
        maxProfitInStocks(price_day);
        System.out.println("New approach "+ bullAndSell(price_day));
    }
}
