package leetcode.editor.cn;

//319、灯泡开关
class BulbSwitcher {
    public static void main(String[] args) {
        Solution solution = new BulbSwitcher().new Solution();
        for (int i = 0; i < 17; i++) {
            System.out.println(i + " -> " + solution.bulbSwitch(i));
        }
        System.out.println();
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int bulbSwitch(int n) {
            return (int) (Math.sqrt(n));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}