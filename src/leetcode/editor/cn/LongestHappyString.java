package leetcode.editor.cn;

import java.util.*;

//1405、最长快乐字符串
class LongestHappyString {
    public static void main(String[] args) {
        Solution solution = new LongestHappyString().new Solution();
        System.out.println(solution.longestDiverseString(1, 0, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestDiverseString(int a, int b, int c) {
            StringBuilder sb = new StringBuilder();
            int aa = 0, bb = 0, cc = 0;
            while (a != 0 || b != 0 || c != 0) {
                if (a >= b && a >= c && aa < 2) {
                    sb.append('a');
                    aa++;
                    bb = 0;
                    cc = 0;
                    a--;
                }else if(b >= a && b >= c && bb < 2){
                    sb.append('b');
                    bb++;
                    aa = 0;
                    cc = 0;
                    b--;
                } else if(c >= a && c >= b && cc < 2){
                    sb.append('c');
                    cc++;
                    aa = 0;
                    bb = 0;
                    c--;
                }else {
                    if (aa == 2) {
                        aa = 0;
                        if (c == 0 && b == 0) {
                            return sb.toString();
                        }else if (b >= c) {
                            sb.append('b');
                            b--;
                            bb++;
                        }else {
                            sb.append('c');
                            c--;
                            cc++;
                        }
                    } else if (bb == 2) {
                        bb = 0;
                        if(a == 0 && c == 0){
                            return sb.toString();
                        } else if (a >= c) {
                            sb.append('a');
                            a--;
                            aa++;
                        }else {
                            sb.append('c');
                            c--;
                            cc++;
                        }
                    } else if (cc == 2) {
                        cc = 0;
                        if (a == 0 && b == 0) {
                            return sb.toString();
                        }else if (a >= b) {
                            sb.append('a');
                            a--;
                            aa++;
                        }else {
                            sb.append('b');
                            b--;
                            bb++;
                        }
                    }
                }
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}