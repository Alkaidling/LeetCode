package leetcode.editor.cn;

import java.util.*;

//17、电话号码的字母组合
class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
        List<String> strings = solution.letterCombinations("2345");
        System.out.println(strings);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> letterCombinations(String digits) {
            List<String> combinations = new ArrayList<String>();
            if (digits.length() == 0) {
                return combinations;
            }
            Map<Character, String> phoneMap = new HashMap<Character, String>() {{
                put('2', "abc");
                put('3', "def");
                put('4', "ghi");
                put('5', "jkl");
                put('6', "mno");
                put('7', "pqrs");
                put('8', "tuv");
                put('9', "wxyz");
            }};
            backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
            return combinations;
        }

        //combinations：结果集，phoneMap：映射集，digits：传入数字字符串，index：当前拼接的位数，combination，当前拼接的字符串
        public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
            if (index == digits.length()) {
                combinations.add(combination.toString()); //StringBuffer长度满足题意，加到结果集中
            } else {
                char digit = digits.charAt(index);  //digit为当前位置的数字
                String letters = phoneMap.get(digit);  //letters为当前数字对应的字母映射
                int lettersCount = letters.length();
                for (int i = 0; i < lettersCount; i++) {
                    combination.append(letters.charAt(i));
                    backtrack(combinations, phoneMap, digits, index + 1, combination); //递归 将位置后移
                    combination.deleteCharAt(index);  //当前位置的值letters.charAt(i)已经加过了，删除后添加映射集的下一的字母
                }
            }
        }


        //面向测试用例编程
        public List<String> letterCombinations1(String digits) {
            ArrayList<String> strings = new ArrayList<>();
            int n = digits.length();
            if (n == 0) {
                return strings;
            }
            ArrayList<List<Character>> chars = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int num = digits.charAt(i) - '0';
                chars.add(chooseLetter(num));
            }
            if (n == 1) {
                for (int i = 0; i < chars.get(0).size(); i++) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(chars.get(0).get(i));
                    strings.add(sb.toString());
                }
            } else if (n == 2) {
                for (int i = 0; i < chars.get(0).size(); i++) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(chars.get(0).get(i));
                    for (int j = 0; j < chars.get(1).size(); j++) {
                        sb.append(chars.get(1).get(j));
                        strings.add(sb.toString());
                        sb.replace(n - 1, n, "");
                    }
                }
            } else if (n == 3) {
                for (int i = 0; i < chars.get(0).size(); i++) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(chars.get(0).get(i));
                    for (int j = 0; j < chars.get(1).size(); j++) {
                        sb.append(chars.get(1).get(j));
                        for (int k = 0; k < chars.get(2).size(); k++) {
                            sb.append(chars.get(2).get(k));
                            strings.add(sb.toString());
                            sb.replace(n - 1, n, "");
                        }
                        sb.replace(n - 2, n - 1, "");
                    }
                }
            } else if (n == 4) {
                for (int i = 0; i < chars.get(0).size(); i++) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(chars.get(0).get(i));
                    for (int j = 0; j < chars.get(1).size(); j++) {
                        sb.append(chars.get(1).get(j));
                        for (int k = 0; k < chars.get(2).size(); k++) {
                            sb.append(chars.get(2).get(k));
                            for (int l = 0; l < chars.get(3).size(); l++) {
                                sb.append(chars.get(3).get(l));
                                strings.add(sb.toString());
                                sb.replace(n - 1, n, "");
                            }
                            sb.replace(n - 2, n - 1, "");
                        }
                        sb.replace(n - 3, n - 2, "");
                    }
                }
            }
            return strings;
        }

        public List<Character> chooseLetter(int num) {
            HashMap<Integer, List<Character>> map = new HashMap<>();
            map.put(2, Arrays.asList('a', 'b', 'c'));
            map.put(3, Arrays.asList('d', 'e', 'f'));
            map.put(4, Arrays.asList('g', 'h', 'i'));
            map.put(5, Arrays.asList('j', 'k', 'l'));
            map.put(6, Arrays.asList('m', 'n', 'o'));
            map.put(7, Arrays.asList('p', 'q', 'r', 's'));
            map.put(8, Arrays.asList('t', 'u', 'v'));
            map.put(9, Arrays.asList('w', 'x', 'y', 'z'));
            return map.get(num);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}