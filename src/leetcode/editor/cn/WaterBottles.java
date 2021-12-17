package leetcode.editor.cn;

import java.util.*;

//1518、换酒问题
class WaterBottles {
    public static void main(String[] args) {
        Solution solution = new WaterBottles().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numWaterBottles(int numBottles, int numExchange) {
            int res = numBottles;
            while (numBottles >= numExchange) {
                res += numBottles / numExchange;
                numBottles = numBottles / numExchange + numBottles % numExchange;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}