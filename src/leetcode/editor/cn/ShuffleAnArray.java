package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

//384、打乱数组
class ShuffleAnArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution solution = new ShuffleAnArray().new Solution(nums);
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.shuffle()));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] nums;
        int[] reset;

        public Solution(int[] nums) {
            this.nums = nums;
            reset = nums;
        }

        public int[] reset() {
            return reset;
        }

        public int[] shuffle() { //O(n) n == 200; 调用次数 == 5 * 1e4; 总次数 == 1e7
            //int[] temp = new int[nums.length];
            //ArrayList<Integer> list = new ArrayList<>();
            //for (int i = 0; i < nums.length; i++) {
            //    list.add(nums[i]);
            //}
            //Random random = new Random();
            //for (int i = 0; i < nums.length; i++) {
            //    int j = random.nextInt(list.size());
            //    temp[i] = list.remove(j);
            //}
            //return Arrays.copyOf(temp,nums.length);
            int n = nums.length;
            Random random = new Random();
            int[] temp = Arrays.copyOf(nums,n);
            for (int i = 0; i < n; i++) {
                int t = i + random.nextInt(n - i);
                int tt = temp[i];
                temp[i] = temp[t];
                temp[t] = tt;
            }
            return temp;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
//leetcode submit region end(Prohibit modification and deletion)

}