package leetcode.editor.cn;

import java.util.*;

//825、适龄的朋友
class FriendsOfAppropriateAges {
    public static void main(String[] args) {
        Solution solution = new FriendsOfAppropriateAges().new Solution();
        int[] ages = {20,30,100,110,120};
        System.out.println(solution.numFriendRequests(ages));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numFriendRequests(int[] ages) {
            Arrays.sort(ages);
            int n = ages.length;
            int res = 0;
            int left = 0, right = 0;
            for (int age : ages) {
                if (age < 15) {
                    continue;
                }
                while (ages[left] <= 0.5 * age + 7) {
                    left++;
                }
                while (right + 1 < n && ages[right + 1] <= age) {
                    right++;
                }
                res += right - left;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}