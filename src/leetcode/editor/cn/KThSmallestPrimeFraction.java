package leetcode.editor.cn;

import java.util.*;

//786、第 K 个最小的素数分数
class KThSmallestPrimeFraction {
    public static void main(String[] args) {
        Solution solution = new KThSmallestPrimeFraction().new Solution();
        int[] ints = solution.kthSmallestPrimeFraction(new int[]{1, 2, 3, 5}, 3);
        System.out.println(Arrays.toString(ints));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //执行耗时:391 ms,击败了27.65% 的Java用户 内存消耗:65.5 MB,击败了24.71% 的Java用户
        public int[] kthSmallestPrimeFraction(int[] arr, int k) {
            ArrayList<int[]> list = new ArrayList<>();
            int n = arr.length;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    list.add(new int[]{arr[i],arr[j]});
                }
            }
            Collections.sort(list,(a,b) -> a[0] * b[1] - b[0] * a[1]);
            return list.get(k-1);
        }

        //暴力
        //执行耗时:888 ms,击败了5.88% 的Java用户 内存消耗:172 MB,击败了5.30% 的Java用户
        public int[] kthSmallestPrimeFraction0(int[] arr, int k) {
            PriorityQueue<Double> queue = new PriorityQueue<>();
            HashMap<Double,int[]> map = new HashMap<>();
            int n = arr.length;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    double t = (double) arr[i] / (double) arr[j];
                    queue.offer(t);
                    map.put(t,new int[]{arr[i],arr[j]});
                }
            }
            double t = 0.0;
            while (k-- > 0 && !queue.isEmpty()) {
                t = queue.poll();
            }
            return map.get(t);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}