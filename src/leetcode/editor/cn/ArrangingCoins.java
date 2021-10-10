package leetcode.editor.cn;

//441、排列硬币
class ArrangingCoins {
    public static void main(String[] args) {
        Solution solution = new ArrangingCoins().new Solution();
        int i = solution.arrangeCoins(5);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int arrangeCoins2(int n) {
            return (int) ((Math.sqrt((long) 8 * n + 1) - 1) / 2);
        }

        //O(log n)
        public int arrangeCoins(int n) {
            int left = 1;
            int right = n;
            while (left < right) {
                //先加1再除以2是为了让中间值靠右
                //(left+right)/2都是向下取整，如果不加上1，left=mid会死循环
                int mid = left + (right - left + 1) / 2;
                if ((long) mid * (mid + 1) <= (long) 2 * n) {
                    left = mid;
                }else {
                    right = mid - 1;
                }
            }
            return left;
        }


        //O(n)
        public int arrangeCoins1(int n) {
            int i = 1;
            for (; i < n; i++) {
                n -= i;
                if (n < i + 1) {
                    return i;
                }
            }
            return i;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}