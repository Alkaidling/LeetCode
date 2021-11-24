package leetcode.editor.cn;

import java.util.*;

//423、从英文中重建数字
class ReconstructOriginalDigitsFromEnglish {
    public static void main(String[] args) {
        Solution solution = new ReconstructOriginalDigitsFromEnglish().new Solution();
        String owoztneoer = solution.originalDigits("owofviefuroztfviefuroneoer");
        System.out.println(owoztneoer);
    }

    //　　0 zero    z `
    //　　1 one
    //　　2 two     w `
    //　　3 three     `
    //　　4 four    u `
    //　　5 five      `
    //　　6 six     x `
    //　　7 seven     `
    //　　8 eight   g `
    //　　9 nine
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String originalDigits(String s) {
            char[] count = new char[26 + (int) 'a'];
            for (char c : s.toCharArray()) {
                count[c]++;
            }
            List<Character> characters =  Arrays.asList('z', 'w', 'u', 'x', 'g');

            int[] out = new int[10];
            for (int i = 0, flag = 0; i < out.length; i += 2) {
                out[i] = count[characters.get(flag)];
                flag++;
            }
            // letter "h" is present only in "three" and "eight"
            out[3] = count['h'] - out[8];
            // letter "f" is present only in "five" and "four"
            out[5] = count['f'] - out[4];
            // letter "s" is present only in "seven" and "six"
            out[7] = count['s'] - out[6];
            // letter "i" is present in "nine", "five", "six", and "eight"
            out[9] = count['i'] - out[5] - out[6] - out[8];
            // letter "n" is present in "one", "nine", and "seven"
            out[1] = count['n'] - out[7] - 2 * out[9];

            // building output string
            StringBuilder output = new StringBuilder();
            for (int i = 0; i < 10; i++)
                for (int j = 0; j < out[i]; j++)
                    output.append(i);
            return output.toString();
        }

        public String originalDigits1(String s) {
            Map<Character, Integer> c = new HashMap<Character, Integer>();
            for (int i = 0; i < s.length(); ++i) {
                char ch = s.charAt(i);
                c.put(ch, c.getOrDefault(ch, 0) + 1);
            }

            int[] cnt = new int[10];
            cnt[0] = c.getOrDefault('z', 0);
            cnt[2] = c.getOrDefault('w', 0);
            cnt[4] = c.getOrDefault('u', 0);
            cnt[6] = c.getOrDefault('x', 0);
            cnt[8] = c.getOrDefault('g', 0);

            cnt[3] = c.getOrDefault('h', 0) - cnt[8];
            cnt[5] = c.getOrDefault('f', 0) - cnt[4];
            cnt[7] = c.getOrDefault('s', 0) - cnt[6];

            cnt[1] = c.getOrDefault('o', 0) - cnt[0] - cnt[2] - cnt[4];

            cnt[9] = c.getOrDefault('i', 0) - cnt[5] - cnt[6] - cnt[8];

            StringBuffer ans = new StringBuffer();
            for (int i = 0; i < 10; ++i) {
                for (int j = 0; j < cnt[i]; ++j) {
                    ans.append((char) (i + '0'));
                }
            }
            return ans.toString();
        }

        //执行耗时:58 ms,击败了5.08% 的Java用户 内存消耗:44.5 MB,击败了5.08% 的Java用户
        public String originalDigits0(String s) {
            char[] chars = s.toCharArray();
            int n = chars.length;
            PriorityQueue<Integer> heap = new PriorityQueue<>();
            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                char ch = chars[i];
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            if (map.containsKey('z')) {
                int num = map.get('z');
                for (int i = 0; i < num; i++) {
                    heap.offer(0);
                }
                map.remove('z');
                if (num > 0) {
                    map.put('e', map.get('e') - num);
                    map.put('r', map.get('r') - num);
                    map.put('o', map.get('o') - num);
                }
            }
            if (map.containsKey('w')) {
                int num = map.get('w');
                for (int i = 0; i < num; i++) {
                    heap.offer(2);
                }
                map.remove('w');
                if (num > 0) {
                    map.put('t', map.get('t') - num);
                    map.put('o', map.get('o') - num);
                }
            }
            if (map.containsKey('u')) {
                int num = map.get('u');
                for (int i = 0; i < num; i++) {
                    heap.offer(4);
                }
                map.remove('u');
                if (num > 0) {
                    map.put('f', map.get('f') - num);
                    map.put('r', map.get('r') - num);
                    map.put('o', map.get('o') - num);
                }
            }
            if (map.containsKey('x')) {
                int num = map.get('x');
                for (int i = 0; i < num; i++) {
                    heap.offer(6);
                }
                map.remove('x');
                if (num > 0) {
                    map.put('s', map.get('s') - num);
                    map.put('i', map.get('i') - num);
                }
            }
            if (map.containsKey('g')) {
                int num = map.get('g');
                for (int i = 0; i < num; i++) {
                    heap.offer(8);
                }
                map.remove('g');
                if (num > 0) {
                    map.put('e', map.get('e') - num);
                    map.put('i', map.get('i') - num);
                    map.put('h', map.get('h') - num);
                    map.put('t', map.get('t') - num);
                }
            }
            if (map.containsKey('t')) {
                int num = map.get('t');
                for (int i = 0; i < num; i++) {
                    heap.offer(3);
                }
                map.remove('t');
                if (num > 0) {
                    map.put('e', map.get('e') - num * 2);
                    map.put('r', map.get('r') - num);
                    map.put('h', map.get('h') - num);
                }
            }
            if (map.containsKey('s')) {
                int num = map.get('s');
                for (int i = 0; i < num; i++) {
                    heap.offer(7);
                }
                map.remove('s');
                if (num > 0) {
                    map.put('e', map.get('e') - num * 2);
                    map.put('v', map.get('v') - num);
                    map.put('n', map.get('n') - num);
                }
            }
            if (map.containsKey('f')) {
                int num = map.get('f');
                for (int i = 0; i < num; i++) {
                    heap.offer(5);
                }
                map.remove('f');
                if (num > 0) {
                    map.put('e', map.get('e') - num);
                    map.put('v', map.get('v') - num);
                    map.put('i', map.get('i') - num);
                }
            }
            if (map.containsKey('i')) {
                int num = map.get('i');
                for (int i = 0; i < num; i++) {
                    heap.offer(9);
                }
                map.remove('i');
                if (num > 0) {
                    map.put('e', map.get('e') - num);
                    map.put('n', map.get('n') - num * 2);
                }
            }
            if (map.containsKey('e')) {
                int num = map.get('e');
                for (int i = 0; i < num; i++) {
                    heap.offer(1);
                }
                map.remove('e');
                map.remove('n');
                map.remove('o');
            }
            StringBuilder builder = new StringBuilder();
            while (!heap.isEmpty()) {
                builder.append(heap.poll());
            }
            return builder.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}