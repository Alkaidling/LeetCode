package leetcode.editor.cn;

import java.util.*;

//846、一手顺子
class HandOfStraights {
    public static void main(String[] args) {
        Solution solution = new HandOfStraights().new Solution();
        System.out.println(solution.isNStraightHand(new int[]{8,10,12}, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean isNStraightHand(int[] hand, int groupSize) {
            if (groupSize == 1) {
                return true;
            }
            int n = hand.length;
            if (n % groupSize != 0) {
                return false;
            }
            Arrays.sort(hand);
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i : hand) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
            for (int i : hand) {
                if (!map.containsKey(i)) {
                    continue;
                }
                for (int j = 0; j < groupSize; j++) {
                    int num = i + j;
                    if (!map.containsKey(num)) {
                        return false;
                    }
                    map.put(num, map.get(num) - 1);
                    if (map.get(num) == 0) {
                        map.remove(num);
                    }
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}