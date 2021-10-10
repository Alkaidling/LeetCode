package leetcode.editor.cn;

import java.util.TreeMap;

//5896、股票价格波动
class StockPriceFluctuation {
    public static void main(String[] args) {
        StockPrice solution = new StockPriceFluctuation().new StockPrice();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class StockPrice {

        TreeMap<Integer, Integer> map;
        TreeMap<Integer, Integer> mapPrice;
        int maxPrice, minPrice;

        public StockPrice() {
            this.map = new TreeMap<>();
            this.mapPrice = new TreeMap<>();
            this.maxPrice = 0;
            this.minPrice = Integer.MAX_VALUE;
        }

        public void update(int timestamp, int price) {
            if (map.containsKey(timestamp)) { //更新操作
                int lastPrice = map.get(timestamp);
                if (mapPrice.get(lastPrice) == 1) {  //如果只有一个价格是lastPrice，则直接删除
                    mapPrice.remove(lastPrice);
                } else if (mapPrice.get(lastPrice) > 1) {
                    mapPrice.put(lastPrice, mapPrice.get(lastPrice) - 1); //多个价格是lastPrice,删除一个，然后val-1
                }
            }
            mapPrice.put(price, mapPrice.get(price) == null ? 1 : mapPrice.get(price) + 1);  //防止覆盖，如果由重复价钱则val+1

            maxPrice = mapPrice.lastKey();
            minPrice = mapPrice.firstKey();

            map.put(timestamp, price);
        }

        public int current() {
            return map.get(map.lastKey());
        }

        public int maximum() {
            return maxPrice;
        }

        public int minimum() {
            return minPrice;
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