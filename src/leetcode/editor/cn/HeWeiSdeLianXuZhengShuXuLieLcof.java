package leetcode.editor.cn;

import java.util.ArrayList;

//剑指 Offer 57 - II、和为s的连续正数序列
class HeWeiSdeLianXuZhengShuXuLieLcof {
    public static void main(String[] args) {
        Solution solution = new HeWeiSdeLianXuZhengShuXuLieLcof().new Solution();
        int[][] nums = {{1, 2, 3, 4, 5}, {4, 5, 6}, {7, 8}};
        int[][] continuousSequence = solution.findContinuousSequence(10000);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //双指针
        public int[][] findContinuousSequence(int target) {
            ArrayList<int[]> lists = new ArrayList<>();
            int left = 1, right = 2;
            while (left < right) {
                int sum = (left + right) * (right - left + 1) / 2;  //left 到 right 的所有数的和
                if (sum == target) {
                    int[] t = new int[right - left + 1];
                    for (int i = left; i <= right; i++) {
                        t[i - left] = i;
                    }
                    lists.add(t);
                    left++;
                } else if (sum > target) {
                    left++;
                } else {
                    right++;
                }
            }
            return lists.toArray(new int[][]{});
        }

        //O(n√n)
        public int[][] findContinuousSequence0(int target) {
            int sum = 0;
            ArrayList<int[]> lists = new ArrayList<>();
            for (int i = 1; i <= (target - 1) / 2; i++) {
                sum = 0;
                for (int j = i; j < target; j++) {
                    sum += j;
                    if (sum == target) {
                        int[] t = new int[j - i + 1];
                        for (int k = i; k <= j; k++) {
                            t[k - i] = k;
                        }
                        lists.add(t);
                    } else if (sum > target) {
                        break;
                    }
                }
            }
            return lists.toArray(new int[lists.size()][]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}