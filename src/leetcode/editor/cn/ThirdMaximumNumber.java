package leetcode.editor.cn;

import java.util.Arrays;
import java.util.TreeSet;

//414、第三大的数
class ThirdMaximumNumber {
    public static void main(String[] args) {
        Solution solution = new ThirdMaximumNumber().new Solution();
        int[] nums = {3,2,1};
        int i = solution.thirdMax(nums);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //定义有序集合维护前三大的数，
        //由于会出现重复值所以用小根堆（PriorityQueue）实现时，需要用contains判断是否重复
        //TreeSet维护搜索二叉树，添加重复值会覆盖
        public int thirdMax(int[] nums) {
            TreeSet<Integer> set = new TreeSet<>();
            for (int num : nums) {
                set.add(num);
                if (set.size() > 3) {
                    set.remove(set.first()); //超过三个数就删去较小的数
                }
            }
            return set.size() == 3 ? set.first() : set.last();  //有三个数则第一个数就是第三大的，否则就返回最大
        }


        //三次或一次for循环  O(n)
        public int thirdMax2(int[] nums) {
            if (nums.length == 1) {
                return nums[0];
            } else if (nums.length == 2) {
                return Math.max(nums[0], nums[1]);
            }
            int n = nums.length;
            long max = Long.MIN_VALUE;
            long max2 = Long.MIN_VALUE;
            long res = Long.MIN_VALUE;
            //三次for循环可合并为一次
            for (int i = 0; i < n; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                }
            }
            for (int i = 0; i < n; i++) {
                if (nums[i] > max2 && nums[i] < max) {
                    max2 = nums[i];
                }
            }
            if (max == max2) {
                return (int) max;
            }
            for (int i = 0; i < n; i++) {
                if (nums[i] > res && nums[i] < max2) {
                    res = nums[i];
                }
            }

            //for (int num : nums) {
            //    if (num > max) {
            //        res = max2;
            //        max2 = max;
            //        max = num;
            //    } else if (num > max2 && num < max) {
            //        res = max2;
            //        max2 = num;
            //    } else if (num > res && num < max2) {
            //        res = num;
            //    }
            //}
            return res == Long.MIN_VALUE ? (int) max : (int) res;
        }


        //Arrays.sort  O(nlogn)
        public int thirdMax1(int[] nums) {
            if (nums.length == 1) {
                return nums[0];
            } else if (nums.length == 2) {
                return Math.max(nums[0], nums[1]);
            }

            Arrays.sort(nums);
            int n = nums.length;
            int max = nums[n - 1];
            int max2 = nums[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                if (nums[i] < nums[i + 1] && max2 == max) {
                    max2 = nums[i];
                }
                if (nums[i] < max2) {
                    return nums[i];
                }
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}