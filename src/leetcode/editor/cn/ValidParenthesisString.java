package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

//Java：678、有效的括号字符串
class ValidParenthesisString {
    public static void main(String[] args) {
        Solution solution = new ValidParenthesisString().new Solution();
        boolean b = solution.checkValidString("(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())");
        boolean b1 = solution.checkValidString("(((((*(((((*((**(((*)*((((**))*)*)))))))))((*(((((**(**)");
        System.out.println(b1);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        //双栈 时间O(n) 空间O(n)
    public boolean checkValidString(String s) {
        Deque<Integer> left = new ArrayDeque<>();
        Deque<Integer> space = new ArrayDeque<>();

        if(s.charAt(s.length()-1) == '('){
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '('){
                //left.push(ch);  方便比较括号的位置前后，所以push序号
                left.push(i);
            }else if(ch == '*'){
                //space.push(ch);
                space.push(i);
            }else if(ch == ')' && !left.isEmpty()){
                left.pop();
            }else if(ch == ')' && left.isEmpty() && !space.isEmpty()){
                space.pop();
            }else if(ch == ')' && left.isEmpty() && space.isEmpty()){
                return false;
            }
        }

        if(!left.isEmpty() && !space.isEmpty()) {
            while (!left.isEmpty() && !space.isEmpty()) {
                int spaceIndex = space.pop();
                int leftIndex = left.pop();
                if (leftIndex > spaceIndex) {  // *(情况
                    return false;
                }
            }
        }
        return left.isEmpty();

    /*
        if(left.isEmpty() && space.isEmpty()){
            return true;
        }else if(left.isEmpty() && !space.isEmpty()){
            return true;
        }else if(!left.isEmpty() && space.isEmpty()){
            return false;
        }else if(!left.isEmpty() && !space.isEmpty()){
            while (!left.isEmpty() && !space.isEmpty()) {
                int spaceIndex = space.pop();
                int leftIndex = left.pop();
                if (leftIndex > spaceIndex) {  // *(情况
                    return false;
                }
            }
            if (left.isEmpty()) {
                return true;
            }else {
                return false;
            }
        }else{
            return false;
        }
    */
    }
        //动态规划 时间O(n³) 空间O(n²)
        public boolean checkValidString1(String s) {
            int n = s.length();
            boolean[][] dp = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '*') {
                    dp[i][i] = true;
                }
            }
            for (int i = 1; i < n; i++) {
                char c1 = s.charAt(i - 1), c2 = s.charAt(i);
                dp[i - 1][i] = (c1 == '(' || c1 == '*') && (c2 == ')' || c2 == '*');
            }
            for (int i = n - 3; i >= 0; i--) {
                char c1 = s.charAt(i);
                for (int j = i + 2; j < n; j++) {
                    char c2 = s.charAt(j);
                    if ((c1 == '(' || c1 == '*') && (c2 == ')' || c2 == '*')) {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                    for (int k = i; k < j && !dp[i][j]; k++) {
                        dp[i][j] = dp[i][k] && dp[k + 1][j];
                    }
                }
            }
            return dp[0][n - 1];
        }

        //贪心算法 时间O(n) 空间O(1)

        //如果遇到左括号，则将最小值和最大值分别加 1；
        //如果遇到右括号，则将最小值和最大值分别减 1；
        //如果遇到星号，则将最小值减 1 ，即把星号看作右括号的情况。 将最大值加 1 ，即把星号看作左括号的情况；

        //如果最小值为负时，不能把星号全当做右括号，则把最小值置为0，也就是把其中一个星号当作左括号
        //如果最大值为负时，则意味着把星号全当做左括号的情况下，左括号数量仍然小于右括号数量，即不匹配 129-132行
        //遍历完成，最小值为0时，则意味着把星号既当作右括号，也当作左括号，刚好匹配

        //任何情况下，未匹配的左括号数量必须非负，因此当最大值变成负数时，说明没有左括号可以和右括号匹配，返回false。
        //当最小值为 0 时，不应将最小值继续减少，以确保最小值非负。
        //遍历结束时，所有的左括号都应和右括号匹配，因此只有当最小值为 0 时，字符串 s 才是有效的括号字符串。
        public boolean checkValidString2(String s) {
            int minCount = 0, maxCount = 0;
            int n = s.length();
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                if (c == '(') {
                    minCount++;
                    maxCount++;
                } else if (c == ')') {
                    minCount = Math.max(minCount - 1, 0);
                    maxCount--;
                    if (maxCount < 0) {
                        return false;
                    }
                } else {
                    minCount = Math.max(minCount - 1, 0);
                    maxCount++;
                }
            }
            return minCount == 0;
        }

        //正反遍历 时间O(n) 空间O(1)
        public boolean checkValidString3(String s) {
            int n = s.length();
            int l = 0, m = 0;
            for(int i = 0; i < n; ++i){ //正遍历，用 ) 去匹配 (
                if(s.charAt(i) == '('){
                    l++;
                }
                else if(s.charAt(i) == ')'){
                    l--;
                }
                else{
                    m++;
                }
                if(l < 0){  //左括号多的话就用*代替右括号，即m--
                    m--;
                    l++;
                }
                if(m < 0){  //如果*消耗为负值说明不匹配
                    return false;
                }
            }
            int r = 0;
            m = 0;
            for(int i = n-1; i >=0; --i){ //反遍历，用 ( 去匹配 )
                if(s.charAt(i) == ')'){
                    r++;
                }
                else if(s.charAt(i) == '('){
                    r--;
                }
                else{
                    m++;
                }
                if(r < 0){ //右括号多的话就用*代替左括号，即m--
                    m--;
                    r++;
                }
                if(m < 0){
                    return false;
                }
            }
            return true;
        }
}
//leetcode submit region end(Prohibit modification and deletion)
}