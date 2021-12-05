package leetcode.editor.cn;

//372、超级次方
class SuperPow {
    public static void main(String[] args) {
        Solution solution = new SuperPow().new Solution();
        int[] b = {4, 3, 3, 8, 5, 2};
        int i = solution.superPow(2, new int[]{3});
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //执行耗时:1199 ms,击败了5.01% 的Java用户 内存消耗:39.4 MB,击败了5.01% 的Java用户
        //O(nlogB) B = b，n = b.length
        //a ^ b ==> b是奇数：(a²) ^ b/2 , b是偶数：a * (a²) ^ b/2
        public int superPow(int a, int[] b) {
            if (a > 1337) {
                a %= 1337;
            }
            boolean flag = true;
            for (int i = 0; i < b.length - 1; i++) {
                if (b[i] != 0) {
                    flag = false;
                    break;
                }
            }
            if (b[b.length - 1] != 1) {
                flag = false;
            }
            if (flag) {
                return a;
            } else {
                return b[b.length - 1] % 2 == 0 ? superPow((a * a) % 1337, divide(b)) : (superPow((a * a) % 1337, divide(b)) * a) % 1337;
            }
        }

        //求 b / 2    433852 / 2 = 216926
        public int[] divide(int[] b) {
            int n = b.length;
            int[] res = new int[n];
            for (int i = 0; i < n; i++) {
                res[i] = b[i] / 2;
                if (b[i] % 2 != 0 && i < n - 1) {
                    b[i + 1] += 10;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}