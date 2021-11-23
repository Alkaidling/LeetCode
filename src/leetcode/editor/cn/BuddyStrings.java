package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;

//859、亲密字符串
class BuddyStrings {
    public static void main(String[] args) {
        Solution solution = new BuddyStrings().new Solution();
        boolean b = solution.buddyStrings("aaaabc", "aaaacb");
        System.out.println(b);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //执行耗时:4 ms,击败了25.69% 的Java用户 内存消耗:38.5 MB,击败了15.88% 的Java用户
        public boolean buddyStrings(String s, String goal) {
            int n = s.length();
            if (goal.length() != n) {
                return false;
            }
            HashSet<Character> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                set.add(s.charAt(i));
            }
            if (s.equals(goal)) {
                if (set.size() < n) {
                    return true;
                } else {
                    return false;
                }
            } else {
                int count = 0;
                int first = -1;
                int second = -1;
                for (int i = 0; i < n; i++) {
                    if (s.charAt(i) != goal.charAt(i)) {
                        count++;
                        if (first == -1) {
                            first = i;
                        } else {
                            second = i;
                        }
                    }
                }
                if (count != 2 || s.charAt(first) != goal.charAt(second) || s.charAt(second) != goal.charAt(first)) {
                    return false;
                } else {
                    return true;
                }
            }
        }


        //执行耗时:10 ms,击败了5.39% 的Java用户 内存消耗:39.5 MB,击败了5.39% 的Java用户
        public boolean buddyStrings0(String s, String goal) {
            int n = s.length();
            if (goal.length() != n) {
                return false;
            }
            HashMap<Integer, Character> map = new HashMap<>();
            HashSet<Character> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                map.put(i, s.charAt(i));
                set.add(s.charAt(i));
            }
            if (set.size() < n && s.equals(goal)) {
                return true;
            }
            int count = 0;
            int first = -1;
            int second = -1;
            for (int i = 0; i < n; i++) {
                char ch = map.get(i);
                if (ch != goal.charAt(i)) {
                    count++;
                    if (first == -1) {
                        first = i;
                    } else {
                        second = i;
                    }
                }
            }
            if (count != 2) {
                return false;
            } else if (s.charAt(first) == goal.charAt(second) && s.charAt(second) == goal.charAt(first)) {
                return true;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}