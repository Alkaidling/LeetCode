package leetcode.editor.cn;

//剑指 Offer 16、数值的整数次方
class ShuZhiDeZhengShuCiFangLcof {
    public static void main(String[] args) {
        Solution solution = new ShuZhiDeZhengShuCiFangLcof().new Solution();
        double v = solution.myPow(2.0, -2147483648);
        System.out.println(v);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public double myPow(double x, int n) {
            if (n > 0) {
                //double res = myPow(x, n / 2);
                //if (n % 2 == 0) {
                //    return res * res;
                //}else {
                //    return res * res * x;
                //}
                if (n % 2 == 0) {
                    return myPow(x * x, n / 2);
                } else {
                    return x * myPow(x * x, n / 2);
                }
            } else if (n < 0) {
                //if (n == Integer.MIN_VALUE) {
                //    return 1.0 / (myPow(x,Integer.MAX_VALUE) * x);
                //}else {
                //    return 1.0 / myPow(x,-n);
                //}
                // x^-n = 1/x^n
                return 1.0 / (myPow(x, -(n + 1)) * x);
            } else {
                return 1.0;
            }
        }

        //StackOverflowError
        //public double myPow(double x, int n) {
        //    if (n > 0) {
        //        return myPow(x,n-1) * x;
        //    } else if (n < 0) {
        //        return 1.0 / myPow(x,-n);
        //    }else {
        //        return 1.0;
        //    }
        //}
    }
//leetcode submit region end(Prohibit modification and deletion)

}