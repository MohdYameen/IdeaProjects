package DSA;

public class BuyAndSellStocks {

    /*

    profit = selling price - buying price
    set buying price as  Max integer
    if buying price is less than todays price => profit = today's proce - buying price

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

    public static void main(String[] args) {
        int [] price_day = {7,1,5,3,6,4};
        maxProfitInStocks(price_day);
    }
}
