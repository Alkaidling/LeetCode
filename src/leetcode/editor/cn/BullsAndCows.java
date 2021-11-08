package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//299、猜数字游戏
class BullsAndCows {
    public static void main(String[] args) {
        Solution solution = new BullsAndCows().new Solution();
        String hint = solution.getHint("1122", "2211");
        System.out.println(hint);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //执行耗时:1 ms,击败了100.00% 的Java用户 内存消耗:37.2 MB,击败了83.73% 的Java用户
        public String getHint(String secret, String guess) {
            StringBuilder builder = new StringBuilder();
            int x = 0, y = 0;
            int n = secret.length();
            int[] S = new int[10];
            int[] G = new int[10];
            for (int i = 0; i < n; i++) {
                if(secret.charAt(i) == guess.charAt(i)){
                    x++;
                }else {
                    ++S[secret.charAt(i) - '0'];
                    ++G[guess.charAt(i) - '0'];
                }
            }
            for (int i = 0; i < 10; i++) {
                y += Math.min(G[i],S[i]);
            }
            builder.append(x);builder.append("A");builder.append(y);builder.append("B");
            return builder.toString();
        }


        //哈希表 O(n)
        //执行耗时:4 ms,击败了74.11% 的Java用户 内存消耗:38.3 MB,击败了69.64% 的Java用户
        public String getHint1(String secret, String guess) {
            StringBuilder builder = new StringBuilder();
            Map<Character, Integer> map = new HashMap<>();
            Set<Integer> setInt = new HashSet<>();
            char[] secretChars = secret.toCharArray();
            char[] guessChars = guess.toCharArray();
            int x = 0, y = 0;
            int n = secret.length();
            for (int i = 0; i < n; i++) {
                if (secretChars[i] == guessChars[i]) {
                    x++;
                    setInt.add(i);
                } else {
                    map.put(secretChars[i], map.getOrDefault(secretChars[i], 0) + 1);
                }
            }
            for (int i = 0; i < n; i++) {
                if (!setInt.contains(i) && map.containsKey(guessChars[i])) {
                    int val = map.get(guessChars[i]);
                    if (val == 1) {
                        map.remove(guessChars[i]);
                    } else {
                        map.put(guessChars[i], val - 1);
                    }
                    y++;
                }
            }
            builder.append(x);builder.append("A");builder.append(y);builder.append("B");
            return builder.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}