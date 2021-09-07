package leetcode.editor.cn;

//Java：1221、分割平衡字符串
class SplitAStringInBalancedStrings {
    public static void main(String[] args) {
        Solution solution = new SplitAStringInBalancedStrings().new Solution();
        StringBuilder stringBuilder = new StringBuilder("");
        String s = stringBuilder.toString();
        int i = solution.balancedStringSplit(s);
        System.out.println(i);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int balancedStringSplit(String s) {
        int index = 0;

        int lCount = 0;
        int rCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'R'){
                rCount++;
            }else if(s.charAt(i) == 'L'){
                lCount++;
            }
            if (rCount == lCount && rCount != 0 && lCount != 0) {
                index++;
                lCount = 0;
                rCount = 0;
            }
        }

        //int d = 0;
        //for (int i = 0; i < s.length(); i++) {
        //    char ch = s.charAt(i);
        //    if(ch == 'L'){
        //        ++d;
        //    }else{
        //        --d;
        //    }
        //    if (d == 0) {
        //        ++index;
        //    }
        //}

        return index;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}