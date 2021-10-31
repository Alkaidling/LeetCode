package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

//500、键盘行
class KeyboardRow {
    public static void main(String[] args) {
        Solution solution = new KeyboardRow().new Solution();
        String[] words = {"adsdf", "sfd"};
        String[] words1 = solution.findWords(words);
        System.out.println(Arrays.toString(words1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        HashSet<Character> set1 = new HashSet<>();
        HashSet<Character> set2 = new HashSet<>();
        HashSet<Character> set3 = new HashSet<>();
        {
            set1.add('q');set1.add('w');set1.add('e');set1.add('r');set1.add('t');set1.add('y');set1.add('u');set1.add('i');set1.add('o');set1.add('p');
            set2.add('a');set2.add('s');set2.add('d');set2.add('f');set2.add('g');set2.add('h');set2.add('j');set2.add('k');set2.add('l');
            set3.add('z');set3.add('x');set3.add('c');set3.add('v');set3.add('b');set3.add('n');set3.add('m');
        }

        public String[] findWords(String[] words) {
            ArrayList<String> list = new ArrayList<>();
            for (String word : words) {
                String str = word.toLowerCase();
                char[] chars = str.toCharArray();
                int i1 = 0, i2 = 0, i3 = 0;
                int n = chars.length;
                for (int i = 0; i < n; i++) {
                    if (set1.contains(chars[i])) {
                        i1++;
                    } else if (set2.contains(chars[i])) {
                        i2++;
                    } else if (set3.contains(chars[i])) {
                        i3++;
                    }
                }
                if (i1 == n || i2 == n || i3 == n) {
                    list.add(word);
                }
            }
            return list.toArray(new String[list.size()]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}