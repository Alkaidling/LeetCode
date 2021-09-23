package leetcode.editor.cn;
//Java：326、3的幂
class PowerOfThree {
    public static void main(String[] args) {
        Solution solution = new PowerOfThree().new Solution();
        boolean powerOfThree = solution.isPowerOfThree(27);

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }


    public boolean isPowerOfThree2(int n) {
        if (n % 3 == 0 && n != 0) {
            return isPowerOfThree(n/3);
        }else if(n == 1){
            return true;
        }else {
            return false;
        }
    }


    public boolean isPowerOfThree1(int n) {
        while (n >= 3) {
            if (n % 3 == 0) {
                n /= 3;
            }else {
                return false;
            }
        }
        return n == 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}