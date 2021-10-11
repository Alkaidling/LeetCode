package leetcode.editor.cn;


import java.util.ArrayDeque;
import java.util.Deque;

//273、整数转换英文表示
class IntegerToEnglishWords {
    public static void main(String[] args) {
        Solution solution = new IntegerToEnglishWords().new Solution();
        String s = solution.numberToWords(1000001000);
        System.out.println(s);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        String[] singles = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] thousands = {"", "Thousand", "Million", "Billion"};

        public String numberToWords(int num) {
            if (num == 0) {
                return "Zero";
            }
            StringBuffer sb = new StringBuffer();
            for (int i = 3, unit = 1000000000; i >= 0; i--, unit /= 1000) {
                int curNum = num / unit;
                if (curNum != 0) {
                    num -= curNum * unit;
                    sb.append(toEnglish(curNum)).append(thousands[i]).append(" ");
                }
            }
            return sb.toString().trim();
        }

        public String toEnglish(int num) {
            StringBuffer curr = new StringBuffer();
            int hundred = num / 100;
            num %= 100;
            if (hundred != 0) {
                curr.append(singles[hundred]).append(" Hundred ");
            }
            int ten = num / 10;
            if (ten >= 2) {
                curr.append(tens[ten]).append(" ");
                num %= 10;
            }
            if (num > 0 && num < 10) {
                curr.append(singles[num]).append(" ");
            } else if (num >= 10) {
                curr.append(teens[num - 10]).append(" ");
            }
            return curr.toString();
        }


        public String numberToWords0(int num) {
            String[] table1 = {"Zero ", "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine "};
            String[] table2 = {"Ten ", "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ", "Nineteen "};
            String[] table3 = {"", "", "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety "};
            String[] table4 = {"Billion ", "Million ", "Thousand ", "Hundred "};
            if (num == 0) {
                return table1[0].trim();
            }
            StringBuilder builder = new StringBuilder();
            Deque<String> stack = new ArrayDeque<>();
            int index = 0;
            while (num != 0) {
                if (index == 1) {
                    stack.push(table4[2]);
                } else if (index == 2) {
                    stack.push(table4[1]);
                }else if (index == 3) {
                    stack.push(table4[0]);
                }
                String str = "";
                int carry = num % 1000;
                num /= 1000;
                if (carry >= 100) {
                    str += table1[carry / 100] + table4[3];
                    carry %= 100;
                    if (carry >= 20) {
                        str += table3[carry / 10];
                        carry %= 10;
                        if (carry != 0) {
                            str += table1[carry];
                        }
                    } else if (carry >= 10) {
                        str += table2[carry % 10];
                    }else if(carry > 0){
                        str += table1[carry];
                    }
                } else if (carry >= 20) {
                    str += table3[carry / 10];
                    carry %= 10;
                    if (carry != 0) {
                        str += table1[carry];
                    }
                } else if (carry >= 10) {
                    str += table2[carry % 10];
                } else {
                    carry %= 10;
                    if (carry != 0) {
                        str += table1[carry];
                    }
                }
                if(str != ""){
                    stack.push(str);
                }
                index++;
            }
            while (!stack.isEmpty()) {
                String str = stack.pop();
                builder.append(str);
                while ((str == "Billion " && stack.peek() == "Million ")
                        || (str == "Million " && stack.peek() == "Thousand ")
                        || (str == "Thousand " && stack.isEmpty())){
                    if(!stack.isEmpty()){
                        str = stack.pop();
                    }else{
                        break;
                    }
                }
            }
            return builder.toString().trim();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}