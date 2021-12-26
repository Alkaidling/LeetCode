package leetcode.editor.cn;

import java.util.*;

//128、最长连续序列
class LongestConsecutiveSequence {
    public static void main(String[] args) {
        Solution solution = new LongestConsecutiveSequence().new Solution();
        int i = solution.longestConsecutive(new int[]{1,2,0,1});
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestConsecutive1(int[] nums) {
            HashMap<Integer, Integer> map = new HashMap<>();
            int res = 0;
            for (int num : nums) {
                if (!map.containsKey(num)) {
                    int left = map.getOrDefault(num - 1,0);
                    int right = map.getOrDefault(num + 1,0);
                    int len = left + right + 1;
                    res = Math.max(res, len);
                    map.put(num,len);
                    map.put(num - left,len);
                    map.put(num + right,len);
                }
            }
            return res;
        }
        public int longestConsecutive(int[] nums) {
            HashSet<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }
            int res = 0;
            for (int num : set) {
                if (!set.contains(num - 1)) {
                    int curNum = num;
                    int len = 1;
                    while (set.contains(curNum + 1)) {
                        curNum++;
                        len++;
                    }
                    res = Math.max(res,len);
                }
            }
            return res;
        }
        //nlogn
        public int longestConsecutive0(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            Arrays.sort(nums);
            int res = 0;
            int n = nums.length;
            int len = 1;
            for (int i = 1; i < n; i++) {
                if (nums[i] - nums[i - 1] == 1) {
                    len++;
                }else if(nums[i] == nums[i - 1]){
                } else {
                    res = Math.max(res,len);
                    len = 1;
                }
            }
            return Math.max(res,len);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}