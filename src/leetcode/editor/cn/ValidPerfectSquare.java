package leetcode.editor.cn;

//367、有效的完全平方数
class ValidPerfectSquare {
    public static void main(String[] args) {
        Solution solution = new ValidPerfectSquare().new Solution();
        boolean perfectSquare = solution.isPerfectSquare(1000000);
        System.out.println(perfectSquare);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean isPerfectSquare(int num) {
            int x = 1;
            while (num > 0) {
                num -= x;
                x += 2;
            }
            return num == 0;
        }

        public boolean isPerfectSquare3(int num) {
            long x = 1;
            while (x * x <= num) {
                if (x * x == num) {
                    return true;
                }
                x++;
            }
            return false;
        }

        public boolean isPerfectSquare2(int num) {
            int x = (int) Math.sqrt(num);
            return x * x == num;
        }

        public boolean isPerfectSquare1(int num) {
            long left = 0;
            long right = num / 2 + 1;
            while (left <= right) {
                long mid = left + (right - left) / 2;
                if(mid * mid < num){
                    left = mid + 1;
                } else if (mid * mid > num) {
                    right = mid - 1;
                }else {
                    return true;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}