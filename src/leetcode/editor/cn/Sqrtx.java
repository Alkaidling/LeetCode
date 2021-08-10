package leetcode.editor.cn;
//Java：x 的平方根
class Sqrtx {
    public static void main(String[] args) {
        Solution solution = new Sqrtx().new Solution();
        //int i = solution.mySqrt(2147483646);
        //int i = solution.mySqrt(1000080000);
        int i = solution.mySqrt(1);
        System.out.println(i);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int mySqrt(int x) {
        int low = 0;
        int high = x;
        int mid = 0;
        while(low < high){
            mid = (low + high + 1) / 2;
            if ((long)mid * mid > x)
                high = mid - 1;
            else
                low = mid;
        }
        return low;
    }

    public int mySqrt1(int x) {
        int low = 0;
        int high = x;
        int mid = 0;
        while(low != high - 1){
            mid = (low + high) / 2;
            if ((long)mid * mid > x)
                high = mid;
            else
                low = mid;
        }
        if (mid * mid > x)
            return mid - 1;
        else
            return mid;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}