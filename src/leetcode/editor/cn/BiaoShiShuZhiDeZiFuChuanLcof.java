package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//剑指 Offer 20、表示数值的字符串
class BiaoShiShuZhiDeZiFuChuanLcof {
    public static void main(String[] args) {
        Solution solution = new BiaoShiShuZhiDeZiFuChuanLcof().new Solution();
        String[] strings = {"12e", "1a3.14", "1.2.3", "+-5", "12e+5.4"};
        for (String string : strings) {
            System.out.println(solution.isNumber(string));
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //小数表示可省去0，-0.4 = -.4，0.4 = .4；2.、3. = 2、3，小数点前有数，后面可以不跟数代表原数
        //注意e8即10的8次幂（8次方），也可以是e-7，但题目要求必须跟整数
        //题目规定是数值前后可有空格，中间不能有，这个情况要考虑清楚。s：符号、d：数字
        public boolean isNumber(String s) {
            Map[] states = {
                    //0：规定0是初值，字符串表示数值，有4种起始状态，开头空格、符号、数字、前面没有数的小数点
                    //其中 开头空格 还是指向states[0]，上一位是 开头空格，下一位可以是 空格、符号、数字、前面没有数的小数点
                    new HashMap<Character,Integer>() {{ put(' ', 0); put('s', 1); put('d', 2); put('.', 4); }},
                    //1：上一位是符号，符号位后面可以是 数字、前面没有数的小数点
                    new HashMap<Character,Integer>() {{ put('d', 2); put('.', 4); }},
                    //2：上一位是数字，数字的下一位可以是 数字、前面有数的小数点、e、结尾空格
                    new HashMap<Character,Integer>() {{ put('d', 2); put('.', 3); put('e', 5); put(' ', 8); }},
                    //3：上一位是前面有数的小数点，下一位可以是 数字、e（8.e2 = 8e2，和2的情况一样）、结尾空格
                    new HashMap<Character,Integer>() {{ put('d', 3); put('e', 5); put(' ', 8); }},
                    //4：上一位是前面没有数的小数点，下一位只能是 数字（符号肯定不行，e得前面有数才行）
                    new HashMap<Character,Integer>() {{ put('d', 3); }},
                    //5：上一位是e，下一位可以是 符号、数字
                    new HashMap<Character,Integer>() {{ put('s', 6); put('d', 7); }},
                    //6：：上一位是e后面的符号，下一位只能是 数字
                    new HashMap<Character,Integer>() {{ put('d', 7); }},
                    //7：上一位是e后面的数字，下一位可以是 数字、结尾空格
                    new HashMap<Character,Integer>() {{ put('d', 7); put(' ', 8); }},
                    //8：上一位是结尾空格，下一位只能是 结尾空格
                    new HashMap<Character,Integer>() {{ put(' ', 8); }}
            };
            int p = 0;
            char t;
            //遍历字符串，每个字符匹配对应属性并用t标记，非法字符标记？
            for(char c : s.toCharArray()) {
                if(c >= '0' && c <= '9') t = 'd';
                else if(c == '+' || c == '-') t = 's';
                else if(c == 'e' || c == 'E') t = 'e';
                else if(c == '.' || c == ' ') t = c;
                else t = '?';
                //当前字符标记和任何一种当前规定格式都不匹配，直接返回false
                if(!states[p].containsKey(t)) return false;
                //更新当前字符的规定格式，进入下一个规定的Map数组
                p = (int)states[p].get(t);
            }
            //2（正、负整数）、3（正、负小数）、7（科学计数法）、8（前三种形式的结尾加上空格）
            //只有这四种才是正确的结尾
            return p == 2 || p == 3 || p == 7 || p == 8;
        }

        public boolean isNumber0(String s) {
            s = s.trim();
            char[] chars = s.toCharArray();
            int n = chars.length;
            int pointCount = 0;
            for (int i = 0; i < n; i++) {
                char ch = chars[i];
                if (ch == ' ') {
                    return false;
                } else if (ch == 'e' || ch == 'E') {
                    if (i > 0 && chars[i - 1] == '.') {
                        return isNum(s.substring(i + 1));
                    }
                    if (i == 0 || i == n - 1 || chars[i - 1] < '0' || chars[i - 1] > '9') {
                        return false;
                    }
                    return isNum(s.substring(i + 1));
                } else if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                    return false;
                } else if (ch == '+' || ch == '-') {
                    if (i != 0 && (chars[i - 1] != 'e' || chars[i - 1] != 'E')) {
                        return false;
                    }
                } else if (ch == '.') {
                    pointCount++;
                    if (pointCount > 1) { //有多个小数点
                        return false;
                    }
                    if (i == n - 1 && i != 0 && (chars[i - 1] < '0' || chars[i - 1] > '9')) {
                        return false;
                    }
                    if(i == 0 && i != n - 1 && (chars[i + 1] < '0' || chars[i + 1] > '9')){
                        return false;
                    }
                    if (i != n - 1) { //小数点后面不为数字
                        if (chars[i + 1] == 'e' || chars[i + 1] == 'E') {
                            continue;
                        }
                        if (chars[i + 1] < '0' || chars[i + 1] > '9') {
                            return false;
                        }
                    }
                    if (i != 0) {  //小数点前面不为数字或符号
                        if (chars[i - 1] == '+' || chars[i - 1] == '-') {
                            continue;
                        }
                        if (chars[i - 1] < '0' || chars[i - 1] > '9') {
                            return false;
                        }
                    }
                }
            }
            return n != pointCount;
        }

        private boolean isNum(String str) {
            if (str.length() == 0) {
                return false;
            }
            if (str.charAt(0) == '+' || str.charAt(0) == '-') {
                str = str.substring(1);
            }
            if (str.length() == 0) {
                return false;
            }
            for (char c : str.toCharArray()) {
                if (c < '0' || c > '9') {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}