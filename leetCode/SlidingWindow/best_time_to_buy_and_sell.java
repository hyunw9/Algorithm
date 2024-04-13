package leetCode.SlidingWindow;

public class best_time_to_buy_and_sell {

  public int maxProfit(int[] prices) {
    int minprice =Integer.MAX_VALUE;
    int maxProfit = 0;
    for(int price : prices){
      minprice = Math.min(minprice,price);
      maxProfit = Math.max(maxProfit,price-minprice);
    }
    return maxProfit;
  }

}
