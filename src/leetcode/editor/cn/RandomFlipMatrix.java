package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

//519、随机翻转矩阵
class RandomFlipMatrix {
    public static void main(String[] args) {
        Solution solution = new RandomFlipMatrix().new Solution(3, 2);
        System.out.println(Arrays.toString(solution.flip()));
        System.out.println(Arrays.toString(solution.flip()));
        System.out.println(Arrays.toString(solution.flip()));
        System.out.println(Arrays.toString(solution.flip()));
        System.out.println(Arrays.toString(solution.flip()));
        System.out.println(Arrays.toString(solution.flip()));
        solution.reset();
        System.out.println(Arrays.toString(solution.flip()));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int n;
        int m;
        int total;
        HashMap<Integer,Integer> map;

        public Solution(int m, int n) {
            this.m = m;
            this.n = n;
            total = m*n;
            map = new HashMap<>();
        }

        public int[] flip() {
            Random random = new Random();
            int x = random.nextInt(total);
            total--;
            int idx = map.getOrDefault(x,x);
            map.put(x,map.getOrDefault(total,total));
            return new int[] {idx / n, idx % n};
        }

        public void reset() {
            map.clear();
            total = m * n;
        }
    }

    //执行耗时:32 ms,击败了30.33% 的Java用户 内存消耗:39.4 MB,击败了18.85% 的Java用户
    //class Solution {
    //    int m;
    //    int n;
    //    HashMap<Integer,HashSet<Integer>> maps;
    //
    //    public Solution(int m, int n) {
    //        this.m = m;
    //        this.n = n;
    //        this.maps = new HashMap<>();
    //    }
    //
    //    public int[] flip() {
    //        Random random = new Random();
    //        while (true) {
    //            int rand = random.nextInt(m * n); //最差调用m*n次随机函数
    //            int x = rand / n; //行
    //            int y = rand % n; //列
    //            if(!maps.containsKey(x)){
    //                HashSet<Integer> set = new HashSet<>();
    //                maps.put(x,set);
    //            }
    //            HashSet<Integer> set = maps.get(x);
    //            if(!set.contains(y)){
    //                set.add(y);
    //                return new int[]{x,y};
    //            }
    //        }
    //    }
    //
    //    public void reset() {
    //        maps.clear();
    //    }
    //}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(m, n);
 * int[] param_1 = obj.flip();
 * obj.reset();
 */
//leetcode submit region end(Prohibit modification and deletion)

}