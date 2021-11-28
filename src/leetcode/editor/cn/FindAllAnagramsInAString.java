package leetcode.editor.cn;

import java.util.*;

//438、找到字符串中所有字母异位词
class FindAllAnagramsInAString {
    public static void main(String[] args) {
        Solution solution = new FindAllAnagramsInAString().new Solution();
        List<Integer> anagrams = solution.findAnagrams("cbaebabacd", "abc");
        System.out.println(anagrams);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<Integer> findAnagrams(String s, String p) {
            int[] map = new int[26];
            int[] smap = new int[26];
            ArrayList<Integer> list = new ArrayList<>();
            char[] charsP = p.toCharArray();
            char[] chars = s.toCharArray();
            int len = charsP.length;
            if (len > chars.length) {
                return list;
            }
            for (int i = 0; i < len; i++) {
                map[charsP[i]-'a']++;
                smap[chars[i]-'a']++;
            }
            int n = chars.length;
            if(Arrays.equals(map,smap)){
                list.add(0);
            }
            for (int i = 0,j = len; j < n; i++,j++) {
                smap[chars[i]-'a']--;
                smap[chars[j]-'a']++;
                if(Arrays.equals(map,smap)){
                    list.add(i+1);
                }
            }
            return list;
        }

        //执行耗时:1173 ms,击败了8.86% 的Java用户 内存消耗:40 MB,击败了5.17% 的Java用户
        public List<Integer> findAnagrams0(String s, String p) {
            HashMap<Character,Integer> map = new HashMap<>();
            ArrayList<Integer> list = new ArrayList<>();
            int len = p.length();
            char[] charsP = p.toCharArray();
            for (int i = 0; i < len; i++) {
                map.put(charsP[i],map.getOrDefault(charsP[i],0)+1);
            }
            char[] chars = s.toCharArray();
            int n = chars.length;
            boolean flag = false;
            for (int i = 0,j = len-1; j < n; i++,j++) {
                if (flag && chars[i-1] == chars[j]) {
                    list.add(i);
                    continue;
                }
                flag = check(map,s.substring(i,j+1));
                if (flag) {
                    list.add(i);
                }
            }
            return list;
        }

        private boolean check(HashMap<Character, Integer> map, String substring) {
            char[] chars = substring.toCharArray();
            int n = chars.length;
            HashMap<Character, Integer> checkMap = new HashMap<>();
            for (int i = 0; i < n; i++) {
                if(!map.containsKey(chars[i])){
                    return false;
                }
                checkMap.put(chars[i],checkMap.getOrDefault(chars[i],0)+1);
            }
            if (map.size() != checkMap.size()) {
                return false;
            }
            for (Character ch : checkMap.keySet()) {
                if(!map.get(ch).equals(checkMap.get(ch))){
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}