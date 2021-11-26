package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//剑指 Offer 58 - I、翻转单词顺序
class FanZhuanDanCiShunXuLcof {
    public static void main(String[] args) {
        Solution solution = new FanZhuanDanCiShunXuLcof().new Solution();
        String s = solution.reverseWords("   the sky    is blue  ");
        System.out.println(s);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String reverseWords(String s) {
            List<String> list = Arrays.asList(s.trim().split(" +"));
            Collections.reverse(list);
            return String.join(" ",list);
        }

        //双指针
        public String reverseWords1(String s) {
            s = s.trim();
            if (s.length() == 0) {
                return "";
            }
            int j = s.length() - 1, i = j;
            StringBuilder builder = new StringBuilder();
            while (j >= 0) {
                while (i >= 0 && s.charAt(i) != ' ') {
                    i--;
                }
                builder.append(s.substring(i+1,j+1));
                builder.append(" ");
                while (i >= 0 && s.charAt(i) == ' '){
                    i--;
                }
                j = i;
            }
            builder.deleteCharAt(builder.length()-1);
            return builder.toString();
        }


        //分割字符串
        public String reverseWords0(String s) {
            //String[] s1 = s.split(" +");
            ArrayList<String> s1 = splitBySpace(s);
            int n = s1.size();
            //int n = s1.length;
            if (n == 0 || s.length() == 0) {
                return "";
            }
            StringBuilder builder = new StringBuilder();
            for (int i = n - 1; i >= 0; i--) {
                if(s1.get(i).length() != 0){
                    builder.append(s1.get(i));
                    builder.append(" ");
                }
                //if(s1[i].length() != 0){
                //    builder.append(s1[i]);
                //    builder.append(" ");
                //}
            }
            builder.deleteCharAt(builder.length()-1);
            return builder.toString();
        }

        public ArrayList<String> splitBySpace(String s){
            ArrayList<String> strings = new ArrayList<>();
            int j = 0;
            int i = 0;
            while (i < s.length()) {
                StringBuilder builder = new StringBuilder();
                while (j < s.length() && s.charAt(j) != ' '){
                    builder.append(s.charAt(j));
                    j++;
                }
                if (builder.length() > 0) {
                    strings.add(builder.toString());
                }
                while (j < s.length() && s.charAt(j) == ' '){
                    j++;
                }
                i = j;
            }
            return strings;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}