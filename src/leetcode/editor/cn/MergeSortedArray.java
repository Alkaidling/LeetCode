package leetcode.editor.cn;

import java.util.Arrays;

//Java：88、合并两个有序数组
class MergeSortedArray {
    public static void main(String[] args) {
        Solution solution = new MergeSortedArray().new Solution();
        int[] nums1 = {1,2,3,7,0,0,0};
        //int[] nums1 = {1};
        int[] nums2 = {2,5,6};
        //int[] nums2 = {};
        solution.merge(nums1,4,nums2,3);
        System.out.println(Arrays.toString(nums1));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        //从后往前按顺序放到nums1中 时间o(m+n) 空间o(1)
        public void merge2(int[] nums1, int m, int[] nums2, int n) {
            int p1 = m - 1, p2 = n - 1;
            int tail = m + n - 1;
            int cur;
            while (p1 >= 0 || p2 >= 0) {
                if (p1 == -1) {
                    cur = nums2[p2--];
                } else if (p2 == -1) {
                    cur = nums1[p1--];
                } else if (nums1[p1] > nums2[p2]) {
                    cur = nums1[p1--];
                } else {
                    cur = nums2[p2--];
                }
                nums1[tail--] = cur;
            }
        }
        //合并到另一个数组里 时间o(m+n) 空间o(m+n)
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0;
        int[] sorted = new int[m + n];
        int cur;
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                cur = nums2[p2++];
            } else if (p2 == n) {
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }
            sorted[p1 + p2 - 1] = cur;
        }
        for (int i = 0; i != m + n; ++i) {
            nums1[i] = sorted[i];
        }
    }
        //先合并后排序 时间o((m+n)log(m+n)) 空间o(log(m+n))
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n != 0) {
            for (int i = 0; i < n; i++) {
                nums1[m+i] = nums2[i];
            }
            //冒泡排序
            int len = nums1.length;
            for (int i = 0; i < len; i++) {
                for (int j = i; j < len; j++) {
                    if(nums1[j] <= nums1[i]){
                        int temp = nums1[j];
                        nums1[j] = nums1[i];
                        nums1[i] = temp;
                    }
                }
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}