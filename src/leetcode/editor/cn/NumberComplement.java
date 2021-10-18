package leetcode.editor.cn;

//476、数字的补数
class NumberComplement {
    public static void main(String[] args) {
        Solution solution = new NumberComplement().new Solution();
        int complement = solution.findComplement(2147483640);
        System.out.println(complement);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findComplement(int num) {
            int t = num;
            t |= t >> 1;
            t |= t >> 2;
            t |= t >> 4;
            t |= t >> 8;
            t |= t >> 16; //t为比num大且最近的2的幂-1
            return t ^ num;
        }

        public int findComplement1(int num) {
            long t = 1;  //t为比num大且最近的2的幂
            while (t <= num) {
                t <<= 1;
            }
            return (int) (num ^ (t-1));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}