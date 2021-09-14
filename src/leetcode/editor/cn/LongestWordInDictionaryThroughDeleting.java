package leetcode.editor.cn;

import java.util.*;

//Java：524、通过删除字母匹配到字典里最长单词
class LongestWordInDictionaryThroughDeleting {
    public static void main(String[] args) {
        Solution solution = new LongestWordInDictionaryThroughDeleting().new Solution();
        String s = "bab";
        //List<String> dictionary = Arrays.asList("ale","apple","monkey","plea");
        List<String> dictionary = Arrays.asList("ba","ab","a","b");
        String longestWord = solution.findLongestWord(s, dictionary);
        System.out.println(longestWord);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        String ans = "";
        //多余的map集合
        Map<Integer, String> map = new HashMap<>();

        for (int i = 0; i < dictionary.size(); i++) {
            String str = dictionary.get(i);
            if(s.length() < str.length()){
                map.put(0,"");
                continue;
            }
            int index = 0;
            for (int j = 0; j < s.length(); j++) {
                if(index < str.length()){
                    if(str.charAt(index) == s.charAt(j)){
                        index++;
                    }
                }
            }
            if(index == str.length()){
                if(!map.containsKey(index) || map.containsKey(index) && str.compareTo(map.get(index)) < 0){
                    map.put(index,dictionary.get(i));
                }
                //不用map 直接与ans比较并替换
                //if (str.length() > ans.length() || (str.length() == ans.length()) && (str.compareTo(ans) < 0)) {
                //    ans = str;
                //}
            }
            else {
                map.put(0,"");
            }
        }
        int max = 0;
        Set<Integer> set = map.keySet();
        for (Integer integer : set) {
            if(integer > max){
                max = integer;
            }
        }
        return map.get(max);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}