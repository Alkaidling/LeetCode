package leetcode.editor.cn;

import java.util.Arrays;

//1833、雪糕的最大数量
class MaximumIceCreamBars {
    public static void main(String[] args) {
        Solution solution = new MaximumIceCreamBars().new Solution();
        int[] costs = {1, 6, 3, 1, 2, 5};
        int i = solution.maxIceCream(costs, 7);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //排序后从最便宜的开始买 O(nlogn)
        public int maxIceCream(int[] costs, int coins) {
            Arrays.sort(costs);
            int num = 0;
            for (int i = 0; i < costs.length; i++) {
                if (coins >= costs[i]) {
                    num++;
                    coins -= costs[i];
                } else {
                    break;
                }
            }
            return num;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}