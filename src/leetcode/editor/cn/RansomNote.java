package leetcode.editor.cn;

//383、赎金信
class RansomNote {
    public static void main(String[] args) {
        Solution solution = new RansomNote().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            int n = magazine.length();
            int[] map = new int[26];
            for (char c : magazine.toCharArray()) {
                map[c-'a']++;
            }
            //for (int i = 0; i < n; i++) {
            //    map[magazine.charAt(i)-'a']++;
            //}
            for (char c : ransomNote.toCharArray()) {
                if (map[c - 'a'] < 1) {
                    return false;
                }
                map[c-'a']--;
            }
            //n = ransomNote.length();
            //for (int i = 0; i < n; i++) {
            //    if(map[ransomNote.charAt(i)-'a'] < 1){
            //        return false;
            //    }
            //    map[ransomNote.charAt(i)-'a']--;;
            //}
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}