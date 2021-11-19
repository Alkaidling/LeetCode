package leetcode.editor.cn;

import java.util.HashMap;

//397、整数替换
class IntegerReplacement {
    public static void main(String[] args) {
        Solution solution = new IntegerReplacement().new Solution();
        for (int i = 1; i <= 32; i++) {
            if(solution.integerReplacement(i) != solution.integerReplacement1(i)){
                System.out.println("error");
                break;
            }
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //位运算
        public int integerReplacement(int n) {
            long x = n;
            int res = 0;
            while (x != 1) {
                if (x % 2 == 0) {
                    x /= 2;
                }else {
                    if(x != 3 && (x >> 1 & 1) == 1){
                        x++;
                    }else {
                        x--;
                    }
                }
                res++;
            }
            return res;
        }

        //贪心
        public int integerReplacement2(int n) {
            int ans = 0;
            while (n != 1) {
                if (n % 2 == 0) {
                    ++ans;
                    n /= 2;
                } else if (n % 4 == 1) {
                    ans += 2;
                    n /= 2;
                } else {
                    if (n == 3) {
                        ans += 2;
                        n = 1;
                    } else {
                        ans += 2;
                        n = n / 2 + 1;
                    }
                }
            }
            return ans;
        }

        //记忆化搜索
        HashMap<Integer,Integer> map = new HashMap<>();
        public int integerReplacement1(int n) {
            if (n == 1) {
                return 0;
            }
            if(!map.containsKey(n)){
                if (n % 2 == 0) {
                    map.put(n,integerReplacement(n/2)+1);
                }else {
                    map.put(n,Math.min(integerReplacement(n / 2), integerReplacement(n / 2 + 1)) + 2);
                }
            }
            return map.get(n);
        }


        public int integerReplacement0(int n) {
            return dfs(n);
        }

        public int dfs(int n) {
            if (n == 1) {
                return 0;
            }
            if (n % 2 == 0) {
                return dfs(n / 2) + 1;
            } else {
                int res1 = dfs(n / 2) + 2;
                int res2 = dfs(n / 2 + 1) + 2;
                return Math.min(res1,res2);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}