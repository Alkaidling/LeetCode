package leetcode.editor.cn;

//748、最短补全词
class ShortestCompletingWord {
    public static void main(String[] args) {
        Solution solution = new ShortestCompletingWord().new Solution();
        String s = solution.shortestCompletingWord("iMSlpe4", new String[]{"claim","consumer","student","camera","public","never","wonder","simple","thought","use"});
        System.out.println(s);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //执行耗时:6 ms,击败了33.72% 的Java用户 内存消耗:39 MB,击败了40.76% 的Java用户
        //O(n*len) 1000 * 26
        public String shortestCompletingWord(String licensePlate, String[] words) {
            int[] map = new int[26];
            int sum = 0;
            licensePlate = licensePlate.toLowerCase();
            for (char c : licensePlate.toCharArray()) {
                if(c >= 'a' && c <= 'z'){
                    map[c - 'a']++;
                    sum++;
                }
            }
            StringBuilder builder = new StringBuilder();
            int len = Integer.MAX_VALUE;
            for (String word : words) {
                if (word.length() < sum) {
                    continue;
                }
                int[] t = map.clone();
                if(isCompletingWord(word,t)){
                    if (word.length() < len) {
                        builder = new StringBuilder();
                        builder.append(word);
                        len = word.length();
                    }
                }
            }
            return builder.toString();
        }

        private boolean isCompletingWord(String word, int[] map) {
            for (char c : word.toCharArray()) {
                map[c-'a']--;
            }
            for (int i : map) {
                if (i > 0) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}