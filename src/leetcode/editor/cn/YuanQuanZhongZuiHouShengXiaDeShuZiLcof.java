package leetcode.editor.cn;

import java.util.ArrayList;

//剑指 Offer 62、圆圈中最后剩下的数字
class YuanQuanZhongZuiHouShengXiaDeShuZiLcof {
    public static void main(String[] args) {
        Solution solution = new YuanQuanZhongZuiHouShengXiaDeShuZiLcof().new Solution();
        int i = solution.lastRemaining(10, 17);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lastRemaining(int n, int m) {
            ArrayList<Integer> list = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                list.add(i);
            }
            int index = 0;
            while (n > 1) {
                index = (index + m - 1) % n;  //删除的坐标
                list.remove(index);
                n--;
            }
            return list.get(0);
        }

        public int lastRemaining3(int n, int m) {
            if (n == 1) {
                return 0;
            }
            int x = lastRemaining(n - 1, m);  //n-1个人时的胜利者的下标位置
            //则n个人时下标为x+m
            return (x + m) % n;
        }

        public int lastRemaining2(int n, int m) {
            int f = 0;
            for (int i = 2; i <= n; ++i) {
                f = (f + m) % i;
            }
            return f;
        }

        public int lastRemaining1(int n, int m) {
            int[] t = new int[n];
            int count = 0;
            int c = 0;
            for (int i = 0; i < n; i++) {
                if (t[i] != -1) {
                    c++;
                }
                if (c == (m % (n - count) == 0 ? m : m % (n - count))) {
                    t[i] = -1;
                    c = 0;
                    count++;
                    if (count == n - 1) {
                        break;
                    }
                }
                if (i == n - 1) {
                    i = -1;
                }
            }
            for (int i = 0; i < n; i++) {
                if (t[i] != -1) {
                    return t[i];
                }
            }
            return -1;
        }

        //递归 TLE
        public int lastRemaining0(int n, int m) {
            int[] t = new int[n];
            for (int i = 0; i < n; i++) {
                t[i] = i;
            }
            dfs(t, m, 0, 1);
            for (int i = 0; i < n; i++) {
                if (t[i] != -1) {
                    return t[i];
                }
            }
            return -1;
        }

        private void dfs(int[] t, int m, int index, int count) {
            if (count == t.length) {
                return;
            }
            int c = 0;
            int i = index;
            for (; i < t.length; i++) {
                if (t[i] != -1) {
                    c++;
                }
                if (c == m) {
                    t[i] = -1;
                    break;
                }
                if (i == t.length - 1) {
                    i = -1;
                }
            }
            dfs(t, m, i, count + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}