package leetcode.editor.cn;

import java.util.HashSet;

//575、分糖果
class DistributeCandies {
    public static void main(String[] args) {
        Solution solution = new DistributeCandies().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int distributeCandies(int[] candyType) {
            HashSet<Integer> set = new HashSet<>();
            for (int candy : candyType) {
                set.add(candy);
            }
            int n = candyType.length;
            int m = set.size();
            if (m <= n / 2) {
                return m;
            } else {
                return n / 2;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}