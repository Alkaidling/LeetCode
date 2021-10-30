package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

//260、只出现一次的数字 III
class SingleNumberIii {
    public static void main(String[] args) {
        Solution solution = new SingleNumberIii().new Solution();
        int[] ints = solution.singleNumber(new int[]{1, 2, 1, 3, 5, 2});
        System.out.println(Arrays.toString(ints));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //TODO
        public int[] singleNumber(int[] nums) {
            int n = nums.length;
            int a = 0;
            for (int i = 0; i < n; i++) {
                a ^= nums[i];
            }
            int x = a == Integer.MIN_VALUE ? a : a ^ (-a);
            int x1 = 0;
            for (int i = 0; i < n; i++) {
                if ((nums[i] & x) != 0) {
                    x1 ^= nums[i];
                }
            }
            int x2 = x1 ^ a;
            return new int[] {x1,x2};
        }


        //执行耗时:4 ms,击败了18.37% 的Java用户 内存消耗:39.6 MB,击败了10.25% 的Java用户
        //public int[] singleNumber(int[] nums) {
        //    int n = nums.length;
        //    HashSet<Integer> set = new HashSet<>();
        //    for (int i = 0; i < n; i++) {
        //        if(!set.contains(nums[i])){
        //            set.add(nums[i]);
        //        }else {
        //            set.remove(nums[i]);
        //        }
        //    }
        //    int i = 0;
        //    int[] res = new int[2];
        //    for (int integer : set) {
        //        res[i++] = integer;
        //    }
        //    return res;
        //}

        //执行耗时:7 ms,击败了6.41% 的Java用户 内存消耗:39.7 MB,击败了5.38% 的Java用户
        //哈希表 + 遍历
        //public int[] singleNumber(int[] nums) {
        //    Map<Integer, Integer> map = new HashMap<>();
        //    int n = nums.length;
        //    for (int i = 0; i < n; i++) {
        //        map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        //    }
        //    int[] res = new int[2];
        //    int i = 0;
        //    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        //        if (entry.getValue() == 1) {
        //            res[i++] = entry.getKey();
        //        }
        //    }
        //    return res;
        //}
    }
//leetcode submit region end(Prohibit modification and deletion)

}