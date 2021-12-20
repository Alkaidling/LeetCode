package leetcode.editor.cn;

import java.util.*;

//剑指 Offer II 019、最多删除一个字符得到回文
class RQku0D {
    public static void main(String[] args) {
        Solution solution = new RQku0D().new Solution();
        System.out.println(solution.validPalindrome("aguokepatgbnvfqmgmlucupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuclmgmqfvnbgtapekouga"));
        //"aguokepatgbnvfqmgmlucupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuclmgmqfvnbgtapekouga"
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int cnt = 0;
        public boolean validPalindrome(String s) {
            int left = 0, right = s.length() - 1;
            while (left < right) {
                if (s.charAt(left) != s.charAt(right)) {
                    cnt++;
                    if (cnt > 1) {
                        return false;
                    }
                    return validPalindrome(s.substring(left, right)) || validPalindrome(s.substring(left + 1, right + 1));
                }
                left++;
                right--;
            }
            return true;
        }


        public boolean validPalindrome1(String s) {
            return valid(s, 0, s.length() - 1, false);
        }

        public boolean valid(String s, int left, int right, boolean flag) {
            while (left < right) {
                if (s.charAt(left) != s.charAt(right)) {
                    if (!flag) {
                        return valid(s, left + 1, right, true) || valid(s, left, right - 1, true);
                    } else {
                        return false;
                    }
                }
                left++;
                right--;
            }
            return true;
        }

        public boolean validPalindrome0(String s) {
            return validLeft(s) || validRight(s);
        }

        public boolean validLeft(String s) {
            int cnt = 0;
            int left = 0, right = s.length() - 1;
            while (left < right) {
                if (s.charAt(left) != s.charAt(right)) {
                    cnt++;
                    if (cnt > 1) {
                        return false;
                    }
                    if (s.charAt(left + 1) == s.charAt(right)) {
                        left++;
                    } else {
                        return false;
                    }
                }
                left++;
                right--;
            }
            return true;
        }

        public boolean validRight(String s) {
            int cnt = 0;
            int left = 0, right = s.length() - 1;
            while (left < right) {
                if (s.charAt(left) != s.charAt(right)) {
                    cnt++;
                    if (cnt > 1) {
                        return false;
                    }
                    if (s.charAt(left) == s.charAt(right - 1)) {
                        right--;
                    } else {
                        return false;
                    }
                }
                left++;
                right--;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}