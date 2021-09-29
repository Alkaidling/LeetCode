package leetcode.editor.cn;

//11、盛最多水的容器
class ContainerWithMostWater {
    public static void main(String[] args) {
        Solution solution = new ContainerWithMostWater().new Solution();
        int[] height = {9,8,6,2,5,4,8,3,7,9};
        int i = solution.maxArea(height);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //假定全范围为最大值，头尾双指针缩小范围
        //执行耗时:4 ms,击败了70.67% 的Java用户 内存消耗:51.8 MB,击败了55.56% 的Java用户
        public int maxArea(int[] height) {
            int n = height.length;
            int start = 0;
            int end = n-1;
            int ans = 0;
            while (start < end) {
                int area = (end - start) * Math.min(height[end], height[start]);
                //若end的值小，则直接从后开始缩小范围
                if(height[end] < height[start]) {
                    end--;
                }else {
                    start++;
                }
                ans = Math.max(ans,area);
            }
            return ans;
        }

        //Time Limit Exceeded  O(n²)
        //public int maxArea1(int[] height) {
        //    int len = height.length;
        //    int start = 0;
        //    int end = 0;
        //    int ans = 0;
        //    for (; start < len; start++) {
        //        end = start;
        //        while (end < len) {
        //            int area = (end - start) * Math.min(height[end], height[start]);
        //            ans = Math.max(ans, area);
        //            end++;
        //        }
        //    }
        //    return ans;
        //}
    }
//leetcode submit region end(Prohibit modification and deletion)

}