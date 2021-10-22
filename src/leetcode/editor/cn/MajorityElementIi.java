package leetcode.editor.cn;

import java.util.*;

//229、求众数 II
class MajorityElementIi {
    public static void main(String[] args) {
        Solution solution = new MajorityElementIi().new Solution();
        int[] nums = {1, 2, 2, 2, 1, 2, 2, 2, 1, 1, 1, 1};
        List<Integer> integers = solution.majorityElement(nums);
        System.out.println(integers);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //O(n) O(1)
        //摩尔投票法
        //如果至多选一个代表，那他的票数至少要超过一半（⌊ 1/2 ⌋）的票数；
        //如果至多选两个代表，那他们的票数至少要超过 ⌊ 1/3 ⌋ 的票数；
        //如果至多选m个代表，那他们的票数至少要超过 ⌊ 1/(m+1) ⌋ 的票数。
        //此题答案中最多只有两个数
        //每次消除3个不同的数。由于数组长度为n，因此消消乐最多进行[n/3]次。
        // 因此，我们想要的答案（超过[n/3]的数字）一定没有被消除完，一定存在最后活下来的两个数当中。
        // 但是，存活的两个数不一定都是想要的真正的答案，最后再遍历确认一下这两个数是不是答案即可。
        public List<Integer> majorityElement(int[] nums) {
            int element1 = 0;
            int element2 = 0;
            int vote1 = 0;
            int vote2 = 0;
            for (int num : nums) {
                if (vote1 > 0 && num == element1) { //如果该元素为第一个元素，则计数加1
                    vote1++;
                } else if (vote2 > 0 && num == element2) { //如果该元素为第二个元素，则计数加1
                    vote2++;
                } else if (vote1 == 0) { // 选择第一个元素
                    element1 = num;
                    vote1++;
                } else if (vote2 == 0) { // 选择第二个元素
                    element2 = num;
                    vote2++;
                } else { //如果三个元素均不相同，则相互抵消1次
                    vote1--;
                    vote2--;
                }
            }
            int cnt1 = 0;
            int cnt2 = 0;
            for (int num : nums) {
                if (vote1 > 0 && num == element1) {
                    cnt1++;
                }
                if (vote2 > 0 && num == element2) {
                    cnt2++;
                }
            }
            // 检测元素出现的次数是否满足要求
            List<Integer> ans = new ArrayList<>();
            if (vote1 > 0 && cnt1 > nums.length / 3) {
                ans.add(element1);
            }
            if (vote2 > 0 && cnt2 > nums.length / 3) {
                ans.add(element2);
            }
            return ans;
        }

        //O(n)  O(n)
        //哈希表
        //执行耗时:11 ms,击败了28.12% 的Java用户 内存消耗:41.8 MB,击败了72.90% 的Java用户
        public List<Integer> majorityElement0(int[] nums) {
            List<Integer> list = new ArrayList<>();
            int n = nums.length;
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            n /= 3;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() > n) {
                    list.add(entry.getKey());
                }
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}