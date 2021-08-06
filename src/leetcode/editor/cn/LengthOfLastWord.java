package leetcode.editor.cn;
//Java：最后一个单词的长度
class LengthOfLastWord {
    public static void main(String[] args) {
        Solution solution = new LengthOfLastWord().new Solution();

        //int i = solution.lengthOfLastWord("Today is a nice day");
        int i = solution.lengthOfLastWord("Hello World");
        System.out.println(i);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0) return 0;
        int temp = 0;
        for (int i = s.length()-1; i >= 0; i--) {

            if(s.charAt(i) == ' '){
                if(temp == 0)
                    continue;
                break;
            }
            temp++;

            //if(s.charAt(i) != ' '){
            //    temp++;
            //}else if(s.charAt(i) == ' ' && temp == 0)
            //    continue;
            //else
            //    break;
        }
        return temp;
    }

        //返回最大单词长度
    //public int lengthOfLastWord(String s) {
    //    int temp = 0,result = 0;
    //    for (int i = 0; i < s.length(); i++) {
    //        if(s.charAt(i) != ' '){
    //            temp++;
    //            if(temp > result)
    //                result = temp;
    //        }else if(s.charAt(i) == ' ' )
    //            temp = 0;
    //    }
    //    return result;
    //}
}
//leetcode submit region end(Prohibit modification and deletion)

}