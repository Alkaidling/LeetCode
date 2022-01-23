package leetcode.editor.cn;

import java.util.HashMap;
import java.util.TreeMap;

//5896、股票价格波动
class StockPriceFluctuation {
    public static void main(String[] args) {
        StockPrice solution = new StockPriceFluctuation().new StockPrice();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class StockPrice {

        HashMap<Integer, Integer> map;
        TreeMap<Integer, Integer> mapPrice;
        int cur;

        public StockPrice() {
            cur = -1;
            this.map = new HashMap<>();
            this.mapPrice = new TreeMap<>();
        }

        public void update(int timestamp, int price) {
            cur = Math.max(cur,timestamp);
            if (map.containsKey(timestamp)) { //更新操作
                int lastPrice = map.get(timestamp);
                if (mapPrice.get(lastPrice) == 1) {  //如果只有一个价格是lastPrice，则直接删除
                    mapPrice.remove(lastPrice);
                } else if (mapPrice.get(lastPrice) > 1) {
                    mapPrice.put(lastPrice, mapPrice.get(lastPrice) - 1); //多个价格是lastPrice,删除一个，然后val-1
                }
            }
            mapPrice.put(price,mapPrice.getOrDefault(price,0) + 1);  //防止覆盖，如果由重复价钱则val+1
            map.put(timestamp, price);
        }

        public int current() {
            return map.get(cur);
        }

        public int maximum() {
            return mapPrice.lastKey();
        }

        public int minimum() {
            return mapPrice.firstKey();
        }
    }

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */
//leetcode submit region end(Prohibit modification and deletion)

}