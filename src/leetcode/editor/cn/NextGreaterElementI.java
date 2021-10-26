package leetcode.editor.cn;

import java.util.*;

//496、下一个更大元素 I
class NextGreaterElementI {
    public static void main(String[] args) {
        Solution solution = new NextGreaterElementI().new Solution();
        int[] nums1 = {4};
        int[] nums2 = {4};
        int[] ints = solution.nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(ints));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //O(n+m)
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            int n = nums1.length;
            int m = nums2.length;
            int[] res = new int[n];
            ArrayDeque<Integer> stack = new ArrayDeque<>();
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = m - 1; i >= 0; i--) {
                while (!stack.isEmpty() && stack.peek() <= nums2[i]) {  //单调栈，栈顶元素是大于nums2[i]的下一个元素
                    stack.pop();
                }
                map.put(nums2[i],stack.isEmpty() ? -1 : stack.peek());
                stack.push(nums2[i]);
            }
            for (int i = 0; i < n; i++) {
                res[i] = map.get(nums1[i]);
            }
            return res;
        }


        //O(m*n)
        public int[] nextGreaterElement0(int[] nums1, int[] nums2) {
            int n = nums1.length;
            int m = nums2.length;
            int[] res = new int[n];
            for (int i = 0; i < n; i++) {
                int j = 0;
                res[i] = -1;
                for (; j < m; j++) {
                    if (nums1[i] == nums2[j]) {
                        break;
                    }
                }
                for (; j < m; j++) {
                    if (nums1[i] < nums2[j]) {
                        res[i] = nums2[j];
                        break;
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}