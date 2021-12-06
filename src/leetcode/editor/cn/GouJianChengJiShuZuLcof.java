package leetcode.editor.cn;

//剑指 Offer 66、构建乘积数组
class GouJianChengJiShuZuLcof {
    public static void main(String[] args) {
        Solution solution = new GouJianChengJiShuZuLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] constructArr(int[] a) {
            int n = a.length;
            int[] res = new int[n];
            int pre = 1; //前缀积
            int after = 1; //后缀积
            for (int i = 0; i < n; i++) {
                res[i] = pre;
                pre *= a[i];
            }
            for (int i = n - 1; i >= 0; i--) {
                res[i] *= after;
                after *= a[i];
            }
            return res;
        }

        public int[] constructArr1(int[] a) {
            int n = a.length;
            int[] res = new int[n];
            int count = 0;
            int index = 0;
            int mul = 1;
            for (int i = 0; i < n; i++) {
                if (a[i] == 0) {
                    count++;
                    index = i;
                }else {
                    mul *= a[i];
                }
            }
            if (count == 0) {
                for (int i = 0; i < n; i++) {
                    res[i] = mul / a[i];
                }
            } else if (count == 1) {
                res[index] = mul;
            }
            return res;
        }

        //前缀、后缀积
        public int[] constructArr0(int[] a) {
            int n = a.length;
            int[] res = new int[n];
            int[] pre = new int[n];
            int[] after = new int[n];
            if (n == 0) {
                return res;
            }
            pre[0] = 1;
            after[n-1] = 1;
            for (int i = 1; i < n; i++) {
                pre[i] = pre[i - 1] * a[i - 1];
            }
            for (int i = n - 2; i >= 0; i--) {
                after[i] = after[i+1] * a[i + 1];
            }
            for (int i = 0; i < n; i++) {
                res[i] = pre[i] * after[i];
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}